package com.javaProjects.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaProjects.models.User;
import com.javaProjects.repositories.UserRepo;



@Controller
public class UserController {
	
	UserRepo userRepo;
	
	@RequestMapping("/") //backslash always represents homepage
	public String homepage() {
		return "index";
	}
	
	@RequestMapping({"","login","login.html"})
	public String login() {
		return "login";
	}
	
	@RequestMapping({"", "register", "register.html"})
	public String register() {
		return "register";
	}
	
	@PostMapping({"", "register", "register.html"})
	public String submitRegister(@ModelAttribute("user") User user) {
		System.out.println(user);
		userRepo.save(user);
		return "register";
	}

}
