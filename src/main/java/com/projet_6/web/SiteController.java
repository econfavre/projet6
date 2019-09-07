package com.projet_6.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projet_6.dao.SiteRepository;
import com.projet_6.entity.Site;

@Controller
public class SiteController {
	@Autowired
	private SiteRepository siteRepository;

	// @RequestMapping(value = "/user/index", method=RequestMethod.GET)
	@GetMapping("/sites")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		Page<Site> pageSite = siteRepository.findByNameSiteContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listSites", pageSite.getContent());
		model.addAttribute("pages", new int[pageSite.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "site";
	}

	// @RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
	@GetMapping("/delete")
	public String delete(Long siteId, int page, String motCle) {
		siteRepository.deleteById(siteId);
		return "redirect:/sites?page=" + page + "&motCle=" + motCle;
	}

	@GetMapping("/formSite")
	public String formSite(Model model) {
		model.addAttribute("site", new Site());
		return "FormSite";
	}

	@PostMapping("/save")
	public String save(Model model, @Valid Site site, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "FormSite";
		siteRepository.save(site);
		return "redirect:/sites"; // on redirige vers une nouvelle page de confirmation que l'on doit creee dan
	}

	@GetMapping("/edit")
	public String edit(Model model, Long id) {
		Site site = siteRepository.findById(id).get();
		// if (p.isPresent()) {// vérifie si p est null ou non. Si il n'est pas null, je
		// créer un objet Produit
		// que j'initialise avec p et que j'envois par la suite dans le formulaire via
		// model.
		// Produit produit = p.get();
		model.addAttribute("site", site);
		// }
		return "EditSite"; // on redirige vers une nouvelle page de confirmation que l'on doit creee dan
	}

}
