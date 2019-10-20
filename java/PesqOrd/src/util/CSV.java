package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import classes.ContaBancaria;
import classes.VetorDeContasBancarias;

import java.io.BufferedReader;

public class CSV {
	
    ///////////////////////////////////////////////////
    // Atributos
    ///////////////////////////////////////////////////	
	private String mensagem = "";
	
	
	
    ///////////////////////////////////////////////////
    // Construtor(es)
    ///////////////////////////////////////////////////
	public CSV() {
		// Só o construtor padrão aqui
	}
	
	
	
    ///////////////////////////////////////////////////
    // Lê arquivos de dados em formato CSV
    ///////////////////////////////////////////////////
	public boolean lerCSVcontas(String arquivo,   VetorDeContasBancarias vContas, int numeroDeCampos,
			                    String separador, Boolean header) throws IOException {
		String  linha = "";
		boolean ok    = true;
		
		try {
			// Cria objeto FileReader para "apontar" para o arquivo passado como argumento; e
			// Cria objeto BufferedReader que lê o conteúdo do arquivo apontado pelo FileReader.
			FileReader     arq    = new FileReader(arquivo);
			BufferedReader lerArq = new BufferedReader(arq);
			
			try {
				// Se tem header pula a linha de cabeçalho
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
						if (!vContas.inserirContaBancaria(novaContaBancaria)) {
							ok = false;
							this.mensagem = "Erro durante a inserção da conta no vetor temporário.";
							System.out.println(this.mensagem);
							break;
						}
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

} // fecha a classe CSV
