package br.org.iel.recrutaif.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import br.org.iel.recrutaif.model.dao.VagaDao;
import br.org.iel.recrutaif.model.entity.Vaga;
import br.org.iel.recrutaif.model.enums.StatusVaga;

//@Seguro
@Stateless
@Path("/vagas")
public class VagaRest {

	@Inject
	private VagaDao dao;

	/**
	 * método salva vaga no bd e retorna o id da vaga salva
	 * @param entity
	 * @return
	 */
	@POST
	@Consumes("application/json")
	public Response create(Vaga entity) {
		dao.save(entity);
		return Response
				.created(UriBuilder.fromResource(VagaRest.class).path(String.valueOf(entity.getId())).build())
				.build();
	}

	/**
	 * método recebe o id e retorna a vaga
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id:[0-9][0-9]}")
	@Produces("application/json")
	public Response buscaPorId(@PathParam("id") Integer id) {
		Vaga entity;
		try {
			entity = dao.find(id);
		} catch (NoResultException nre) {
			entity = null;
		}
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(entity).build();
	}

	/**
	 * Lista todas as vagas, recebendo o status como argumento
	 * @param status
	 * @return
	 */
	@GET
	@Produces("application/json")
	public List<Vaga> listaVagas(@QueryParam("status") StatusVaga status) {
		final List<Vaga> results = dao.listaTodos(status);
		return results;
	}

	/**
	 * Atualiza a vaga, recebe o id no caminho e no corpo a vaga completa e alterada
	 * @param id
	 * @param entity
	 * @return
	 */
	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Integer id, Vaga entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!id.equals(entity.getId())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (dao.find(id) == null) {
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