package classes;

public class Hashing {
	
	///////////////////////////////////////////////////
	// Atributos
	///////////////////////////////////////////////////
	
	private LSE[] vetContas;
	private int   m;
	
	
	
	///////////////////////////////////////////////////
	// Construtor(es)
	///////////////////////////////////////////////////
	
	public Hashing(int tamanho) {
		int tamanhoAjustado = (int) (tamanho * 1.1);
		
		this.m = melhorPrimo(tamanhoAjustado);
		
		this.vetContas = new LSE[this.m];
		for (int i = 0; i < vetContas.length; i++) {
			vetContas[i] = new LSE();
		}
	}
	
	
	
	///////////////////////////////////////////////////
	// Getters
	///////////////////////////////////////////////////
	
	public LSE getVetContas(int posicao) {
		return this.vetContas[posicao];
	}
	
	
	
	///////////////////////////////////////////////////
	// Função hashing
	///////////////////////////////////////////////////
	
	private int calculaHashValue(long chave) {
		return (int) (chave % this.m);
	}
	
	
	
	///////////////////////////////////////////////////
	// Inserir conta bancária
	///////////////////////////////////////////////////
	
	public void inserirConta(ContaBancaria conta) {
		
		long chave = Long.parseLong(conta.getCPF());
		int hashValue = calculaHashValue(chave);
		
		boolean ok = true;	
		while(ok) {
			LSE lista = vetContas[hashValue];
			if (lista.eVazia()) {
				lista.inserirOrdenado2(conta);
				ok = false;
			}
			else if ((!lista.eVazia()) && lista.getPrim().getConta().getCPF().equals(conta.getCPF())) {
				lista.inserirOrdenado2(conta);
				ok = false;
			}
			else {
				hashValue += 1;
				if (hashValue == this.vetContas.length) {
					hashValue = 0;
				}
			}
		}
	}
	
	
	
	///////////////////////////////////////////////////
	// Hashing para vetor
	///////////////////////////////////////////////////
	
	public void hashParaVetor(ContaBancaria[] contas) {
		int contador = 0;
		
		for (int i = 0; i < vetContas.length; i++) {
			LSE lista = vetContas[i];
			if (!lista.eVazia()) {
				NoLSE atual = lista.getPrim();
				while(atual != null) {
					//System.out.println(atual.getConta().getCPF());
					contas[contador] = atual.getConta();
					contador += 1;
					atual = atual.getProx();
				}
			}
		}
	}
	
	
	
	///////////////////////////////////////////////////
	// Acha "melhor" número primo para a função
	// de hashing
	///////////////////////////////////////////////////
	
	/**
	 * <p>Retorna o melhor número primo a ser utilizado
	 * pela função hashing.</p>
	 * 
	 * @param tamanho
	 *        (int) do vetor de hash
	 * @return m
	 *        (int) um número primo inteiro para a função hashing
	 */
	private int melhorPrimo(int tamanho) {
		int n     = tamanho;
		int menor = 0;
		int maior = 0;
		
		if ((n % 2) == 0) {
			n = n - 1;
			menor = n;
			maior = n + 2;
		}
		
		while (true) {
			if (ePrimo(menor) && eBomPrimo(menor)) {
				return menor;
			}
			else if (ePrimo(maior) && eBomPrimo(maior)) {
				return maior;
			}
			menor = menor - 2;
			maior = maior + 2;
		}
	}
	
	/**
	 * <p>Verifica se um número é primo.</p>
	 * 
	 * @param n
	 *        (int) um número inteiro qualquer
	 *        
	 * @return TRUE, se for um número primo<br />
	 *         FALSE, se não for um número primo
	 */
	private boolean ePrimo(int n) {
		if (n == 2) {
			return true;
		}
		else if (n <= 1 || n % 2 == 0) {
			return false;
		}
		
		int maximo = (int) Math.sqrt(n);
		
		for (int i = 3; i <= maximo; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * <p>Verifica se um número primo é um "bom" primo para função
	 * de hashing. No momento esta função faz duas verificações:
	 * se o primo não é uma potência de 10 (mais ou menos 9), e
	 * se o primo não é uma potência de 2 (mais ou menos 9).</p>
	 * 
	 * <p>O objetivo dessa verificação é minimizar o número de
	 * colisões que podem ocorrer se o número primo for "ruim".</p>
	 * 
	 * @param n
	 *        (int) um número inteiro primo qualquer
	 *        
	 * @return TRUE, se for um bom primo<br />
	 *         FALSE, se não for um bom primo
	 */
	private boolean eBomPrimo(int n) {
		for (int i = 1; Math.pow(10, i) <= n; i++) {
			for (int j = 1; j < 10; j++) {
				if (n == Math.pow(10, i) + j) {
					return false;
				}
				else if (n == Math.pow(10, i) - j) {
					return false;
				}
			}
			
		}
		for (int i = 1; Math.pow(2, i) <= n; i++) {
			for (int j = 1; j < 10; j++) {
				if (n == Math.pow(2, i) + j) {
					return false;
				}
				else if (n == Math.pow(2, i) - j) {
					return false;
				}
			}
			
		}
		return true;
	}

}
