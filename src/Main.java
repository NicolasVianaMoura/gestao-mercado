//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner produto = new Scanner(System.in);
        int opcao = -1;

        do {

            exibirmenu();

            opcao = produto.nextInt();
            produto.nextLine();

            switch (opcao) {
                case 1:

                    cadastro(produto);
                    break;


                case 0:
                    System.out.println("===Saindo do Cadastro.===");
                    break;

                default:
                    System.out.println("=== Invalido!!! Digite 1 ou 0.===");
                    break;
            }

        } while (opcao != 0) ;


        produto.close();

    }

    public static void exibirmenu(){

        System.out.println("\n ===Menu de Cadastro de Produto===");
        System.out.println("1 - Cadastro de Produto");
        System.out.println("0 - Sair");
        System.out.println("Escolha uma das alternativas:");
    }

    public static void cadastro(Scanner produto){

        System.out.println("Digite o nome do produto:");
        String nomeDoProduto = produto.nextLine();

        System.out.println("Digite o valor do Produto:");
        Double precoDoProduto = produto.nextDouble();

        System.out.println("Digite a quantidade em estoque do produto:");
        int estoqueProduto = produto.nextInt();

        System.out.println("\n =====PRODUTO CADASTRADO=====");
        System.out.println("NOME DO PRODUTO: " + nomeDoProduto);
        System.out.println("VALOR DO PRODUTO: " + precoDoProduto);
        System.out.println("QUANTIDADE DO PRODUTO EM ESTOQUE: " + estoqueProduto);

        double valorTotalEstoque = valorDoEstoque(precoDoProduto, estoqueProduto);

        if (estoqueProduto > 5) {
            System.out.println("\n =====Estoque Ok !!!====");
        } else {
            System.out.println("=====Estoque Baixo!!!=====");
        }

        System.out.println("\n VALOR DO ESTOQUE: " + valorTotalEstoque);


    }

    public  static double valorDoEstoque( double preco, int estoque){
        return preco * estoque;

    }

}
