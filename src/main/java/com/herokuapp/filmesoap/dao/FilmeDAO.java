package com.herokuapp.filmesoap.dao;

import java.util.List;

import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.herokuapp.filmesoap.model.Filme;

public class FilmeDAO extends GenericDAO<Filme, Long>{
	
	public FilmeDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public FilmeDAO(EntityManager currentEntityManager) {
		super(currentEntityManager);
	}
	
	public List<Filme> buscarFilme(String titulo, String diretor,String estudio, String genero, String ano){
		
		StringBuilder sql = new StringBuilder();
		sql.append("Select f from Filme f where 1=1");
		if(titulo!=null && !titulo.isEmpty()) {
			sql.append(" AND upper(f.titulo) like :titulo");
		}
		if(diretor != null && !diretor.isEmpty()) {
			sql.append(" AND upper(f.diretor) like :diretor");
		}
		if(estudio != null && !estudio.isEmpty()) {
			sql.append(" AND upper(f.estudio) like :estudio");
		}
		if(genero != null && !genero.isEmpty()) {
			sql.append(" AND upper(f.genero) like :genero");
		}
		if(ano != null && !ano.isEmpty()) {
			sql.append(" AND upper(f.ano) like :ano");
		}
		
		Query q = this.getEntityManager().createQuery(sql.toString());

		if(titulo!=null && !titulo.isEmpty()) {
			q.setParameter("titulo", "%"+titulo.toUpperCase()+"%");
		}
		if(diretor != null && !diretor.isEmpty()) {
			q.setParameter("diretor", "%"+diretor.toUpperCase()+"%");
		}
		if(estudio != null && !estudio.isEmpty()) {
			q.setParameter("estudio", "%"+estudio.toUpperCase()+"%");
		}
		if(genero != null && !genero.isEmpty()) {
			q.setParameter("genero", "%"+genero.toUpperCase()+"%");
		}
		if(ano != null && !ano.isEmpty()) {
			q.setParameter("ano", "%"+ano+"%");
		}

		return q.getResultList();
	}
	
	

}
