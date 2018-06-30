package com.herokuapp.filmesoap.service;

import java.util.List;

import javax.jws.WebService;

import com.herokuapp.filmesoap.dao.FilmeDAO;
import com.herokuapp.filmesoap.dao.PersistenceUtil;
import com.herokuapp.filmesoap.model.Filme;

@WebService(endpointInterface="com.herokuapp.filmesoap.service.FilmeService")
public class FilmeService {
	
	public FilmeService() {
		PersistenceUtil.createEntityManagerFactory("filmesoap");
	}
	
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
