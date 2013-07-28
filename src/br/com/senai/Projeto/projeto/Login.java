/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.Projeto.projeto;

/**
 *
 * @author Gustavo
 */
public class Login extends javax.swing.JFrame {
    Projeto pro = new Projeto();

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setVisible(true);
        SenhaErro.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelFundo = new javax.swing.JPanel();
        LabelLogin = new javax.swing.JLabel();
        lLogin = new javax.swing.JLabel();
        LabelSenha = new javax.swing.JLabel();
        LembrarLogin = new javax.swing.JLabel();
        EntrarAuto = new javax.swing.JLabel();
        CampoLogin = new javax.swing.JTextField();
        CampoSenha = new javax.swing.JPasswordField();
        BotaoEntrar = new javax.swing.JButton();
        Lembrar = new javax.swing.JCheckBox();
        Auto = new javax.swing.JCheckBox();
        SenhaErro = new javax.swing.JLabel();
        Cadastro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 255));

        PainelFundo.setBackground(new java.awt.Color(51, 255, 255));

        LabelLogin.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        LabelLogin.setText("Pagina Login");

        lLogin.setText("Login :");

        LabelSenha.setText("Senha :");

        LembrarLogin.setText("Lembrar Login");

        EntrarAuto.setText("Entrar Automaticamente");

        CampoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoLoginActionPerformed(evt);
            }
        });

        BotaoEntrar.setText("Entrar");
        BotaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEntrarActionPerformed(evt);
            }
        });

        Lembrar.setBackground(new java.awt.Color(51, 255, 255));

        Auto.setBackground(new java.awt.Color(51, 255, 255));

        SenhaErro.setText("Login ou Senha Incorretos!");

        Cadastro.setText("Cadastre-se Aqui");
        Cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelFundoLayout = new javax.swing.GroupLayout(PainelFundo);
        PainelFundo.setLayout(PainelFundoLayout);
        PainelFundoLayout.setHorizontalGroup(
            PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelFundoLayout.createSequentialGroup()
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelFundoLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(LabelLogin))
                    .addGroup(PainelFundoLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(BotaoEntrar))
                    .addGroup(PainelFundoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PainelFundoLayout.createSequentialGroup()
                                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LabelSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PainelFundoLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(EntrarAuto)
                                            .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(CampoLogin)
                                                .addComponent(CampoSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))))
                                    .addGroup(PainelFundoLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(SenhaErro, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(PainelFundoLayout.createSequentialGroup()
                                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PainelFundoLayout.createSequentialGroup()
                                        .addComponent(Lembrar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LembrarLogin))
                                    .addComponent(Auto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        PainelFundoLayout.setVerticalGroup(
            PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelFundoLayout.createSequentialGroup()
                .addComponent(LabelLogin)
                .addGap(52, 52, 52)
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lLogin)
                    .addComponent(CampoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelSenha)
                    .addComponent(CampoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SenhaErro, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LembrarLogin)
                    .addComponent(Lembrar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EntrarAuto)
                    .addComponent(Auto, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(BotaoEntrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(Cadastro)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CampoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoLoginActionPerformed

    private void BotaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEntrarActionPerformed
        if(CampoLogin.getText().equals("admin") && new String(CampoSenha.getPassword()).equals("proinfocrici")){
            pro.setVisible(true);
            this.dispose();
        }else{
            SenhaErro.setVisible(true);
        }
        
        
    }//GEN-LAST:event_BotaoEntrarActionPerformed

    private void CadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroActionPerformed
       NovoFuncionario nf = new NovoFuncionario();
    }//GEN-LAST:event_CadastroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Auto;
    private javax.swing.JButton BotaoEntrar;
    private javax.swing.JButton Cadastro;
    private javax.swing.JTextField CampoLogin;
    private javax.swing.JPasswordField CampoSenha;
    private javax.swing.JLabel EntrarAuto;
    private javax.swing.JLabel LabelLogin;
    private javax.swing.JLabel LabelSenha;
    private javax.swing.JCheckBox Lembrar;
    private javax.swing.JLabel LembrarLogin;
    private javax.swing.JPanel PainelFundo;
    private javax.swing.JLabel SenhaErro;
    private javax.swing.JLabel lLogin;
    // End of variables declaration//GEN-END:variables
}
