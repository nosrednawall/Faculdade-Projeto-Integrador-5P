package br.org.iel.recrutaif.REST;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.org.iel.recrutaif.entity.Setor;
import br.org.iel.recrutaif.dao.SetorDao;

@Path("/setor")
public class SetorREST {

    @GET
    @Path("/busca/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String printMessage(@PathParam("id")Integer id) {
    	
    	Setor setor = new SetorDao().busca(id);
    	return setor.toGson();
        //return Response.status(200).entity(result).build();
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
