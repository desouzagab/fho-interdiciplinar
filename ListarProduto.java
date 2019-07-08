import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListarProduto extends Produto implements OperacaoProduto{


    public boolean executar() {
        boolean ok = true;

        try {

                //Le o arquivo
                FileReader ler = new FileReader("produtos.txt");
                BufferedReader reader = new BufferedReader(ler);
                String array[];
                String linha;
                System.out.println("*************************************************");
                System.out.println("  NOME \t\t\t ID \t\t PRECO");
                System.out.println("*************************************************");
                //System.out.println("\n");
                while( (linha = reader.readLine()) != null ){
                    array =  linha.split(";");
                    System.out.println(array[1].toUpperCase() + " \t\t|  ID:" +array[0] +"  |Preco: R$ "+ array[2]);
                    //System.out.println("\n");
                }
                System.out.println("\n");
                System.out.println("*************************************************");

            } catch (IOException e) {
                e.printStackTrace();
            }
        return ok;
        }
    }





