package br.com.crcarvalho.spring.gerenciadordetarefas.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class TarefaBeanParam {
	
	private Status status;
	private String tipoData;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dtInicial;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dtFinal;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTipoData() {
		return tipoData;
	}

	public void setTipoData(String tipoData) {
		this.tipoData = tipoData;
	}

	public LocalDate getDtInicial() {
		return dtInicial;
	}

	public void setDtInicial(LocalDate dtInicial) {
		this.dtInicial = dtInicial;
	}

	public LocalDate getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(LocalDate dtFinal) {
		this.dtFinal = dtFinal;
	}
	
}
