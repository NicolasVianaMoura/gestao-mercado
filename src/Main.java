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

                    cadastro(produto, listaDeProdutos);
                    break;

                case 2:

                    listarProdutos(listaDeProdutos);
                    break;

                case 3:

                    busca(produto, listaDeProdutos);

                    break;

                case 4:

                    alterar(produto, listaDeProdutos);
                    break;

                case 5:

                    relatorioEstoque(listaDeProdutos);
                    break;

                case 6:

                    excluir(produto, listaDeProdutos);
                    break;

                case 0:
                    System.out.println("===Saindo do Cadastro.===");
                    break;

                default:
                    System.out.println("=== Invalido!!! Digite 1 ou 0.===");
                    break;
            }

        } while (opcao != 0);


        produto.close();

    }

    public static void exibirmenu() {

        System.out.println("\n ===Menu de Cadastro de Produto===");
        System.out.println("1 - Cadastro de Produto");
        System.out.println("2 - Lista de Produto");
        System.out.println("3 - Buscar Produto");
        System.out.println("4 - Alterar Produto");
        System.out.println("5 - Relatorio de estoque baixc");
        System.out.println("6 - Excluir Produto");
        System.out.println("0 - Sair");
        System.out.println("Escolha uma das alternativas:");
    }

    public static void cadastro(Scanner produto, ArrayList<String> listaDeProdutos) {


        String nomeDoProduto = lerNome(produto);

        Double precoDoProduto = lerValor(produto);

        int estoqueProduto = lerestoque(produto);


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
        String status = (estoqueProduto <= 5) ? "ESTOQUE BAIXO" : "ESTOQUE OK";

        String produtoCadastrado = "Nome:" + nomeDoProduto + "| Preco:" + precoDoProduto + "| Quantidade:" + estoqueProduto + "| Status:" +status;

        listaDeProdutos.add(produtoCadastrado);


    }

    public static double valorDoEstoque(double preco, int estoque) {
        return preco * estoque;

    }

    public static void listarProdutos(ArrayList<String> lista) {

        if (lista.isEmpty()) {
            System.out.println("=== Nenhum Produto  cadastrado ainda!!! ===");
        } else {
            System.out.println("\n === Lista de Produtos ===");
            for (String p : lista)
                System.out.println("- " + p);
        }

    }

    public static void busca(Scanner produto, ArrayList<String> lista) {
        if (lista.isEmpty()) {
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
        if (!encontrando) {

            System.out.println("===Produto" + nomeBusca + "nao encontrado!===");

        }
    }

    public static void alterar(Scanner produto, ArrayList<String> lista) {

        if (lista.isEmpty()) {
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

        if (indice >= 0 && indice < lista.size()) {

            String novoNome = lerNome(produto);

            Double valorNovo = lerValor(produto);

            int estoqueNovo = lerestoque(produto);

            String status = (estoqueNovo <= 5) ? "ESTOQUE BAIXO" : "ESTOQUE OK";

            String produtoAtualizado = "Nome:" + novoNome + "|Valor:" + valorNovo + "|Quantidade:" + estoqueNovo;

            lista.set(indice, produtoAtualizado);

            System.out.println("===Produto Atualizado!!!===");
        } else {
            System.out.println("===Indice invalido!!!===");
        }

    }

    public static void excluir(Scanner produto, ArrayList<String> lista) {

        if (lista.isEmpty()) {
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

        if (indice >= 0 && indice < lista.size()) {
            lista.remove(indice);
            System.out.println("===Produto excluido com sucesso!!!===");

        } else {
            System.out.println("===Indice invalido===");
        }

    }

    public static String lerNome(Scanner produto) {
        System.out.println("Digite o nome do produto:");
        String nome = produto.nextLine();

        while (nome.trim().isEmpty()) {
            System.out.println("===Nome Invalido!!! digite novamente===");
            System.out.println("Digite o Nome do Produto Novamente!!!");
            nome = produto.nextLine();
        }
        return nome;
    }

    public static double lerValor(Scanner produto) {
        System.out.println("Digite o Valor do Produto:");
        double valor = produto.nextDouble();

        while (valor <= 0) {
            System.out.println("===Valor Invalido!!! digite novamente===");
            System.out.println("Digite o Valor do Produto Novamente!!!");
            valor = produto.nextDouble();
        }
        return valor;
    }

    public static int lerestoque(Scanner produto) {
        System.out.println("Digite a quantidade em estoque do produto:");
        int estoque = produto.nextInt();

        while (estoque < 0) {
            System.out.println("===Estoque Invalido!!! digite novamente===");
            System.out.println("Digite o Estoque do Produto Novamente!!!");
            estoque = produto.nextInt();
        }
        return estoque;
    }

    public static void relatorioEstoque(ArrayList<String> listaDeProduto) {

        if (listaDeProduto.isEmpty()) {
            System.out.println("===Nenhum Produto Cadastrado!===");
            return;
        }

        System.out.println("\n ====Quantidade de produtos cadastrados:" + listaDeProduto.size() + "!!!===");
        System.out.println("\n ====Lista de Produtos com estoque baixo!!!===");

        boolean estoquebaixo = false;

        for (String p : listaDeProduto) {
            if (p.contains("ESTOQUE BAIXO")) {
                System.out.println(" - " + p);
                estoquebaixo = true;
            }
        }
        if (!estoquebaixo) {
            System.out.println("Nenhum produto com estoque baixo! Todos estão abastecidos.");


        }
    }
}




