package br.org.iel.recrutaif;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

import br.org.iel.recrutaif.DTO.SetorDTO;


public class SetorTest {
	
	@Test
	public void TestaBusca() {
		
		Client client= ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/rest/setor/busca/1").request().get(String.class);
		System.out.println(conteudo);
		SetorDTO setor = (SetorDTO) new Gson().fromJson(conteudo, SetorDTO.class);
		Assert.assertEquals("TI",setor.getNome());

	}
}
