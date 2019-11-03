package classes;

/**
 * <p>A classe <code><b>Insertion</b></code> implementa o método de ordenação <b>Insertion Sort</b>
 * que será utilizado em casos especiais no trabalho final da disciplina de Pesquisa e Ordenação,
 * do curso de Ciência da Computação, da FAESA.</p>
 * 
 * <p>Os métodos utilizados aqui foram retirados/modificados de:</p>
 * <ul>
 * <li><b>SEDGEWICK R, WAYNE K. Algorithms. 4 ed. Princeton: Addison Wesley, 2011.</b></li>
 * </ul>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 */
public class Insertion {
	
    ///////////////////////////////////////////////////
    // Atributos
    ///////////////////////////////////////////////////
	
	
	
    ///////////////////////////////////////////////////
    // Construtor
    ///////////////////////////////////////////////////
	
	/** <p>O construtor é privado pois esta classe não deve ser instanciada.</p> **/
	private Insertion() {};
	
	
	
    ///////////////////////////////////////////////////
    // Insertion Sort
    ///////////////////////////////////////////////////
	
	/**
	 * <p>O método <code><b>sort</b></code> implementa o Insertion Sort "in-place",
	 * ou seja, recebe um vetor de objetos, constrói um heap nesse vetor e,
	 * após a construção do heap, realizar o sort.</p>
	 * 
	 * @param pq
	 *        (Comparable[] pq) este método recebe como parâmetro um vetor de
	 *        objetos que implementam a interface <code>Comparable</code> com
	 *        os critérios de ordenação. De acordo com as instruções do trabalho,
	 *        as contas serão ordenadas por CPF, agência e conta.
	 */
	public static void sort(Comparable[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
				exchange(a, j, j-1);
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
