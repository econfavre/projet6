package com.projet_6.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.projet_6.dao.WayRepository;
import com.projet_6.entity.Way;

@Controller
public class WayController {

	@Autowired
	WayRepository wayRepository;

	// @RequestMapping(value = "/user/index", method=RequestMethod.GET)
	@GetMapping("/ways")
	public String waysList(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		Page<Way> pageWay = wayRepository.findByNameWayContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listWays", pageWay.getContent());
		model.addAttribute("pages", new int[pageWay.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "sector";
	}

	// @RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
	@GetMapping("/deleteWay")
	public String deleteWay(Long wayId, int page, String motCle) {
		wayRepository.deleteById(wayId);
		return "redirect:/sectors?page=" + page + "&motCle=" + motCle;
	}

	@GetMapping("/editWay")
	public String editWay(Model model, Long wayId) {
		Way way = wayRepository.findById(wayId).get();
		// if (s.isPresent()) {// vérifie si s est null ou non. Si il n'est pas null, je
		// créer un objet Site
		// que j'initialise avec s et que j'envoie par la suite dans le formulaire via
		// model.
		// Site site = s.get();
		model.addAttribute("way", way);
		// }
		return "EditWay"; // on redirige vers une nouvelle page de confirmation que l'on doit creee dan
	}

	@GetMapping("/CreationWay")
	public String wayCreation(Model model) {
		model.addAttribute("way", new Way());
		return "CreationWay";
	}

	@GetMapping("/listWay")
	public String searchWay(Model model) {
		return "listWay";
	}

	@RequestMapping(value = "/saveNewWay", method = RequestMethod.POST)
	public String save(@Valid Way way, BindingResult bindingResult, Model model) {
		System.out.println(bindingResult);
		if (bindingResult.hasErrors())
			return "CreationWay";
		wayRepository.save(way);
		return "redirect:/way"; // on redirige vers une nouvelle page de confirmation que l'on doit creee dan
	}

	@RequestMapping(value = "/saveEditWayForm", method = RequestMethod.POST)
	public String saveEditWayForm(@Valid Way way, BindingResult bindingResult, Model model) {
		System.out.println(bindingResult);
		if (bindingResult.hasErrors())
			return "EditWay";
		wayRepository.save(way);
		return "redirect:/way"; // on redirige vers une nouvelle page de confirmation que l'on doit creee dan
	}
}
