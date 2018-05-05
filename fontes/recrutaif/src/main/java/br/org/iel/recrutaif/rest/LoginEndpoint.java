package br.org.iel.recrutaif.rest;

import java.util.Calendar;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.DatatypeConverter;

import br.org.iel.recrutaif.dao.UsuarioDao;
import br.org.iel.recrutaif.entity.Usuario;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Stateless
@Path("/login")
public class LoginEndpoint {

	private static final String FRASE_SEGREDO = "Hipopotomonstrosesquipedaliofobia";
	
	@Inject
	UsuarioDao dao;
	
	//recebe um usuário 
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response fazerLogin(Usuario entity) {

		try {
			//valida o usuario
			validarCrendenciais(entity);
			//gera o token
			String token = gerarToken(entity.getEmail(), 1);
			
			System.out.println(token);
			
			return Response.ok(token).build();

		} catch (Exception e) {
			
			e.printStackTrace();
			return Response.status(Status.UNAUTHORIZED).build();
		}
	}

	private void validarCrendenciais(Usuario crendencial) throws Exception {
		try {
			if(!crendencial.getEmail().equals("teste@teste.com") || !crendencial.getSenha().equals("123"))
				throw new Exception("Crendencias não válidas!");

		} catch (Exception e) {
			throw e;
		}

	}

	private  String gerarToken(String login,Integer expiraEmDias ){
		//Defini qual vai ser o algotirmo da assinatura no caso vai ser o HMAC SHA512
		SignatureAlgorithm algoritimoAssinatura = SignatureAlgorithm.HS512;
		//Data atual que data que o token foi gerado
		Date agora = new Date();
		//Define até que data o token é pelo quantidade de dias que foi passo pelo parametro expiraEmDias
		Calendar expira = Calendar.getInstance();
		expira.add(Calendar.DAY_OF_MONTH, expiraEmDias);
		//Encoda a frase sergredo pra base64 pra ser usada na geração do token 
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(FRASE_SEGREDO);
		
		
		SecretKeySpec key = new SecretKeySpec(apiKeySecretBytes, algoritimoAssinatura.getJcaName());
		
		
		//E finalmente utiliza o JWT builder pra gerar o token
		JwtBuilder construtor = Jwts.builder()
				.setIssuedAt(agora)//Data que o token foi gerado
				.setIssuer(login)//Coloca o login do usuario mais podia qualquer outra informação
				.signWith(algoritimoAssinatura, key)//coloca o algoritimo de assinatura e frase segredo ja encodada
				.setExpiration(expira.getTime());// coloca até que data que o token é valido

		return construtor.compact();//Constroi o token retorando a string dele
	}
	
//	backup
//	@POST
//	@Consumes("application/json")
//	public Response fazerLogin(String credenciaisJson) {
//
//		try {
//			Gson gson = new Gson();
//			Credencial credencial = gson.fromJson(credenciaisJson, Credencial.class);
//			String token = gerarToken(credencial.getEmail(), 1);
//			return Response.ok(token).build();
//
//		} catch (Exception e) {
//			
//			System.out.println(credenciaisJson);
//			e.printStackTrace();
//			return Response.status(Status.UNAUTHORIZED).build();
//		}
//
//	}
//	
//		private void validarCredenciais(Credencial credencial) throws Exception {
//
//	try {
//		
//		
//		
//		if (!credencial.getEmail().equals("teste") || !credencial.getSenha().equals("123"));
//		throw new Exception("Crendencias não válidas!");
//	} catch (Exception e) {
//		throw e;
//	}
//}
//
//private String gerarToken(String email, Integer expiraEmDias) {
//
//	SignatureAlgorithm algoritmoAssinatura = SignatureAlgorithm.HS512;
//	Date agora = new Date();
//	Calendar expira = Calendar.getInstance();
//	expira.add(Calendar.DAY_OF_MONTH, expiraEmDias);
//	byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(FRASE_SEGREDO);
//	SecretKeySpec key = new SecretKeySpec(apiKeySecretBytes, algoritmoAssinatura.getJcaName());
//	JwtBuilder contrutor = Jwts.builder().setIssuedAt(agora).setIssuer(email).signWith(algoritmoAssinatura, key).setExpiration(expira.getTime());
//	return contrutor.compact();
//
//}
	

}
