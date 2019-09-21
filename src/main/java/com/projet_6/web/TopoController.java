package com.projet_6.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopoController {

	@GetMapping("/reservation")
	public String reservation(Model model) {
		return "reservation";
	}
}
