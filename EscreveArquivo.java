

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.NumberFormat;
import java.util.Locale;


public class EscreveArquivo {
	
	public boolean escreverLinha(Produto produto) {
		boolean escreveu = true;
		String ARQUIVO = "produtos.txt";
        String PROGRAMA_ORDENANDOR = "integrador.exe";
        String COMANDO = "ordena";
		try {
	        
			
            File arquivo = new File(ARQUIVO);
            // verifica se o arquivo ja existe, se nao existir cria um novo
            if(!arquivo.exists()){
                arquivo.createNewFile();
            }

            FileWriter fw = new FileWriter (arquivo,true);
            
            BufferedWriter bw = new BufferedWriter(fw);
 
            StringBuffer buffer = new StringBuffer();
            
            // codigo
            // 123;
            buffer.append(produto.getCodigo().toString());
            buffer.append(";"); // usa "|" para separar os campos
            
            // nome
            // biscoito buddy
            // 123;biscoito buddy;
            buffer.append(produto.getDescricao());
            buffer.append(";");
            
            // converte o valor para o formato R$ 999,99
            // pega o formato de numero do real brasileiro
            NumberFormat numberFormat =NumberFormat.getInstance(new Locale("en", "US"));
            //.getCurrencyInstance(new Locale("pt", "BR"));
            // converte o preco do produto para real brasileiro
            // por exemplo, 13.25 = > 13,25
            //String valorFormatado = String.format("%.02d", produto.getPreco());
            String valorFormatado = numberFormat.format(produto.getPreco()); // 13,25 => R$ 13,25
            
            // grava o preco
            // 123;biscoito buddy;R$ 13,25; 
            buffer.append(valorFormatado);
            buffer.append(";");
            buffer.append("\n");

            bw.write(buffer.toString());
            bw.close();

            // ordenar ...
            StringBuffer builder = new StringBuffer();
            builder.append(PROGRAMA_ORDENANDOR);
            builder.append(" ");
            builder.append(COMANDO);
            System.out.println(builder.toString());
            Process p =  Runtime.getRuntime().exec(builder.toString());
            p.waitFor();
    
        }
        catch ( Exception e ) {
            e.printStackTrace();
            escreveu = false;
        }
		
		return escreveu;
	}
} 