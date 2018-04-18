package br.org.iel.recrutaif;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class AplicacaoREST extends ResourceConfig {
	
	
	public AplicacaoREST() {
		packages("br.org.iel.recrutaif.REST");
	}
	
 
}