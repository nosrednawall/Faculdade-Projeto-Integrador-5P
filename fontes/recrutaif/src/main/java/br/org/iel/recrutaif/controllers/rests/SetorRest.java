package br.org.iel.recrutaif.controllers.rests;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import br.org.iel.recrutaif.model.dao.SetorDao;
import br.org.iel.recrutaif.model.entity.Setor;
import br.org.iel.recrutaif.model.enums.StatusBinarioEnum;

/**
 * Classe rest de setor
 * @author anderson
 *
 */

@Stateless
@Path("/setores")
public class SetorRest {
	/**
	 * Responsável por injetar o dao
	 */
	@Inject
	private SetorDao dao;

	/**
	 * Método para salvar um setor no banco
	 * @param entity
	 * @return
	 */
	@POST
	@Consumes("application/json")
	public Response create(Setor entity) {
		entity.setStatus(StatusBinarioEnum.ATIVO);
		dao.save(entity);
		return Response
				.created(UriBuilder.fromResource(SetorRest.class).path(String.valueOf(entity.getId())).build())
				.build();

	}
	/**
	 * Método para apagar um setor do banco
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") Integer id) {
		Setor entity = null;
		if((entity = dao.find(Setor.class, id)) != null) {
			dao.remove(entity);
		}
		return Response.noContent().build();
	}

	/**
	 * Método para buscar um setor pelo id
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public Response findById(@PathParam("id") Integer id) {

		Setor entity = dao.find(id);

		return Response.ok(entity).build();
	}

	@GET
	@Path("/listar/{status:[0-3]*}")
	@Produces("application/json")
	public List<Setor> listaUsuarios(@PathParam("status") Integer idstatus) {

		StatusBinarioEnum status;

		final List<Setor> results;

		if (idstatus == 0) {
			status = StatusBinarioEnum.ATIVO;
		} else if (idstatus == 1) {
			status = StatusBinarioEnum.INATIVO;
		} else {
			status = StatusBinarioEnum.AMBOS;
		}

		results = dao.listaTodos(status);

		return results;
	}
	/**
	 * Método para atualizar um setor, pelo id
	 * @param id
	 * @param entity
	 * @return
	 */
	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Integer id, Setor entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!id.equals(entity.getId())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (dao.find(Setor.class, id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		try {
			entity = dao.update(entity);
		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT).entity(e.getEntity()).build();
		}

		return Response.noContent().build();
	}
}