//<<<<<<< HEAD
////package br.org.iel.recrutaif.security;
////
////import java.io.IOException;
////import java.util.List;
////
////import javax.ws.rs.container.ContainerRequestContext;
////import javax.ws.rs.container.ContainerRequestFilter;
////
////import org.jboss.resteasy.util.Base64;
////
////public class SecurityFilter implements ContainerRequestFilter {
////
////	private static final String AUTHORIZATION_HEADER_KEY = "Authotization";
////	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
////	
////	@Override
////	public void filter(ContainerRequestContext requestContext) throws IOException {
////		List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
////		
////		if(authHeader.size() > 0) {
////			String authToken = authHeader.get(0);
////			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
//////			String decodedString = Base64.decodeAsString(authToken);
////		}
////	}
////
////}
////
////
//////tava assistindo a https://www.youtube.com/watch?v=W5jm4E0TTlA video
//=======
//package br.org.iel.recrutaif.security;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//
//public class SecurityFilter implements ContainerRequestFilter {
//
//	private static final String AUTHORIZATION_HEADER_KEY = "Authotization";
//	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
//	
//	@Override
//	public void filter(ContainerRequestContext requestContext) throws IOException {
//		List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
//		
//		if(authHeader.size() > 0) {
//			String authToken = authHeader.get(0);
//			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
////			String decodedString = Base64.decodeAsString(authToken);
//		}
//	}
//
//}
//
//
////tava assistindo a https://www.youtube.com/watch?v=W5jm4E0TTlA video
//>>>>>>> 42308dff1e2df5baa90cf28341ee819c522f22df
