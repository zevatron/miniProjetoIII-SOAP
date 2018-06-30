package com.herokuapp.filmesoap.service;

import java.util.List;

import com.herokuapp.filmesoap.dao.FilmeDAO;
import com.herokuapp.filmesoap.model.Filme;

public class FilmeService {
	
	public List<Filme> buscarFilmes(){
		
		FilmeDAO dao = new FilmeDAO();
		
		return dao.findAll();
	}
	
	public Filme cadastrar(Filme filme) {
		
		FilmeDAO dao = new FilmeDAO();
		
		dao.beginTransaction();
		if(filme.getId()==null) {
			dao.insert(filme);
		}else {
			dao.update(filme);
		}
		dao.commit();
		return filme;
	}

}
