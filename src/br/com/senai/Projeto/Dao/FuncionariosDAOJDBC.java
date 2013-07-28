/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.Projeto.Dao;

import br.com.senai.Projeto.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe que implementa a classe FuncionarioDAO
 *
 * @author gustavo_monteiro
 */

public class FuncionariosDAOJDBC implements FuncionarioDAO{
    
    private final String INSERT = "INSERT INTO FUNCIONARIO (NOME, Email, Endereco, Cpf, Sexo, Login, Senha) VALUES(?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE FUNCIONARIO SET NOME = ?, Email = ?, Endereco = ?, Cpf = ?, Sexo = ?, Login = ?, Senha = ?, WHERE ID = ?";
    private final String DELETE = "DELETE FROM FUNCIONARIO WHERE ID=?";
    private final String LIST = "SELECT * FROM FUNCIONARIO";
    private final String LIST_NOME = "SELECT * FROM FUNCIOANRIO WHERE NOME LIKE ?";
    private final String LIST_ID = "SELECT * FROM FUNCIONARIO WHERE ID = ?";

    /**
     * Metodo que faz a inserção dos Funcionarios na base de dados
     *
     * @param Funcionario
     */
    public void inserir(Funcionario funcionario) {


        if (funcionario != null) {
            Connection conn = null;
            try {
                conn = FabricaConexao.getConexao();
                PreparedStatement pstm = null;
                pstm = conn.prepareStatement(INSERT);
                //pega os dados que estão no objeto passado por parametro e coloca na instrução sql de inserção
               pstm.setString(1, funcionario.getNome());
                pstm.setString(2,funcionario.getEmail());
                pstm.setString(3, funcionario.getEndereco());
                pstm.setString(4, funcionario.getCpf());
                pstm.setString(5, funcionario.getSexo());
                pstm.setString(6, funcionario.getLogin());
                pstm.setString(7, funcionario.getSenha());
                
                
                
                //executa o comando sql
                pstm.execute();
                JOptionPane.showMessageDialog(null, "O Funcionario foi cadastrado com sucesso!");
                FabricaConexao.fecharConexao(conn, pstm);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir o Funcionario no banco de dados" + e.getMessage());
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Erro com o driver de conexão " + e.getMessage());
            }
        }
    }

    /**
     * Metodo que atualiza os dados de um Funcionario no banco de dados
     *
     * @param Funcionario
     */
        public void atualizar(Funcionario funcionario) {
        if (funcionario != null) {
            Connection conn = null;
            try {
                conn = FabricaConexao.getConexao();
                PreparedStatement pstm = null;
                pstm = conn.prepareStatement(UPDATE);
                //pega os dados que estão no objeto passado por parametro e coloca na instrução sql de inserção
                pstm.setString(1, funcionario.getNome());
                pstm.setString(2,funcionario.getEmail());
                pstm.setString(3, funcionario.getEndereco());
                pstm.setString(4, funcionario.getCpf());
                pstm.setString(5, funcionario.getSexo());
                pstm.setString(6, funcionario.getLogin());
                pstm.setString(7, funcionario.getSenha());
                pstm.setInt(8, funcionario.getId());
                //executa o comando sql
                pstm.execute();
                JOptionPane.showMessageDialog(null, "O Funcionario foi Atualizado com sucesso!");
                FabricaConexao.fecharConexao(conn, pstm);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar o Funcionario no banco de dados" + e.getMessage());
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Erro com o driver de conexão " + e.getMessage());
            }
        }
    }

    /**
     * Metodo que deleta dados do Funcioanrio no banco de dados
     *
     * @param Funcionario
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
                JOptionPane.showMessageDialog(null, "O Funcionario foi removido com sucesso!");
                FabricaConexao.fecharConexao(conn, pstm);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao remover o Funcionario no banco de dados" + e.getMessage());
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Erro com o driver de conexão " + e.getMessage());
            
        }
    }

    /**
     * Metodo que lista todas os Funcionarios no banco de dados
     *
     * @return ArrayList Pessoa *
     */
    public List<Funcionario> getFuncionarios() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs;
        List<Funcionario> funcionario = new ArrayList<Funcionario>();

        try {
            conn = FabricaConexao.getConexao();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario funcionarios  = new Funcionario();
                funcionarios.setId(rs.getInt("id"));
                funcionarios.setNome(rs.getString("nome"));
                funcionario.add(funcionarios);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao listar produtos" + e.getMessage());
        }
        return funcionario;
    }

    
    public List<Funcionario> getFuncionarioByNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs;
        List<Funcionario> funcionario = new ArrayList<Funcionario>();

        try {
            conn = FabricaConexao.getConexao();
            pstm = conn.prepareStatement(LIST_NOME);
            pstm.setString(1,"%"+nome+"%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario produto = new Funcionario();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.add(funcionario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produto" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao listar produto" + e.getMessage());
        }
        return funcionario;
    }

   
    public Funcionario getFuncionarioById(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs;
        Funcionario funcionario = new Funcionario();

        try {
            conn = FabricaConexao.getConexao();
            pstm = conn.prepareStatement(LIST_ID);
            pstm.setInt(1,id);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                
                
                 funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("E-Mail"));
                funcionario.setEndereco(rs.getString("Endereço"));
                funcionario.setCpf(rs.getString("Cpf"));
                funcionario.setSexo(rs.getString("Sexo"));
                funcionario.setLogin(rs.getString("Login"));
                funcionario.setSenha(rs.getString("Senha"));
              
             
            }
        FabricaConexao.fecharConexao(conn, pstm, rs);
        } catch (SQLException e) {
            System.out.println("Erro ao listar Funcionario" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao listar Funcionario" + e.getMessage());
        }
        return funcionario;
    }

    @Override
    public List<Funcionario> getFuncionario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> getlogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> getSenha() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    

    
}
