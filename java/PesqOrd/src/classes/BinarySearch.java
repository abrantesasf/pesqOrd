package classes;

/**
 * <p>A classe <code><b>BinarySearch</b></code> implementa a Binary Search
 * para pesquisar por CPFs ordenados pelo Heap Sort e o Quicksort, 
 * conforme as especificações do trabalho final da disciplina de Pesquisa
 * e Ordenação, do curso de Ciência da Computação, da FAESA.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 */
public class BinarySearch {
	
    ///////////////////////////////////////////////////
    // Atributos
    ///////////////////////////////////////////////////
	
	
	
    ///////////////////////////////////////////////////
    // Construtor
    ///////////////////////////////////////////////////
	
	/** <p>O construtor é privado pois esta classe não deve ser instanciada.</p> **/
	private BinarySearch() {};
	
	
	
    ///////////////////////////////////////////////////
    // Busca binária
    ///////////////////////////////////////////////////	

	public static void pesquisarCPFs(ResultadoBusca[] vResult, ContaBancaria[] contas) {
		
		for (int i = 0; i < vResult.length; i++) {
			int esq = 0;
			int dir = contas.length - 1;
			int meio;
			LSE listaTemp = new LSE();
			
			while(esq <= dir) {
				meio = (esq + dir)/2;
				int inicio = meio;
				int fim = meio;

				if (vResult[i].getCPF().equals(contas[meio].getCPF())) {
					while(true) {
						if (inicio > 0 && vResult[i].getCPF().equals(contas[inicio-1].getCPF())) {
							inicio -= 1;
						} else {
							break;
						}
					}
					while(true) {
						if (inicio < contas.length - 1 && vResult[i].getCPF().equals(contas[fim+1].getCPF())) {
							fim += 1;
						} else {
							break;
						}
					}
					for (int j = inicio; j <= fim; j++) {
						listaTemp.inserirOrdenado2(contas[j]);
					}
					vResult[i].setLista(listaTemp);
					break;
				} else {
					if (Long.parseLong(vResult[i].getCPF()) < Long.parseLong(contas[meio].getCPF())) {
						dir = meio - 1;
					} else {
						esq = meio + 1;
					}
				}
				if (listaTemp.eVazia()) {
					vResult[i].setLista(null);
				}
			}
		}
	}
}
