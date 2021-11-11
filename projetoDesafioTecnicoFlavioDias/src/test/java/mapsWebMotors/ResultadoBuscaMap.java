package mapsWebMotors;

public class ResultadoBuscaMap {

	/**
	 * Cria um elemento dinamicamente
	 * 
	 * @param nomeElemento
	 * @return Elemento
	 */
	public String criaElementoMarca(String marca) {
		return "//small[contains(text(),'"+marca.toLowerCase()+"')]";
	}

	/**
	 * Cria elemento para clicar em todas as Versoes
	 * 
	 * @return
	 */
	public String criaElementoTodosModelos() {
		return "//div[@class='Filters__line Filters__line--gray Filters__line--icon Filters__line--icon--right']";
	}

	/**
	 * Cria elemento dinamicamente Modelo
	 * 
	 * @param modelo
	 * @return
	 */
	public String criaElementoModelo(String modelo) {
		return "//a[contains(text(),'" + modelo + "')]";
	}

	/**
	 * Cria elemento para clicar em todas as versões
	 * 
	 * @return
	 */
	public String criaElementoTodasVersoes() {

		return "//div[@class='Filters__line Filters__line--icon Filters__line--icon Filters__line--icon--right Filters__line--gray']";
	}

	public String criaElementoVersao(String versao) {
		return "//a[contains(text(),'" + versao + "')]";
	}

	/**
	 * Resultado da busca, cria elemento para clicar no primeiro resultado
	 * 
	 * @return
	 */
	public String criaElementoClicaPrimeiroResultado() {
		return "//body/div/main/div/div/div[2]/div[1]/div[1]";
	}

	/**
	 * Cria elemento para Validar Marca esta de acordo com pesquisado
	 * @param marca
	 * @return
	 */
	public String criaElementoValidaMarca(String marca) {
		
		return "//h1[contains(text(),'" + marca + "')]";
	}
	
	/**
	 * Valida modelo se esta de acordo
	 * @param modelo
	 * @return
	 */
	public String criaElementoValidaModelo(String modelo) {
		return "//h1//strong[contains(text(),'" + modelo + "')]";
	}
	/**
	 * Valida se a versao esta de acordo ao pesquisado
	 * 
	 * @param versao
	 * @return
	 */
	public String criaElementoValidaVersao(String versao) {
		return "//span[contains(text(),'" + versao + "')]";
	}

}
