package br.org.iel.recrutaif.controllers.rests;

import java.util.Date;
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

import br.org.iel.recrutaif.controllers.validators.VagaValidator;
import br.org.iel.recrutaif.model.dao.SetorDao;
import br.org.iel.recrutaif.model.dao.VagaDao;
import br.org.iel.recrutaif.model.entity.Setor;
import br.org.iel.recrutaif.model.entity.Vaga;
import br.org.iel.recrutaif.model.entity.VagaIds;
import br.org.iel.recrutaif.model.enums.StatusBinarioEnum;

@Stateless
@Path("/vagas")
public class VagaRest {

	@Inject
	private VagaDao dao;
	@Inject
	private SetorDao daoSetor;

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
	public Response create(VagaIds entity) throws InstantiationException, IllegalAccessException {

		System.out.println(entity);
		VagaValidator validacao = new VagaValidator();

		Setor setor = daoSetor.find(entity.getIdSetor());

		Vaga vaga = new Vaga(entity.getTitulo(), entity.getDescricao(), StatusBinarioEnum.ATIVO,
				Date.class.newInstance(), entity.getDataExpiracao(), setor);

		if (validacao.validaVaga(vaga)) {
			dao.save(vaga);
			return Response
					.created(UriBuilder.fromResource(VagaRest.class).path(String.valueOf(entity.getId())).build())
					.build();
		}

		return Response.status(Status.CONFLICT).entity(entity).build();

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
		Vaga entity;
		try {
			entity = dao.find(id);
			System.out.println(entity);
		} catch (NoResultException nre) {
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
	@Path("/listar/{status:[0-3]*}")
	@Produces("application/json")
	public List<Vaga> listaVagas(@PathParam("status") Integer idstatus) {
		StatusBinarioEnum status;

		final List<Vaga> results;

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
	 * Atualiza a vaga, recebe o id no caminho e no corpo a vaga completa e alterada
	 * 
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