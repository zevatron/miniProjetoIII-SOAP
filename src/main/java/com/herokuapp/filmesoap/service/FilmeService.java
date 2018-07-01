package com.herokuapp.filmesoap.service;

import java.util.List;

import javax.jws.WebService;
import javax.persistence.EntityManagerFactory;

import com.herokuapp.filmesoap.dao.FilmeDAO;
import com.herokuapp.filmesoap.dao.PersistenceUtil;
import com.herokuapp.filmesoap.model.Filme;

@WebService(endpointInterface="com.herokuapp.filmesoap.service.FilmeService")
public class FilmeService {
	
	public void conectar() {
		PersistenceUtil.createEntityManagerFactory("filmesoap");
	}
	public void desconectar() {
		 EntityManagerFactory emf = PersistenceUtil.getEntityManagerFactory(); 
		    if (emf != null) { 
		      emf.close(); 
		    } 
	}
	
	public List<Filme> buscarFilmes(){
		
		conectar();
		
		FilmeDAO dao = new FilmeDAO();
		
		List<Filme> result = dao.findAll();
		
		desconectar();
		
		return result;
	}
	
	public Filme cadastrar(Filme filme) {
		
		conectar();
		
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
