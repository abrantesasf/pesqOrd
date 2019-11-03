package classes;

/**
 * <p>A classe <code><b>ContaBancaria</b></code> repersenta uma conta (corrente ou poupança)
 * de uma pessoa (representada por seu CPF), e é utilizada no trabalho
 * final da disciplina de Pesquisa e Ordenação, do curso de Ciência da
 * Computação, da FAESA.</p>
 * 
 * @author Abrantes Araújo Silva Filho ({@link<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>})
 */
public class ContaBancaria implements Comparable<ContaBancaria>{
	
	///////////////////////////////////////////////////
	// Atributos
	///////////////////////////////////////////////////
	
	/** <p>Número da agência bancária</p> */
	private String agencia;
		
	/** <p>Número da conta bancária, representando uma conta corrente
	 * ou uma conta poupança dependendo dos 3 caracteres iniciais:</p>
	 * <ul>
	 *   <li>001: conta correte</li>
	 *   <li>002: conta poupança</li>
	 * </ul>
	 */
	private String conta;
		
	/** <p>Saldo da conta bancária</p> */
	private double saldo;
		
	/** <p>CPF do titular da conta bancária</p> */
	private String cpf;
	
	
	
	///////////////////////////////////////////////////
	// Construtor(es)
	///////////////////////////////////////////////////
	
	/**
	 * <p>Construtor para a classe <code>ContaBancaria</code>. Todos os parâmetros
	 * são obrigatórios, já que não há nenhum valor default inicializado pelo
	 * construtor.</p>
	 * 
	 * @param agencia
	 *        (String) Número da agência bancária
	 *        
	 * @param conta
	 *        (String) Número da conta corrente ou poupança
	 *        
	 * @param saldo
	 *        (double) Saldo da conta corrente
	 *        
	 * @param cpf
	 *        (String) CPF do titular da conta corrente
	 */
	public ContaBancaria(String agencia, String conta, double saldo, String cpf) {
		setAgencia(agencia);
		setConta(conta);
		setSaldo(saldo);
		setCPF(cpf);
	}
	
	
	
	///////////////////////////////////////////////////
	// Getters
	///////////////////////////////////////////////////
	
	/** <p>Retorna a agência bancária</p> */
	public String getAgencia() {
		return agencia;
	}

	/** <p>Retorna a conta bancária</p> */
	public String getConta() {
		return conta;
	}

	/** <p>Retorna o saldo na conta bancária</p> */
	public double getSaldo() {
		return saldo;
	}

	/** <p>Retorna o CPF do titular da conta bancária</p> */
	public String getCPF() {
		return cpf;
	}
	
	
	
	///////////////////////////////////////////////////
	// Setters
	///////////////////////////////////////////////////
	
	/** <p>Ajusta a agência bancária</p>
	 * 
	 * @param agencia
	 *        (String) Número da agência bancária
	 */
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	/** <p>Ajusta a conta bancária</p>
	 * 
	 * @param conta
	 *        (String) Número da conta bancária
	 */
	public void setConta(String conta) {
		this.conta = conta;
	}

	/** <p>Ajusta o saldo da conta bancária</p>
	 * 
	 * @param saldo
	 *        (double) Saldo da conta bancária
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/** <p>Ajusta o CPF do titular da conta bancária</p>
	 * 
	 * @param cpf
	 *        (String) CPF do titular da conta bancária
	 */
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	///////////////////////////////////////////////////
	// Ordena por CPF, agência e conta bancária
	///////////////////////////////////////////////////
	
	/**
	 * <p>Código de comparação entre contas bancárias, que implementa a seguinte
	 * lógica de ordenação:</p>
	 * 
	 * <ol>
	 * <li>Inicialmente o <b>CPF</b> é comparado;</li>
	 * <li>Se o CPF for igual, o código da <b>agência</b> é comparado;</li>
	 * <li>Se a agência também for igual, o códgido da <b>conta</b> é comparado.</li>
	 * </ol>
	 * 
	 * @param that
	 *        (ContaBancaria) a ser comparada com a conta atual
	 * 
	 * @return -1: se a ContaBancaria atual (this) é MENOR do que a de comparação (that)<br />
	 *          0: se, após todas as comprações, as contas forem iguais<br />
	 *         +1: se a ContaBancaria atual (this) é MAIOR do que a de comparação (that)
	 */
	public int compareTo(ContaBancaria that) {
		if (Long.parseLong(this.cpf) > Long.parseLong(that.cpf)) return +1;
		if (Long.parseLong(this.cpf) < Long.parseLong(that.cpf)) return -1;
		// Para ordenar também por agência, antes da conta bancária, descomentar:
		//if (Integer.parseInt(this.agencia) > Integer.parseInt(that.agencia)) return +1;
		//if (Integer.parseInt(this.agencia) < Integer.parseInt(that.agencia)) return -1;
		if (Long.parseLong(this.conta) > Long.parseLong(that.conta)) return +1;
		if (Long.parseLong(this.conta) < Long.parseLong(that.conta)) return -1;
		return 0;
	}
	
	
	
	///////////////////////////////////////////////////
	// toString
	///////////////////////////////////////////////////
	
	/** <p>Sobrescreve o método <code>toString()</code> padrão do Java para
	 * apresentar a conta bancária de modo mais amigável.</p>
	 * 
	 * @return String que representa uma conta bancária, com cada informação
	 *         em uma linha, indentada de modo amigável.
	 */
	public String toString() {
		String retorno = "";
		retorno = "CPF:     " + this.cpf     + "\n" +
		          "Agência: " + this.agencia + "\n" +
		          "Conta:   " + this.conta   + "\n" +
		          "Saldo:   " + this.saldo   + "\n";
		return retorno;
	}
	
} // fecha classe ContaBancaria
