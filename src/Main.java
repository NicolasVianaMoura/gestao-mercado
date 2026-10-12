//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner produto = new Scanner(System.in);
        int opcao = -1;
        ArrayList<String> listaDeProdutos = new ArrayList<>();

        do {

            exibirmenu();

            opcao = produto.nextInt();
            produto.nextLine();

            switch (opcao) {
                case 1:

                    cadastro(produto,listaDeProdutos);
                    break;

                case 2:

                    listarProdutos(listaDeProdutos);
                    break;

                case 3:

                    busca(produto, listaDeProdutos);

                    break;

                case 4:

                    alterar(produto,listaDeProdutos);
                    break;

                case 5:

                    excluir(produto, listaDeProdutos);
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
        System.out.println("2 - Lista de Produto");
        System.out.println("3 - Buscar Produto");
        System.out.println("4 - Alterar Produto");
        System.out.println("5 - Excluir Produto");
        System.out.println("0 - Sair");
        System.out.println("Escolha uma das alternativas:");
    }

    public static void cadastro(Scanner produto, ArrayList<String> listaDeProdutos){

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

        String produtoCadastrado = "Nome:" + nomeDoProduto + "| Preco:" + precoDoProduto + "| Quantidade:" + estoqueProduto;

        listaDeProdutos.add(produtoCadastrado);


    }

    public  static double valorDoEstoque( double preco, int estoque){
        return preco * estoque;

    }

    public static void listarProdutos(ArrayList<String> lista){

        if (lista.isEmpty()){
            System.out.println("=== Nenhum Produto  cadastrado ainda!!! ===");
        } else {
            System.out.println("\n === Lista de Produtos ===");
            for (String p : lista)
                System.out.println("- " + p);
        }

    }

    public static void busca(Scanner produto,ArrayList<String> lista){
        if (lista.isEmpty()){
            System.out.println("===Nenhum produto encontrado!===");
            return;
        }
        System.out.println("Digite o Nome do Produto:");
        String nomeBusca = produto.nextLine();

        boolean encontrando = false;

        for (String p : lista) {

            if (p.toLowerCase().contains(nomeBusca.toLowerCase())) {
                System.out.println("Encontrado: " + p);
                encontrando = true;
            }
          }
            if (!encontrando){

                System.out.println("===Produto" + nomeBusca + "nao encontrado!===");

         }
        }

        public static void alterar(Scanner produto, ArrayList<String> lista){

        if (lista.isEmpty()){
                System.out.println("===Nenhum Produto Cadastrado!===");
                return;
            }

            System.out.println("\n ====Escolha o produto da lista que quer alterar===");

            for (int i = 0; i < lista.size(); i++) {
                System.out.println(i + " - " + lista.get(i));
            }

            System.out.println("Digite o indice que dejesa alterar");
            int indice = produto.nextInt();
            produto.nextLine();

            if (indice >= 0 && indice < lista.size()){
                System.out.println("Digite o novo nome do seu produto:");
                String novoNome = produto.nextLine();

                System.out.println("Digite o novo valor do produto:");
                Double valorNovo = produto.nextDouble();

                System.out.println("Digite o nova quantidade do estoque:");
                int estoqueNovo = produto.nextInt();
                produto.nextLine();

            String produtoAtualizado = "Nome:" + novoNome + "|Valor:"+ valorNovo + "|Estoque" + estoqueNovo;

                lista.set(indice, produtoAtualizado);

                System.out.println("===Produto Atualizado!!!===");
            } else {
                System.out.println("===Indice invalido!!!===");
            }

        }

        public static void excluir(Scanner produto,ArrayList<String> lista){

            if (lista.isEmpty()){
                System.out.println("===Nenhum Produto Cadastrado!===");
                return;
            }

            System.out.println("\n ====Escolha o produto da lista que quer excluir===");

            for (int i = 0; i < lista.size(); i++) {
                System.out.println(i + " - " + lista.get(i));
            }

            System.out.println("Digite o indice que dejesa excluir");
            int indice = produto.nextInt();
            produto.nextLine();

            if (indice >= 0 && indice < lista.size()){
                lista.remove(indice);
                System.out.println("===Produto excluido com sucesso!!!===");

            } else {
                System.out.println("===Indice invalido===");
            }

        }

    }


