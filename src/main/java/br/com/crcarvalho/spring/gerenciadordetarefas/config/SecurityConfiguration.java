package br.com.crcarvalho.spring.gerenciadordetarefas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

import br.com.crcarvalho.spring.gerenciadordetarefas.dao.UsuarioDao;
import br.com.crcarvalho.spring.gerenciadordetarefas.error.CustomAccessDeniedHandler;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("utf-8");
		http.addFilterBefore(encodingFilter, CsrfFilter.class);
		
		http
			.authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("/usuario/logicamalucacadastrausuariopadrao").permitAll()
			.antMatchers("/usuario/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login").permitAll()
			.and().exceptionHandling().accessDeniedHandler(accessDeniedHandler())
			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(usuarioDao)
			.passwordEncoder(new BCryptPasswordEncoder());
		
	}
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	

}
