package com.urban.spatium.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.urban.spatium.dto.User;
import com.urban.spatium.service.UserService;

@Controller
public class ItemController2 {

	@Autowired
	private UserService userService;
	
	@GetMapping("/addItem")
	public String addUser(Model model) {
		return "item/buy";
	}

}
