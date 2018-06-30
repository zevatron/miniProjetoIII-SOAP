package com.herokuapp.filmesoap;

import javax.persistence.EntityManagerFactory;
import javax.xml.ws.Endpoint;

import com.herokuapp.filmesoap.dao.PersistenceUtil;
import com.herokuapp.filmesoap.service.FilmeService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	
    	
    	FilmeService filmeService = new FilmeService();
    	
    	String port = System.getenv("PORT");
        String host = "http://0.0.0.0:";
        String uri = "/service";
        Endpoint.publish(host + port + uri, filmeService);
    	
        
        
    }
}
