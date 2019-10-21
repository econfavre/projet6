package com.projet_6.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.projet_6.dao.MemberRepository;
import com.projet_6.dao.SiteRepository;
import com.projet_6.entity.Site;
import com.projet_6.entity.Way;

@Controller
public class SiteController {
	@Autowired
	private SiteRepository siteRepository;

	@Autowired
	private MemberRepository memberRepository;

	// @RequestMapping(value = "/user/index", method=RequestMethod.GET)
	@GetMapping("/sites")
	public String listSites(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
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

	@GetMapping("/CreationSite")
	public String siteCreation(Model model) {
		model.addAttribute("site", new Site());
		return "CreationSite";
	}

	@RequestMapping(value = "/saveNewSite", method = RequestMethod.POST)
	public String save(@Valid Site site, BindingResult bindingResult, Model model, HttpServletRequest request) {
		System.out.println(bindingResult);
		if (bindingResult.hasErrors())
			return "CreationSite";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		site.setMember(memberRepository.findByUsername(authentication.getName()));
		siteRepository.save(site);
		return "redirect:/sites"; // on redirige vers une nouvelle page de confirmation que l'on doit creee dan
	}

	@RequestMapping(value = "/saveEditSiteForm", method = RequestMethod.POST)
	public String saveEditForm(@Valid Site site, BindingResult bindingResult, Model model) {
		System.out.println(bindingResult);
		if (bindingResult.hasErrors())
			return "EditSite";
		siteRepository.save(site);
		return "redirect:/sites"; // on redirige vers une nouvelle page de confirmation que l'on doit creee dan
	}

	@GetMapping("/edit")
	public String edit(Model model, Long siteId) {
		Site site = siteRepository.findById(siteId).get();
		// if (s.isPresent()) {// vérifie si s est null ou non. Si il n'est pas null, je
		// créer un objet Site
		// que j'initialise avec s et que j'envoie par la suite dans le formulaire via
		// model.
		// Site site = s.get();
		model.addAttribute("site", site);
		// }
		return "EditSite"; // on redirige vers une nouvelle page de confirmation que l'on doit creee dan
	}

	@GetMapping("/searchForm")
	public String search(Model model, @Valid Site site, @Valid Way way, BindingResult bindingResult) {
		return "SearchForm";
	}

	@GetMapping("/sitesconnecte")
	public String index2(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		Page<Site> pageSite = siteRepository.findByNameSiteContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listSites", pageSite.getContent());
		model.addAttribute("pages", new int[pageSite.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "siteconnecte";
	}

}