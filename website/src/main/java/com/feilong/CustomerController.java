package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CustomerController { //注意类名不能时Controller
	@RequestMapping(value="/custmoer_input")
	public String inputCustomer() {
		// do something here
		return "CustomerForm";
	}
}
