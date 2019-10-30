package util;

// Imports
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import classes.ContaBancaria;


/**
 * <p>A classe <code><b>CSV</b></code> implementa os métodos para a leitura
 * dos arquivos de dados a serem utilizados no trabalho final da disciplina
 * de Pesquisa e Ordenação, do curso de Ciência da Computação, da FAESA.</p>
 * 
 * @author Abrantes Araújo Silva Filho ({@link<a href="mailto:abrantesasf@gmail.com">abrantesasf@gmail.com</a>})
 */
public class CSV2 {
	
    ///////////////////////////////////////////////////
    // Atributos
    ///////////////////////////////////////////////////	
	
	/** <p>String para diversas mensagens a serem retornadas pelos métodos</p> */
	private String mensagem = "";
	
	
	
    ///////////////////////////////////////////////////
    // Construtor(es)
    ///////////////////////////////////////////////////
	
	/** <p>Construtor padrão.</p> */
	public CSV2() {}
	
	
	
    ///////////////////////////////////////////////////
    // Lê arquivos de dados em formato CSV
    ///////////////////////////////////////////////////
	
	/**
	 * <p>Faz a leitura de um arquivo CSV com os dados das contas bancárias,
	 * conforme o formato especificado na documentação técnica do trabalho
	 * de pesquisa e ordenação.</p>
	 * 
	 * @param arquivo
	 *        (String) com o path COMPLETO do arquivo a ser lido
	 *        
	 * @param vContas
	 *        (ContaBancaria[]) é o vetor de contas bancárias que será
	 *        preenchido com os dados das contas lidas a partir do arquivo
	 *        
	 * @param numeroDeCampos
	 *        (int) inteiro que representa quantos campos (variáveis) há
	 *        em cada linha do arquivo de dados
	 *        
	 * @param separador
	 *        (String) com o separador utilizado entre em campos no arquivo
	 *        
	 * @param header
	 *        (boolean) indica se o arquivo contém (TRUE) ou não (FALSE) uma
	 *        linha de cabeçalho
	 *        
	 * @return <code>TRUE</code> se todas as contas bancárias foram lidas e inseridas no vetor<br />
	 *         <code>FALSE</code> se as contas bancárias não puderam ser lidas e inseridas no vetor
	 *         
	 * @throws IOException
	 */
	public boolean lerArquivoDeContas(String arquivo,
			                          ContaBancaria[] vContas,
			                          int numeroDeCampos,
			                          String separador,
			                          Boolean header
			                         ) throws IOException {
		String  linha = "";
		boolean ok    = true;
		int qtdIn = 0;
		
		try {
			// Cria objeto FileReader para "apontar" para o arquivo passado como argumento; e
			// Cria objeto BufferedReader que lê o conteúdo do arquivo apontado pelo FileReader.
			FileReader     arq    = new FileReader(arquivo);
			BufferedReader lerArq = new BufferedReader(arq);
			
			try {
				// Se tem header, pula a linha de cabeçalho
				if (header) {
					lerArq.readLine();
				}
				
				// Enquanto ainda existem linhas a serem lidas e não há erros (ok = true):
				while (((linha = lerArq.readLine()) != null) && ok) {
					// Pega a próxima linha, divide os campos nos divisores e coloca em vetor
					String[] vetor = linha.split(separador);
					
					// Valida se o número de campos da linha está nos conformes
					if (vetor.length != numeroDeCampos) {
						ok = false;
						this.mensagem = "Erro na estrutura do arquivo CSV: " + arquivo;
						this.mensagem += "\nO número de campos encontrados é diferente do informado.";
						System.out.println(this.mensagem);
						break;
					} else {
						// Cria uma conta bancária para armazenar os dados da conta especificada na linha atual
						ContaBancaria novaContaBancaria = new ContaBancaria(vetor[0], vetor[1], Double.parseDouble(vetor[2]), vetor[3]);
						
						// Insere a nova conta bancária no vetor de contas bancárias
//						if (!vContas.inserirContaBancaria(novaContaBancaria)) {
//							ok = false;
//							this.mensagem = "Erro durante a inserção da conta no vetor temporário.";
//							System.out.println(this.mensagem);
//							break;
//						}
						vContas[qtdIn] = novaContaBancaria;
						qtdIn++;
					}
				}
			} catch (Exception e) {
				System.out.println("Erro não esperado. O StackTrace é: ");
				e.printStackTrace();
			} finally {
				lerArq.close();
				arq.close();
			}
			
		} catch (Exception e) {
			System.out.println("Erro não esperado. O stack de erro é: ");
			e.printStackTrace();
		}
		return ok;
	}
	
	public boolean gravarArquivoDeContas(String arquivo, ContaBancaria[] contas, boolean header) {
		boolean ok = false;
		try {
			// Instancia objeto do tipo PrintWriter, usanto UTF-8 por padrão
			PrintWriter saida = new PrintWriter(arquivo, "UTF-8");

			// Se tem cabeçalho, grava:
			if (header) {
				saida.print("agencia;numero;saldo;cpf");
				saida.print(System.getProperty("line.separator"));
			}

			// Percorre o vetor e salva os dados no arquivo, colocando o separador
			// ";" entre os campos e, ao final, o caractere de final de linha adequado para o SO
			for (int i = 0; i < contas.length; i++) {
				saida.print(contas[i].getAgencia());
				saida.print(";");
				saida.print(contas[i].getConta());
				saida.print(";");
				saida.print(Double.toString(contas[i].getSaldo()));
				saida.print(";");
				saida.print(contas[i].getCPF());
				saida.print(System.getProperty("line.separator"));
			}
			ok = true;
			saida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ok;
	}

} // fecha a classe CSV2
