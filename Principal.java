import java.util.Scanner;

public class Principal {

	private static Scanner scan;

	public static void main(String[] args) {
		
		CadastroProduto cadastro = new CadastroProduto();
		
		// falta fazer essa classe ainda ...
		PesquisarProduto pesquisa = new PesquisarProduto();
		ListarProduto listar = new ListarProduto();
		
		scan = new Scanner(System.in);
		
		System.out.println(" **** Bem vindo ao shopping FHO: ");
		System.out.println("  *** Informe a opcao desejada: ");
		System.out.println(" **** Digite 0 para sair: ");

		int opcao = 100;

		while (opcao != 0) {
			System.out.println("(1) Cadastrar produtos");
			System.out.println("(2) Pesquisar produtos");
			System.out.println("(3) Listar    produtos");
			System.out.println("(0) Sair");

			opcao = scan.nextInt();

			switch (opcao) {
			case 1:
				if (!cadastro.executar()) {
					System.out.println("Nao foi possivel cadastrar. Tente novamente");
				};
				break;
			case 2:
				if (!pesquisa.executar()) {
					System.out.println("Nao foi possivel pesquisar. Tente novamente");
				};

				break;
				case 3:
					if (!listar.executar()) {
						System.out.println("Nao foi possivel pesquisar. Tente novamente");
					};
					break;

			default:
				System.out.println("Obrigado por usar o nosso programa. Volte sempre !");
			}
		}
		cadastro=null;
		pesquisa = null;
	}

}
