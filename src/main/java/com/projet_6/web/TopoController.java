package com.projet_6.web;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.projet_6.dao.MemberRepository;
import com.projet_6.dao.TopoRepository;
import com.projet_6.entity.Topo;

@Controller
public class TopoController {

	@Autowired
	TopoRepository topoRepository;

	@Autowired
	MemberRepository memberRepository;

	@Value("${dir.file}")
	private String fileDir;

	@GetMapping("/reservation")
	public String reservation(Model model) {
		return "reservation";
	}

	@GetMapping("/CreationTopo")
	public String topoCreation(Model model) {
		model.addAttribute("topo", new Topo());
		return "CreationTopo";
	}

	@RequestMapping(value = "/saveNewTopo", method = RequestMethod.POST)
	public String saveTopo(@Valid Topo topo, BindingResult bindingResult,
			@RequestParam(name = "file") MultipartFile file, HttpServletRequest request) throws Exception {
		if (bindingResult.hasErrors()) {
			return "CreationTopo";
		}
		if (!(file.isEmpty())) {
			topo.setTopoFile(file.getOriginalFilename());
			file.transferTo(new File("C:/Users/Administrator/files" + "/" + file.getOriginalFilename()));
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		topo.setMember(memberRepository.findByUsername(authentication.getName()));
		topoRepository.save(topo);
		return "redirect:/homeconnecte";
	}
}
