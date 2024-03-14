package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    /**
     * Testa o getNome.
     */
    @Test
    void getNome() {
        Produto produto = new Produto("Camisa", 50.0);
        assertEquals("Camisa", produto.getNome());
    }

    /**
     * Testa o setNome.
     */
    @Test
    void setNome() {
        Produto produto = new Produto("Camisa", 50.0);
        produto.setNome("Shorts");
        assertEquals("Shorts", produto.getNome());
    }

    /**
     * Testa o getValor.
     */
    @Test
    void getValor() {
        Produto produto = new Produto("Camisa", 50.0);
        assertEquals(50.0, produto.getValor());
    }

    /**
     * Testa o setValor.
     */
    @Test
    void setValor() {
        Produto produto = new Produto("Camisa", 50.0);
        produto.setValor(60.0);
        assertEquals(60.0, produto.getValor());
    }
}