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

import br.org.iel.recrutaif.dao.UsuarioDao;
import br.org.iel.recrutaif.entity.Usuario;

//@Seguro
@Stateless
@Path("/usuarios")
public class UsuarioRest {
	// cria a unidade de persistencia que será passada pelo wildfly

	@Inject
	private UsuarioDao dao;

	// método para criar um usuario
	@POST
	@Consumes("application/json")
	public Response create(Usuario entity) {
		dao.create(entity);
		return Response
				.created(UriBuilder.fromResource(UsuarioRest.class).path(String.valueOf(entity.getId())).build())
				.build();
	}

	@GET
	@Path("/{id:[0-9][0-9]}")
	@Produces("application/json")
	public Response buscaPorId(@PathParam("id") Integer id) {
		Usuario entity;
		try {
			entity = dao.buscaPorId(id);
		} catch (NoResultException nre) {
			entity = null;
		}
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(entity).build();
	}

	@GET
	@Produces("application/json")
	public List<Usuario> listaUsuarios(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		final List<Usuario> results = dao.listaTodos(startPosition, maxResult);
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Integer id, Usuario entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!id.equals(entity.getId())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (dao.buscaPorId(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		try {
			entity = dao.atualiza(entity);
		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT).entity(e.getEntity()).build();
		}

		return Response.noContent().build();
	}

}