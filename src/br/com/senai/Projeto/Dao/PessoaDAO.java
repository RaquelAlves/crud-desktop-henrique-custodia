/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.Projeto.Dao;

import java.util.List;
import br.com.senai.Projeto.model.Pessoa;

    
    /**
 * Interface que contém os métodos para acesso a entidade Pessoa na base de dados
 * @version 1.0 06/05/13
 * @author gustavo_monteiro
 */
public interface PessoaDAO {
    
    /**
     * Método que faz a inserção de uma nova pessoa no banco
     * @param pessoa 
     */
    void inserir(Pessoa pessoa);
    
    /**
     * Atualiza uma pessoa no banco de dados
     * @param pessoa 
     */
    void atualizar(Pessoa pessoa);
    
    /**
     * Remove uma pessoa no banco de dados
     * @param pessoa 
     */
    void remover (int id);
    
   
    
    /**
     * Metodo que lista todas as pessoas no banco de dados
     * @return ArrayList Pessoa     *
     */
    List<Pessoa> getPessoas();
    
    List<Pessoa> getPessoasByNome(String nome);
    
    List<Pessoa> getValidaLogin();
 
    Pessoa getPessoasById(int id);
    
    
}
