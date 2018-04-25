package br.org.iel.recrutaif.util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;

import br.org.iel.recrutaif.entity.Setor;

public class PopulaBanco {
	
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		
		Setor setor = new Setor();
		setor.setNome("ADMINISTRACAO");
		
		Entity<Setor> entity = Entity.entity(setor, MediaType.APPLICATION_XML);
		
        Response response = target.path("/rest/setores").request().post(entity);
        
        Assert.assertEquals(201, response.getStatus());

		
		
		
	}

}
