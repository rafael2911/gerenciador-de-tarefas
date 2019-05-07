package br.com.crcarvalho.spring.gerenciadordetarefas.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.crcarvalho.spring.gerenciadordetarefas.model.Usuario;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public ModelAndView formLogin(@AuthenticationPrincipal Usuario usuario) {
		
		if(usuario != null) {
			return new ModelAndView("redirect:/tarefa/");
		}
		
		return new ModelAndView("login/formLogin");
	}
	
}
