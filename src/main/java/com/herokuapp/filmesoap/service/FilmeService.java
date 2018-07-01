package com.herokuapp.filmesoap.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;

import com.herokuapp.filmesoap.dao.FilmeDAO;
import com.herokuapp.filmesoap.dao.PersistenceUtil;
import com.herokuapp.filmesoap.model.Filme;

@WebService(endpointInterface="com.herokuapp.filmesoap.service.FilmeService")
public class FilmeService {
	
	
	public List<Filme> buscarFilmes(){
		
		
		FilmeDAO dao = new FilmeDAO();
		
		List<Filme> result = dao.findAll();
		
		PersistenceUtil.getCurrentEntityManager().close();
		return result;
	}
	
	public Filme cadastrar(@WebParam(name="filme") Filme filme) {
		
		
		FilmeDAO dao = new FilmeDAO();
		
		dao.beginTransaction();
		if(filme.getId()==null) {
			dao.insert(filme);
		}else {
			dao.update(filme);
		}
		dao.commit();
		PersistenceUtil.getCurrentEntityManager().close();
		
		
		return filme;
	}

}
