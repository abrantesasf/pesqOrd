package aplicacao;

import java.util.Scanner;

import classes.VetorDeContasBancarias;
import util.Arquivos;
import util.CSV;

public class PesqOrd {

	///////////////////////////////////////////////////
	// Atributos estáticos da classe
	///////////////////////////////////////////////////
	private static Scanner                scan = new Scanner(System.in);
	private static Arquivos               arq  = new Arquivos();
	private static CSV                    csv  = new CSV();
	private static VetorDeContasBancarias contas;
	
	private static String dirDados = "/home/abrantesasf/repositoriosGit/pesqOrd/dados/";
	
	private static String alea500   = dirDados + "cliente500alea.txt";
	private static String alea1000  = dirDados + "cliente1000alea.txt";
	private static String alea5000  = dirDados + "cliente5000alea.txt";
	private static String alea10000 = dirDados + "cliente10000alea.txt";
	private static String alea50000 = dirDados + "cliente50000alea.txt";
	
	private static String ord500   = dirDados + "cliente500ord.txt";
	private static String ord1000  = dirDados + "cliente1000ord.txt";
	private static String ord5000  = dirDados + "cliente5000ord.txt";
	private static String ord10000 = dirDados + "cliente10000ord.txt";
	private static String ord50000 = dirDados + "cliente50000ord.txt";
	
	private static String inv500   = dirDados + "cliente500inv.txt";
	private static String inv1000  = dirDados + "cliente1000inv.txt";
	private static String inv5000  = dirDados + "cliente5000inv.txt";
	private static String inv10000 = dirDados + "cliente10000inv.txt";
	private static String inv50000 = dirDados + "cliente50000inv.txt";

	
	///////////////////////////////////////////////////
	// Método MAIN
	///////////////////////////////////////////////////	
	public static void main(String[] args) {
		
		///////////////////////////////////////////////////
		// Lê arquivo aleatório 500:
		///////////////////////////////////////////////////
		try {
			contas = new VetorDeContasBancarias(arq.contarLinhas(alea500));
			try {
				if (csv.lerCSVcontas(alea500, contas, 4, ";", false)) {
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
