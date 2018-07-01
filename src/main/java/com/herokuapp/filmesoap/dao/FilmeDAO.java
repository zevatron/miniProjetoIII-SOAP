package com.herokuapp.filmesoap.dao;

import javax.persistence.EntityManager;

import com.herokuapp.filmesoap.model.Filme;

public class FilmeDAO extends GenericDAO<Filme, Long>{
	
	public FilmeDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public FilmeDAO(EntityManager currentEntityManager) {
		super(currentEntityManager);
	}
	
	

}
