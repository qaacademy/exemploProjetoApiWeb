package scenarios.api;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import mapsApi.MapsApi;

/**
 * Classe para consulta de API Desafio Webmotors
 * 
 * @author Flávio Dias
 *
 */
public class ConsultaApi {
	private static final Logger logger = Logger.getLogger(ConsultaApi.class);
	private String baseURI;
	private Map<String, String> paramsMap;
	private String bodyString;
	Response responseApiBusca;
	MapsApi jsonPath = new MapsApi();

	@Before
	public void printScenarioName(Scenario scenario) {
		logger.info("-- Inicio da Execução Cenário: " + scenario.getName());
	}

	/**
	 * Cria uma requisição para consultar na api
	 */
	@Dado("que o usuário deseja fazer uma consulta por marca")
	public void criarRequisicao() {
		baseURI = "http://desafioonline.webmotors.com.br/api/OnlineChallenge/Make";
		logger.info("URI de Request: " + baseURI);
	}

	/**
	 * Cria uma requisição para consultar marca Invalida
	 */
	@Dado("que o usuário faça uma consulta inválida por marca")
	public void consultaMarcaInvalida() {
		baseURI = "http://desafioonline.webmotors.com.br/api/OnlineChallenge/MakeTestInvalid";
		logger.info("URI de Request: " + baseURI);
	}

	@Dado("que o usuário deseja fazer uma consulta pelo modelo: {string}")
	public void ConsultaPorModelo(String modelo) {
		baseURI = "http://desafioonline.webmotors.com.br/api/OnlineChallenge/Model";
		paramsMap = criaUriRequestModelo(modelo);
		logger.info("URI de Request: " + baseURI);
	}

	@Dado("que o usuário deseja fazer uma consulta pela versão: {string}")
	public void ConsultaPelaVersao(String versao) {
		baseURI = "http://desafioonline.webmotors.com.br/api/OnlineChallenge/Version";
		paramsMap = criaUriRequestVersao(versao);
		logger.info("URI de Request: " + baseURI);
	}

	@Dado("que o usuário deseja fazer uma consulta por veiculos")
	public void ConsultaPorVeiculos() {
		baseURI = "http://desafioonline.webmotors.com.br/api/OnlineChallenge/Vehicles";
		paramsMap = criaUriRequestVeiculo();
		logger.info("URI de Request: " + baseURI);
	}

	/**
	 * Envia uma requisição para a API e grava no LOG
	 */
	@Quando("enviar a requisição")
	public void enviarRequisicao() {
		responseApiBusca = given().when().get(baseURI);
		logger.info("Resposta Request: " + responseApiBusca.getBody().asString());
	}

	/**
	 * Consulta por Modelo, Versão, Veiculo
	 */
	@Quando("enviar a requisição de consulta")
	public void enviar_a_requisição_de_consulta_por_modelo() {
		responseApiBusca = given().when().queryParams(paramsMap).get(baseURI);
		logger.info("Resposta Request: " + responseApiBusca.getBody().asString());
	}

	/**
	 * Metodo para validar o codigo de retono da API
	 * 
	 * @param codigoResposta
	 */
	@Então("validar se o código de resposta é {int}")
	public void validaCodigoResposta(int codigoResposta) {
		assertTrue("StatusCode não esperado! codigo: " + responseApiBusca.andReturn().getStatusCode(),
				codigoResposta == responseApiBusca.andReturn().getStatusCode());
	}

	/**
	 * Valida se no json retorno existe a marca buscada Se não existir falha o teste
	 * Se ocorrer alguma exception, arremessa uma Exception
	 * 
	 * @param string
	 * @throws Exception
	 */
	@Então("validar se existe a marca: {string} no retorno")
	public void validarMarca(String marca) throws Exception {
		List<String> listMarcas = responseApiBusca.jsonPath().getList(jsonPath.getNomeMarca());
		Boolean marcaEncontrada = false;
		try {
			for (Object marcasList : listMarcas) {
				if (marcasList.toString().equalsIgnoreCase(marca.toLowerCase())) {
					marcaEncontrada = true;
				}
			}
			assertTrue("Marca Não encontrada", marcaEncontrada);
		} catch (Exception e) {
			throw new Exception("Falha ao pesquisar marca");
		}
	}

	@Então("validar se existe o modelo: {string} no retorno")
	public void ValidarModeloRetorno(String modelo) throws Exception {
		List<String> listModelos = responseApiBusca.jsonPath().getList(jsonPath.getNomeModelo());
		Boolean modeloEncontrado = false;
		try {
			for (Object marcasList : listModelos) {
				if (marcasList.toString().equalsIgnoreCase(modelo.toLowerCase())) {
					modeloEncontrado = true;
				}
			}
			assertTrue("Modelo Não encontrado", modeloEncontrado);
		} catch (Exception e) {
			throw new Exception("Falha ao pesquisar Modelo");
		}
	}

	/**
	 * Valida A Versao
	 * 
	 * @param versao
	 * @throws Exception
	 */
	@Então("se existe a versão: {string} no retorno")
	public void ValidarVersaoRetorno(String versao) throws Exception {
		List<String> listVersao = responseApiBusca.jsonPath().getList(jsonPath.getNomeVersao());
		Boolean versaoEncontrada = false;
		try {
			for (Object versaoList : listVersao) {
				if (versaoList.toString().equalsIgnoreCase(versao.toLowerCase())) {
					versaoEncontrada = true;
				}
			}
			assertTrue("Versão não encontrada", versaoEncontrada);
		} catch (Exception e) {
			throw new Exception("Falha ao pesquisar Versao");
		}
	}

	/**
	 * Faz a leitura de uma datatable do BDD, e verifica se existe o veiculo
	 * 
	 * @param dataTable
	 * @throws Exception
	 */
	@Então("validar se existe o veiculo:")
	public void validaVeiculo(io.cucumber.datatable.DataTable dataTable) throws Exception {
		List<Map<String, String>> tabela = dataTable.asMaps();
		validarVeiculo(tabela.get(0).get("marca"), tabela.get(0).get("modelo"), tabela.get(0).get("versão"));
	}
/**
 * Valida o retorno vazio. Quando a Busca não encontra nada
 */
	@Então("validar o retorno vazio")
	public void validar_o_retorno_vazio() {
		List<String> listRetorno = responseApiBusca.jsonPath().getList(jsonPath.getName());
		assertTrue("Retorno não está vazio", listRetorno.isEmpty());

	}

	/**
	 * Verifica se o vaiculo desejado esta no retorno do JSon
	 * 
	 * @param marca
	 * @param modelo
	 * @param versao
	 */
	private void validarVeiculo(String marca, String modelo, String versao) {
		String veiculo = responseApiBusca.getBody().asString();
		assertTrue("Marca encontrada!", veiculo.toLowerCase().contains(marca.toLowerCase()));
		assertTrue("Modelo não encontrado!", veiculo.toLowerCase().contains(modelo.toLowerCase()));
		assertTrue("Versão não encontrada!", veiculo.toLowerCase().contains(versao.toLowerCase()));

	}

	/**
	 * Metodo para criar os querieParam do modelo
	 * 
	 * @param modelo
	 * @return Map com os QueriesParam
	 */
	private Map<String, String> criaUriRequestModelo(String modelo) {
		Map<String, String> mapParametrosConsulta = new HashMap<String, String>();
		if (modelo != null && modelo.equalsIgnoreCase("city")) {
			mapParametrosConsulta.put("MakeID", "2");
		} else {
			mapParametrosConsulta.put("MakeID", "99");
		}
		return mapParametrosConsulta;
	}

	private Map<String, String> criaUriRequestVersao(String versao) {
		Map<String, String> mapParametrosConsulta = new HashMap<String, String>();
		if (versao != null && versao.equalsIgnoreCase("1.5 LX 16V FLEX 4P MANUAL")) {
			mapParametrosConsulta.put("ModelID", "4");
		} else {
			mapParametrosConsulta.put("ModelID", "99");
		}
		return mapParametrosConsulta;
	}

	private Map<String, String> criaUriRequestVeiculo() {
		Map<String, String> mapParametrosConsulta = new HashMap<String, String>();
		mapParametrosConsulta.put("Page", "2");
		return mapParametrosConsulta;
	}

}
