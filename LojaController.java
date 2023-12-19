package entities;

import java.util.Scanner;

public class LojaController {
    private Loja loja;
    private Scanner scanner;

    public LojaController(Scanner scanner) {
        this.loja = new Loja();
        this.scanner = scanner;
    }

    public void adicionarMangasAutomaticamente() {
       
    }

    public void exibirMenu() {
        System.out.println("----- Menu -----");
        System.out.println("1. Adicionar Produto");
        System.out.println("2. Exibir Estoque");
        System.out.println("3. Pesquisar Produto");
        System.out.println("4. Remover Produto");
        System.out.println("5. Atualizar Produto");
        System.out.println("6. Comprar Produto");
        System.out.println("0. Encerrar Programa");
    }

    public void processarOpcao(int escolha) {
        switch (escolha) {
            case 1:
                // Adicionar Produto
                int tipoProduto;
                do {
                    System.out.println("Escolha o tipo de produto:");
                    System.out.println("1. Manga");
                    System.out.println("2. Livro");
                    System.out.println("0. Voltar ao menu principal");
                    System.out.print("Escolha uma opção: ");
                    tipoProduto = scanner.nextInt();
                    scanner.nextLine();

                    switch (tipoProduto) {
                        case 1:
                            loja.adicionarProduto(MangaFactory.criarProduto(scanner));
                            break;
                        case 2:
                            loja.adicionarProduto(LivroFactory.criarProduto(scanner));
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                } while (tipoProduto != 0);
                break;
            case 2:
                // Exibir Estoque
                loja.exibirEstoque();
                break;
            case 3:
                // Pesquisar Produto
                System.out.print("Digite o ID do produto a ser pesquisado: ");
                int idPesquisa = scanner.nextInt();
                scanner.nextLine();
                Produto produtoPesquisado = loja.buscarProdutoPorId(idPesquisa);
                if (produtoPesquisado != null) {
                    System.out.println("Produto encontrado:");
                    produtoPesquisado.exibirInfo();
                } else {
                    System.out.println("Produto não encontrado.");
                }
                break;
            case 4:
                // Remover Produto
                System.out.print("Digite o ID do produto a ser removido: ");
                int idRemocao = scanner.nextInt();
                scanner.nextLine();
                loja.removerProduto(idRemocao);
                break;
            case 5:
                // Atualizar Produto
                System.out.print("Digite o ID do produto a ser atualizado: ");
                int idAtualizacao = scanner.nextInt();
                scanner.nextLine();
                Produto produtoAtualizado = null;

                loja.atualizarProduto(idAtualizacao, produtoAtualizado);
                break;
            case 6:
                // Comprar Produto
                System.out.print("Digite o ID do produto a ser comprado: ");
                int idCompra = scanner.nextInt();
                scanner.nextLine();
                loja.comprarProduto(idCompra);
                break;
            case 0:
                System.out.println("Encerrando o programa. Obrigado!");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}