package br.org.iel.recrutaif.controllers.validators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

	public class teste{
		
		public void testeMarionetteDriver(){

	   System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
	   WebDriver driver = new FirefoxDriver();
	   driver.get("http://eliasnogueira.com");
	   driver.quit();

	}
}