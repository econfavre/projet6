package com.projet_6.web;

import java.util.List;

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

import com.projet_6.dao.SectorRepository;
import com.projet_6.dao.SiteRepository;
import com.projet_6.entity.Sector;
import com.projet_6.entity.Site;

@Controller
public class SectorController {

	@Autowired
	SectorRepository sectorRepository;

	@Autowired
	SiteRepository siteRepository;

	// @RequestMapping(value = "/user/index", method=RequestMethod.GET)
	@GetMapping("/sectors")
	public String sectorsList(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		Page<Sector> pageSector = sectorRepository.findByNameSectorContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listSectors", pageSector.getContent());
		model.addAttribute("pages", new int[pageSector.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "sector";
	}

	// @RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
	@GetMapping("/deleteSector")
	public String deleteSector(Long sectorId, int page, String motCle) {
		sectorRepository.deleteById(sectorId);
		return "redirect:/sectors?page=" + page + "&motCle=" + motCle;
	}

	@GetMapping("/editSector")
	public String editSector(Model model, Long sectorId) {
		Sector sector = sectorRepository.findById(sectorId).get();
		// if (s.isPresent()) {// vérifie si s est null ou non. Si il n'est pas null, je
		// créer un objet Site
		// que j'initialise avec s et que j'envoie par la suite dans le formulaire via
		// model.
		// Site site = s.get();
		List<Site> listNameSite = siteRepository.findAll();
		model.addAttribute("listNameSite", listNameSite);
		model.addAttribute("sector", sector);
		// }
		return "EditSector"; // on redirige vers une nouvelle page de confirmation que l'on doit creee dan
	}

	@GetMapping("/CreationSector")
	public String sectorCreation(Model model) {
		List<Site> listNameSite = siteRepository.findAll();
		model.addAttribute("listNameSite", listNameSite);
		model.addAttribute("sector", new Sector());
		return "CreationSector";
	}

	@GetMapping("/listSector")
	public String search(Model model) {
		return "listSector";
	}

	@RequestMapping(value = "/saveNewSector", method = RequestMethod.POST)
	public String save(@Valid Sector sector, BindingResult bindingResult, Model model) {
		System.out.println(sector.getNameSite());
		if (bindingResult.hasErrors())
			return "CreationSector";
		// sector.setSite(siteRepository.findByName(.getId()));
		sectorRepository.save(sector);
		return "redirect:/homeconnecte"; // on redirige vers une nouvelle page de confirmation que l'on doit creee dan
	}

	@RequestMapping(value = "/saveEditSectorForm", method = RequestMethod.POST)
	public String saveEditSectorForm(@Valid Sector sector, BindingResult bindingResult, Model model) {
		System.out.println(bindingResult);
		if (bindingResult.hasErrors())
			return "EditSector";
		sectorRepository.save(sector);
		return "redirect:/sector"; // on redirige vers une nouvelle page de confirmation que l'on doit creee dan
	}
}
