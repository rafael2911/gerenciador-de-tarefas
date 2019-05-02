package br.com.crcarvalho.spring.gerenciadordetarefas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.crcarvalho.spring.gerenciadordetarefas.controller.HomeController;
import br.com.crcarvalho.spring.gerenciadordetarefas.dao.TarefaDao;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, TarefaDao.class})
public class AppWebConfiguration {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
}
