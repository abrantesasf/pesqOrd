package classes;

/**
 * <p>A classe <code><b>Quick</b></code> implementa o método de ordenação <b>Quicksort</b>
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
public class Quick {
	
    ///////////////////////////////////////////////////
    // Atributos
    ///////////////////////////////////////////////////
	
	
	
    ///////////////////////////////////////////////////
    // Construtor
    ///////////////////////////////////////////////////
	
	/** <p>O construtor é privado pois esta classe não deve ser instanciada.</p> **/
	private Quick() {};
	
	
	
    ///////////////////////////////////////////////////
    // Quicksort
    ///////////////////////////////////////////////////
	
	/**
	 * <p>O método <code><b>sort</b></code> implementa o Quicksort, que é um
	 * método de ordenação "in-place", custo proporcional a nlog(n) na média,
	 * e utiliza uma estratégia de dividir e conquistar.</p>
	 * 
	 * <p>O Quicksort funciona <b>particionando</b> um array em 2 sub-arrays,
	 * e então ordenando os sub-arrays de modo independente.
	 * 
	 * @param a
	 *        (Comparable[] a) este método recebe como parâmetro um vetor de
	 *        objetos que implementam a interface <code>Comparable</code> com
	 *        os critérios de ordenação. De acordo com as instruções do trabalho,
	 *        as contas serão ordenadas por CPF e conta.
	 */
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
    }
	
	@SuppressWarnings("rawtypes")
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	@SuppressWarnings("rawtypes")
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		
		while (true)	 {
			while (less(a[++i], v)) if (i == hi) break;
			while (less(v, a[--j])) if (j == lo) break;
			if (i >= j) break;
			exchange(a, i, j);
		}
		exchange(a, lo, j);
		return j;
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
