package br.org.iel.recrutaif.testes;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Assert;

import br.org.iel.recrutaif.entity.Setor;

public class TestaInsereSetor {
	
//	public void testaInsereSetor() {
//
//		Client client = ClientBuilder.newClient();
//		WebTarget target = client.target("http://localhost:8080");
//		String conteudo = target.path("/carrinhos/1").request().get(String.class);
//		
//		Setor setor = new Setor();
//		setor.setNome("TI");
//		
//		SetorDao dao = new SetorDao();
//		
//		dao.salva(setor);
//	}
	
	public void testaBusaSetor() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		Setor setor = target.path("/recrutaif/1").request().get(Setor.class);
		
		Assert.assertEquals("TI", setor.getNome());
	}
	
}