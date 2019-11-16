package classes;

/**
 * <p>A classe <code><b>VetorDeContasBancarias</b></code> implementa um array (vetor)
 * para armazenar informações de diversas contas bancárias. É utilizada no trabalho
 * final da disciplina de Pesquisa e Ordenação, do curso de Ciência da
 * Computação, da FAESA</p>.
 * 
 * @author Abrantes Araújo Silva Filho ({@link<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>})
 */
public class VetorDeContasBancarias {
	
    ///////////////////////////////////////////////////
	// Atributos
    ///////////////////////////////////////////////////
	
	/** <p>Vetor de contas bancárias</p> */
	private ContaBancaria[] vContas;
	
	/** <p>Quantidade de contas no vetor</p> */
	private int qtdDeContas;
	
	
	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////
	
	/**
	 * <p>Construtor para a classe <code>VetorDeContasBancarias</code>.
	 * O único parâmetro é obrigatório e indica qual o tamanho (length)
	 * que o vetor terá. A quantidade de contas é inicializada como 0 (pois
	 * imediatamente à criação do vetor, ainda não há nenhuma conta bancária
	 * cadastrada).</p>
	 * 
	 * @param tamanho
	 *        (int) Tamanho (length) que o vetor de contas terá
	 */
	public VetorDeContasBancarias(int tamanho) {
		this.vContas = new ContaBancaria[tamanho];
		this.qtdDeContas = 0;
	}

	
	
    ///////////////////////////////////////////////////
	// Getters
    ///////////////////////////////////////////////////
	
	/** <p>Retorna uma <code>ContaBancaria</code> de uma localização
	 * específica no <code>VetorDeContasBancarias</code>.</p>
	 * 
	 * @param posicao
	 *        (int) Inteiro que especifica a POSIÇÃO no vetor da conta
	 *        bancária a ser retornada (inicia em 0).
	 *        
	 * @return Objeto <code>ContaBancaria</code>
	 */
	public ContaBancaria getConta(int posicao) {
		return this.vContas[posicao]; 
	}

	/** <p>Retorna a quantidade de contas bancárias já cadastradas no vetor</p> */
	public int getQtdDeContasNoVetor() {
		return this.qtdDeContas;
	}
	
	/** <p>Retorna o tamanho total (length) do vetor de contas, ou seja,
	 * quantas posições existem para o armazenamento de contas bancárias</p>
	 */
	public int getTamanhoDoVetorDeContas() {
		return this.vContas.length;
	}
	
	
	
    ///////////////////////////////////////////////////
	// Vetor vazio/cheio
    ///////////////////////////////////////////////////	
	
	/**
	 * <p>Retorna <code>TRUE</code> se o vetor de contas estiver vazio,
	 * ou <code>FALSE</code> caso contrário.</p>
	 */
	private boolean estaVazio() {
		if (this.qtdDeContas == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		String retorno = "";
		for (int i = 0; i < vContas.length; i++) {
			retorno += vContas[i].toString();
		}
		return retorno;
	}
	
	/**
	 * <p>Retorna <code>TRUE</code> se o vetor de contas estiver cheio,
	 * ou <code>FALSE</code> caso contrário.</p>
	 */
	private boolean estaCheio() {
		if (this.qtdDeContas == this.vContas.length) {
			return true;
		} else {
			return false; 
		}
	}
	
	
	
    ///////////////////////////////////////////////////
	// Inserir Conta Bancária
    ///////////////////////////////////////////////////
	
	/**
	 * <p>Insere um novo objeto <code>ContaBancaria</code> no vetor de contas
	 * bancárias, retornando <code>TRUE</code> se a inserção foi bem sucedida
	 * ou <code>FALSE</code> caso contrário.</p>
	 * 
	 * @param novaContaBancaria
	 *        Objeto <code>ContaBancaria</code>
	 *        
	 * @return <code>TRUE</code> se a inserção foi realizada<br />
	 *         <code>FALSE</code> se a inserção não foi realizada
	 */
	public boolean inserirContaBancaria(ContaBancaria novaContaBancaria) {
		if (this.estaCheio()) {
			return false;
		} else {
			this.vContas[this.qtdDeContas] = novaContaBancaria;
			this.qtdDeContas++;
			return true;
		}
	}
	
	/**
	 * <p>Insere um novo objeto <code>ContaBancaria</code> no vetor de contas
	 * bancárias, a partir de uma LISTA SIMPLES ENCADEADA onde cada nó é uma
	 * conta bancária.</p>
	 * 
	 * @param (LSE) com Contas Bancárias
	 */
	public void inserirContaBancaria(LSE lista) {
		if (this.estaCheio()) {
			System.out.println("Está cheio.");
		} else {
			NoLSE atual = lista.getPrim();
			while (atual != null) {
				this.vContas[this.qtdDeContas] = atual.getConta();
				this.qtdDeContas++;
				atual = atual.getProx();
			}
		}
	}
	
	
	
    ///////////////////////////////////////////////////
	// Remover Conta Bancária
    ///////////////////////////////////////////////////
	
	/**
	 * <p>Remove um objeto <code>ContaBancaria</code> do vetor de contas bancárias,
	 * copiando a última conta do vetor para a posição a ser removida, e diminuindo
	 * de 1 unidade a quantidade de contas no vetor.</p>
	 * 
	 * <p><b>ATENÇÃO:</b> esse método de remoção de conta bancária pode fazer com que
	 * um vetor corretamente ordenado passe a ser não ordenado! Use este método com
	 * cautela.</p>
	 * 
	 * @param posicao
	 *        (int) Inteiro que especifica a POSIÇÃO no vetor da conta
	 *        bancária a ser removida.
	 *        
	 * @return <code>TRUE</code> se a remoção foi realizada<br />
	 *         <code>FALSE</code> se a remoção não foi realizada
	 */
	public boolean removerContaBancaria(int posicao) {
		if (this.estaVazio()) {
			return false;
		} else if (posicao > this.qtdDeContas) {
			return false;
		} else {
			this.vContas[posicao] = this.vContas[this.qtdDeContas - 1];
			this.qtdDeContas--;
			return true;
		}
	}
	
} // fecha classe VetorDeContasBancarias
