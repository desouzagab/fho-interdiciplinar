import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeitorArquivo {
	
	private String linhaLida;

	public String getLinhaLida() {
		return linhaLida;
	}

	public boolean leitura() {
		
		boolean ok = true;
		
		String ARQUIVO = "retorno.txt";
		
		try {
			
			File arquivo = new File(ARQUIVO);
			if (!arquivo.exists()) {
				throw new Exception("Arquivo de retorno nao encontrado !");
			}

			FileReader fr = new FileReader (ARQUIVO);
            BufferedReader br = new BufferedReader(fr);
            String linha ;

            while ((linha = br.readLine()) != null) {
            	if (linha != null) {
            		linhaLida = linha;		
            	}
            }
                
            br.close();
		} catch (Exception e) {
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}
}
