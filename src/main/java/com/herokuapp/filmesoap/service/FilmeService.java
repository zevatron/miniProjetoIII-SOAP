package com.herokuapp.filmesoap.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

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
	
	public List<Filme> buscarFilme(
			@WebParam(name="titulo") String titulo,
			@WebParam(name="diretor") String diretor,
			@WebParam(name="estudio") String estudio,
			@WebParam(name="genero") String genero,
			@WebParam(name="anoLancamento") String anoLancamento
			){
		FilmeDAO dao = new FilmeDAO();
		List<Filme> resutlt = dao.buscarFilme(titulo, diretor, estudio, genero, anoLancamento);
		PersistenceUtil.getCurrentEntityManager().close();
		return resutlt;
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
	
	public Filme excluir(@WebParam(name="id") Long id) {
		
		FilmeDAO dao = new FilmeDAO();
		
		Filme filme = dao.find(id);
		
		dao.beginTransaction();
		dao.delete(filme);
		dao.commit();
		PersistenceUtil.getCurrentEntityManager().close();
		
		return filme;
	}

}
