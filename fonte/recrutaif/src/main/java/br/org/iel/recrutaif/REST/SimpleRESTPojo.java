package br.org.iel.recrutaif.REST;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/pojo")
public class SimpleRESTPojo {
    @GET
    public String pojo() {
        return "pojo ok @ " + new Date().toString();
    }
}