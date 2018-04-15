package br.org.iel.recrutaif.REST;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.org.iel.recrutaif.dao.SetorDao;
import br.org.iel.recrutaif.entity.Setor;

@Path("/setor")
public class SetorREST {

    @GET
    @Path("/listar")
    @Produces("application/json")
    @PathParam("param")
    public Response printMessage(String msg) {
    	
        String result = "Restful example: " + msg;
        return Response.status(200).entity(result).build();
    }
    
    @GET
    @Path("/busca")
    @Produces(MediaType.APPLICATION_JSON)
    @PathParam("id")
    public String mostraSetor(Integer id) {
    	Setor setor = new SetorDao().busca(id);
    	return setor.toGson();
    }
    
}
