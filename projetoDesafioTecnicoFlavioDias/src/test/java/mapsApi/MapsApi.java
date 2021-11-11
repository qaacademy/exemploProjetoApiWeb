package mapsApi;
/**
 * Classe MapsApi tem por objetivo separar a camada de mapeamento do JsonPath, 
 * para minimizar problemas de possíveis alterações nos retornos
 * @author Flávio Dias
 *
 */
public class MapsApi {
	private String nomeMarca = "Name";
	private String nomeModelo = "Name";
	private String nomeVersao = "Name";
	private String name = "Name";



	public String getNomeMarca() {
		return nomeMarca;
	}


	public String getNomeModelo() {
		return nomeModelo;
	}


	public String getNomeVersao() {
		return nomeVersao;
	}


	public String getName() {
		return name;
	}
	
}
