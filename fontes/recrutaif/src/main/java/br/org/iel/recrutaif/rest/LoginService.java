package br.org.iel.recrutaif.rest;

import java.util.Calendar;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.DatatypeConverter;

import com.google.gson.Gson;

import br.org.iel.recrutaif.entity.Credencial;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Path("/login")
public class LoginService {

	private static final String FRASE_SEGREDO = "Hipopotomonstrosesquipedaliofobia";
	
	@POST
	@Consumes("application/json")
	public Response fazerLogin(String credenciaisJson) {

		try {

			Gson gson = new Gson();
			Credencial credencial = gson.fromJson(credenciaisJson, Credencial.class);
//			validarCredenciais(credencial);

			String token = gerarToken(credencial.getEmail(), 1);

			return Response.ok(token).build();

		} catch (Exception e) {
			
			System.out.println(credenciaisJson);
//			System.out.println(cre);
			
			e.printStackTrace();

			return Response.status(Status.UNAUTHORIZED).build();
		}

	}

	private void validarCredenciais(Credencial credencial) throws Exception {

		try {
			if (!credencial.getEmail().equals("teste") || !credencial.getSenha().equals("123"));
			throw new Exception("Crendencias não válidas!");
		} catch (Exception e) {
			throw e;
		}
	}

	private String gerarToken(String email, Integer expiraEmDias) {

		SignatureAlgorithm algoritmoAssinatura = SignatureAlgorithm.HS512;

		Date agora = new Date();
		
		Calendar expira = Calendar.getInstance();
		expira.add(Calendar.DAY_OF_MONTH, expiraEmDias);
		
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(FRASE_SEGREDO);
		SecretKeySpec key = new SecretKeySpec(apiKeySecretBytes, algoritmoAssinatura.getJcaName());
		
		JwtBuilder contrutor = Jwts.builder().setIssuedAt(agora).setIssuer(email).signWith(algoritmoAssinatura, key).setExpiration(expira.getTime());
		
		return contrutor.compact();

	}

}
