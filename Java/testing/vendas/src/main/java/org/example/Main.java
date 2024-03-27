package org.example;

public class Main {
    public static void main (String[]args){
        // Testando o sistema de vendas
        Produto produto1 = new Produto("Camisa", 50.0);
        Produto produto2 = new Produto("Calça", 80.0);

        Pedido pedido = new Pedido();
        pedido.adicionarProduto(produto1);
        pedido.adicionarProduto(produto2);

        System.out.println("Produtos no pedido:");
        for (Produto produto : pedido.getProdutos()) {
            System.out.println(produto.getNome() + " - R$" + produto.getValor());
        }

        System.out.println("Valor total do pedido: R$" + pedido.getValorTotal());

        pedido.efetuarPagamento("crédito", 3);
        // Caso de teste com pagamento inválido (parcelas menores que R$ 20)
        pedido.efetuarPagamento("débito", 1);

        // Testando remoção de produto
        pedido.removerProduto(produto1);
        System.out.println("Produtos no pedido após remoção:");
        for (Produto produto : pedido.getProdutos()) {
            System.out.println(produto.getNome() + " - R$" + produto.getValor());
        }

        // Alterando o segundo produto no pedido
        pedido.alterarProduto(1, "Shorts", 60.0);

        System.out.println("Produtos no pedido após alteração:");
        for (Produto produto : pedido.getProdutos()) {
            System.out.println(produto.getNome() + " - R$" + produto.getValor());
        }

        // Testando caso de pagamento à vista
        Pedido pedido2 = new Pedido();
        pedido2.efetuarPagamento("à vista", 0);
    }
}
