/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.Projeto.Relatorio;

import br.com.senai.Projeto.Dao.FabricaConexao;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class Relatorio {
    
    public void abreRelatorio(String caminho) throws SQLException, ClassNotFoundException{
        
        Connection con = FabricaConexao.getConexao();
        //Hash Map de parâmetros utilizados no relatório.
        Map parameters = new HashMap();
        
        File file = new File(caminho);
        file = file.getAbsoluteFile();
        String rep = file.getPath();
        try {
           
            JasperFillManager.fillReportToFile(rep, parameters, con);
            JasperPrint jasperPrint = JasperFillManager.fillReport(rep, parameters, con);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);
        } catch (JRException jex) {
           // mostrarErro("JasperException: " + jex.getMessage());
        } catch (Exception ex) {
          //  mostrarErro("" + ex.getStackTrace());
        }
        
    }
    
}

