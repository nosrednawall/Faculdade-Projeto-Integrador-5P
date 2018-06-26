package br.org.iel.recrutaif.controllers.rests;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.org.iel.recrutaif.model.dao.UsuarioDao;
import br.org.iel.recrutaif.model.entity.Credencial;
import br.org.iel.recrutaif.model.entity.Usuario;

@Stateless
@Path("/login")
public class LoginRest {

	@Inject
	UsuarioDao dao;

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response fazerLogin(Credencial credencial) {

		Usuario entity = validarCrendenciais(credencial);
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		return Response.accepted(entity).build();

	}

	private Usuario validarCrendenciais(Credencial credencial) {

		return dao.getBuscaPorEmail(credencial);
	}
}
