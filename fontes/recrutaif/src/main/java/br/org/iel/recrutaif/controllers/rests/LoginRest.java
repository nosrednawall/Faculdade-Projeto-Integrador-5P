package br.org.iel.recrutaif.controllers.rests;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;

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
	public Response fazerLogin(String credenciaisJson) {

		try {
			
			System.out.println("credencial json " + credenciaisJson);
			
			Gson gson = new Gson();
			
			Credencial credencial = gson.fromJson(credenciaisJson, Credencial.class);	
			
			Usuario entity = validarCrendenciais(credencial);
			if(entity ==  null) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			
			String usuarioGson = gson.toJson(entity);
			
			return Response.accepted(usuarioGson).build();

		} catch (Exception e) {
			System.out.println("credencial json " + credenciaisJson);

			e.printStackTrace();
			return Response.status(Status.UNAUTHORIZED).build();
		}

	}
	private Usuario validarCrendenciais(Credencial credencial) {
		
		return dao.getBuscaPorEmail(credencial);
	}
}
