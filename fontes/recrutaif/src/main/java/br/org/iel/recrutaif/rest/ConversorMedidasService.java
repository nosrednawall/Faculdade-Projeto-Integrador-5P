package br.org.iel.recrutaif.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("servicos")
public class ConversorMedidasService {

	@GET
	@Path("quilometrosParaMilhas/{quilometros}")
	public Response quilometroParaMilha(@PathParam("quilometros") Double quilometros) {

		quilometros = quilometros / 1.6;
		return Response.ok(quilometros).build();

	}

	@GET

	@Path("milhasParaQuilometros/{milhas}")

	// Metodo que faz um simples conversão de milhas para quilometros

	public Response milhasParaQuilometros(@PathParam("milhas") Double milhas)

	{

		milhas = milhas * 1.6;

		return Response.ok(milhas).build();

	}

}
