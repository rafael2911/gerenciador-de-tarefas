package br.com.crcarvalho.spring.gerenciadordetarefas.config;

public class TarefaFinalizadaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public TarefaFinalizadaException(String message) {
		super(message);
	}
	
}
