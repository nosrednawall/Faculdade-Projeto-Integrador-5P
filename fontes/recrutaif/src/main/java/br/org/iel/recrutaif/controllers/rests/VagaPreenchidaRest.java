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

import br.org.iel.recrutaif.model.dao.VagaDao;
import br.org.iel.recrutaif.model.dao.VagaPreenchidaDao;
import br.org.iel.recrutaif.model.entity.Usuario;
import br.org.iel.recrutaif.model.entity.Vaga;
import br.org.iel.recrutaif.model.entity.VagaPreenchida;
import br.org.iel.recrutaif.model.entity.VagaPreenchidaIds;
import br.org.iel.recrutaif.model.enums.StatusBinarioEnum;

@Stateless
@Path("/vagaspreenchidas")
public class VagaPreenchidaRest {

	@Inject
	private VagaPreenchidaDao dao;
	private VagaDao daoVaga;
	private Usuario daoUsuario;

	/**
	 * método salva vaga no bd e retorna o id da vaga salva
	 * 
	 * @param entity
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response create(VagaPreenchidaIds ids) throws InstantiationException, IllegalAccessException {

		System.out.println(ids);
		 Vaga vaga = daoVaga.find(ids.getVagaId());
//		 Usuario usuario = new UsuarioDao().find(ids.getCandidatoId());
//		 Date horarioInscricao = Date.class.newInstance();
//		 
//		 VagaPreenchida entity = new VagaPreenchida(horarioInscricao, vaga, usuario);
//		 
//		 System.out.println(entity);
//		
//		 dao.save(entity);
//		 return Response
//		 .created(UriBuilder.fromResource(VagaPreenchidaRest.class).path(String.valueOf(entity.getId())).build())
//		 .build();

		return Response.ok().build();
		
	}

	/**
	 * método recebe o id e retorna a vaga
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public Response buscaPorId(@PathParam("id") Integer id) {
		VagaPreenchida entity;
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
	 * 
	 * @param status
	 * @return
	 */
	@GET
	@Produces("application/json")
	public List<VagaPreenchida> listaVagas() {
		final List<VagaPreenchida> results = dao.listaTodos(StatusBinarioEnum.ATIVO);
		return results;
	}

	/**
	 * Atualiza a vaga, recebe o id no caminho e no corpo a vaga completa e alterada
	 * 
	 * @param id
	 * @param entity
	 * @return
	 */
	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Integer id, VagaPreenchida entity) {
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