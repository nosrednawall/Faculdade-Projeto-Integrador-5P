package br.org.iel.recrutaif.controllers.validators;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TesteSeleniumUsuario {

	/**
	 * @ Teste com Selenium + JUnit
	 */

	@Test
	public void testeSeleniumOK() {

		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/recrutaif/#/register");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement nome = driver.findElement(By.name("nome"));
		nome.sendKeys("Marco Polo Paulo Algusto");

		WebElement matricula = driver.findElement(By.name("matricula"));
		matricula.sendKeys("32324");

		WebElement dataAdmissao = driver.findElement(By.name("dataAdmissao"));
		Actions action = new Actions(driver);
		action.doubleClick(dataAdmissao).perform();
		dataAdmissao.sendKeys(new String[] { "19921128" });

		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("marco.polo.paulo.augusto@gmail.com");

		WebElement senha = driver.findElement(By.name("senha"));
		senha.sendKeys("123456");

		WebElement salvar = driver.findElement(By.name("salvar"));
		salvar.click();
		
		/*
		 * System.out.println("Antes da Data");
		 * 
		 * WebElement dataAdmissao = driver.findElement(By.className("dataAdmissao"));
		 * dataAdmissao.sendKeys(""); dataAdmissao.click();
		 * dataAdmissao.sendKeys("10.09.18");
		 */
		System.out.println("Depos Data");

		driver.findElement(By.id("Data Admissão")).click();
		driver.findElement(By.id("Salvar")).sendKeys("1");

		WebElement hideCalendar = driver.findElement(By.id("Data Admissão"));
		hideCalendar.sendKeys("2018-08-08");

		/*
		 * // WebElement data = driver.findElement(By.id("Data Admissão"));
		 * data.click(); data.sendKeys(Keys.ENTER); data.sendKeys("2018-08-08");
		 * 
		 * System.out.println("Antes da data");
		 * 
		 * driver.quit();
		 */

		/*
		 * WebElement dataAdmissao =
		 * driver.findElement(By.id("//input[@Date='usuario.dataAdmissao]"));
		 * dataAdmissao.sendKeys(Keys.ENTER); dataAdmissao.sendKeys("2018-08-08");
		 */

		System.out.println("Depois da data");

		/*
		 * WebElement setDatepickerDay =
		 * driver.findElement(By.cssSelector("setDatepickerDay")); ((Select)
		 * setDatepickerDay).selectByVisibleText("2018-08-08");
		 */

		System.out.println("depois d data");

		/*
		 * WebElement hideCalendar =
		 * driver.findElement(By.id("id=usuario.dataAdmissao"));
		 * hideCalendar.sendKeys("2018-08-08");
		 * 
		 * 
		 * 
		 * 
		 * WebElement email = driver.findElement(By.name("email"));
		 * email.sendKeys("neymar.psg,junior@gmail.com");
		 * 
		 * WebElement senha = driver.findElement(By.name("senha"));
		 * senha.sendKeys("123");
		 */

		// WebElement inputregister = driver.findElement(By.name("register"));

		// <a href="#/register"> ou registre-se</a>

		// buttonBuscar.click();

		// WebElement userName = driver.findElement("<a href=\"#/register\"> ou
		// registre-se</a>");

		// <a href="#/register"> ou registre-se</a>
		// userName.sendKeys("wilson");

	}

}
