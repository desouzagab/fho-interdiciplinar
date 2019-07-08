import java.util.Scanner;

public class PesquisarProduto extends Produto implements OperacaoProduto{
	
	private static Scanner scan;
	
	public boolean executar() {
		
		boolean ok = true;
		String PROGRAMA_PESQUISADOR = "integrador.exe";
        String COMANDO = "pesquisa ";
		
		try {
	        scan = new Scanner(System.in);
	        
	        System.out.println("******** Pesquisa de Produtos ********* ");
	        
	        System.out.println("Digite o codigo do produto: ");
	        this.setCodigo(scan.nextInt());
	        
	        // pesquisar no C
            StringBuffer builder = new StringBuffer();
            builder.append(PROGRAMA_PESQUISADOR);
            builder.append(" ");
            builder.append(COMANDO);
            builder.append(this.getCodigo().toString());
            System.out.println(builder.toString());
            Process p =  Runtime.getRuntime().exec(builder.toString());
            p.waitFor();
	        
            LeitorArquivo leitor = new LeitorArquivo();
	        
	        if (leitor.leitura()) {
	        	if (leitor.getLinhaLida().equals("SEMCADASTRO")) {
	        		System.out.println(" Produto nao cadastrado !");
	        	} else {
	        		String[] produto = leitor.getLinhaLida().split(";"); 
	        		System.out.println(" Produto:");
	        		
	        		this.setCodigo(Integer.parseInt(produto[0]));
	        		this.setDescricao(produto[1]);
	        		this.setPreco(Double.parseDouble(produto[2]));
	        		
	        		System.out.println(" ***** Encontrado ******");
			        System.out.println("  Codigo: " + this.getCodigo());
			        System.out.println("    Nome: " + this.getDescricao());
			        System.out.println("   Preco: " + this.getPreco());
	        	}
	        } 
			
		} catch (Exception ex) {
			ok = false;
			ex.printStackTrace();
			System.out.println("Ocorreu um erro no processo de pesquisa dos dados");
		}
		
        return ok;
	}

}
