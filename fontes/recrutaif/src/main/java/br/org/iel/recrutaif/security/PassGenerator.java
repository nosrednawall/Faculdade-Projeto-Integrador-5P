package br.org.iel.recrutaif.security;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.jboss.security.Base64Encoder;

public class PassGenerator {
	
	public static void main(String[] args) {
		
		System.out.println(new PassGenerator().generate("abc"));
		
	}
	
	public String generate(String senhaTexto) {
		try {
			byte[] digest = MessageDigest.getInstance("sha-256").digest(senhaTexto.getBytes());
			
			return Base64Encoder.encode(digest);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
