package com.javaProjects.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaProjects.models.User;
import com.javaProjects.repositories.UserRepo;



@Controller
public class UserController {
	
	UserRepo userRepo;

	public UserController(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@RequestMapping("/") //backslash always represents homepage
	public String homepage() {
		return "index";
	}
	
	@RequestMapping({"","login","login.html"})
	public String login() {
		return "login";
	}
	
	@RequestMapping({"", "register", "register.html"})
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping({"", "register", "register.html"})
	public String submitRegister(@ModelAttribute("user") User user) {
		System.out.println(user);
		userRepo.save(user);
		return "register";
	}

}
