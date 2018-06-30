package com.herokuapp.filmesoap;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import com.herokuapp.filmesoap.dao.PersistenceUtil;
import com.herokuapp.filmesoap.model.Filme;
import com.herokuapp.filmesoap.service.FilmeService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	
    	PersistenceUtil.createEntityManagerFactory("filmesoap");
    	
        System.out.println( "Hello World!" );
        Filme filme = new Filme();
        FilmeService service = new FilmeService();
        filme.setTitulo("teste2");
        service.cadastrar(filme);
        List<Filme> filmes = service.buscarFilmes();
        for (Filme f : filmes) {
        	System.out.println(f.getTitulo());
        }
        
        EntityManagerFactory emf = PersistenceUtil.getEntityManagerFactory();
		if (emf != null) {
			emf.close();
		}
    }
}
