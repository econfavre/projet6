package com.projet_6.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.projet_6.entity.Sector;

@Controller
public class SectorController {

	@GetMapping("/sectorcreation")
	public String sectorCreation(Model model, @Valid Sector sector, BindingResult bindingResult) {
		return "SectorCreation";
	}
}
