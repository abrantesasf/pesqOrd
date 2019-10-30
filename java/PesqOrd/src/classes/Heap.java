package classes;

/**
 * <p>A classe <code><b>Heap</b></code> implementa o método de ordenação <b>Heap Sort</b>
 * que será utilizado no trabalho final da disciplina de Pesquisa e Ordenação,
 * do curso de Ciência da Computação, da FAESA.</p>
 * 
 * <p>Os métodos utilizados aqui foram retirados/modificados de:</p>
 * <ul>
 * <li><b>SEDGEWICK R, WAYNE K. Algorithms. 4 ed. Princeton: Addison Wesley, 2011.</b></li>
 * </ul>
 * 
 * @author Abrantes Araújo Silva Filho ({@link<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>})
 */
public class Heap {
	
    ///////////////////////////////////////////////////
    // Atributos
    ///////////////////////////////////////////////////
	
	
	
    ///////////////////////////////////////////////////
    // Construtor
    ///////////////////////////////////////////////////
	
	/** <p>O construtor é privado pois esta classe não deve ser instanciada.</p> **/
	private Heap() {};
	
	
	
    ///////////////////////////////////////////////////
    // Heap Sort
    ///////////////////////////////////////////////////
	
	/**
	 * <p>O método <code><b>sort</b></code> implementa o Heap Sort "in-place",
	 * ou seja, recebe um vetor de objetos, constrói um heap nesse vetor e,
	 * após a construção do heap, realizar o sort.</p>
	 * 
	 * @param pq
	 *        (Comparable[] pq) este método recebe como parâmetro um vetor de
	 *        objetos que implementam a interface <code>Comparable</code> com
	 *        os critérios de ordenação. De acordo com as instruções do trabalho,
	 *        as contas serão ordenadas por CPF, agência e conta.
	 */
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] pq) {
        int n = pq.length;
        
        // Constrói o Heap:
        for (int k = n/2; k >= 1; k--)
            sink(pq, k, n);
        
        // Faz o sort:
        while (n > 1) {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }

	
	
    ///////////////////////////////////////////////////
    // isSorted assegura que o resultado está ordenado
    ///////////////////////////////////////////////////
	
	/** <p>Verifica se os objetos estão ordenados conforme as regras
	 * de comparação definidas na interface Comparable, implementada
	 * na classe que define os objetos.</p>
	 * 
	 * @param pq
	 *        (Comparable[] pq) este método recebe como parâmetro um vetor de
	 *        objetos que implementam a interface <code>Comparable</code>
	 *        
	 * @return TRUE: se os objetos estão ordenados<br />
	 *         FALSE: se os objetos não estão ordenados
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isSorted(Comparable [] pq) {
		for (int i = 1; i < pq.length; i++) {
			if (less(pq[i], pq[i-1])) return false;
		}
		return true;
	}
	

	
	///////////////////////////////////////////////////
    // Métodos auxiliares privados
    ///////////////////////////////////////////////////
	
	/** <p>Garante a propriedade do Heap, "descendo" com os nós.</p> **/
	@SuppressWarnings("rawtypes")
	private static void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }
	
	/** <p>Troca dois nós de posição.</p> **/
    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }	

    /** <p>Realiza a comparação durante a construção e o sort do heap</p> **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }
  
	/** <p>Realiza a comparação para verificar se o resultado está ordenado</p> **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}    
	
}
