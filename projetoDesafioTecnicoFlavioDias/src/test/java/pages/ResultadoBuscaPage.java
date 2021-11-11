package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mapsWebMotors.ResultadoBuscaMap;
import scenarios.api.ConsultaApi;

public class ResultadoBuscaPage {
	ResultadoBuscaMap resultadoBuscaMap = new ResultadoBuscaMap();

	private static final Logger logger = Logger.getLogger(ResultadoBuscaPage.class);

	public void selecinarMarca(String marca, WebDriver driver) throws Exception {
		try {
			WebElement elemento = driver.findElement(By.xpath((resultadoBuscaMap.criaElementoMarca(marca))));
			elemento.click();
		} catch (Exception e) {
			throw new Exception("Erro ao selecionar a marca");
		}
	}

	public void clicarTodosModelo(WebDriver driver) throws Exception {
		try {
			WebElement elemento = driver.findElement(By.xpath((resultadoBuscaMap.criaElementoTodosModelos())));
			elemento.click();
		} catch (Exception e) {
			throw new Exception("Erro ao clicar em Todos os modelos");
		}
	}

	public void selecinarModelo(String modelo, WebDriver driver) throws Exception {
		try {
			WebElement elemento = driver.findElement(By.xpath((resultadoBuscaMap.criaElementoModelo(modelo))));
			elemento.click();
		} catch (Exception e) {
			throw new Exception("Erro ao selecionar a modelo");
		}
	}

	public void clicarTodasVersoes(WebDriver driver) throws Exception {
		try {
			WebElement elemento = driver.findElement(By.xpath((resultadoBuscaMap.criaElementoTodasVersoes())));
			elemento.click();
		} catch (Exception e) {
			throw new Exception("Erro ao selecionar a versao");
		}
	}

	public void selecinarVersao(String versao, WebDriver driver) throws Exception {
		try {
			WebElement elemento = driver.findElement(By.xpath((resultadoBuscaMap.criaElementoClicaPrimeiroResultado())));
			elemento.click();
		} catch (Exception e) {
			throw new Exception("Erro ao selecionar a versao");
		}
	}

	public boolean validaMarca(String marca, WebDriver driver) throws Exception {
		WebElement elemento;
		try {
			elemento = driver.findElement(By.xpath((resultadoBuscaMap.criaElementoValidaMarca(marca))));
		} catch (Exception e) {
			throw new Exception("Erro ao selecionar a marca");
		}
		return elemento.isDisplayed();

	}

	public boolean validaModelo(String modelo, WebDriver driver) throws Exception {
		WebElement elemento;
		try {
			elemento = driver.findElement(By.xpath((resultadoBuscaMap.criaElementoValidaModelo(modelo))));
		} catch (Exception e) {
			throw new Exception("Erro ao selecionar a modelo");
		}
		return elemento.isDisplayed();
		
	}

	public boolean validaVersao(String versao, WebDriver driver) throws Exception {
		WebElement elemento;
		try {
			elemento = driver.findElement(By.xpath((resultadoBuscaMap.criaElementoValidaVersao(versao))));
		} catch (Exception e) {
			throw new Exception("Erro ao selecionar a versao");
		}
		return elemento.isDisplayed();
		
	}
}
