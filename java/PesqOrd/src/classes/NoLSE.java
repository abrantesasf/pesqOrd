package classes;

/**
 * <p>A classe <code><b>NoLSE</b></code> implementa o um nó a ser utilizado
 * em uma lista simplesmente encadeada (LSE). Esta classe será utilizada
 * no trabalho final da disciplina de Pesquisa e Ordenação,
 * do curso de Ciência da Computação, da FAESA.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com)
 */
public class NoLSE {
	
	///////////////////////////////////////////////////
	// Atributos
	///////////////////////////////////////////////////		
	
	/** Conta bancária armazenada no nó */
	private ContaBancaria conta;
	
	/** Link para o próximo nó */
	private NoLSE prox;
	
	
	
	///////////////////////////////////////////////////
	// Construtor(es)
	///////////////////////////////////////////////////	
	
	/**
	 * Construtor do nó que aceita uma conta bancária como
	 * argumento.
	 * 
	 * @param conta
	 *        (ContaBancaria)
	 */
	public NoLSE(ContaBancaria conta) {
		this.conta = conta;
		this.prox = null;
	}
	
	
	
	///////////////////////////////////////////////////
	// Getters
	///////////////////////////////////////////////////	
	
	/**
	 * Retorna uma conta bancária
	 * @return conta bancária
	 *         (ContaBancaria)
	 */
	public ContaBancaria getConta() {
		return this.conta;
	}
	
	/**
	 * Retorna o link para o próximo nó
	 * @return próximo nó
	 *         (NoLSE)
	 */
	public NoLSE getProx() {
		return this.prox;
	}
	
	
	
	///////////////////////////////////////////////////
	// Setters
	///////////////////////////////////////////////////		
	
	/**
	 * Coloca uma conta bancária no nó
	 * @param conta
	 *        (ContaBancaria)
	 */
	public void setConta(ContaBancaria conta) {
		this.conta = conta;
	}
	
	/**
	 * Ajusta o link para o póximo nó
	 * @param novoNoLSE
	 *        (NoLSE)
	 */
	public void setProx(NoLSE novoNoLSE) {
		this.prox = novoNoLSE;
	}
	
}
