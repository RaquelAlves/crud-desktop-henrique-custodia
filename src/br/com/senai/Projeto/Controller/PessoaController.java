/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.Projeto.Controller;

import br.com.senai.Projeto.Dao.PessoaDAO;
import br.com.senai.Projeto.Dao.FabricaConexao;
import br.com.senai.Projeto.Dao.PessoaDAOJDBC;
import java.util.List;
import br.com.senai.Projeto.model.Pessoa;
import br.com.senai.Projeto.model.Produtos;

/**
 *Classe que faz ligação entre pessoaDao e a interface grafica
 * @author gustavo_monteiro
 * @version 1.0, 07/05/2013
 */

public class PessoaController {
    /**
     * Metodo que liga o botão inserir da interface grafica com o método inserir  do banco de dados
     * @param pessoa 
     */
    public void inserir(Pessoa pessoa){
        PessoaDAO dao = new PessoaDAOJDBC();
        dao.inserir(pessoa);
    }
    
    /**
     * Meotodo que liga o botão editar da interface grafica com o método update  do banco de dados
     * @param pessoa 
     */
    public void atualizar(Pessoa pessoa){
        PessoaDAO dao = new PessoaDAOJDBC();
        dao.atualizar(pessoa);
    }
    
    /**
     * Meotodo que liga o botão excluir da interface grafica com o método excluir do banco de dados
     * @param pessoa 
     */
    public void deletar(int id){
        PessoaDAO dao = new PessoaDAOJDBC();
        dao.remover(id);
    }
    
    /**
     * Método que retorna as pessoas cadastradas da base de dados para preencher a tabela presente na view
     * @return lista de pessoas
     */
    public List<Pessoa> buscarPessoa(){
        PessoaDAO dao = new PessoaDAOJDBC();
        return dao.getPessoas();
        
        
    }
    
    public List<Pessoa> buscarPessoaByNome(String nome){
        PessoaDAO dao = new PessoaDAOJDBC();
        return dao.getPessoasByNome(nome);
    
    
}
    
       public Pessoa buscarPessoaById(int id){
        PessoaDAO dao = new PessoaDAOJDBC();
        return dao.getPessoasById(id);
    
       }

    public void inserir(Produtos cp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
    

