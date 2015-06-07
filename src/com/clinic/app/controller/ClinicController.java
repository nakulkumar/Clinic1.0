package com.clinic.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clinic.app.entity.Login;
import com.clinic.app.entity.SearchForm;
import com.clinic.app.entity.User;
import com.clinic.app.service.IClinicService;
import com.clinic.app.utils.ClinicUtils;

@Controller
public class ClinicController {

	private static final Logger LOG = LoggerFactory
			.getLogger(ClinicController.class);

	@Autowired
	IClinicService clinicService;

	//To take to the login screen
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String userLogin() {
		return "index";
	}

	//to validate login
	@RequestMapping(value = "validateLogin", method = RequestMethod.GET)
	public String validateLogin(@ModelAttribute("loginDetails") Login login,Model model) {
		LOG.info("username : {} , password : {}", login.getUsername(),
				login.getPassword());
		Login validUser = clinicService.validateLogin(login);
		if (validUser == null) {
			model.addAttribute("error", "Incorrect Username/Password!!");
			return "index";
		} else if("REC".equals(validUser.getRoleType())){
			return "receptionist";
		}
		else {
			//dummy jsp success to test the things
			model.addAttribute("username", login.getUsername());
			model.addAttribute("password", login.getPassword());
			return "success";
		}
	}
	
	//to add patient details in the db 
	@RequestMapping(value="addPatientDetails",method=RequestMethod.POST)
	public String addPatientDetails(@ModelAttribute("userDetails")User user,Model model){
		System.out.println(user.getFirstname()+" "+user.getAge()+user.getSex());
		if(clinicService.persistPatientDetails(user)){
			System.out.println("data inserted");
		}
		else{
			System.out.println("some error occured");
		}
		//display hidden div whether data inserted successfully or not
		return "success";
	}
	
	//to search for patient in the db
	@RequestMapping(value="findPatient",method=RequestMethod.POST)
	public String findPatient(@ModelAttribute("searchForm") SearchForm search,Model model){
		
		//if nothing is entered and button is pressed, reload page again.
		if (ClinicUtils.isEmpty(search)) {
			return "receptionist";
		}
		//fetch details of all the patients as a list.
		List<User> patientList = clinicService.findPatient(search);
		
		model.addAttribute("patientList",patientList);
		return "searchResults";
	}
}
