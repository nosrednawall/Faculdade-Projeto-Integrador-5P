package br.org.iel.recrutaif.controllers.validators;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class teste {
 
    /**
     * @ Teste com Selenium + JUnit
     */
	
	@Test
    public void testeSeleniumOK(){
         
        WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/recrutaif/#/register");
         
        WebElement nome = driver.findElement(By.name("nome"));
        nome.sendKeys("rá");
       
        
        
      // WebElement inputregister = driver.findElement(By.name("register"));
        
      //  <a href="#/register"> ou registre-se</a>
        
        //buttonBuscar.click();
        
        //WebElement userName = driver.findElement("<a href=\"#/register\"> ou registre-se</a>");
        
       // <a href="#/register"> ou registre-se</a>
        //userName.sendKeys("wilson");
 
    }
 
}


/*Teste de cadastro de usuário

public class teste {
		
	//private WebDriver driver = new FirefoxDriver();
	
	private WebDriver driver;
	@Test
	@BeforeClass
	public void abreBrowserChrome() {
	   System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.get("http://www.google.com.br");
	   driver.manage().window().maximize();
	}
}*/