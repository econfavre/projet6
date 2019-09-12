package com.projet_6.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.projet_6.entity.Way;

@Controller
public class WayController {

	@GetMapping("/waycreation")
	public String sectorCreation(Model model, @Valid Way way, BindingResult bindingResult) {
		return "WayCreation";
	}
}
