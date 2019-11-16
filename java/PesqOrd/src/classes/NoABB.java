package classes;

public class NoABB {
	
	///////////////////////////////////////////////////
	// Atributos
	///////////////////////////////////////////////////
	
	private String cpf;
	private LSE    lista;
	private NoABB  esq;
	private NoABB  dir;
	
	
	
	///////////////////////////////////////////////////
	// Construtor(es)
	///////////////////////////////////////////////////	
	
	public NoABB(String cpf) {
		this.cpf   = cpf;
		this.lista = new LSE();
		this.esq   = null;
		this.dir   = null;
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
	
	public NoABB getEsq() {
		return this.esq;
	}
	
	public NoABB getDir() {
		return this.dir;
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
	
	public void setEsq(NoABB esq) {
		this.esq = esq;
	}
	
	public void setDir(NoABB dir) {
		this.dir = dir;
	}
}
