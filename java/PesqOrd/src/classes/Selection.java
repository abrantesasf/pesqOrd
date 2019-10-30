package classes;

/**
 * <p>A classe <code><b>Selection</b></code> implementa o método de ordenação <b>Selection Sort</b>.
 * Esta classe não será utilizada diretamente no trabalho final da disciplina de Pesquisa e Ordenação,
 * do curso de Ciência da Computação, da FAESA, mas servirá para testes e comparações.</p>
 * 
 * <p>Os métodos utilizados aqui foram retirados/modificados de:</p>
 * <ul>
 * <li><b>SEDGEWICK R, WAYNE K. Algorithms. 4 ed. Princeton: Addison Wesley, 2011.</b></li>
 * </ul>
 * 
 * @author Abrantes Araújo Silva Filho ({@link<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>})
 */
public class Selection {
	
    ///////////////////////////////////////////////////
    // Atributos
    ///////////////////////////////////////////////////	
	
	
	
    ///////////////////////////////////////////////////
    // Construtor
    ///////////////////////////////////////////////////
	
	/** <p>O construtor é privado pois esta classe não deve ser instanciada.</p> **/
	private Selection() {};
	
	
	
    ///////////////////////////////////////////////////
    // Selection Sort
    ///////////////////////////////////////////////////	
	
	/**
	 * <p>O método <code><b>sort</b></code> implementa o Selection Sort,
	 * ou seja, recebe um vetor de objetos, e ordena os objetos procurando
	 * sempre os menores (de acordo com o critério de ordenação implementado
	 * em um método Comparator) e colocando-os no início da ordem.</p>
	 * 
	 * @param pq
	 *        (Comparable[] pq) este método recebe como parâmetro um vetor de
	 *        objetos que implementam a interface <code>Comparable</code> com
	 *        os critérios de ordenação. De acordo com as instruções do trabalho,
	 *        as contas serão ordenadas por CPF, agência e conta.
	 */
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i+1; j < n; j++) {
				if (less(a[j], a[min])) min = j;
			exchange(a, i, min);
				
			}
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
	public static boolean isSorted(Comparable [] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i-1])) return false;
		}
		return true;
	}
	
	
	
	///////////////////////////////////////////////////
    // Métodos auxiliares privados
    ///////////////////////////////////////////////////	
	
	/** <p>Realiza a comparação durante a ordenação</p> **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	/** <p>Troca dois objetos de posição.</p> **/
	@SuppressWarnings("rawtypes")
	private static void exchange(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
