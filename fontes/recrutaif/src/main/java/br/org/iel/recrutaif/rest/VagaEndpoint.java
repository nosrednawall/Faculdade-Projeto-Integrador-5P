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
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import br.org.iel.recrutaif.model.Setor;
import br.org.iel.recrutaif.model.Vaga;


@Stateless
@Path("/vagas")
public class VagaEndpoint {
	// cria a unidade de persistencia que será passada pelo wildfly
	@PersistenceContext(unitName = "recrutaif-persistence-unit")
	private EntityManager em;

	// método para criar um Vaga
	@POST
	@Consumes("application/json")
	public Response create(Vaga entity) {
		em.persist(entity);
		// retorna o link de acesso ao Vaga criado
		return Response
				.created(UriBuilder.fromResource(VagaEndpoint.class).path(String.valueOf(entity.getId())).build())
				.build();
	}

	@GET
	@Path("/{id:[0-9][0-9]}")
	@Produces("application/json")
	public Response buscaPorId(@PathParam("id") Long id) {
		TypedQuery<Vaga> queryBuscaPorId = em
				.createQuery("SELECT DISTINCT v FROM Vaga v WHERE v.id = :entityId ORDER BY v.id",Vaga.class);
		queryBuscaPorId.setParameter("entityId", id);
		Vaga entity;
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
	public List<Vaga> listaVagas(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<Vaga> findAllQuery = em.createQuery(
				"SELECT DISTINCT v FROM Vaga v ORDER BY v.id", Vaga.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<Vaga> results = findAllQuery.getResultList();
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Long id, Vaga entity) {
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