package br.org.iel.recrutaif.rest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

import com.google.gson.Gson;

import br.org.iel.recrutaif.dao.UsuarioDao;
import br.org.iel.recrutaif.entity.NivelPermissao;
import br.org.iel.recrutaif.entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Stateless
@Path("/login")
public class LoginEndpoint {

	private static final String FRASE_SEGREDO = "Hipopotomonstrosesquipedaliofobia";

	@Inject
	UsuarioDao dao;

	// recebe um usuário
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
//	@Consumes("application/json")
	public Response fazerLogin(String usuarioGson) {

		try {
			
			Gson gson = new Gson();
			
			Usuario entity = gson.fromJson(usuarioGson, Usuario.class);
			
			// valida o usuario
			validarCrendenciais(entity);
			// gera o token
			String token = gerarToken(entity.getEmail(), 1);

			System.out.println("Bearer"+token);
			return Response.ok("Bearer"+token).build();

		} catch (Exception e) {

			e.printStackTrace();
			return Response.status(Status.UNAUTHORIZED).build();
		}

	}

	private void validarCrendenciais(Usuario crendencial) throws Exception {
		try {
			final List<Usuario> results = dao.listaTodos(0, 0);

			for (Usuario usuario : results) {
				if (crendencial.getEmail().equals(usuario.getEmail())
						|| crendencial.getSenha().equals(usuario.getSenha())) {
					return;
				}
			}
			throw new Exception("Crendencias não válidas!");
		} catch (Exception e) {

			throw e;
		}

	}

	//pegou o email e a quantidade de dias para expirar o token
	private String gerarToken(String email, Integer expiraEmDias) {
		
		System.out.println(email);
		System.out.println(expiraEmDias);

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

	public Claims validaToken(String token) {
		try {
			// JJWT vai validar o token caso o token não seja valido ele vai executar uma
			// exeption
			// o JJWT usa a frase segredo pra descodificar o token e ficando assim possivel
			// recuperar as informações que colocamos no payload
			Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(FRASE_SEGREDO))
					.parseClaimsJws(token).getBody();
			// Aqui é um exemplo que se o token for valido e descodificado
			// vai imprimir o login que foi colocamos no token
			System.out.println(claims.getIssuer());
			return claims;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public NivelPermissao buscarNivelPermissao(String login) {

		return NivelPermissao.ADMINISTRADOR;

	}
}
