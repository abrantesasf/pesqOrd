package classes;

/**
 * <p>A classe <code><b>ABB</b></code> implementa uma árvore binária e busca
 * para armazenar os dados utilizados no no trabalho
 * final da disciplina de Pesquisa e Ordenação, do curso de Ciência da
 * Computação, da FAESA.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 */
public class ABB {

	///////////////////////////////////////////////////
	// Atributos
	///////////////////////////////////////////////////	
	
	private NoABB raiz;
	private int   quantNos;
	
	
	
	///////////////////////////////////////////////////
	// Construtor(es)
	///////////////////////////////////////////////////		
	
	public ABB() {
		this.raiz     = null;
		this.quantNos = 0;
	}
	
	
	
	///////////////////////////////////////////////////
	// Getters
	///////////////////////////////////////////////////		
	
	public NoABB getRaiz() {
		return this.raiz;
	}
	
	public int getQuantNos() {
		return this.quantNos;
	}
	
	
	
	///////////////////////////////////////////////////
	// Setters
	///////////////////////////////////////////////////
	
	public void setRaiz(NoABB raiz) {
		this.raiz = raiz;
	}
	
	public void setQuantNos(int quantNos) {
		this.quantNos = quantNos;
	}
	
	
	
	///////////////////////////////////////////////////
	// Método auxiliar para comprar só CPFs, sem
	// depender do comparator global
	///////////////////////////////////////////////////
	
	private int compararCPF (String esse, String aquele) {
		if (Long.parseLong(esse) > Long.parseLong(aquele)) return +1;
		if (Long.parseLong(esse) < Long.parseLong(aquele)) return -1;
		return 0;
	}
	
	
	
	///////////////////////////////////////////////////
	// Pesquisar por um item
	///////////////////////////////////////////////////
	
	public boolean pesquisa (String cpf) {
		NoABB temp;
		
		temp = this.pesquisa(cpf, this.raiz);
		if (temp != null) return true;
		else              return false;
	}
	

	
	private NoABB pesquisa(String cpf, NoABB no) {
		NoABB temp;
		temp = no;
		
		if (temp != null) {
			if (compararCPF(cpf, temp.getCPF()) < 0) {
				temp = this.pesquisa(cpf, temp.getEsq());
			} else if (compararCPF(cpf, temp.getCPF()) > 0) {
				temp = this.pesquisa(cpf, temp.getDir());
			}
		}
		return temp;
	}
	
	
	
	///////////////////////////////////////////////////
	// Pesquisar por CPF e retornar a lista de contas
	///////////////////////////////////////////////////
	
	public LSE pesquisarCPF(String cpf) {
		NoABB temp;
		temp = this.pesquisa(cpf, this.raiz);
		if (temp != null) {
			return temp.getLista();
		} else {
			return null;
		}
	}
	

	
	///////////////////////////////////////////////////
	// Inserir conta bancária
	///////////////////////////////////////////////////	
	
	public boolean inserir (ContaBancaria conta) {
		boolean existe = false;
		existe = this.pesquisa(conta.getCPF());
		
		if (existe) {
			NoABB existente = this.pesquisa(conta.getCPF(), this.raiz);
			if (compararCPF(existente.getCPF(), conta.getCPF()) == 0) {	
				existente.getLista().inserirOrdenado2(conta);
			}
		} else {
			this.raiz = this.inserir(conta, this.raiz);
		}
		return true;
	}
	
	private NoABB inserir(ContaBancaria conta, NoABB no) {
		NoABB novo;
		
		if (no == null) {
			novo = new NoABB(conta.getCPF());
			novo.getLista().inserirOrdenado2(conta);
			return novo;
		} else {
			if (compararCPF(conta.getCPF(), no.getCPF()) < 0) {
				no.setEsq(this.inserir(conta, no.getEsq()));
				return no;
			}
			else if (compararCPF(conta.getCPF(), no.getCPF()) > 0) {
				no.setDir(this.inserir(conta, no.getDir()));
				return no;
			}
			return no;
		}
	}
	
	
	
	///////////////////////////////////////////////////
	// Percurso in-ordem
	///////////////////////////////////////////////////
	
	public VetorDeContasBancarias percursoInOrdem (VetorDeContasBancarias vetContas) {
		return (this.percursoInOrdem(this.raiz, vetContas));
	}
	
	private VetorDeContasBancarias percursoInOrdem(NoABB arv, VetorDeContasBancarias vetContas) {
		if (arv != null) {
			vetContas = this.percursoInOrdem(arv.getEsq(), vetContas);
			vetContas.inserirContaBancaria(arv.getLista());
			vetContas = this.percursoInOrdem(arv.getDir(), vetContas);
		}
		return vetContas;
	}
	
	
	
	///////////////////////////////////////////////////
	// Balancear a ABB
	///////////////////////////////////////////////////
	
	public ABB balancear(VetorDeContasBancarias vetContas) {
		ABB temp = new ABB();
		this.balancear(vetContas, temp, 0, vetContas.getQtdDeContasNoVetor()-1);
		return temp;
	}
	
	private void balancear(VetorDeContasBancarias vetContas, ABB temp, int inic, int fim) {
		int meio;
		if (fim >= inic) {
			meio = (inic + fim)/2;
			temp.inserir(vetContas.getConta(meio));
			this.balancear(vetContas, temp, inic  , meio-1);
			this.balancear(vetContas, temp, meio+1, fim   );
		}
	}
	
}
