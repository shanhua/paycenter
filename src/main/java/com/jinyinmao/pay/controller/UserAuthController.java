package com.jinyinmao.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author ÉÆ»ª
* @version 1.0
**/

@Controller
@RequestMapping("/userAuth")
public class UserAuthController {
	@RequestMapping(method = RequestMethod.GET)
	public String validateUserInfo(ModelMap model) {
		model.addAttribute("message", "hello shanhua");
		return "userAuth";
	}
	
}