package dao;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.Before;
import org.junit.*;

import br.org.iel.recrutaif.entity.Setor;

public class TestaSetor {

//	private HttpServer server;
	private Client client;

	// executa antes de efetuar o teste, nesse caso levanta o servidor e o cliente
	@Before
	public void startaServidor() {
		// this.server = Servidor.inicializaServidor();

		// cria uma configuração para cliente
		ClientConfig config = new ClientConfig();
		// adiciona o log do jersey a configuração
		// config.register(new LoggingFilter());
		// pegao cliente da classe e instancia com a configuracao
		this.client = ClientBuilder.newClient(config);
	}

//	// exetuta depois de efetuar o teste, nesse caso fecha o servidor
//	@After
//	public void fechaServidor() {
//		this.server.stop();
//	}

	// inicia os testes

	@Test
	public void testaQueaBuscaUmCarrinhoEsperado() {

		WebTarget target = client.target("http://localhost:8080");

		Setor setor = target.path("/recrutaif/rest/setores/1").request().get(Setor.class);

		Assert.assertEquals("TI", setor.getNome());

	}

//	@Test
//	public void testaQueInsereUmCarrinho() {
//
//		// cria o cliente
//		// Client client = ClientBuilder.newClient();
//		WebTarget target = client.target("http://localhost:8080");
//
//		// cria o carrinho
//		Carrinho carrinho = new Carrinho();
//		carrinho.adiciona(new Produto(314L, "Tablet", 999, 1));
//		carrinho.setRua("Rua Vergueiro");
//		carrinho.setCidade("Sao Paulo");
//
//		// converte o carrinho para xml
//		// String xml = carrinho.toXML();
//
//		// transforma o xml de String em uma entidade
//		// Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);
//		Entity<Carrinho> entity = Entity.entity(carrinho, MediaType.APPLICATION_XML);
//
//		// efetua o envio do post para o servidor
//		Response response = target.path("/carrinhos").request().post(entity);
//
//		// recebe o retorno do post e confirma se o statuscode está correto
//		Assert.assertEquals(201, response.getStatus());
//
//		// agora pega a location do objeto criado
//		String location = response.getHeaderString("Location");
//
//		// faz um get do objeto criado
//		Carrinho carrinhoCarregado = client.target(location).request().get(Carrinho.class);
//
//		// Verifica se o objeto buscado é o mesmo
//		// Assert.assertTrue(conteudo.contains("Tablet"));
//		Assert.assertEquals("Tablet", carrinhoCarregado.getProdutos().get(0).getNome());
//	}
}
