package com.ocr.paybuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ocr.paybuddy.dto.UserLoginDto;
import com.ocr.paybuddy.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@GetMapping(value = "/login")
	@ResponseStatus(HttpStatus.OK)
	public String loginPage(@ModelAttribute("userLogin") UserLoginDto userLogin) {
		return "login";
	}

	@PostMapping(value = "/login")
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView loginUser(@ModelAttribute("userLogin") UserLoginDto userLogin) throws Exception {
		if (loginService.login(userLogin.getMail(), userLogin.getPassword())) {
			System.out.println("OK");
			return new ModelAndView("redirect:/");
		} else {
			return new ModelAndView("redirect:/login");
		}
	}
}
