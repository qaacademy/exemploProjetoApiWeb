package scenarios.web;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import objects.Veiculo;
import pages.EstoqueLojaPage;
import pages.ResultadoBuscaPage;

public class ScriptBuscaWebMotors {
	private static final Logger logger = Logger.getLogger(ScriptBuscaWebMotors.class);

	private static final long timeout = 5000;

	ResultadoBuscaPage resultadoBusca = new ResultadoBuscaPage();
	EstoqueLojaPage estoqueLojaPage = new EstoqueLojaPage();
	private WebDriver driver;
	Veiculo veiculo = new Veiculo();
	

	@Before
	public void beforeTest(Scenario scenario) throws Exception {
		logger.info("-- Inicio da Execução Cenário: " + scenario.getName());
	}

	@After
	public void afterTest(Scenario scenario) throws Exception {
		logger.info("-- Fim da Execução Cenário: " + scenario.getName());
		driver.close();
	}

	@Dado("que o usuário esteja na pagina de resultado da busca")
	public void que_o_usuário_esteja_na_pagina_de_resultado_da_busca() throws InterruptedException {
		inicializaChromeDriver();
		
		driver.get("https://www.webmotors.com.br/carros/estoque?tipoveiculo=carros&estadocidade=estoque");
		espera(5);
	}


	
	
	@Dado("que o usuário esteja na pagina da loja Mazola automóveis")
	public void que_o_usuário_esteja_na_pagina_da_loja() throws InterruptedException {
		inicializaChromeDriver();
		driver.get("https://www.webmotors.com.br/carros/estoque/?IdRevendedor=3834764&TipoVeiculo=carros&anunciante=concession%C3%A1ria%7Cloja");
		espera(5);
	}


	/**
	 * Espera
	 * 
	 * @param tempo em segundos
	 * @throws InterruptedException
	 */
	private void espera(int tempo) throws InterruptedException {
		Thread.sleep(tempo * 1000);
	}

	@Quando("selecionar a marca: {string}")
	public void selecionar_a_marca(String marca) throws Exception {
		veiculo.setMarca(marca);
		resultadoBusca.selecinarMarca(marca, driver);
		espera(2);

	}

	@Quando("selecionar o modelo: {string}")
	public void selecionar_o_modelo(String modelo) throws Exception {
		veiculo.setModelo(modelo);
		resultadoBusca.clicarTodosModelo(driver);
		espera(2);
		resultadoBusca.selecinarModelo(modelo, driver);
		espera(2);
	}

	@Quando("selecionar a versão: {string}")
	public void selecionar_a_versão(String versao) throws Exception {
		veiculo.setVersao(versao);
		resultadoBusca.clicarTodasVersoes(driver);
		espera(2);
		resultadoBusca.selecinarVersao(versao, driver);
		espera(5);
	}

	@Então("validar se a marca, modelo e versão da ficha estão corretos")
	public void validar_se_a_marca_modelo_e_versão_da_ficha_estão_corretos() throws Exception {
		trocarJanela();
		assertTrue("Marca Incorreta", resultadoBusca.validaMarca(veiculo.getMarca(),driver));
		assertTrue("Modelo Incorreto", resultadoBusca.validaModelo(veiculo.getModelo(),driver));
		assertTrue("Versao Incorreto",resultadoBusca.validaVersao(veiculo.getVersao(),driver));
	}
	
	@Então("selecionar modelo e versao no estoque da loja")
	public void selecionarModeloEVersaoEstoque() throws Exception {
		estoqueLojaPage.validaModeloEstoqueLoja(veiculo.getVersao(), driver);
	}
	
	
	private void trocarJanela() {
		Set<String> handlers =driver.getWindowHandles();
		Iterator<String> itr= handlers.iterator();
		itr.next();
		driver.switchTo().window(itr.next());
	}
	
	private void inicializaChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "/projetoDesafioTecnicoFlavioDias/driver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");

		
		driver = new ChromeDriver(chromeOptions);
	}

}
