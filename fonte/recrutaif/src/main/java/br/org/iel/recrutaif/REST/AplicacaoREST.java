package br.org.iel.recrutaif.REST;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class AplicacaoREST extends Application {
	
	public Set<Class<?>> getClasses(){
		
        return new HashSet<Class<?>>(Arrays.asList(SimpleRESTPojo.class, SimpleRESTEJB.class));
		
	}
	
	
	
 
}