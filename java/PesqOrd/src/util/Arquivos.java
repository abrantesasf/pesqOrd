package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Arquivos {

	///////////////////////////////////////////////////
	// Atributos
	///////////////////////////////////////////////////
	private Path   path;
	private String separadorDeArquivosString   = File.separator;
	private char   separadorDeArquivosChar     = File.separatorChar;
	private String separadorDeDiretoriosString = File.pathSeparator;
	private char   separadorDeDiretoriosChar   = File.separatorChar;
	
	

	///////////////////////////////////////////////////
	// Construtor(es)
	///////////////////////////////////////////////////
	public Arquivos() {
		// Construtor padrão apenas
	}
	
	
	
	///////////////////////////////////////////////////
	// Arquivo existe?
	///////////////////////////////////////////////////
	public boolean arquivoExiste(String path) {
		boolean retorno = false;

		this.path = Paths.get(path);

		if (Files.exists(this.path) && (Files.isRegularFile(this.path))) {
				retorno = true;
		};
		
		return retorno;
	}
	
	
	
	///////////////////////////////////////////////////
	// Diretório existe?
	///////////////////////////////////////////////////	
	public boolean diretorioExiste(String path) {
		boolean retorno = false;

		this.path = Paths.get(path);
		
		if (Files.exists(this.path) && (Files.isDirectory(this.path))) {
				retorno = true;
		};

		return retorno;
	}
	
	
	
	///////////////////////////////////////////////////
	// Contar linhas do arquivo
	///////////////////////////////////////////////////	
	/**
	 * <p><b>contarLinhas(String arquivo)</b></p>
	 * <p>Método que retorna um inteiro contendo a quantidade de linhas
	 * em um arquivo texto. Esse método foi retirado diretamente de uma
	 * publicação no <a href="https://stackoverflow.com/a/453067/6850077">Stack Overflow</a>,
	 * e ligeiramente adaptado para nossas
	 * necessidades. Todos os créditos vão para o autor original.</p>
	 * 
	 * @author martinus <a href="https://stackoverflow.com/users/48181/martinus">Martinus's Stack Overflow page</a>
	 * @see <a href="https://stackoverflow.com/a/453067/6850077">https://stackoverflow.com/a/453067/6850077</a>
	 * @param arquivo (String que representa o PATH completo até um arquivo)
	 * @return int
	 * @throws IOException
	 */
	public int contarLinhas(String arquivo) throws IOException {
		// Cria um stream de input:
	    InputStream is = new BufferedInputStream(new FileInputStream(arquivo));
	    
	    try {
	        byte[] c = new byte[1024];
	        int contador = 0;
	        int caracteresLidos = 0;
	        boolean arquivoVazio = true;
	        
	        // Enquanto existem caracteres
	        while ((caracteresLidos = is.read(c)) != -1) {
	        	// O arquivo não está vazio
	            arquivoVazio = false;
	            
	            // Se tem nova linha, aumenta o contador de linhas
	            for (int i = 0; i < caracteresLidos; ++i) {
	                if (c[i] == '\n') {
	                    ++contador;
	                }
	            }
	        }
	        return (contador == 0 && !arquivoVazio) ? 1 : contador;
	    } finally {
	    	// Fecha o stream de input:
	        is.close();
	    }
	}
	
	
	
	///////////////////////////////////////////////////
	// Separador de arquivos conforme SO,
	// em formato Strint (S) ou Char (C)
	///////////////////////////////////////////////////	
	public String separadorDeArquivosS() {
		return this.separadorDeArquivosString;
	}
	
	public char separadorDeArquivosC() {
		return this.separadorDeArquivosChar;
	}
	
	
	
	///////////////////////////////////////////////////
	// Separador de diretório conforme SO,
	// em formato Strint (S) ou Char (C)
	///////////////////////////////////////////////////	
	public String separadorDeDiretoriosS() {
		return this.separadorDeDiretoriosString;
	}

	public char separadorDeDiretoriosC() {
		return this.separadorDeDiretoriosChar;
	}	

} // fecha classe Arquivos
