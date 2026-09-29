//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner produto = new Scanner(System.in);

        System.out.println("Digite o nome do produto:");
        String nomeDoProduto = produto.nextLine();

        System.out.println("Digite o valaor do Produto:");
        Double precoDoProduto = produto.nextDouble();

        System.out.println("Digite a quantidade em estoque do produto:");
        int estoqueProduto = produto.nextInt();

                System.out.println("\n =====PRODUTO CADASTRADO=====");
                System.out.println("NOME DO PRODUTO: "+ nomeDoProduto);
                System.out.println("VALOR DO PRODUTO: "+ precoDoProduto);
                System.out.println("QUANTIDADE DO PRODUTO EM ESTOQUE: "+ estoqueProduto);

        produto.close();
    }
}