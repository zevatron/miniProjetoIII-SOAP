package com.herokuapp.filmesoap.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;

import com.herokuapp.filmesoap.dao.FilmeDAO;
import com.herokuapp.filmesoap.dao.PersistenceUtil;
import com.herokuapp.filmesoap.model.Filme;

@WebService(endpointInterface="com.herokuapp.filmesoap.service.FilmeService")
public class FilmeService {
	
	@WebMethod(exclude=true)
	public void desconectar() {
		 EntityManager em = PersistenceUtil.getCurrentEntityManager(); 
		    if (em != null) { 
		      em.close(); 
		    } 
	}
	
	public List<Filme> buscarFilmes(){
		
		
		FilmeDAO dao = new FilmeDAO();
		
		List<Filme> result = dao.findAll();
		
		desconectar();
		
		return result;
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
		
		desconectar();
		
		return filme;
	}

}
