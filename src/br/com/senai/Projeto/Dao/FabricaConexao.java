/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.Projeto.Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe que abre e fecha a conexão com o banco de dados
 *
 * @version 1.0, 06/05/2013
 * @author gustavo_monteiro
 */
public class FabricaConexao {
    //dados para conexão com o banco

    private static final String DRIVER_CONEXAO = "com.mysql.jdbc.Driver";
    private static final String STR_CONEXAO = "jdbc:mysql://localhost:3306/";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String DATABASE = "Projeto";

    /**
     * Método para fazer conexão com banco de dados
     *
     * @return Connection
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getConexao() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName(DRIVER_CONEXAO);
            //DriverManeger é a classe responsavel por verificar os drivers contidos no projeto
            conn = DriverManager.getConnection(STR_CONEXAO + DATABASE, USUARIO, SENHA);
            //imprime mensagem caso o banco seja conectado com sucesso
            System.out.println("Banco conectado com sucesso");
            //retorna a conexao
            return conn;
            //Driver de conexão MySql não está adicionado ao projeto

        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Driver MySql não foi encontrado" + e.getMessage());
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar com a base de dados " + e.getMessage());

        }


    }

    /**
     * Método que fecha a conexão com o banco de dados
     *
     * @param Connection
     */
    public static void fecharConexao(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Conexão fechada com sucesso");
            }
        } catch (Exception e) {
            System.out.println("Erro ao fechar conexão" + e.getMessage());
        }
    }

    /**
     * Metodo que fecha o statement
     *
     * @param connection
     * @param stmt
     */
    public static void fecharConexao(Connection conn, Statement stmt) {
        try {
            if (conn != null) {
                fecharConexao(conn);
            }
            if (stmt != null) {

                stmt.close();
                System.out.println("Statement fechada com sucesso");
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel fechar o statement: " + e.getMessage());
        }
    }

    
    public static void fecharConexao(Connection conn, Statement stm, ResultSet rs) {
        try {
            if (conn != null) {
                fecharConexao(conn, stm);
            }
            if (rs != null) {
                rs.close();
                System.out.println("Result set fechado com sucesso.");
            }

        } catch (Exception e) {
            System.out.println("Não foi possivel fechar o result set" + e.getMessage());
        }
    }
}

