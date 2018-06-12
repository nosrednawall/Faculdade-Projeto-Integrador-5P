package br.org.iel.recrutaif.controllers.validators;

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
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/recrutaif/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		System.out.println( "Erro aqui mesmo");
		WebElement email = driver.findElement(By.name("Usuario.email"));
		WebElement senha = driver.findElement(By.name("Usuario.senha"));
		System.out.println( "Erro aqui");
		email.sendKeys("everton@recrutaif.com.br");
		senha.sendKeys("123");
	}
	
}

//	@After	

