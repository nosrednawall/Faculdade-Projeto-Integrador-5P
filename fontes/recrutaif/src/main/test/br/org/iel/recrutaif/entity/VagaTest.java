package br.org.iel.recrutaif.entity;

import static org.junit.Assert.assertTrue;
import java.io.ByteArrayInputStream;
import java.text.ParseException;
import org.junit.jupiter.api.Test;
public class VagaTest {

//*//**
//* Titulo:
//* 1-Não deve ficar em branco 
//* 2-Não ultrapassar 50 caracteres
//* 3-Não deve conter numeros
//*//*	
	
	@Test
	public void deveRetornarErroSeOCampoEstiverVazio() throws ParseException {
		
		String conteudo = "";
		Vaga vagaTeste = new Vaga();
		
		vagaTeste.setTitulo(conteudo);

//		Collection<titulo> Titulo  = importador.(input);
		assertTrue("O campo está vazio", vagaTeste.getTitulo().isEmpty());

}



}
