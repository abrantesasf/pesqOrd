package aplicacao;

// Imports
import java.util.Scanner;

import classes.ABB;
import classes.ContaBancaria;
import classes.Heap;
import classes.Quick;
import classes.VetorDeContasBancarias;
//import classes.Selection;
//import classes.VetorDeContasBancarias;
import util.Arquivos;
//import util.CSV;
import util.CSV2;

/**
 * <p>A classe <code><b>PesqOrd</b></code> é a classe principal de
 * execução do trabalho final da disciplina de Pesquisa e Ordenação,
 * do curso de Ciência da Computação, da FAESA.</p>
 * 
 * @author Abrantes Araújo Silva Filho (<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>)
 */
public class PesqOrd {

	///////////////////////////////////////////////////
	// Atributos estáticos que podem ser modificados
	// de acordo com seu ambiente
	///////////////////////////////////////////////////
	
	/** <p>Informa o path completo até o diretório com os arquivos de dados
	 * fornecidos pela profa. Cinthia. Os arquivos de saída também serão
	 * gravados nesse diretório.</p>
	 * 
	 * <p>Nesse diretórios devem estar presentes os seguintes arquivos</p>
	 * 
	 * <ul>
	 * <li><i>Arquivos aleatórios</i>: cliente500alea.txt, cliente1000alea.txt, cliente5000alea.txt,
	 *     cliente10000alea.txt e cliente50000alea.txt</li>
	 * <li><i>Arquivos ordenados</i>: cliente500ord.txt, cliente1000ord.txt, cliente5000ord.txt,
	 *     cliente10000ord.txt e cliente50000ord.txt</li>
	 * <li><i>Arquivos ordenados inversamente</i>: cliente500inv.txt, cliente1000inv.txt, cliente5000inv.txt,
	 *     cliente10000inv.txt e cliente50000inv.txt</li>
	 * </ul>
	 * 
	 * <p><b>Atenção</b>: não altere os nomes padronizados
	 * dos arquivos que foram fornecidos pela profa. Cinthia, pois esta classe
	 * depende dos nomes padronizados para execução.</p> */
	private static String dirDados = "/home/abrantesasf/repositoriosGit/pesqOrd/dados/";
	
	/** <p>Quantas vezes você repetirá cada método de ordenação para calcular
	 * a média de duração? O padrão é 5 vezes. */
	private static int repeticoes = 5;
	
	

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
		
		// Mostra o menu para o usuário e chama todas as outras
		// rotinas do trabalho:
		menuPrincipal();
				
		// Fecha scanner:
		scan.close();
		
	} // fecha main
	
	
	
	///////////////////////////////////////////////////
	// Atributos e Métodos estáticos para todas as
	// operações de IO a serem realizadas no trabalho
	// (NÃO ALTERE!)
	///////////////////////////////////////////////////		
	
	/** <p>Scanner para leitura de dados do usuário.</p> */
	private static Scanner scan = new Scanner(System.in);
	
	/** <p>Cria instância da classe Arquivos para as operações de IO.</p> */
	private static Arquivos arq = new Arquivos();
	
	///** <p>Cria instância da classe CSV para a leitura dos arquivos de dados.</p> */
	//private static CSV csv = new CSV();
	
	/** <p>Cria instância da classe CSV2 para a leitura dos arquivos de dados.</p> */
	private static CSV2 csv2 = new CSV2();
	
	/** <p>Armazena a opção do menu principal escolhida pelo usuário</p> **/
	private static int menuOption = 0;
	
	/** <p>Armazena a opção do submenu escolhida pelo usuário</p> **/
	private static int submenuOption = 0;
	
	/** <p>Cria instância da classe VetorDeContasBancarias para armazenar as contas lidas.</p> */
	private static ContaBancaria[] contas;
	
	private static VetorDeContasBancarias vetContas;
	
	/** <p>Cria uma ABB vazia para o método ABB Balanceada.</p> */
	private static ABB abb;
	
	/**
	 * <p>Faz a leitura de um path para um arquivo de dados com as contas
	 * bancárias e faz a carga no vetor <code>contas</code.</p>
	 * 
	 * @param arquivo
	 *        (String) com a representação de um path completo até um arquivo
	 *        de dados de contas bancárias.
	 */
	private static void carregaContas(String arquivo) {
		try {
			int qtd = arq.contarLinhas(arquivo);
			contas = new ContaBancaria[qtd];
			try {
				if (csv2.lerArquivoDeContas(arquivo, contas, 4, ";", false)) {
					System.out.println("Arquivo carregado com sucesso!");
				}
			} catch (Exception e) {
				System.out.println("Não foi possível carregar as contas bancárias. O StackTrace é:");
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("Não foi possível encontrar/ler o arquivo. O StackTrace é:");
			e.printStackTrace();
		}
	}
	
	
	
	///////////////////////////////////////////////////
	// Atributos e Métodos para o registro de tempo
	// (NÃO ALTERE!)
	///////////////////////////////////////////////////
	
	/** <p>Vetor que armazenará os tempos das repetições dos métodos.</p> **/
	private static long[] duracoesRegistradas = new long[repeticoes];
	
	/** <p>Marca tempo de início</p> **/
	private static long tempoInicial = 0;
	
	/** <p>Marca tempo de fim</p> **/
	private static long tempoFinal = 0;
	
	/** <p>Inicia a contagem de tempo.</p> **/
	private static long iniciaTimer() {
		return System.currentTimeMillis();
	}
	
	/** <p>Finaliza a contagem de tempo.</p> **/
	private static long finalizaTimer() {
		return System.currentTimeMillis();
	}
	
	/** <p>Calcula duração em milisegundos</p> **/
	private static long calculaDuracao(long tempoInicial, long tempoFinal) {
		return tempoFinal - tempoInicial;
	}
	
	/** <p>Calcula a média do tempo de duração das repetições dos métodos.</p> **/
	private static long calculaMediaDuracao() {
		long soma = 0;
		for (int i = 0; i < duracoesRegistradas.length; i++) {
			soma += duracoesRegistradas[i];
		}
		return soma / duracoesRegistradas.length;
	}
	
	
	
	///////////////////////////////////////////////////
	// Método fazTrabalho() é o método que realmente
	// faz todo o trabalho de ordenação, cálculos, etc.
	// (NÃO ALTERE!)
	///////////////////////////////////////////////////		
	
	/**
	 * <p><code><b>fazTrabalho</b></code> é o principal método desta aplicação,
	 * pois ele é reponsável por executar, de fato, a leitura dos arquivos
	 * originais de dados, executar um método de ordenação específico, gravar
	 * o arquivo de output, repetir todas as operações por um número especificado
	 * de vezes, contar o tempo de execução e calcular as médias.</p>
	 * 
	 * @param input
	 *        (String) com o path completo até o arquivo de dados original
	 * @param metodo
	 *        (int) com um inteiro que especifica o método de ordenação a
	 *        ser executado. Corresponde aos inteiros que aparecem como
	 *        opção no menu principal.
	 * @param output
	 *        (String) com o path completo até o arquivo a ser gravado
	 *        com os resultados do método de ordenação executado.
	 */
	private static void fazTrabalho(String input, int metodo, String output) {
		for (int i = 0; i < repeticoes; i++) {
			tempoInicial = iniciaTimer();
			carregaContas(input);
			switch (metodo) {
			case 100:
				Heap.sort(contas);
				break;
			case 200:
				Quick.sort(contas);
				break;
			case 300:
				vetContas = new VetorDeContasBancarias(contas.length);
				abb = new ABB();
				for (int j = 0; j < contas.length; j++) {
					ContaBancaria ct = new ContaBancaria(contas[j].getAgencia(),
							                             contas[j].getConta(),
							                             contas[j].getSaldo(),
							                             contas[j].getCPF());
					abb.inserir(ct);
				}
				abb.percursoInOrdem(vetContas);
				abb = new ABB();
				abb.balancear(vetContas);
				break;
			default:
				System.out.println("Método de ordenação especificado não existe.");
				break;
			}
			switch (metodo) {
			case 100:
			case 200:
				csv2.gravarArquivoDeContas(output, contas, false);
				break;
			case 300:
				csv2.gravarArquivoDeContas(output, vetContas, false);
				break;
			default:
				System.out.println("Não foi possível determinar o arquivo a ser gravado pelo CSV2.");
				break;
			}
			tempoFinal = finalizaTimer();
			duracoesRegistradas[i] = calculaDuracao(tempoInicial, tempoFinal);
			System.out.println("Duração da execução nº " + (i+1) + ": " + duracoesRegistradas[i] + " milissegundos.");	
		}
		System.out.println("Duração média (" + repeticoes + " execuções): " + calculaMediaDuracao());
	}
	
	
	
	///////////////////////////////////////////////////
	// MENU PRINCIPAL da aplicação
	// (NÃO ALTERE!)
	///////////////////////////////////////////////////	
	
	/** <p>Exibe o menu principal do trabalho. </p> */
	private static void menuPrincipal() {
		menuOption = 0;
		do {
			System.out.println("------------- MENU DE OPÇÕES -------------\n" +
                               "100) Heap Sort + Binary Search:\n" +
			                   "200) Quicksort + Binary Search:\n" +
                               "300) ABB Balanceada:\n" +
			                   "999) Sai da aplicação\n" +
			                   "------------------------------------------\n"
	                          );
			System.out.print("Sua opção é: ");
			menuOption = scan.nextInt();
			scan.nextLine();
			
			switch (menuOption) {
			case 100:
				menuHeap();
				break;
			case 200:
				menuQuick();
				break;
			case 300:
				menuABB();
				break;
			case 999:
				System.out.println("Encerrando o programa.");
				System.out.println("Moriturus te saluto!");
				break;
			default:
				System.out.println("Opção não reconhecida, informe novamente.");
				break;
			}
		} while (menuOption != 999);
	}
	
	
	
	///////////////////////////////////////////////////
	// Opções padronizadas a serem exibidas em cada
	// submenu específico de um método de ordenação
	// (NÃO ALTERE!)
	///////////////////////////////////////////////////		
	
	/** <p>Método auxiliar para exibir as subopções padronizadas
	 * em cada submenu específico de um método de ordenação.</p> */
	private static void opcoesSubMenu() {
		System.out.println("  1) Aleatório    500\n" +
                           "  2) Aleatório  1.000\n" +
                           "  3) Aleatório  5.000\n" +
                           "  4) Aleatório 10.000\n" +
                           "  5) Aleatório 50.000\n" +
                           "  6) Ordenado     500\n" +
                           "  7) Ordenado   1.000\n" +
                           "  8) Ordenado   5.000\n" +
                           "  9) Ordenado  10.000\n" +
                           " 10) Ordenado  50.000\n" +
                           " 11) Invertido    500\n" +
                           " 12) Invertido  1.000\n" +
                           " 13) Invertido  5.000\n" +
                           " 14) Invertido 10.000\n" +
                           " 15) Invertido 50.000\n" +
                           " 99) Volta para o menu principal\n" +
                           "------------------------------------------"
                           );
	}
	
	
	
	///////////////////////////////////////////////////
	// Menu para o HEAP SORT
	// (NÃO ALTERE!)
	///////////////////////////////////////////////////	
	
	/** <p>Exibe o menu para o Heap Sort</p> */
	private static void menuHeap() {
		submenuOption = 0;
		do {
			System.out.println("-------- HEAP SORT + BINARY SEARCH -------");
			opcoesSubMenu();
			System.out.print("Sua opção é: ");
			submenuOption = scan.nextInt();
			scan.nextLine();
			
			switch (submenuOption) {
			case 1:
				fazTrabalho(alea500, 100, heapAlea500);
				break;
			case 2:
				fazTrabalho(alea1000, 100, heapAlea1000);
				break;
			case 3:
				fazTrabalho(alea5000, 100, heapAlea5000);
				break;
			case 4:
				fazTrabalho(alea10000, 100, heapAlea10000);
				break;
			case 5:
				fazTrabalho(alea50000, 100, heapAlea50000);
				break;
			case 6:
				fazTrabalho(ord500, 100, heapOrd500);
				break;
			case 7:
				fazTrabalho(ord1000, 100, heapOrd1000);
				break;
			case 8:
				fazTrabalho(ord5000, 100, heapOrd5000);
				break;
			case 9:
				fazTrabalho(ord10000, 100, heapOrd10000);
				break;
			case 10:
				fazTrabalho(ord50000, 100, heapOrd50000);
				break;
			case 11:
				fazTrabalho(inv500, 100, heapInv500);
				break;
			case 12:
				fazTrabalho(inv1000, 100, heapInv1000);
				break;
			case 13:
				fazTrabalho(inv5000, 100, heapInv5000);
				break;
			case 14:
				fazTrabalho(inv10000, 100, heapInv10000);
				break;
			case 15:
				fazTrabalho(inv50000, 100, heapInv50000);
				break;
			case 99:
				System.out.println("Retornando ao menu principal");
				break;
			default:
				System.out.println("Opção não reconhecida, informe novamente.");
				break;
			}
			
		} while (submenuOption != 99);		
	}
	
	
	
	///////////////////////////////////////////////////
	// Menu para o QUICKSORT
	// (NÃO ALTERE!)
	///////////////////////////////////////////////////	
	
	/** <p>Exibe o menu para o Quickort</p> */	
	private static void menuQuick() {
		submenuOption = 0;
		do {
			System.out.println("-------- QUICKSORT + BINARY SEARCH -------");
			opcoesSubMenu();
			System.out.print("Sua opção é: ");
			submenuOption = scan.nextInt();
			scan.nextLine();
			
			switch (submenuOption) {
			case 1:
				fazTrabalho(alea500, 200, quickAlea500);
				break;
			case 2:
				fazTrabalho(alea1000, 200, quickAlea1000);
				break;
			case 3:
				fazTrabalho(alea5000, 200, quickAlea5000);
				break;
			case 4:
				fazTrabalho(alea10000, 200, quickAlea10000);
				break;
			case 5:
				fazTrabalho(alea50000, 200, quickAlea50000);
				break;
			case 6:
				fazTrabalho(ord500, 200, quickOrd500);
				break;
			case 7:
				fazTrabalho(ord1000, 200, quickOrd1000);
				break;
			case 8:
				fazTrabalho(ord5000, 200, quickOrd5000);
				break;
			case 9:
				fazTrabalho(ord10000, 200, quickOrd10000);
				break;
			case 10:
				fazTrabalho(ord50000, 200, quickOrd50000);
				break;
			case 11:
				fazTrabalho(inv500, 200, quickInv500);
				break;
			case 12:
				fazTrabalho(inv1000, 200, quickInv1000);
				break;
			case 13:
				fazTrabalho(inv5000, 200, quickInv5000);
				break;
			case 14:
				fazTrabalho(inv10000, 200, quickInv10000);
				break;
			case 15:
				fazTrabalho(inv50000, 200, quickInv50000);
				break;
			case 99:
				System.out.println("Retornando ao menu principal");
				break;
			default:
				System.out.println("Opção não reconhecida, informe novamente.");
				break;
			}
			
		} while (submenuOption != 99);
	}
	
	
	
	///////////////////////////////////////////////////
	// Menu para a ABB Balanceada
	// (NÃO ALTERE!)
	///////////////////////////////////////////////////	
	
	/** <p>Exibe o menu para o Quickort</p> */	
	private static void menuABB() {
		submenuOption = 0;
		do {
			System.out.println("-------- ABB Balanceada -------");
			opcoesSubMenu();
			System.out.print("Sua opção é: ");
			submenuOption = scan.nextInt();
			scan.nextLine();
			
			switch (submenuOption) {
			case 1:
				fazTrabalho(alea500, 300, abbAlea500);
				break;
			case 2:
				fazTrabalho(alea1000, 300, abbAlea1000);
				break;
			case 3:
				fazTrabalho(alea5000, 300, abbAlea5000);
				break;
			case 4:
				fazTrabalho(alea10000, 300, abbAlea10000);
				break;
			case 5:
				fazTrabalho(alea50000, 300, abbAlea50000);
				break;
			case 6:
				fazTrabalho(ord500, 300, abbOrd500);
				break;
			case 7:
				fazTrabalho(ord1000, 300, abbOrd1000);
				break;
			case 8:
				fazTrabalho(ord5000, 300, abbOrd5000);
				break;
			case 9:
				fazTrabalho(ord10000, 300, abbOrd10000);
				break;
			case 10:
				fazTrabalho(ord50000, 300, abbOrd50000);
				break;
			case 11:
				fazTrabalho(inv500, 300, abbInv500);
				break;
			case 12:
				fazTrabalho(inv1000, 300, abbInv1000);
				break;
			case 13:
				fazTrabalho(inv5000, 300, abbInv5000);
				break;
			case 14:
				fazTrabalho(inv10000, 300, abbInv10000);
				break;
			case 15:
				fazTrabalho(inv50000, 300, abbInv50000);
				break;
			case 99:
				System.out.println("Retornando ao menu principal");
				break;
			default:
				System.out.println("Opção não reconhecida, informe novamente.");
				break;
			}
			
		} while (submenuOption != 99);
	}	
	
	
	
	///////////////////////////////////////////////////
	// Atributos estáticos para apontar para cada um
	// dos arquivos de dados da Profa. Cinthia
	// (NÃO ALTERE ESSES ATRIBUTOS!)
	///////////////////////////////////////////////////	
	
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
	// Atributos estáticos para dizer onde os arquivos
	// de saída do HEAP SORT serão gravados
	// (NÃO ALTERE ESSES ATRIBUTOS!)
	///////////////////////////////////////////////////	
	
	/** <p>String com o path completo até o arquivo aleatório 500</p> **/
	private static String heapAlea500 = dirDados + "heap_alea_500.txt";
	
	/** <p>String com o path completo até o arquivo aleatório 1000</p> **/
	private static String heapAlea1000 = dirDados + "heap_alea_1000.txt";
	
	/** <p>String com o path completo até o arquivo aleatório 5000</p> **/
	private static String heapAlea5000 = dirDados + "heap_alea_5000.txt";
	
	/** <p>String com o path completo até o arquivo aleatório 10000</p> **/
	private static String heapAlea10000 = dirDados + "heap_alea_10000.txt";
	
	/** <p>String com o path completo até o arquivo aleatório 50000</p> **/
	private static String heapAlea50000 = dirDados + "heap_alea_50000.txt";
	
	/** <p>String com o path completo até o arquivo ordenado 500</p> **/
	private static String heapOrd500 = dirDados + "heap_ord_500.txt";
	
	/** <p>String com o path completo até o arquivo ordenado 1000</p> **/
	private static String heapOrd1000 = dirDados + "heap_ord_1000.txt";
	
	/** <p>String com o path completo até o arquivo ordenado 5000</p> **/
	private static String heapOrd5000 = dirDados + "heap_ord_5000.txt";
	
	/** <p>String com o path completo até o arquivo ordenado 10000</p> **/
	private static String heapOrd10000 = dirDados + "heap_ord_10000.txt";
	
	/** <p>String com o path completo até o arquivo ordenado 50000</p> **/
	private static String heapOrd50000 = dirDados + "heap_ord_50000.txt";
	
	/** <p>String com o path completo até o arquivo invertido 500</p> **/
	private static String heapInv500 = dirDados + "heap_inv_500.txt";
	
	/** <p>String com o path completo até o arquivo invertido 1000</p> **/
	private static String heapInv1000 = dirDados + "heap_inv_1000.txt";
	
	/** <p>String com o path completo até o arquivo invertido 5000</p> **/
	private static String heapInv5000 = dirDados + "heap_inv_5000.txt";
	
	/** <p>String com o path completo até o arquivo invertido 10000</p> **/
	private static String heapInv10000 = dirDados + "heap_inv_10000.txt";
	
	/** <p>String com o path completo até o arquivo invertido 50000</p> **/
	private static String heapInv50000 = dirDados + "heap_inv_50000.txt";
	
	
	
	///////////////////////////////////////////////////
	// Atributos estáticos para dizer onde os arquivos
	// de saída do QUICKSORT serão gravados
	// (NÃO ALTERE ESSES ATRIBUTOS!)
	///////////////////////////////////////////////////
	
	/** <p>String com o path completo até o arquivo aleatório 500</p> **/
	private static String quickAlea500 = dirDados + "quick_alea_500.txt";
	
	/** <p>String com o path completo até o arquivo aleatório 1000</p> **/
	private static String quickAlea1000 = dirDados + "quick_alea_1000.txt";
	
	/** <p>String com o path completo até o arquivo aleatório 5000</p> **/
	private static String quickAlea5000 = dirDados + "quick_alea_5000.txt";
	
	/** <p>String com o path completo até o arquivo aleatório 10000</p> **/
	private static String quickAlea10000 = dirDados + "quick_alea_10000.txt";
	
	/** <p>String com o path completo até o arquivo aleatório 50000</p> **/
	private static String quickAlea50000 = dirDados + "quick_alea_50000.txt";
	
	/** <p>String com o path completo até o arquivo ordenado 500</p> **/
	private static String quickOrd500 = dirDados + "quick_ord_500.txt";
	
	/** <p>String com o path completo até o arquivo ordenado 1000</p> **/
	private static String quickOrd1000 = dirDados + "quick_ord_1000.txt";
	
	/** <p>String com o path completo até o arquivo ordenado 5000</p> **/
	private static String quickOrd5000 = dirDados + "quick_ord_5000.txt";
	
	/** <p>String com o path completo até o arquivo ordenado 10000</p> **/
	private static String quickOrd10000 = dirDados + "quick_ord_10000.txt";
	
	/** <p>String com o path completo até o arquivo ordenado 50000</p> **/
	private static String quickOrd50000 = dirDados + "quick_ord_50000.txt";
	
	/** <p>String com o path completo até o arquivo invertido 500</p> **/
	private static String quickInv500 = dirDados + "quick_inv_500.txt";
	
	/** <p>String com o path completo até o arquivo invertido 1000</p> **/
	private static String quickInv1000 = dirDados + "quick_inv_1000.txt";
	
	/** <p>String com o path completo até o arquivo invertido 5000</p> **/
	private static String quickInv5000 = dirDados + "quick_inv_5000.txt";
	
	/** <p>String com o path completo até o arquivo invertido 10000</p> **/
	private static String quickInv10000 = dirDados + "quick_inv_10000.txt";
	
	/** <p>String com o path completo até o arquivo invertido 50000</p> **/
	private static String quickInv50000 = dirDados + "quick_inv_50000.txt";
	
	
	
	///////////////////////////////////////////////////
	// Atributos estáticos para dizer onde os arquivos
	// de saída da ABB BALANCEADA serão gravados
	// (NÃO ALTERE ESSES ATRIBUTOS!)
	///////////////////////////////////////////////////

	/** <p>String com o path completo até o arquivo aleatório 500</p> **/
	private static String abbAlea500 = dirDados + "abb_alea_500.txt";

	/** <p>String com o path completo até o arquivo aleatório 1000</p> **/
	private static String abbAlea1000 = dirDados + "abb_alea_1000.txt";

	/** <p>String com o path completo até o arquivo aleatório 5000</p> **/
	private static String abbAlea5000 = dirDados + "abb_alea_5000.txt";

	/** <p>String com o path completo até o arquivo aleatório 10000</p> **/
	private static String abbAlea10000 = dirDados + "abb_alea_10000.txt";

	/** <p>String com o path completo até o arquivo aleatório 50000</p> **/
	private static String abbAlea50000 = dirDados + "abb_alea_50000.txt";

	/** <p>String com o path completo até o arquivo ordenado 500</p> **/
	private static String abbOrd500 = dirDados + "abb_ord_500.txt";

	/** <p>String com o path completo até o arquivo ordenado 1000</p> **/
	private static String abbOrd1000 = dirDados + "abb_ord_1000.txt";

	/** <p>String com o path completo até o arquivo ordenado 5000</p> **/
	private static String abbOrd5000 = dirDados + "abb_ord_5000.txt";

	/** <p>String com o path completo até o arquivo ordenado 10000</p> **/
	private static String abbOrd10000 = dirDados + "abb_ord_10000.txt";

	/** <p>String com o path completo até o arquivo ordenado 50000</p> **/
	private static String abbOrd50000 = dirDados + "abb_ord_50000.txt";

	/** <p>String com o path completo até o arquivo invertido 500</p> **/
	private static String abbInv500 = dirDados + "abb_inv_500.txt";

	/** <p>String com o path completo até o arquivo invertido 1000</p> **/
	private static String abbInv1000 = dirDados + "abb_inv_1000.txt";

	/** <p>String com o path completo até o arquivo invertido 5000</p> **/
	private static String abbInv5000 = dirDados + "abb_inv_5000.txt";

	/** <p>String com o path completo até o arquivo invertido 10000</p> **/
	private static String abbInv10000 = dirDados + "abb_inv_10000.txt";

	/** <p>String com o path completo até o arquivo invertido 50000</p> **/
	private static String abbInv50000 = dirDados + "abb_inv_50000.txt";		

} // fecha classe
