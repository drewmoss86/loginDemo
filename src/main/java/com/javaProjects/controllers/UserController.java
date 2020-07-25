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

	//Need to bring in a new User object to the registration page. In order to do that, I need to use a built in
	// method with Java's Model class attribute called addAttribute
	@RequestMapping({"", "register", "register.html"})
	public String register(Model model) {
		model.addAttribute("user", new User()); // this will instantiate a new User Class object and pass it into
		// register
		return "register";
	}

	// User is passed back out of register view and saved via the repository
	@PostMapping({"", "register", "register.html"})
	public String submitRegister(@ModelAttribute("user") User user) {
		System.out.println(user);
		userRepo.save(user);
		return "register";
	}

}
