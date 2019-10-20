package classes;

public class ContaBancaria {
	
	///////////////////////////////////////////////////
	// Atributos
	///////////////////////////////////////////////////	
	private String agencia;
	private String conta;
	private double saldo;
	private String cpf;
	
	
	
	///////////////////////////////////////////////////
	// Construtor(es)
	///////////////////////////////////////////////////	
	public ContaBancaria(String agencia, String conta, double saldo, String cpf) {
		setAgencia(agencia);
		setConta(conta);
		setSaldo(saldo);
		setCpf(cpf);
	}
	
	
	
	///////////////////////////////////////////////////
	// Getters
	///////////////////////////////////////////////////	
	public String getAgencia() {
		return agencia;
	}

	public String getConta() {
		return conta;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getCPF() {
		return cpf;
	}
	
	
	
	///////////////////////////////////////////////////
	// Setters
	///////////////////////////////////////////////////		
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	///////////////////////////////////////////////////
	// toString
	///////////////////////////////////////////////////		
	public String toString() {
		String retorno = "";
		retorno = "CPF:     " + this.cpf     + "\n" +
		          "Agência: " + this.agencia + "\n" +
		          "Conta:   " + this.conta   + "\n" +
		          "Saldo:   " + this.saldo   + "\n";
		return retorno;
	}
	
} // fecha classe ContaBancaria
