package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mapsWebMotors.EstoqueLojaMap;
import mapsWebMotors.ResultadoBuscaMap;
import scenarios.api.ConsultaApi;

public class EstoqueLojaPage {
	EstoqueLojaMap estoqueLojaPage = new EstoqueLojaMap();
	private static final Logger logger = Logger.getLogger(EstoqueLojaPage.class);


	public void validaModeloEstoqueLoja(String versao, WebDriver driver) throws Exception {
		WebElement elemento;
		try {
			elemento = driver.findElement(By.xpath((estoqueLojaPage.criaElementoEstoqueLoja(versao))));
		} catch (Exception e) {
			throw new Exception("Erro ao validar modelo/versao no estoque da loja");
		}
		 elemento.click();
		
	}
}
