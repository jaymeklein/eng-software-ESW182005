package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> produtos;
    private double valorTotal;
    private String formaPagamento;
    private int quantidadeParcelas;

    public Pedido() {
        this.produtos = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
        this.valorTotal += produto.getValor();
    }

    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
        this.valorTotal -= produto.getValor();
    }

    public void efetuarPagamento(String formaPagamento, int quantidadeParcelas) {
        if (this.produtos.isEmpty()) {
            System.out.println("Não é possível efetuar o pagamento sem produtos no pedido.");
            return;
        }
        if (formaPagamento.equalsIgnoreCase("crédito")) {
            if (quantidadeParcelas * 20 < this.valorTotal) {
                System.out.println("A quantidade de parcelas não atende ao critério mínimo de R$ 20,00 por parcela.");
                return;
            }
            this.formaPagamento = formaPagamento;
            this.quantidadeParcelas = quantidadeParcelas;
            System.out.println("Pagamento efetuado no crédito em " + quantidadeParcelas + " parcelas.");
        } else {
            this.formaPagamento = formaPagamento;
            this.quantidadeParcelas = 0;
            System.out.println("Pagamento efetuado à vista.");
        }
    }

    public void alterarProduto(int indice, String novoNome, double novoValor) {
        if (indice < 0 || indice >= produtos.size()) {
            System.out.println("Índice de produto inválido.");
            return;
        }

        Produto produto = produtos.get(indice);
        produto.setNome(novoNome);
        produto.setValor(novoValor);

        // Atualiza o valor total do pedido
        double diferencaValor = novoValor - produto.getValor();
        this.valorTotal += diferencaValor;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }
}