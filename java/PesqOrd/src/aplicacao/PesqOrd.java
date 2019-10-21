package aplicacao;

// Imports
import java.util.Scanner;
import classes.VetorDeContasBancarias;
import util.Arquivos;
import util.CSV;

/**
 * <p>A classe <code><b>PesqOrd</b></code> é a classe principal de
 * execução do trabalho final da disciplina de Pesquisa e Ordenação,
 * do curso de Ciência da Computação, da FAESA.</p>
 * 
 * @author Abrantes Araújo Silva Filho
 */
public class PesqOrd {

	///////////////////////////////////////////////////
	// Atributos estáticos da classe
	///////////////////////////////////////////////////
	
	/** <p>Scanner para leitura de dados do usuário.</p> */
	private static Scanner scan = new Scanner(System.in);
	
	/** <p>Cria instância da classe Arquivos para as operações de IO.</p> */
	private static Arquivos arq = new Arquivos();
	
	/** <p>Cria instância da classe CSV para a leitura dos arquivos de dados.</p> */
	private static CSV csv = new CSV();
	
	/** <p>Cria instância da classe VetorDeContasBancarias para armazenar as contas lidas.</p> */
	private static VetorDeContasBancarias contas;
	
	/** <p>Informa o path completo até o diretório com os arquivos de dados.</p> */
	private static String dirDados = "/home/abrantesasf/repositoriosGit/pesqOrd/dados/";
	
	/** <p>String com o path completo até arquivo cliente500alea.txt.</p> */
	private static String alea500   = dirDados + "cliente500alea.txt";
	
	/** <p>String com o path completo até arquivo cliente1000alea.txt.</p> */
	private static String alea1000  = dirDados + "cliente1000alea.txt";
	
	/** <p>String com o path completo até arquivo cliente5000alea.txt.</p> */
	private static String alea5000  = dirDados + "cliente5000alea.txt";
	
	/** <p>String com o path completo até arquivo cliente10000alea.txt.</p> */
	private static String alea10000 = dirDados + "cliente10000alea.txt";
	
	/** <p>String com o path completo até arquivo cliente50000alea.txt.</p> */
	private static String alea50000 = dirDados + "cliente50000alea.txt";
	
	/** <p>String com o path completo até arquivo cliente500ord.txt.</p> */
	private static String ord500   = dirDados + "cliente500ord.txt";
	
	/** <p>String com o path completo até arquivo cliente1000ord.txt.</p> */
	private static String ord1000  = dirDados + "cliente1000ord.txt";
	
	/** <p>String com o path completo até arquivo cliente5000ord.txt.</p> */
	private static String ord5000  = dirDados + "cliente5000ord.txt";
	
	/** <p>String com o path completo até arquivo cliente10000ord.txt.</p> */
	private static String ord10000 = dirDados + "cliente10000ord.txt";
	
	/** <p>String com o path completo até arquivo cliente50000ord.txt.</p> */
	private static String ord50000 = dirDados + "cliente50000ord.txt";
	
	/** <p>String com o path completo até arquivo cliente500inv.txt.</p> */
	private static String inv500   = dirDados + "cliente500inv.txt";
	
	/** <p>String com o path completo até arquivo cliente1000inv.txt.</p> */
	private static String inv1000  = dirDados + "cliente1000inv.txt";
	
	/** <p>String com o path completo até arquivo cliente5000inv.txt.</p> */
	private static String inv5000  = dirDados + "cliente5000inv.txt";
	
	/** <p>String com o path completo até arquivo cliente10000inv.txt.</p> */
	private static String inv10000 = dirDados + "cliente10000inv.txt";
	
	/** <p>String com o path completo até arquivo cliente50000inv.txt.</p> */
	private static String inv50000 = dirDados + "cliente50000inv.txt";

	
	///////////////////////////////////////////////////
	// Método MAIN
	///////////////////////////////////////////////////	
	
	/**
	 * Método MAIN para o trabalho de pesquisa e ordenação.
	 * 
	 * @param args
	 *        (argumentos padrão do método main)
	 */
	public static void main(String[] args) {
		
		///////////////////////////////////////////////////
		// Lê arquivo aleatório 500:
		///////////////////////////////////////////////////
		try {
			contas = new VetorDeContasBancarias(arq.contarLinhas(alea500));
			try {
				if (csv.lerArquivoDeContas(alea500, contas, 4, ";", false)) {
					System.out.println("Arquivo carregado com sucesso!");
				}
			} catch (Exception e) {
				System.out.println("Não foi possível carregar as contas bancárias. O StackTrace é:");
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("Não foi possível encontrar/ler o arquivo. O StackTrace é:");
			e.printStackTrace();
			return;
		}		

	} // fecha main

} // fecha classe
