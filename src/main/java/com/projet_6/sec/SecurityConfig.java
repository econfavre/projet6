package com.projet_6.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private DataSource dataSource;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder bcpe = getBCPE();
		System.out.println(bcpe.encode("1234"));

		auth.inMemoryAuthentication().withUser("user").password(bcpe.encode("1234")).roles("USER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder());
	}

//		auth.jdbcAuthentication().dataSource(dataSource) // datasource de l'application
//				.usersByUsernameQuery(
//						"SELECT username as principal, password as credentials, active FROM member WHERE username=?") // requete
//				// SQL
//				// pour
//				// chercher
//				// si
//				// l'utilisateur
//				// existe
//				.authoritiesByUsernameQuery(
//						"SELECT username as principal, role as role FROM members_roles WHERE username=?") // requete
//				// SQL
//				// pour
//				// connaitre
//				// les
//				// roles
//				// de
//				// l'utilisateur
//				.rolePrefix("ROLE_") // prefixe ajoute au role par ex ROLE_ADMIN
//				.passwordEncoder(getBCPE());
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeRequests()
				.antMatchers("/home", "/RegistrationForm", "/login", "/sites", "/topos", "/CreationSite").permitAll()
				.antMatchers("/homeconnecte").authenticated();
		http.exceptionHandling().accessDeniedPage("/403");

	}

	@Bean
	BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
}
