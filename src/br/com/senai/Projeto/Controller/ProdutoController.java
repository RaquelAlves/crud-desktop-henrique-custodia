/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.Projeto.Controller;

import br.com.senai.Projeto.Dao.ProdutoDAO;
import br.com.senai.Projeto.Dao.ProdutosDAOJDBC;
import br.com.senai.Projeto.model.Produtos;
import java.util.List;

/**
 *Classe que faz ligação entre ProdutoDao e a interface grafica
 * @author gustavo_monteiro
 * @version 1.0, 07/05/2013
 */

public class ProdutoController {

    /**
     * Metodo que liga o botão inserir da interface grafica com o método inserir
     * do banco de dados
     *
     * @param produto
     */
    public void inserir(Produtos produtos) {
        ProdutoDAO dao = new ProdutosDAOJDBC();
        dao.inserir(produtos);
    }

    /**
     * Meotodo que liga o botão editar da interface grafica com o método update
     * do banco de dados
     *
     * @param produto
     */
    public void atualizar(Produtos produtos) {
        ProdutoDAO dao = new ProdutosDAOJDBC();
        dao.atualizar(produtos);
    }

    /**
     * Meotodo que liga o botão excluir da interface grafica com o método
     * excluir do banco de dados
     *
     * @param produto
     */
    public void deletar(int id) {
        ProdutoDAO dao = new ProdutosDAOJDBC();
        dao.remover(id);
    }

    /**
     * Método que retorna as Produtoss cadastrados da base de dados para preencher
     * a tabela presente na view
     *
     * @return lista de pessoas
     */
    public List<Produtos> buscarProdutos() {
        ProdutoDAO dao = new ProdutosDAOJDBC();
        return dao.getProdutos();

    }

    public List<Produtos> buscarProdutosByNome(String nome) {
        ProdutoDAO dao = new ProdutosDAOJDBC();
        return dao.getProdutosByNome(nome);
    }

    public Produtos buscarProdutosById(int id) {
        ProdutoDAO dao = new ProdutosDAOJDBC();
        return dao.getProdutosById(id);

    }
}
