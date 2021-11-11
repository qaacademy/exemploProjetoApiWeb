package mapsWebMotors;

public class EstoqueLojaMap {

	/**
	 * Cria um elemento dinamicamente
	 * 
	 * @param nomeElemento
	 * @return Elemento
	 */
	public String criaElementoEstoqueLoja(String modelo) {
		return "//h3[contains(text(),'"+modelo.toLowerCase()+"')]";
	}

}
