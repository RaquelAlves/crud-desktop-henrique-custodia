/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.Projeto.Dao;

import br.com.senai.Projeto.model.Produtos;
import java.util.List;

/**
 * Interface que contém os métodos para acesso a entidade Produto na base de dados
 * @version 1.0 06/05/13
 * @author gustavo_monteiro
 */
public interface ProdutoDAO {
    
    void inserir(Produtos produtos);
    
    /**
     * Atualiza um Produto no banco de dados
     * @param produtos 
     */
    void atualizar(Produtos produtos);
    
    /**
     * Remove um Produto no banco de dados
     * @param produtos 
     */
    void remover (int id);
    
    /**
     * Metodo que lista todas os Produtos no banco de dados
     * @return ArrayList Produtos     *
     */
    List<Produtos> getProdutos();
    
    List<Produtos> getProdutosByNome(String nome);
    
    Produtos getProdutosById(int id);
    
}
