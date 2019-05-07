package br.com.crcarvalho.spring.gerenciadordetarefas.error;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		request.setAttribute("url", request.getRequestURI());
		response.sendRedirect(request.getContextPath() + "/error/acessoNegado?url=" + request.getRequestURI());
		
	}

}
