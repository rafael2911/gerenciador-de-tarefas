package br.com.crcarvalho.spring.gerenciadordetarefas.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	@Column(nullable=false)
	private String descricao;
	
	@Column(name="data_abertura", nullable=false)
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate dataAbertura;
	
	@Column(name="data_encerramento")
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate dataEncerramento;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDate getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(LocalDate dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", descricao=" + descricao + ", dataAbertura=" + dataAbertura
				+ ", dataEncerramento=" + dataEncerramento + ", status=" + status + "]";
	}
	
}
