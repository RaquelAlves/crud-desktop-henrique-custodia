/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.Projeto.Dao;

import br.com.senai.Projeto.model.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe que implementa a classe ProdutoDAO
 *
 * @author gustavo_monteiro
 */

public class ProdutosDAOJDBC implements ProdutoDAO{
    
    private final String INSERT = "INSERT INTO PRODUTOS (NOME, preco, descricao) VALUES(?,?,?)";
    private final String UPDATE = "UPDATE PRODUTOS SET NOME = ?, preco = ?, descricao = ?, WHERE ID = ?";
    private final String DELETE = "DELETE FROM PRODUTOS WHERE ID=?";
    private final String LIST = "SELECT * FROM PRODUTOS";
    private final String LIST_NOME = "SELECT * FROM PRODUTOS WHERE NOME LIKE ?";
    private final String LIST_ID = "SELECT * FROM PRODUTOS WHERE ID = ?";

    /**
     * Metodo que faz a inserção das pessoas na base de dados
     *
     * @param produtos
     */
    public void inserir(Produtos produtos) {


        if (produtos != null) {
            Connection conn = null;
            try {
                conn = FabricaConexao.getConexao();
                PreparedStatement pstm = null;
                pstm = conn.prepareStatement(INSERT);
                //pega os dados que estão no objeto passado por parametro e coloca na instrução sql de inserção
                pstm.setString(1, produtos.getNome());
                pstm.setDouble(2,produtos.getPreco());
                pstm.setString(3,produtos.getDescricao());
                
                //executa o comando sql
                pstm.execute();
                JOptionPane.showMessageDialog(null, "O Produto foi cadastrado com sucesso!");
                FabricaConexao.fecharConexao(conn, pstm);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir o produto no banco de dados" + e.getMessage());
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Erro com o driver de conexão " + e.getMessage());
            }
        }
    }

    /**
     * Metodo que atualiza os dados de uma pessoa no banco de dados
     *
     * @param pessoa
     */
        public void atualizar(Produtos produtos) {
        if (produtos != null) {
            Connection conn = null;
            try {
                conn = FabricaConexao.getConexao();
                PreparedStatement pstm = null;
                pstm = conn.prepareStatement(UPDATE);
                //pega os dados que estão no objeto passado por parametro e coloca na instrução sql de inserção
                pstm.setString(1, produtos.getNome());
                pstm.setDouble(2,produtos.getPreco());
                pstm.setString(3,produtos.getDescricao());
                pstm.setInt(4, produtos.getId());
                //executa o comando sql
                pstm.execute();
                JOptionPane.showMessageDialog(null, "O Produto foi Atualizado com sucesso!");
                FabricaConexao.fecharConexao(conn, pstm);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar o produto no banco de dados" + e.getMessage());
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Erro com o driver de conexão " + e.getMessage());
            }
        }
    }

    /**
     * Metodo que deleta dados da pessoa no banco de dados
     *
     * @param pessoa
     */
    
    public void remover(int id) {
        
            Connection conn = null;
            try {
                conn = FabricaConexao.getConexao();
                PreparedStatement pstm = null;
                pstm = conn.prepareStatement(DELETE);
                //pega os dados que estão no objeto passado por parametro e coloca na instrução sql de inserção                
                pstm.setInt(1, id);
                //executa o comando sql
                pstm.execute();
                JOptionPane.showMessageDialog(null, "O Produto foi removido com sucesso!");
                FabricaConexao.fecharConexao(conn, pstm);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao remover o produto no banco de dados" + e.getMessage());
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Erro com o driver de conexão " + e.getMessage());
            
        }
    }

    /**
     * Metodo que lista todas as pessoas no banco de dados
     *
     * @return ArrayList Pessoa *
     */
    public List<Produtos> getProdutos() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs;
        List<Produtos> produtos = new ArrayList<Produtos>();

        try {
            conn = FabricaConexao.getConexao();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Produtos produto = new Produtos();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.add(produtos);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao listar produtos" + e.getMessage());
        }
        return produtos;
    }

    
    public List<Produtos> getProdutosByNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs;
        List<Produtos> produtos = new ArrayList<Produtos>();

        try {
            conn = FabricaConexao.getConexao();
            pstm = conn.prepareStatement(LIST_NOME);
            pstm.setString(1,"%"+nome+"%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Produtos produto = new Produtos();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.add(produtos);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produto" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao listar produto" + e.getMessage());
        }
        return produtos;
    }

   
    public Produtos getProdutosById(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs;
        Produtos produtos = new Produtos();

        try {
            conn = FabricaConexao.getConexao();
            pstm = conn.prepareStatement(LIST_ID);
            pstm.setInt(1,id);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                
                
                produtos.setId(rs.getInt("id"));
                produtos.setNome(rs.getString("nome"));
                produtos.setPreco(rs.getDouble("Preço"));
                produtos.setDescricao(rs.getString("Descrição"));
              
             
            }
        FabricaConexao.fecharConexao(conn, pstm, rs);
        } catch (SQLException e) {
            System.out.println("Erro ao listar produto" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao listar produto" + e.getMessage());
        }
        return produtos;
    }

    

    
}
