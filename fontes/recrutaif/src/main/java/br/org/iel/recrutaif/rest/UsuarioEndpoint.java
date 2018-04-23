package br.org.iel.recrutaif.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.Status;

import br.org.iel.recrutaif.entity.Setor;
import br.org.iel.recrutaif.entity.Usuario;

@Stateless
@Path("/usuarios")
public class UsuarioEndpoint {
	// cria a unidade de persistencia que será passada pelo wildfly
	@PersistenceContext(unitName = "recrutaif-persistence-unit")
	private EntityManager em;

	// método para criar um usuario
	@POST
	@Consumes("application/json")
	public Response create(Usuario entity) {
		em.persist(entity);
		// retorna o link de acesso ao usuario criado
		return Response
				.created(UriBuilder.fromResource(UsuarioEndpoint.class).path(String.valueOf(entity.getId())).build())
				.build();
	}

	@GET
	@Path("/{id:[0-9][0-9]}")
	@Produces("application/json")
	public Response buscaPorId(@PathParam("id") Long id) {
		TypedQuery<Usuario> queryBuscaPorId = em
				.createQuery("SELECT DISTINCT u FROM Usuario u WHERE u.id = :entityId ORDER BY u.id",Usuario.class);
		queryBuscaPorId.setParameter("entityId", id);
		Usuario entity;
		try {
			entity = queryBuscaPorId.getSingleResult();
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
		TypedQuery<Usuario> findAllQuery = em.createQuery(
				"SELECT DISTINCT u FROM Usuario u ORDER BY u.id", Usuario.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<Usuario> results = findAllQuery.getResultList();
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Long id, Setor entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!id.equals(entity.getId())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(Setor.class, id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		try {
			entity = em.merge(entity);
		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT)
					.entity(e.getEntity()).build();
		}

		return Response.noContent().build();
	}
	
}
