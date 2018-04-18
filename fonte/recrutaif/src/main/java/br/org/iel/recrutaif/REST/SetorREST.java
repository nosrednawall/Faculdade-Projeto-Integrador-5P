package br.org.iel.recrutaif.REST;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.org.iel.recrutaif.dao.SetorDao;
import br.org.iel.recrutaif.entity.Setor;

@Path("setor")
public class SetorREST {

    @GET
    @Path("busca/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String printMessage(@PathParam("id")Integer id) {
    	
    	Setor setor = new SetorDao().buscaSetor(id);
    	return setor.toGson();
        //return Response.status(200).entity(result).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String mostraSetor() {
//    	List<Setor> setores = new SetorDao().listaSetores();
//    	return ((Setor) setores).toGson();
    	
    	return "Acessou";
    }
}
