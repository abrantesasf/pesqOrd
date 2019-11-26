package classes;


/**
 * <p>A classe <code><b>NoAVL</b></code> implementa o nó a ser utilizado
 * em uma árvore AVL. Esta classe será utilizada
 * no trabalho final da disciplina de Pesquisa e Ordenação,
 * do curso de Ciência da Computação, da FAESA.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com)
 */
public class NoAVL {
	
	///////////////////////////////////////////////////
	// Atributos
	///////////////////////////////////////////////////
	
	private String cpf;
	private LSE    lista;
	private NoAVL  esq;
	private NoAVL  dir;
	private byte   fatorBalanceamento;
	
	
	
	///////////////////////////////////////////////////
	// Construtor(es)
	///////////////////////////////////////////////////	
	
	public NoAVL(String cpf) {
		this.cpf   = cpf;
		this.lista = new LSE();
		this.esq   = null;
		this.dir   = null;
		this.fatorBalanceamento = 0;
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
	
	public NoAVL getEsq() {
		return this.esq;
	}
	
	public NoAVL getDir() {
		return this.dir;
	}
	
	public byte getFatorBalanceamento() {
		return this.fatorBalanceamento;
	}
	
	
	
	///////////////////////////////////////////////////
	// Setters
	///////////////////////////////////////////////////	
	
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	//public void setLista(LSE lista) {
	//	this.lista = lista;
	//}
	
	public void setEsq(NoAVL esq) {
		this.esq = esq;
	}
	
	public void setDir(NoAVL dir) {
		this.dir = dir;
	}
	
	public void setFatorBalanceamento(byte fb) {
		this.fatorBalanceamento = fb;
	}

}
