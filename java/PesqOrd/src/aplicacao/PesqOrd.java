package aplicacao;

// Imports
import java.util.Scanner;

import classes.ContaBancaria;
import classes.Heap;
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
 * @author Abrantes Araújo Silva Filho ({@link<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>})
 */
public class PesqOrd {

	///////////////////////////////////////////////////
	// Atributos estáticos da classe
	///////////////////////////////////////////////////
	
	/** <p>Scanner para leitura de dados do usuário.</p> */
	private static Scanner scan = new Scanner(System.in);
	
	/** <p>Cria instância da classe Arquivos para as operações de IO.</p> */
	private static Arquivos arq = new Arquivos();
	
	///** <p>Cria instância da classe CSV para a leitura dos arquivos de dados.</p> */
	//private static CSV csv = new CSV();
	
	/** <p>Cria instância da classe CSV2 para a leitura dos arquivos de dados.</p> */
	private static CSV2 csv2 = new CSV2();
	
	/** <p>Cria instância da classe VetorDeContasBancarias para armazenar as contas lidas.</p> */
	private static ContaBancaria[] contas;
	
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
	
	/** <p>String com o path completo até o arquivo aleatório 500 ordenado pelo heap sort</p> **/
	private static String heapAlea500 = dirDados + "heap_alea_500.txt";
	
	/** <p>String com o path completo até o arquivo aleatório 1000 ordenado pelo heap sort</p> **/
	private static String heapAlea1000 = dirDados + "heap_alea_1000.txt";
	
	/** <p>String com o path completo até o arquivo aleatório 5000 ordenado pelo heap sort</p> **/
	private static String heapAlea5000 = dirDados + "heap_alea_5000.txt";
	
	/** <p>String com o path completo até o arquivo aleatório 10000 ordenado pelo heap sort</p> **/
	private static String heapAlea10000 = dirDados + "heap_alea_10000.txt";
	
	/** <p>String com o path completo até o arquivo aleatório 50000 ordenado pelo heap sort</p> **/
	private static String heapAlea50000 = dirDados + "heap_alea_50000.txt";
	
	/** <p>String com o path completo até o arquivo ordenado 500 ordenado pelo heap sort</p> **/
	private static String heapOrd500 = dirDados + "heap_ord_500.txt";
	
	/** <p>String com o path completo até o arquivo ordenado 1000 ordenado pelo heap sort</p> **/
	private static String heapOrd1000 = dirDados + "heap_ord_1000.txt";
	
	/** <p>String com o path completo até o arquivo ordenado 5000 ordenado pelo heap sort</p> **/
	private static String heapOrd5000 = dirDados + "heap_ord_5000.txt";
	
	/** <p>String com o path completo até o arquivo ordenado 10000 ordenado pelo heap sort</p> **/
	private static String heapOrd10000 = dirDados + "heap_ord_10000.txt";
	
	/** <p>String com o path completo até o arquivo ordenado 50000 ordenado pelo heap sort</p> **/
	private static String heapOrd50000 = dirDados + "heap_ord_50000.txt";
	
	/** <p>String com o path completo até o arquivo invertido 500 ordenado pelo heap sort</p> **/
	private static String heapInv500 = dirDados + "heap_inv_500.txt";
	
	/** <p>String com o path completo até o arquivo invertido 1000 ordenado pelo heap sort</p> **/
	private static String heapInv1000 = dirDados + "heap_inv_1000.txt";
	
	/** <p>String com o path completo até o arquivo invertido 5000 ordenado pelo heap sort</p> **/
	private static String heapInv5000 = dirDados + "heap_inv_5000.txt";
	
	/** <p>String com o path completo até o arquivo invertido 10000 ordenado pelo heap sort</p> **/
	private static String heapInv10000 = dirDados + "heap_inv_10000.txt";
	
	/** <p>String com o path completo até o arquivo invertido 50000 ordenado pelo heap sort</p> **/
	private static String heapInv50000 = dirDados + "heap_inv_50000.txt";
	
	/** <p>Índice de opção para o menu da aplicação</p> **/
	private static int menuOption = 0;
	
	/** <p>Marca tempo de início</p> **/
	private static long tempoInicial = 0;
	
	/** <p>Marca tempo de fim</p> **/
	private static long tempoFinal = 0;
	
	/** <p>Inicia a contagem de tempo.</p> **/
	private static long iniciaTimer() {
		return System.currentTimeMillis();
	}
	
	/** <p>Vetor que armazenará os tempos das 5 repetições dos métodos.</p> **/
	private static long[] duracoesRegistradas = new long[5];
	
	/** <p>Finaliza a contagem de tempo.</p> **/
	private static long finalizaTimer() {
		return System.currentTimeMillis();
	}
	
	/** <p>Calcula duração em milisegundos</p> **/
	private static long calculaDuracao(long tempoInicial, long tempoFinal) {
		return tempoFinal - tempoInicial;
	}
	
	
	
	///////////////////////////////////////////////////
	// Métodos estáticos da classe
	///////////////////////////////////////////////////
	
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
	
	/** <p>Calcula a média do tempo de duração das repetições dos métodos.</p> **/
	private static long calculaMediaDuracao() {
		long soma = 0;
		for (int i = 0; i < duracoesRegistradas.length; i++) {
			soma += duracoesRegistradas[i];
		}
		return soma / duracoesRegistradas.length;
	}
	

	
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
		
		do {
			System.out.println("------------- MENU DE OPÇÕES -------------\n" +
		                       "Heap Sort + Binary Search:\n" +
					           "   1) Aleatório    500\n" +
		                       "   2) Aleatório  1.000\n" +
					           "   3) Aleatório  5.000\n" +
		                       "   4) Aleatório 10.000\n" +
					           "   5) Aleatório 50.000\n" +
					           "   6) Ordenado     500\n" +
		                       "   7) Ordenado   1.000\n" +
					           "   8) Ordenado   5.000\n" +
		                       "   9) Ordenado  10.000\n" +
					           "  10) Ordenado  50.000\n" +
					           "  11) Invertido    500\n" +
					           "  12) Invertido  1.000\n" +
					           "  13) Invertido  5.000\n" +
					           "  14) Invertido 10.000\n" +
					           "  15) Invertido 50.000\n" +
					           "------------------------------------------\n"
			);
			System.out.print("Sua opção é: ");
			menuOption = scan.nextInt();
			scan.nextLine();
		
			switch (menuOption) {
				case 1:
					for (int i = 0; i < 5; i++) {
						tempoInicial = iniciaTimer();
						carregaContas(alea500);
						Heap.sort(contas);
						csv2.gravarArquivoDeContas(heapAlea500, contas, false);
						tempoFinal = finalizaTimer();
						duracoesRegistradas[i] = calculaDuracao(tempoInicial, tempoFinal);
						System.out.println("Duração da execução nº " + (i+1) + ": " + duracoesRegistradas[i] + " milissegundos.");	
					}
					System.out.println("Duração média (5 execuções): " + calculaMediaDuracao());
					break;
				case 2:
					for (int i = 0; i < 5; i++) {
						tempoInicial = iniciaTimer();
						carregaContas(alea1000);
						Heap.sort(contas);
						csv2.gravarArquivoDeContas(heapAlea1000, contas, false);
						tempoFinal = finalizaTimer();
						duracoesRegistradas[i] = calculaDuracao(tempoInicial, tempoFinal);
						System.out.println("Duração da execução nº " + (i+1) + ": " + duracoesRegistradas[i] + " milissegundos.");	
					}
					System.out.println("Duração média (5 execuções): " + calculaMediaDuracao());
					break;
				case 3:
					for (int i = 0; i < 5; i++) {
						tempoInicial = iniciaTimer();
						carregaContas(alea5000);
						Heap.sort(contas);
						csv2.gravarArquivoDeContas(heapAlea5000, contas, false);
						tempoFinal = finalizaTimer();
						duracoesRegistradas[i] = calculaDuracao(tempoInicial, tempoFinal);
						System.out.println("Duração da execução nº " + (i+1) + ": " + duracoesRegistradas[i] + " milissegundos.");	
					}
					System.out.println("Duração média (5 execuções): " + calculaMediaDuracao());
					break;
				case 4:
					for (int i = 0; i < 5; i++) {
						tempoInicial = iniciaTimer();
						carregaContas(alea10000);
						Heap.sort(contas);
						csv2.gravarArquivoDeContas(heapAlea10000, contas, false);
						tempoFinal = finalizaTimer();
						duracoesRegistradas[i] = calculaDuracao(tempoInicial, tempoFinal);
						System.out.println("Duração da execução nº " + (i+1) + ": " + duracoesRegistradas[i] + " milissegundos.");	
					}
					System.out.println("Duração média (5 execuções): " + calculaMediaDuracao());
					break;
				case 5:
					for (int i = 0; i < 5; i++) {
						tempoInicial = iniciaTimer();
						carregaContas(alea50000);
						Heap.sort(contas);
						csv2.gravarArquivoDeContas(heapAlea50000, contas, false);
						tempoFinal = finalizaTimer();
						duracoesRegistradas[i] = calculaDuracao(tempoInicial, tempoFinal);
						System.out.println("Duração da execução nº " + (i+1) + ": " + duracoesRegistradas[i] + " milissegundos.");	
					}
					System.out.println("Duração média (5 execuções): " + calculaMediaDuracao());
					break;
				case 6:
					for (int i = 0; i < 5; i++) {
						tempoInicial = iniciaTimer();
						carregaContas(ord500);
						Heap.sort(contas);
						csv2.gravarArquivoDeContas(heapOrd500, contas, false);
						tempoFinal = finalizaTimer();
						duracoesRegistradas[i] = calculaDuracao(tempoInicial, tempoFinal);
						System.out.println("Duração da execução nº " + (i+1) + ": " + duracoesRegistradas[i] + " milissegundos.");	
					}
					System.out.println("Duração média (5 execuções): " + calculaMediaDuracao());
					break;
				case 7:
					for (int i = 0; i < 5; i++) {
						tempoInicial = iniciaTimer();
						carregaContas(ord1000);
						Heap.sort(contas);
						csv2.gravarArquivoDeContas(heapOrd1000, contas, false);
						tempoFinal = finalizaTimer();
						duracoesRegistradas[i] = calculaDuracao(tempoInicial, tempoFinal);
						System.out.println("Duração da execução nº " + (i+1) + ": " + duracoesRegistradas[i] + " milissegundos.");	
					}
					System.out.println("Duração média (5 execuções): " + calculaMediaDuracao());
					break;
				case 8:
					for (int i = 0; i < 5; i++) {
						tempoInicial = iniciaTimer();
						carregaContas(ord5000);
						Heap.sort(contas);
						csv2.gravarArquivoDeContas(heapOrd5000, contas, false);
						tempoFinal = finalizaTimer();
						duracoesRegistradas[i] = calculaDuracao(tempoInicial, tempoFinal);
						System.out.println("Duração da execução nº " + (i+1) + ": " + duracoesRegistradas[i] + " milissegundos.");	
					}
					System.out.println("Duração média (5 execuções): " + calculaMediaDuracao());
					break;
				case 9:
					for (int i = 0; i < 5; i++) {
						tempoInicial = iniciaTimer();
						carregaContas(ord10000);
						Heap.sort(contas);
						csv2.gravarArquivoDeContas(heapOrd10000, contas, false);
						tempoFinal = finalizaTimer();
						duracoesRegistradas[i] = calculaDuracao(tempoInicial, tempoFinal);
						System.out.println("Duração da execução nº " + (i+1) + ": " + duracoesRegistradas[i] + " milissegundos.");	
					}
					System.out.println("Duração média (5 execuções): " + calculaMediaDuracao());
					break;
				case 10:
					for (int i = 0; i < 5; i++) {
						tempoInicial = iniciaTimer();
						carregaContas(ord50000);
						Heap.sort(contas);
						csv2.gravarArquivoDeContas(heapOrd50000, contas, false);
						tempoFinal = finalizaTimer();
						duracoesRegistradas[i] = calculaDuracao(tempoInicial, tempoFinal);
						System.out.println("Duração da execução nº " + (i+1) + ": " + duracoesRegistradas[i] + " milissegundos.");	
					}
					System.out.println("Duração média (5 execuções): " + calculaMediaDuracao());
					break;
				case 11:
					for (int i = 0; i < 5; i++) {
						tempoInicial = iniciaTimer();
						carregaContas(inv500);
						Heap.sort(contas);
						csv2.gravarArquivoDeContas(heapInv500, contas, false);
						tempoFinal = finalizaTimer();
						duracoesRegistradas[i] = calculaDuracao(tempoInicial, tempoFinal);
						System.out.println("Duração da execução nº " + (i+1) + ": " + duracoesRegistradas[i] + " milissegundos.");	
					}
					System.out.println("Duração média (5 execuções): " + calculaMediaDuracao());
					break;
				case 12:
					for (int i = 0; i < 5; i++) {
						tempoInicial = iniciaTimer();
						carregaContas(inv1000);
						Heap.sort(contas);
						csv2.gravarArquivoDeContas(heapInv1000, contas, false);
						tempoFinal = finalizaTimer();
						duracoesRegistradas[i] = calculaDuracao(tempoInicial, tempoFinal);
						System.out.println("Duração da execução nº " + (i+1) + ": " + duracoesRegistradas[i] + " milissegundos.");	
					}
					System.out.println("Duração média (5 execuções): " + calculaMediaDuracao());
					break;
				case 13:
					for (int i = 0; i < 5; i++) {
						tempoInicial = iniciaTimer();
						carregaContas(inv5000);
						Heap.sort(contas);
						csv2.gravarArquivoDeContas(heapInv5000, contas, false);
						tempoFinal = finalizaTimer();
						duracoesRegistradas[i] = calculaDuracao(tempoInicial, tempoFinal);
						System.out.println("Duração da execução nº " + (i+1) + ": " + duracoesRegistradas[i] + " milissegundos.");	
					}
					System.out.println("Duração média (5 execuções): " + calculaMediaDuracao());
					break;
				case 14:
					for (int i = 0; i < 5; i++) {
						tempoInicial = iniciaTimer();
						carregaContas(inv10000);
						Heap.sort(contas);
						csv2.gravarArquivoDeContas(heapInv10000, contas, false);
						tempoFinal = finalizaTimer();
						duracoesRegistradas[i] = calculaDuracao(tempoInicial, tempoFinal);
						System.out.println("Duração da execução nº " + (i+1) + ": " + duracoesRegistradas[i] + " milissegundos.");	
					}
					System.out.println("Duração média (5 execuções): " + calculaMediaDuracao());
					break;
				case 15:
					for (int i = 0; i < 5; i++) {
						tempoInicial = iniciaTimer();
						carregaContas(inv50000);
						Heap.sort(contas);
						csv2.gravarArquivoDeContas(heapInv50000, contas, false);
						tempoFinal = finalizaTimer();
						duracoesRegistradas[i] = calculaDuracao(tempoInicial, tempoFinal);
						System.out.println("Duração da execução nº " + (i+1) + ": " + duracoesRegistradas[i] + " milissegundos.");	
					}
					System.out.println("Duração média (5 execuções): " + calculaMediaDuracao());
					break;
				case 99:
					System.out.println("Encerrando o programa.");
					System.out.println("Moriturus te saluto!");
					break;
				default:
					System.out.println("Opção não reconhecida, informe novamente!");
					break;
			}
			
		} while (menuOption != 99);
		
		// Fecha scanner:
		scan.close();
		
	} // fecha main

} // fecha classe
