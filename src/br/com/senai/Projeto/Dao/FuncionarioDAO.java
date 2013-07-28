/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.Projeto.Dao;

import br.com.senai.Projeto.model.Funcionario;
import java.util.List;

/**
 * Interface que contém os métodos para acesso a entidade Funcionario na base de dados
 * @version 1.0 06/05/13
 * @author gustavo_monteiro
 */
public interface FuncionarioDAO {
    
    void inserir(Funcionario funcionarios);
    
    /**
     * Atualiza um funcionario no banco de dados
     * @param funcionario
     */
    void atualizar(Funcionario funcionarios);
    
    /**
     * Remove um funcionario no banco de dados
     * @param funcionarios 
     */
    void remover (int id);
    
    /**
     * Metodo que lista todas os Funcionarios no banco de dados
     * @return ArrayList Funcionario     *
     */
    List<Funcionario> getFuncionario();
    
    List<Funcionario> getFuncionarioByNome(String nome);
    
    List<Funcionario> getlogin();
    
    List<Funcionario> getSenha();
    
    Funcionario getFuncionarioById(int id);
    
}
