package com.projet_6.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet_6.dao.MemberRepository;
import com.projet_6.entity.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberRepository memberRepository;

	@GetMapping("/RegistrationForm")
	public String registrationForm(Model model) {
		model.addAttribute("member", new Member());
		return "registrationForm";
	}

	@PostMapping("/memberSave")
	public String save(Model model, @Valid Member member, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "RegistrationForm";
		memberRepository.save(member);
		return "redirect:/hom"; // on redirige vers une nouvelle page de confirmation que l'on doit creee dan
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}

	@GetMapping("/")
	public String login() {
		return "login2";
	}

	@GetMapping("/newAccount")
	public String newAccount() {
		return "registrationForm";
	}

}
