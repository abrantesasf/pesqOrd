package classes;

public class VetorDeContasBancarias {
	
    ///////////////////////////////////////////////////
	// Atributos
    ///////////////////////////////////////////////////		
	private ContaBancaria[] vContas;
	private int             qtdDeContas;
	
	
	
    ///////////////////////////////////////////////////
	// Construtor(es)
    ///////////////////////////////////////////////////		
	public VetorDeContasBancarias(int tamanho) {
		this.vContas = new ContaBancaria[tamanho];
		this.qtdDeContas = 0;
	}

	
	
    ///////////////////////////////////////////////////
	// Getters
    ///////////////////////////////////////////////////		
	public ContaBancaria getConta(int i) {
		return this.vContas[i];
	}

	public int getQtdDeContasNoVetor() {
		return this.qtdDeContas;
	}
	
	public int getTamanhoDoVetorDeContas() {
		return this.vContas.length;
	}
	
	
	
    ///////////////////////////////////////////////////
	// Vetor vazio/cheio
    ///////////////////////////////////////////////////		
	private boolean vetorVazio() {
		if (this.qtdDeContas == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean vetorCheio() {
		if (this.qtdDeContas == this.vContas.length) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
    ///////////////////////////////////////////////////
	// Inserir Conta Bancária
    ///////////////////////////////////////////////////
	public boolean inserirContaBancaria(ContaBancaria novaContaBancaria) {
		if (this.vetorCheio()) {
			return false;
		} else {
			this.vContas[this.qtdDeContas] = novaContaBancaria;
			this.qtdDeContas++;
			return true;
		}
	}
	
	
	
    ///////////////////////////////////////////////////
	// Remover Conta Bancária
    ///////////////////////////////////////////////////
	public boolean removerContaBancaria(int i) {
		if (this.vetorVazio()) {
			return false;
		} else if (i > this.qtdDeContas) {
			return false;
		} else {
			this.vContas[i] = this.vContas[this.qtdDeContas - 1];
			this.qtdDeContas--;
			return true;
		}
	}
	
} // fecha classe VetorDeContasBancarias
