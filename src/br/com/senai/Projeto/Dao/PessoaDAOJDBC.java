/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.Projeto.Dao;



import br.com.senai.Projeto.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


    


   
/**
 * Classe que implementa a classe PessoaDAO
 *
 * @author gustavo_monteiro
 */
public class PessoaDAOJDBC implements PessoaDAO {

    private final String INSERT = "INSERT INTO PESSOA (NOME, Email, Sexo, Cpf, Endereco) VALUES(?,?,?,?,?)";
    private final String UPDATE = "UPDATE PESSOA SET NOME = ?, Email = ?, Sexo = ?, Cpf = ?,Endereco = ? WHERE ID = ?";
    private final String DELETE = "DELETE FROM PESSOA WHERE ID=?";
    private final String LIST = "SELECT * FROM PESSOA";
    private final String LIST_NOME = "SELECT * FROM PESSOA WHERE NOME LIKE ?";
    private final String LIST_ID = "SELECT * FROM PESSOA WHERE ID = ?";

    /**
     * Metodo que faz a inserção das pessoas na base de dados
     *
     * @param pessoa
     */
    public void inserir(Pessoa pessoa) {


        if (pessoa != null) {
            Connection conn = null;
            try {
                conn = FabricaConexao.getConexao();
                PreparedStatement pstm = null;
                pstm = conn.prepareStatement(INSERT);
                //pega os dados que estão no objeto passado por parametro e coloca na instrução sql de inserção
                pstm.setString(1, pessoa.getNome());
                pstm.setString(2,pessoa.getEmail());
                pstm.setString(3, pessoa.getSexo());
               pstm.setString(4, pessoa.getCpf());
                pstm.setString(5, pessoa.getEndereco());
                
                //executa o comando sql
                pstm.execute();
                JOptionPane.showMessageDialog(null, "A pessoa foi cadastrada com sucesso!");
                FabricaConexao.fecharConexao(conn, pstm);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir pessoa no banco de dados" + e.getMessage());
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
    @Override
    public void atualizar(Pessoa pessoa) {
        if (pessoa != null) {
            Connection conn = null;
            try {
                conn = FabricaConexao.getConexao();
                PreparedStatement pstm = null;
                pstm = conn.prepareStatement(UPDATE);
                //pega os dados que estão no objeto passado por parametro e coloca na instrução sql de inserção
                pstm.setString(1, pessoa.getNome());
                pstm.setString(2, pessoa.getSexo());
                pstm.setString(3, pessoa.getEmail());
                pstm.setString(4, pessoa.getCpf());
                pstm.setString(5, pessoa.getEndereco());
                pstm.setInt(6, pessoa.getId());
                //executa o comando sql
                pstm.execute();
                JOptionPane.showMessageDialog(null, "A pessoa foi Atualizada com sucesso!");
                FabricaConexao.fecharConexao(conn, pstm);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar pessoa no banco de dados" + e.getMessage());
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
                JOptionPane.showMessageDialog(null, "A pessoa foi removida com sucesso!");
                FabricaConexao.fecharConexao(conn, pstm);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao remover pessoa no banco de dados" + e.getMessage());
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Erro com o driver de conexão " + e.getMessage());
            
        }
    }

    /**
     * Metodo que lista todas as pessoas no banco de dados
     *
     * @return ArrayList Pessoa *
     */
    public List<Pessoa> getPessoas() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs;
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        try {
            conn = FabricaConexao.getConexao();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pessoas" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao listar pessoas" + e.getMessage());
        }
        return pessoas;
    }

    
    public List<Pessoa> getPessoasByNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs;
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        try {
            conn = FabricaConexao.getConexao();
            pstm = conn.prepareStatement(LIST_NOME);
            pstm.setString(1,"%"+nome+"%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pessoas" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao listar pessoas" + e.getMessage());
        }
        return pessoas;
    }

   
    public Pessoa getPessoasById(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs;
        Pessoa pessoa = new Pessoa();

        try {
            conn = FabricaConexao.getConexao();
            pstm = conn.prepareStatement(LIST_ID);
            pstm.setInt(1,id);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                
                
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setSexo(rs.getString("Sexo"));
                pessoa.setEmail(rs.getString("E-Mail"));
                pessoa.setEndereco(rs.getString("Endereço"));
                pessoa.setCpf(rs.getString("Cpf"));
             
            }
        FabricaConexao.fecharConexao(conn, pstm, rs);
        } catch (SQLException e) {
            System.out.println("Erro ao listar pessoas" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao listar pessoas" + e.getMessage());
        }
        return pessoa;
    }

    @Override    
    public List<Pessoa> getValidaLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    }

   


