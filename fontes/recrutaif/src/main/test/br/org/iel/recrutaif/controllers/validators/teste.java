package br.org.iel.recrutaif.controllers.validators;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*Teste de cadastro de usuário*/

public class teste {
		
	
	//private WebDriver driver = new FirefoxDriver();
	
	private WebDriver driver;
	
	@BeforeClass
	public void abreBrowser() throws Exception {
	   System.setProperty("webdriver.chrome.driver", "C:\\geckodriver.exe");
	   driver = new FirefoxDriver();
	   driver.get("http:\\localhost:8080/");
	   driver.manage().window().maximize();
}
}