package br.org.iel.recrutaif.entity;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.util.Collection;

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
		ByteArrayInputStream input = new ByteArrayInputStream(new byte[0]);
		Vaga importador = new Vaga();
		
		Collection<Setor> titulo = importador.getSetores();
		
//		Collection<titulo> Titulo  = importador.(input);
		
		
		
		assertTrue("O campo está vazio", titulo.isEmpty());
		
		
}

private Collection<Vaga> importador(String conteudo) {
	// TODO Auto-generated method stub
	return null;
}

}
