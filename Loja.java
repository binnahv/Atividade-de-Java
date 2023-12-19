package entities;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Produto> estoque;

    public Loja() {
        this.estoque = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produto.setId(gerarProximoId());
        estoque.add(produto);
    }

    public void exibirEstoque() {
        System.out.println("----- Estoque Atual -----");
        for (Produto produto : estoque) {
            produto.exibirInfo();
            System.out.println("--------------------------");
        }
    }

    public Produto buscarProdutoPorId(int id) {
        for (Produto produto : estoque) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null; // Retorna null se nenhum produto for encontrado
    }

    public void removerProduto(int id) {
        Produto produto = buscarProdutoPorId(id);
        if (produto != null) {
            estoque.remove(produto);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }

    public void atualizarProduto(int id, Produto produtoAtualizado) {
        for (int i = 0; i < estoque.size(); i++) {
            Produto produto = estoque.get(i);
            if (produto.getId() == id) {
                produtoAtualizado.setId(id); // Manter o mesmo ID
                estoque.set(i, produtoAtualizado);
                System.out.println("Produto atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado no estoque.");
    }

    public void comprarProduto(int id) {
        Produto produto = buscarProdutoPorId(id);
        if (produto != null) {
            estoque.remove(produto);
            System.out.println("Compra realizada com sucesso!");
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }

    public static int gerarProximoId() {
        return proximoId++;
    }

    private static int proximoId = 1;
}
