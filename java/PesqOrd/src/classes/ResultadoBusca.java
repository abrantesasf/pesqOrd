package classes;

/**
 * <p>A classe <code><b>ResultadoBusca</b></code> implementa um vetor
 * para armazenar a lista dos CPFs (400 CPFs de teste) a serem pesquisados
 * utilizando-se os outros métodos deste trabalho (Heap + Binary, Quick + Binary,
 * ABB, AVL e Hashing). Esta classe é utilizada no trabalho
 * final da disciplina de Pesquisa e Ordenação, do curso de Ciência da
 * Computação, da FAESA.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 */
public class ResultadoBusca {
	
	///////////////////////////////////////////////////
	// Atributos
	///////////////////////////////////////////////////
	
	private String cpf;
	private LSE    lista;
	
	
	
	///////////////////////////////////////////////////
	// Construtor(es)
	///////////////////////////////////////////////////	
	
	public ResultadoBusca() {
		this.cpf   = null;
		this.lista = new LSE();
	}
	
	
	
	///////////////////////////////////////////////////
	// Getters
	///////////////////////////////////////////////////	
	
	public String getCPF() {
		return this.cpf;
	}
	
	public LSE getLista() {
		return this.lista;
	}
	
	
	
	///////////////////////////////////////////////////
	// Setters
	///////////////////////////////////////////////////	
	
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	public void setLista(LSE lista) {
		this.lista = lista;
	}

}
