package br.org.iel.recrutaif.controllers.rests;

import java.util.Calendar;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.DatatypeConverter;

import com.google.gson.Gson;

import br.org.iel.recrutaif.model.dao.UsuarioDao;
import br.org.iel.recrutaif.model.entity.Credencial;
import br.org.iel.recrutaif.model.entity.Usuario;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Stateless
@Path("/login")
public class LoginRest {

	private static final String FRASE_SEGREDO = "Hipopo";

	@Inject
	UsuarioDao dao;

	// recebe um usuário
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response fazerLogin(String credenciaisJson) {

		try {
			
			System.out.println("credencial json " + credenciaisJson);
			
			Gson gson = new Gson();
			
			Credencial credencial = gson.fromJson(credenciaisJson, Credencial.class);	
			
			System.out.println("credencial foi transformada em objeto " + credencial.getEmail()+" , "+ credencial.getSenha());

			Usuario entity = validarCrendenciais(credencial);
			if(entity ==  null) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			
			System.out.println("Credencial foi validada");
			
			
			String usuarioGson = gson.toJson(entity);
			
			System.out.println(usuarioGson);
			
			
			return Response.accepted(usuarioGson).build();
//			return Response.ok(usuarioGson).build();
//			// gera o token
//			String token = gerarToken(credencial.getEmail(),1);
//
//			System.out.println("A token gerada é: "+token);
//			
//            JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
//            jsonObjBuilder.add( "auth_token", token );
//            JsonObject jsonObj = jsonObjBuilder.build();
//			
//            System.out.println("O json gerado é : "+jsonObj);
//            
//            return getNoCacheResponseBuilder( Response.Status.OK ).entity( jsonObj.toString() ).build();

		} catch (Exception e) {
			System.out.println("credencial json " + credenciaisJson);

			e.printStackTrace();
			return Response.status(Status.UNAUTHORIZED).build();
		}

	}
	
    private Response.ResponseBuilder getNoCacheResponseBuilder( Response.Status status ) {
        CacheControl cc = new CacheControl();
        cc.setNoCache( true );
        cc.setMaxAge( -1 );
        cc.setMustRevalidate( true );
 
        return Response.status( status ).cacheControl( cc );
    }

	private Usuario validarCrendenciais(Credencial credencial) {
		
		return dao.getBuscaPorEmail(credencial);
	}

	//pegou o email e a quantidade de dias para expirar o token
	private String gerarToken(String email, Integer expiraEmDias) {

		// Defini qual vai ser o algotirmo da assinatura no caso vai ser o HMAC SHA512
		SignatureAlgorithm algoritimoAssinatura = SignatureAlgorithm.HS512;
		
		// Data atual que data que o token foi gerado
		Date agora = new Date();
		
		// Define até que data o token é pelo quantidade de dias que foi passo pelo
		// parametro expiraEmDias
		Calendar expira = Calendar.getInstance();
		expira.add(Calendar.DAY_OF_MONTH, expiraEmDias);
		
		// Encoda a frase sergredo pra base64 pra ser usada na geração do token
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(FRASE_SEGREDO);

		SecretKeySpec key = new SecretKeySpec(apiKeySecretBytes, algoritimoAssinatura.getJcaName());

		// E finalmente utiliza o JWT builder pra gerar o token
		JwtBuilder construtor = Jwts.builder().setIssuedAt(agora)// Data que o token foi gerado
				.setIssuer(email)// Coloca o login do usuario mais podia qualquer outra informação
				.signWith(algoritimoAssinatura, key)// coloca o algoritimo de assinatura e frase segredo ja encodada
				.setExpiration(expira.getTime());// coloca até que data que o token é valido

		return construtor.compact();// Constroi o token retorando a string dele
	}

//	public Claims validaToken(String token) {
//		try {
//			// JJWT vai validar o token caso o token não seja valido ele vai executar uma
//			// exeption
//			// o JJWT usa a frase segredo pra descodificar o token e ficando assim possivel
//			// recuperar as informações que colocamos no payload
//			Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(FRASE_SEGREDO))
//					.parseClaimsJws(token).getBody();
//			// Aqui é um exemplo que se o token for valido e descodificado
//			// vai imprimir o login que foi colocamos no token
//			System.out.println(claims.getIssuer());
//			return claims;
//		} catch (Exception ex) {
//			throw ex;
//		}
//	}
//
//	public NivelPermissao buscarNivelPermissao(String login) {
//
//		return NivelPermissao.ADMINISTRADOR;
//
//	}
}
