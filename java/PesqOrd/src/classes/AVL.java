package classes;

public class AVL {
	
	///////////////////////////////////////////////////
	// Atributos
	///////////////////////////////////////////////////	
	
	private NoAVL   raiz;
	private boolean h;
	
	
	
	///////////////////////////////////////////////////
	// Construtor(es)
	///////////////////////////////////////////////////		
	
	public AVL() {
		this.raiz = null;
		this.h    = true;
	}
	
	
	
	///////////////////////////////////////////////////
	// Getters
	///////////////////////////////////////////////////		
	
	public NoAVL getRaiz() {
		return this.raiz;
	}
	
	public boolean getH() {
		return this.h;
	}
	
	
	
	///////////////////////////////////////////////////
	// Setters
	///////////////////////////////////////////////////
	
	public void setRaiz(NoAVL raiz) {
		this.raiz = raiz;
	}
	
	public void setH(boolean h) {
		this.h = h;
	}
	
	
	
	///////////////////////////////////////////////////
	// Método auxiliar para comparar só CPFs, sem
	// depender do comparator global da ContaBancaria
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
		NoAVL temp;
		
		temp = this.pesquisa(cpf, this.raiz);
		if (temp != null) return true;
		else              return false;
	}
	
	private NoAVL pesquisa(String cpf, NoAVL no) {
		NoAVL temp;
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
		NoAVL temp;
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
			NoAVL existente = this.pesquisa(conta.getCPF(), this.raiz);
			if (compararCPF(existente.getCPF(), conta.getCPF()) == 0) {	
				existente.getLista().inserirOrdenado2(conta);
			}
		} else {
			this.raiz = this.inserir(conta, this.raiz);
		}
		return true;
	}
	
	private NoAVL inserir(ContaBancaria conta, NoAVL no) {
		NoAVL novo;
		
		if (no == null) {
			novo = new NoAVL(conta.getCPF());
			novo.getLista().inserirOrdenado2(conta);
			this.h = true;
			return novo;
		} else {
			if (compararCPF(conta.getCPF(), no.getCPF()) < 0) {
				no.setEsq(this.inserir(conta, no.getEsq()));
				no = this.balancearDir(no);
				return no;
			}
			else if (compararCPF(conta.getCPF(), no.getCPF()) > 0) {
				no.setDir(this.inserir(conta, no.getDir()));
				no = this.balancearEsq(no);
				return no;
			}
			return no;
		}
	}
	
	
	
	///////////////////////////////////////////////////
	// Métodos para verificar se o balanceamento é
	// necessário (direita e esquerda)
	///////////////////////////////////////////////////
	
	private NoAVL balancearDir (NoAVL no) {
		if (this.h) {
			switch (no.getFatorBalanceamento()) {
			case 1:
				no.setFatorBalanceamento((byte) 0);
				this.h = false;
				break;
			case 0:
				no.setFatorBalanceamento((byte) -1);
				break;
			case -1:
				no = this.rotacaoDireita(no);
			}
		}
		return no;
	}
	
	private NoAVL balancearEsq (NoAVL no) {
		if (this.h) {
			switch (no.getFatorBalanceamento()) {
			case -1:
				no.setFatorBalanceamento((byte) 0);
				this.h = false;
				break;
			case 0:
				no.setFatorBalanceamento((byte) 1);
				break;
			case 1:
				no = this.rotacaoEsquerda(no);
			}
		}
		return no;
	}
	
	
	
	///////////////////////////////////////////////////
	// Métodos para realizar a rotação ou rotação dupla
	// dos nós (direita e esquerda)
	///////////////////////////////////////////////////	
	
	private NoAVL rotacaoDireita(NoAVL no) {
		NoAVL temp1;
		NoAVL temp2;
		temp1 = no.getEsq();
		if (temp1.getFatorBalanceamento() == -1) {
			// faz rotação simples para direita
			no.setEsq(temp1.getDir());
			temp1.setDir(no);
			no.setFatorBalanceamento((byte) 0);
			no = temp1;
		}
		else {
			// faz rotação dupla para a direita
			temp2 = temp1.getDir();
			temp1.setDir(temp2.getEsq());
			temp2.setEsq(temp1);
			no.setEsq(temp2.getDir());
			temp2.setDir(no);
			
			// Recalcula FB do nó à direita da nova árvore
			if (temp2.getFatorBalanceamento() == -1) {
				no.setFatorBalanceamento((byte) 1);
			}
			else {
				no.setFatorBalanceamento((byte) 0);
			}
			
			// Recalcula FB do nó à esquerda da nova árvore
			if (temp2.getFatorBalanceamento() == 1) {
				temp1.setFatorBalanceamento((byte) -1);
			}
			else {
				temp1.setFatorBalanceamento((byte) 0);
			}
			
			no = temp2;
		}
		
		// Raiz passa a ter FB 0
		no.setFatorBalanceamento((byte) 0);
		this.h = false;
		return no;
	}
	
	private NoAVL rotacaoEsquerda(NoAVL no) {
		NoAVL temp1;
		NoAVL temp2;
		temp1 = no.getDir();
		if (temp1.getFatorBalanceamento() == 1) {
			// faz rotação simples para esquerda
			no.setDir(temp1.getEsq());
			temp1.setEsq(no);
			no.setFatorBalanceamento((byte) 0);
			no = temp1;
		}
		else {
			// faz rotação dupla para a esquerda
			temp2 = temp1.getEsq();
			temp1.setEsq(temp2.getDir());
			temp2.setDir(temp1);
			no.setDir(temp2.getEsq());
			temp2.setEsq(no);
			
			// Recalcula FB do nó à esquerda da nova árvore
			if (temp2.getFatorBalanceamento() == 1) {
				no.setFatorBalanceamento((byte) -1);
			}
			else {
				no.setFatorBalanceamento((byte) 0);
			}
			
			// Recalcula FB do nó à direita da nova árvore
			if (temp2.getFatorBalanceamento() == -1) {
				temp1.setFatorBalanceamento((byte) 1);
			}
			else {
				temp1.setFatorBalanceamento((byte) 0);
			}
			
			no = temp2;
		}
		
		// Raiz passa a ter FB 0
		no.setFatorBalanceamento((byte) 0);
		this.h = false;
		return no;
	}
	
	
	
	///////////////////////////////////////////////////
	// Percurso in-ordem
	///////////////////////////////////////////////////
	
	public VetorDeContasBancarias percursoInOrdem (VetorDeContasBancarias vetContas) {
		return (this.percursoInOrdem(this.raiz, vetContas));
	}
	
	private VetorDeContasBancarias percursoInOrdem(NoAVL arv, VetorDeContasBancarias vetContas) {
		if (arv != null) {
			vetContas = this.percursoInOrdem(arv.getEsq(), vetContas);
			vetContas.inserirContaBancaria(arv.getLista());
			vetContas = this.percursoInOrdem(arv.getDir(), vetContas);
		}
		return vetContas;
	}	

}
