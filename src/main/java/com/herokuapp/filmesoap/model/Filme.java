package com.herokuapp.filmesoap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Filme {
	
	@Id
	@GeneratedValue
	private Long id;
	private String titulo, diretor, estudio, genero, anoLancamento;
	
	public Filme() {
		// TODO Auto-generated constructor stub
	}
	
	public Filme(Long id, String titulo, String diretor, String estudio, String genero, String anoLancamento) {
		this.id = id;
		this.titulo = titulo;
		this.diretor = diretor;
		this.estudio = estudio;
		this.genero = genero;
		this.anoLancamento = anoLancamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getEstudio() {
		return estudio;
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
	

}
