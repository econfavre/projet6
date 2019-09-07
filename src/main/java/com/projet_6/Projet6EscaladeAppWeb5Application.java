package com.projet_6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Projet6EscaladeAppWeb5Application implements CommandLineRunner {

	@Autowired
	// private SiteRepository siteRepository;

	public static void main(String[] args) {
		SpringApplication.run(Projet6EscaladeAppWeb5Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// siteRepository.findAll().forEach(s -> {
		// System.out.println(s.getNameSite());
		// });
	}
}
