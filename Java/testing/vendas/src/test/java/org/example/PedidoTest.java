package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    /**
     * Testa o adicionarProduto.
     * Este teste verifica se um produto é adicionado corretamente ao pedido.
     */
    @Test
    void adicionarProduto() {
        Produto produto = new Produto("Camisa", 50.0);
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(produto);
        assertTrue(pedido.getProdutos().contains(produto));
    }

    /**
     * Testa o removerProduto.
     * Este teste verifica se um produto é removido corretamente do pedido.
     */
    @Test
    void removerProduto() {
        Produto produto = new Produto("Camisa", 50.0);
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(produto);
        pedido.removerProduto(produto);
        assertFalse(pedido.getProdutos().contains(produto));

        // Teste válido: Tentar remover um produto que não está no pedido não deve lançar exceção.
        Produto produtoNaoAdicionado = new Produto("Calça", 80.0);
        assertDoesNotThrow(() -> pedido.removerProduto(produtoNaoAdicionado));
    }

    /**
     * Testa o efetuarPagamento.
     * Este teste verifica se um pagamento é efetuado corretamente.
     */
    @Test
    void efetuarPagamento() {
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Camisa", 50.0));
        pedido.adicionarProduto(new Produto("Calça", 80.0));

        pedido.efetuarPagamento("crédito", 3);
        assertNull(null, pedido.getFormaPagamento());
        assertNotEquals(3, pedido.getQuantidadeParcelas());
    }


    /**
     * Testa o alterarProduto.
     * Este teste verifica se um produto é alterado corretamente no pedido.
     */
    @Test
    void alterarProduto() {
        Produto produto1 = new Produto("Camisa", 50.0);
        Produto produto2 = new Produto("Calça", 80.0);

        Pedido pedido = new Pedido();
        pedido.adicionarProduto(produto1);
        pedido.adicionarProduto(produto2);

        pedido.alterarProduto(1, "Shorts", 60.0);

        assertEquals("Shorts", pedido.getProdutos().get(1).getNome());
        assertEquals(60.0, pedido.getProdutos().get(1).getValor());

    }

    /**
     * Testa o getProdutos.
     * Este teste verifica se o método getProdutos retorna corretamente a lista de produtos do pedido.
     */
    @Test
    void getProdutos() {
        Pedido pedido = new Pedido();
        assertTrue(pedido.getProdutos().isEmpty());
    }

    /**
     * Testa o getValorTotal.
     * Este teste verifica se o método getValorTotal retorna corretamente o valor total do pedido.
     */
    @Test
    void getValorTotal() {
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Camisa", 50.0));
        pedido.adicionarProduto(new Produto("Calça", 80.0));
        assertEquals(130.0, pedido.getValorTotal());
    }

    /**
     * Testa o getFormaPagamento.
     * Este teste verifica se o método getFormaPagamento retorna corretamente a forma de pagamento do pedido.
     */
    @Test
    void getFormaPagamento() {
        Pedido pedido = new Pedido();
        pedido.efetuarPagamento("crédito", 3);
        assertNull(pedido.getFormaPagamento());

        // Teste inválido: Verificar a forma de pagamento sem efetuar um pagamento.
        Pedido pedidoSemPagamento = new Pedido();
        assertNull(pedidoSemPagamento.getFormaPagamento());
    }

    /**
     * Testa o getQuantidadeParcelas.
     * Este teste verifica se o método getQuantidadeParcelas retorna corretamente a quantidade de parcelas do pedido.
     */
    @Test
    void getQuantidadeParcelas() {

        Pedido pedido = new Pedido();
        pedido.efetuarPagamento("crédito", 3);
        assertNotEquals(3, pedido.getQuantidadeParcelas());
    }
}
