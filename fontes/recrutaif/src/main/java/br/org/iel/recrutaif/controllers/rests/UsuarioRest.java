package br.org.iel.recrutaif.controllers.rests;

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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import br.org.iel.recrutaif.model.dao.UsuarioDao;
import br.org.iel.recrutaif.model.entity.Usuario;
import br.org.iel.recrutaif.model.enums.StatusBinarioEnum;

/**
 * 
 * @author anderson
 *
 */
// @Seguro
@Stateless
@Path("/usuarios")
public class UsuarioRest {

	/**
	 * Dao sendo injetado pelo CDI
	 */
	@Inject
	private UsuarioDao dao;

	/**
	 * Método para adicionar um usuario
	 * 
	 * @param usuarioGson
	 * @return
	 */
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response create(Usuario entity) {

		System.out.println(entity);

		// System.out.println(usuarioGson);
		//
		// Gson gson = new Gson();
		// Usuario novoUsuario = gson.fromJson(usuarioGson, Usuario.class);

		// System.out.println(usuarioGson);
		// System.out.println(novoUsuario);

		dao.save(entity);
		return Response.created(UriBuilder.fromResource(UsuarioRest.class).path(String.valueOf(entity.getId())).build())
				.build();

		// return Response.ok().build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public Response buscaPorId(@PathParam("id") Integer id) {
		Usuario entity;
		try {
			entity = dao.find(Usuario.class, id);
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
	public List<Usuario> listaUsuarios() {
		final List<Usuario> results = dao.listaTodos(StatusBinarioEnum.ATIVO);

		return results;
	}

	// @GET
	// @Produces("application/json")
	// public List<Usuario> listaUsuarios(@QueryParam("status") StatusUsuario
	// status) {
	// final List<Usuario> results = dao.listaTodos(status);
	// return results;
	// }

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
		if (dao.find(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		try {

			entity = dao.update(entity);

		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT).entity(e.getEntity()).build();
		}
		entity = dao.update(entity);
		return Response.noContent().build();
	}
}