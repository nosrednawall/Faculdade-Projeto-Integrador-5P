package br.org.iel.recrutaif.REST;

import java.util.Date;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Singleton
@Lock(LockType.READ)
@Path("/ejb")
public class SimpleRESTEJB {
    @GET
    public String ejb() {
        return "ejb ok @ " + new Date().toString();
    }
}