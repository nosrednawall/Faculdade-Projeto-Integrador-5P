package br.org.iel.recrutaif.controllers.validators;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*Teste de cadastro de usuário*/

public class RegistroValidarTest {
		
	
	//private WebDriver driver = new FirefoxDriver();
	
	private WebDriver driver;
	@Before
	
	public void abreBrowser() {
	   System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
	   driver = new FirefoxDriver();
	   driver.get("http://localhost:8080/recrutaif/#/login");
	   driver.manage().window().maximize();
}

/*	public void abreBrowser() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/recrutaif/");
		driver.manage().window().maximize();*/
	
	
	@Test
	public void test() {
		//System.out.println( "Erro aqui mesmo");
		
		WebElement email = driver.findElement(By.name("Usuario.email"));
		WebElement senha = driver.findElement(By.name("Usuario.senha"));
		//System.out.println( "Erro aqui");
		
		email.sendKeys("everton@recrutaif.com.br");
		senha.sendKeys("123");
		
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
	}
	
}



