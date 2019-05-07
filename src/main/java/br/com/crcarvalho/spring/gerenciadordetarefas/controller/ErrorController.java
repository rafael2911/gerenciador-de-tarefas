package br.com.crcarvalho.spring.gerenciadordetarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/error")
public class ErrorController {
	
	@GetMapping("acessoNegado")
	public ModelAndView acessoNegado(@RequestParam("url") String url, RedirectAttributes attr) {
		ModelAndView modelAndView = new ModelAndView("redirect:/tarefa/");
		attr.addFlashAttribute("erro", "Você não tem permissão para acessar a URL: " + url);
		return modelAndView;
	}
	
}