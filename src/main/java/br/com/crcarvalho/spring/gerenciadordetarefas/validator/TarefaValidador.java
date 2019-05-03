package br.com.crcarvalho.spring.gerenciadordetarefas.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.crcarvalho.spring.gerenciadordetarefas.model.Tarefa;
import br.com.crcarvalho.spring.gerenciadordetarefas.model.TarefaBeanParam;

public class TarefaValidador implements Validator {
	
	/* informa classe que deve ser validada ao realizar o binding */
	@Override
	public boolean supports(Class<?> clazz) {
		
		return Tarefa.class.isAssignableFrom(clazz) || TarefaBeanParam.class.isAssignableFrom(clazz);
	}
	
	/* informa quais campos e como deverá realizar a validacao */
	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
		
	}

}
