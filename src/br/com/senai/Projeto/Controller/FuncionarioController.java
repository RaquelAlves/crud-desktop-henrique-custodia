/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.Projeto.Controller;

import br.com.senai.Projeto.Dao.FuncionarioDAO;
import br.com.senai.Projeto.Dao.FuncionariosDAOJDBC;
import br.com.senai.Projeto.model.Funcionario;
import java.util.List;

/**
 *Classe que faz ligação entre FuncionarioDao e a interface grafica
 * @author gustavo_monteiro
 * @version 1.0, 07/05/2013
 */

public class FuncionarioController {

    /**
     * Metodo que liga o botão inserir da interface grafica com o método inserir
     * do banco de dados
     *
     * @param Funcionario
     */
    public void inserir(Funcionario funcionarios) {
        FuncionarioDAO dao = new FuncionariosDAOJDBC();
        dao.inserir(funcionarios);
    }

    /**
     * Meotodo que liga o botão editar da interface grafica com o método update
     * do banco de dados
     *
     * @param Funcionario
     */
    public void atualizar(Funcionario funcionario) {
        FuncionarioDAO dao = new FuncionariosDAOJDBC();
        dao.atualizar(funcionario);
    }

    /**
     * Meotodo que liga o botão excluir da interface grafica com o método
     * excluir do banco de dados
     *
     * @param Funcionario
     */
    public void deletar(int id) {
        FuncionarioDAO dao = new FuncionariosDAOJDBC();
        dao.remover(id);
    }

    /**
     * Método que retorna os Funcionarios cadastrados da base de dados para preencher
     * a tabela presente na view
     *
     * @return lista de Funcionario
     */
    public List<Funcionario> buscarFuncionario() {
        FuncionarioDAO dao = new FuncionariosDAOJDBC();
        return dao.getFuncionario();

    }

    public List<Funcionario> buscarFuncionarioByNome(String nome) {
        FuncionarioDAO dao = new FuncionariosDAOJDBC();
        return dao.getFuncionarioByNome(nome);
    }

    public Funcionario buscarFuncioanrioById(int id) {
        FuncionarioDAO dao = new FuncionariosDAOJDBC();
        return dao.getFuncionarioById(id);

    }
}
