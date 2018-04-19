package br.org.iel.recrutaif.REST;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.org.iel.recrutaif.dao.SetorDao;
import br.org.iel.recrutaif.entity.Setor;

@Path("setor")
public class SetorREST {

	@GET
	@Path("busca/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String printMessage(@PathParam("id") Integer id) {

		Setor setor = new SetorDao().buscaSetor(id);
		return setor.toGson();
		// return Response.status(200).entity(result).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public String mostraSetor() {

		Setor setor = new Setor();
		setor.setNome("TI");
		new SetorDao().adiciona(setor);

		List<Setor> setores = new SetorDao().listaSetores();
		return ((Setor) setores).toGson();

		// return "Acessou";
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create() {

		return Response.ok().build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response deleteSetor(@PathParam("id") Integer id) {
		new SetorDao().deletaSetor(id);
		return Response.ok().build();
	}

//	@PATCH
//	public Response alteraSetor(@PathParam("id") Integer id, String conteudo) {
//
//		// return provisório
//		return Response.ok().build();
//	}
}
