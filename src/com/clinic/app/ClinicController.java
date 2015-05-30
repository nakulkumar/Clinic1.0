package com.clinic.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClinicController {

	private static final Logger LOG = LoggerFactory
			.getLogger(ClinicController.class);

	@Autowired
	IClinicService clinicService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("message", "hello guyz");
		User user = clinicService.getdetails();
		System.out.println(user.getId() + " " + user.getFirstname());
		return "index";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String userLogin() {
		return "index";
	}

	@RequestMapping(value = "validateLogin", method = RequestMethod.GET)
	public String validateLogin(@ModelAttribute("loginDetails") Login login,
			Model model) {
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
			model.addAttribute("username", login.getUsername());
			model.addAttribute("password", login.getPassword());
			return "success";
		}
	}

}
