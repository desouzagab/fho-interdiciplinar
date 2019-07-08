import java.util.Scanner;

public class CadastroProduto extends Produto implements OperacaoProduto{

    private static Scanner scan;

	public boolean executar() {

		boolean ok = true;
		
		try {
	        scan = new Scanner(System.in);
	        
	        System.out.println("******** Cadastro de Produtos ********* ");
	        System.out.println("***** Informe os dados do produto ***** ");
	        
	        System.out.println("Digite o codigo do produto: ");
	        this.setCodigo(scan.nextInt());
	        	
	        System.out.println("Nome do produto: ");
	        this.setDescricao(scan.next());

	        System.out.println("Digite o preco: ");
	        this.setPreco(scan.nextDouble());
	        
	        EscreveArquivo escrever = new EscreveArquivo();
	        if (escrever.escreverLinha(this)) {
	        	System.out.println(" Produto:");
		        System.out.println("  Codigo: " + this.getCodigo());
		        System.out.println("    Nome: " + this.getDescricao());
		        System.out.println("   Preco: " + this.getPreco());
	        	System.out.println(" Gravado com sucesso !");
	        } else {
	        	ok = false;
	        	System.out.println("Ocorreu um erro ao gravar o produto");
	        }
			
		} catch (Exception ex) {
			ok = false;
			ex.printStackTrace();
			System.out.println("Ocorreu um erro no processo de entrada dos dados");
		}
		
        return ok;
    }
}
	

