package util;

// Imports
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <p>A classe <code><b>Arquivos</b></code> é uma classe com métodos
 * auxiliares para as atividades de IO do trabalho final da disciplina
 * de Pesquisa e Ordenação, do curso de Ciência da Computação, da FAESA.</p>
 * 
 * @author Abrantes Araújo Silva Filho
 */
public class Arquivos {

	///////////////////////////////////////////////////
	// Atributos
	///////////////////////////////////////////////////
	
	/** <p>Objeto que representa um <code>path</code> para um diretório/arquivo.</p> */
	private Path path;
	
	/** <p>Separador de arquivos padrão do sistema operacional, em formato String.</p> */
	private String separadorDeArquivosString = File.separator;
	
	/** <p>Separador de arquivos padrão do sistema operacional, em formato char.</p> */
	private char separadorDeArquivosChar = File.separatorChar;
	
	/** <p>Separador de diretórios padrão do sistema operacional, em formato String.</p> */
	private String separadorDeDiretoriosString = File.pathSeparator;
	
	/** <p>Separador de diretórios padrão do sistema operacional, em formato char.</p> */
	private char separadorDeDiretoriosChar = File.separatorChar;
	
	

	///////////////////////////////////////////////////
	// Construtor(es)
	///////////////////////////////////////////////////
	
	/** <p>Construtor padrão.</p> */
	public Arquivos() {	}
	
	
	
	///////////////////////////////////////////////////
	// Arquivo existe?
	///////////////////////////////////////////////////
	
	/**
	 * <p>Checa se um arquivo existe.</p>
	 * 
	 * @param path
	 *        (String) que representa um caminho até um arquivo no sistema operacional
	 *        
	 * @return <code>TRUE</code> se o arquivo existe<br />
	 *         <code>FALSE</code> se o arquivo não existe
	 */
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
	
	/**
	 * <p>Checa se um diretório existe.</p>
	 * 
	 * @param path
	 *        (String) que representa um caminho até um diretório no sistema operacional
	 *        
	 * @return <code>TRUE</code> se o diretório existe<br />
	 *         <code>FALSE</code> se o diretório não existe
	 */
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
	// Retorna o separador de arquivos padrão
	///////////////////////////////////////////////////
	
	/** <p>Retorna o separador de arquivos padrão no formato String.</p> */
	public String separadorDeArquivosS() {
		return this.separadorDeArquivosString;
	}
	
	/** <p>Retorna o separador de arquivos padrão no formato char.</p> */
	public char separadorDeArquivosC() {
		return this.separadorDeArquivosChar;
	}
	
	
	
	///////////////////////////////////////////////////
	// Retorna o separador de diretórios padrão
	///////////////////////////////////////////////////
	
	/** <p>Retorna o separador de diretórios padrão no formato String.</p> */
	public String separadorDeDiretoriosS() {
		return this.separadorDeDiretoriosString;
	}

	/** <p>Retorna o separador de diretórios padrão no formato char.</p> */
	public char separadorDeDiretoriosC() {
		return this.separadorDeDiretoriosChar;
	}	

} // fecha classe Arquivos
