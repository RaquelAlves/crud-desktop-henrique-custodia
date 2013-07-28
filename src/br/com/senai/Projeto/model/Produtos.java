/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.Projeto.model;

import java.util.List;

/**
 * Classe responsavel por modelar os objetos do tipo Produtos
 * @version 1.0, 06/05/13
 * @author gustavo_monteiro
 */

public class Produtos {
    private String nome;
    private double preco;
    private String descricao;
    private String CaixaSelecao;
    private int id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaixaSelecao() {
        return CaixaSelecao;
    }

    public void setCaixaSelecao(String CaixaSelecao) {
        this.CaixaSelecao = CaixaSelecao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void add(List<Produtos> produtos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
