package com.clinic.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clinic.app.entity.User;
import com.clinic.app.service.IClinicService;

@Controller
public class ClinicController {

	@Autowired
	IClinicService clinicService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("message", "hello guyz");
		User user = clinicService.getdetails();
		System.out.println(user.getId() + " " + user.getFirstname());
		return "index";
	}

}
