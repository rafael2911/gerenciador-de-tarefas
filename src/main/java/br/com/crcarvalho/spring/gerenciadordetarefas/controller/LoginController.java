package br.com.crcarvalho.spring.gerenciadordetarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public ModelAndView formLogin() {
		return new ModelAndView("login/formLogin");
	}
	
}
