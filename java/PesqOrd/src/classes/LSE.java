package classes;

/**
 * <p>A classe <code><b>LSE</b></code> implementa uma lista simplesmente
 * encadeada (LSE). Esta classe será utilizada
 * no trabalho final da disciplina de Pesquisa e Ordenação,
 * do curso de Ciência da Computação, da FAESA.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com)
 */
public class LSE {
	
	///////////////////////////////////////////////////
	// Atributos
	///////////////////////////////////////////////////	
	
	/** Ponteiro para o primeiro nó da lista */
	private NoLSE prim;
	
	/** Ponteiro para o último nó da lista */
	private NoLSE ult;
	
	/** Quantidade de nós na lista */
	private int   quantNos;
	
	
	
	///////////////////////////////////////////////////
	// Construtor(es)
	///////////////////////////////////////////////////	
	
	/**
	 * Construtor padrão para a classe LSE. Não recebe
	 * nenhum parâmetro e inicializa os ponteiros como null
	 * e a quantidade de nós como zero.
	 */
	public LSE() {
		this.prim     = null;
		this.ult      = null;
		this.quantNos = 0;
	}
	
	
	
	///////////////////////////////////////////////////
	// Getters
	///////////////////////////////////////////////////	
	
	/** Retorna o primeiro nó da lista */
	public NoLSE getPrim() {
		return this.prim;
	}
	
	/** Retorna o último nó da lista */
	public NoLSE getUlt() {
		return this.ult;
	}
	
	/** Retorna a quantidade de nós na lista */
	public int getQuantNos() {
		return this.quantNos;
	}
	
	
	
	///////////////////////////////////////////////////
	// Setters
	///////////////////////////////////////////////////	
	
	/**
	 * Aponta o primeiro nó na lista para o nó passado como
	 * parâmetro.
	 * 
	 * @param prim
	 *        (NoLSE)
	 */
	public void setPrim(NoLSE prim) {
		this.prim = prim;
	}
	
	/** Aponta o último nó na lista para o nó passado como
	 * parâmetro.
	 * 
	 * @param ult
	 *        (NoLSE)
	 */
	public void setUlt(NoLSE ult) {
		this.ult = ult;
	}
	
	/** Ajusta a quantidade de nós */
	public void setQuantNos(int quantNos) {
		this.quantNos = quantNos;
	}
	
	
	
	///////////////////////////////////////////////////
	// Verifica se a LSE está vazia
	///////////////////////////////////////////////////	
	
	/**
	 * Verifica se a lista está vazia.
	 * 
	 * @return TRUE se a lista estiver vazia<br />
	 *         FALSE se a lista não estiver vazia
	 */
	public boolean eVazia() {
		return (this.prim == null);
	}
	
	
	
	///////////////////////////////////////////////////
	// Insere de modo ordenado na LSE
	// Obs.: é necessário que o elemente implemente
	// a interface Comparator
	///////////////////////////////////////////////////	
	
	/**
	 * Insere uma nova conta bancária de modo ordenado na lista,
	 * tomando como parâmetro de ordenação o resultado de um
	 * método comparator implementado na classe ContaBancaria.
	 * 
	 * @param novaConta
	 *        (ContaBancaria)
	 */
	public void inserirOrdenado(ContaBancaria novaConta) {
		NoLSE novoNoLSE = new NoLSE(novaConta);
		
		// Se a lista está vazia, insere o primeiro nó
		if (this.eVazia()) {
			setPrim(novoNoLSE);
			setUlt(novoNoLSE);
		} else {
			// Se a lista não está vazia:
			NoLSE atual    = getPrim();
			NoLSE anterior = null;
			
			// Percorre a lista até o último nó, verificando se  a conta bancária passada
			// como parâmetro é maior do que a conta do nó atual (a comparação é feita
			// através de um comparator implementado na classe ContaBancaria):
			while (atual.getProx() != null && novoNoLSE.getConta().compareTo(atual.getConta()) > 0) {
				System.out.println(novoNoLSE.getConta().toString());
				System.out.println(atual.getConta().toString());
				System.out.println("Comp: " + novoNoLSE.getConta().compareTo(atual.getConta()));
				anterior = atual;
				atual    = atual.getProx();
			}
			
			// Se o while parar no primeiro e o novo nó for MENOR do que o primeiro, 
			// a nova conta deve ser inserida ANTES do primeiro nó:
			if (atual == getPrim() && novoNoLSE.getConta().compareTo(atual.getConta()) < 0) {
				novoNoLSE.setProx(getPrim());
				setPrim(novoNoLSE);
			}
			// Se o while parar no primeiro e o novo nó for MAIOR do que o primeiro,
			// a nova conta deve ser inserida APÓS o primeiro nó:
			else if (atual == getPrim() && novoNoLSE.getConta().compareTo(atual.getConta()) > 0) {
				novoNoLSE.setProx(atual.getProx());
				atual.setProx(novoNoLSE);
			}
			// Se o while parar no último e o novo nó for MAIOR do que o último,
			// a nova conta deve ser inserida APÓS o último nó:
			else if (atual == getUlt() && novoNoLSE.getConta().compareTo(atual.getConta()) > 0) {
				atual.setProx(novoNoLSE);
				setUlt(novoNoLSE);
			}
			// Se o while parar no último e o novo nó for MENOR do que o último,
			// a nova conta deve ser insediro ANTES do último nó:
			else if (atual == getUlt() && novoNoLSE.getConta().compareTo(atual.getConta()) < 0) {
				novoNoLSE.setProx(getUlt());
				anterior.setProx(novoNoLSE);
			}
			// Se o while parar em algum lugar ENTRE o primeiro e o último nó, o novo nó deve ser
			// inserido ANTES desse nó:
			else {
				novoNoLSE.setProx(atual);
				anterior.setProx(novoNoLSE);	
			}
		}
		setQuantNos(getQuantNos()+1);
	}
	
	public void inserirOrdenado2(ContaBancaria novaConta) {
		NoLSE novoNoLSE = new NoLSE(novaConta);
		//int status = 0;
		
		// Se a lista está vazia, insere o primeiro nó
		if (this.eVazia()) {
			this.setPrim(novoNoLSE);
			this.setUlt(novoNoLSE);
			//System.out.println(">>0" + " " +getPrim().getConta().getCPF() + " " +getPrim().getConta().getConta());
			//System.out.println("Prim:");
			//System.out.println(this.getPrim().getConta().toString());
		} else {
			// Se a lista não está vazia:
			NoLSE atual    = this.getPrim();
			NoLSE anterior = null;
			
			// Percorre a lista até o último nó, verificando se  a conta bancária passada
			// como parâmetro é maior do que a conta do nó atual (a comparação é feita
			// através de um comparator implementado na classe ContaBancaria):
			while (atual.getProx() != null && novoNoLSE.getConta().compareTo(atual.getConta()) > 0) {
				//status = novoNoLSE.getConta().compareTo(atual.getConta());
				anterior = atual;
				atual    = atual.getProx();
			}
			
			if (atual == getPrim() && atual.getProx() == null) {
				if (novoNoLSE.getConta().compareTo(atual.getConta()) > 0) {
					atual.setProx(novoNoLSE);
					setUlt(novoNoLSE);
					//System.out.println(status);
					//System.out.println(">>1");
				}
				else if (novoNoLSE.getConta().compareTo(atual.getConta()) < 0) {
					novoNoLSE.setProx(atual);
					setPrim(novoNoLSE);
					//System.out.println(status);
					//System.out.println(">>2");
				}
			}
			else if (atual == getPrim() && atual.getProx() != null) {
				if (novoNoLSE.getConta().compareTo(atual.getConta()) > 0) {
					novoNoLSE.setProx(atual.getProx());
					atual.setProx(novoNoLSE);
					//System.out.println(status);
					//System.out.println(">>3");
				}
				else if (novoNoLSE.getConta().compareTo(atual.getConta()) < 0) {
					novoNoLSE.setProx(atual);
					setPrim(novoNoLSE);
					//System.out.println(status);
					//System.out.println(">>4");
				}
			} else if (atual == getUlt()) {
				if (novoNoLSE.getConta().compareTo(atual.getConta()) > 0) {
					atual.setProx(novoNoLSE);
					setUlt(novoNoLSE);
					//System.out.println(status);
					//System.out.println(">>5");
				}
				else if (novoNoLSE.getConta().compareTo(atual.getConta()) < 0) {
					novoNoLSE.setProx(atual);
					anterior.setProx(novoNoLSE);
					//System.out.println(status);
					//System.out.println(">>6");
				}
			}
			else {
				novoNoLSE.setProx(atual);
				anterior.setProx(novoNoLSE);
				//System.out.println(status);
				//System.out.println(">>7");
			}
		}
		setQuantNos(getQuantNos()+1);
	}
}