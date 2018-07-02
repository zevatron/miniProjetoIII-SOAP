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
	
	public List<Filme> buscarFilme(String titulo, String diretor, String genero, String anoLancamento){
		
		StringBuilder sql = new StringBuilder();
		sql.append("Select f from Filme f where 1=1");
		if(titulo!=null && !titulo.isEmpty()) {
			sql.append(" AND upper(f.titulo) like '%:titulo%'");
		}
		if(diretor != null && !diretor.isEmpty()) {
			sql.append(" AND upper(f.diretor) like '%:diretor%'");
		}
		if(genero != null && !genero.isEmpty()) {
			sql.append(" AND upper(f.genero) like '%:genero%'");
		}
		if(anoLancamento != null && !anoLancamento.isEmpty()) {
			sql.append(" AND upper(f.anoLancamento) like '%:anoLancamento%'");
		}
		
		Query q = this.getEntityManager().createQuery(sql.toString());

		if(titulo!=null && !titulo.isEmpty()) {
			q.setParameter("titulo", titulo);
		}
		if(diretor != null && !diretor.isEmpty()) {
			q.setParameter("diretor", diretor);
		}
		if(genero != null && !genero.isEmpty()) {
			q.setParameter("genero", genero);
		}
		if(anoLancamento != null && !anoLancamento.isEmpty()) {
			q.setParameter("anoLancamento", anoLancamento);
		}

		return q.getResultList();
	}
	
	

}
