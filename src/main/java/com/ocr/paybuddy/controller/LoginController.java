package com.ocr.paybuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ocr.paybuddy.dto.UserLoginDto;
import com.ocr.paybuddy.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	LoginService loginService;

	@GetMapping(value = "/login")
	public String loginPage(@ModelAttribute("userLogin") UserLoginDto userLogin) {
		return "login";
	}

	@PostMapping(value = "/login")
	public String loginUser(@ModelAttribute("userLogin") UserLoginDto userLogin, final Model model,
			final BindingResult mapping1BindingResult, final RedirectAttributes redirectAttributes) throws Exception {
		if (loginService.login(userLogin.getMail(), userLogin.getPassword())) {
			redirectAttributes.addFlashAttribute("userLogin", userLogin);
			return "redirect:/";
		} else {
			return "redirect:/login";
		}
	}
}
