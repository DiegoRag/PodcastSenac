/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.senac.atividade3uc10.view;

import br.com.senac.atividade3uc10.persistencia.Usuario;
import br.com.senac.atividade3uc10.persistencia.UsuarioDAO;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author lizz
 */
public class TelaLog extends javax.swing.JFrame {

    private static Usuario usuarioAutenticado;
    private static boolean isAdmin;
    private static boolean isOperador;
    private static boolean isUsuario;

    /**
     * Creates new form TelaLog
     */
    
    

/** Jframe responsavel pelo login no sistema */

    public TelaLog() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        LogTxtField = new javax.swing.JTextField();
        SenhaTxtField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BotaoLog = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setText("CENAFLIX");

        jLabel2.setText("Login:");

        jLabel3.setText("Senha:");

        BotaoLog.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        BotaoLog.setText("LOGIN");
        BotaoLog.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotaoLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoLogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LogTxtField)
                                .addComponent(SenhaTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(BotaoLog, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SenhaTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(BotaoLog)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoLogActionPerformed
        UsuarioDAO UsuarioDAO = new UsuarioDAO();

        String nome = LogTxtField.getText();
        String senha = SenhaTxtField.getText();

        // Autenticar usuário e obter usuário autenticado
        setUsuarioAutenticado(UsuarioDAO.autenticar(nome, senha));
        if (getUsuarioAutenticado() != null) {
            // Definir o tipo de usuário
            String tipo = getUsuarioAutenticado().getTipo();
            setIsAdmin(tipo.equals("admin"));
            setIsOperador(tipo.equals("operador"));
            setIsUsuario(tipo.equals("usuario"));

            // Exibir mensagem com o cargo do usuário
            JOptionPane.showMessageDialog(this, "Seu cargo é: " + tipo, "Cargo do Usuário", JOptionPane.INFORMATION_MESSAGE);

            // Criar instância da TelaListagem e passar o usuário autenticado
            TelaListagem telaListagem = new TelaListagem();
            telaListagem.setUsuarioAutenticado(getUsuarioAutenticado());

            // Exibir a TelaListagem
            telaListagem.setVisible(true);

            // Fechar a TelaLogin
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_BotaoLogActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoLog;
    private javax.swing.JTextField LogTxtField;
    private javax.swing.JTextField SenhaTxtField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    public static Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public static void setUsuarioAutenticado(Usuario aUsuarioAutenticado) {
        usuarioAutenticado = aUsuarioAutenticado;
    }

    public static boolean isIsAdmin() {
        return isAdmin;
    }

   

    public static void setIsAdmin(boolean aIsAdmin) {
        isAdmin = aIsAdmin;
    }

    public static boolean isIsOperador() {
        return isOperador;
    }

    public static void setIsOperador(boolean aIsOperador) {
        isOperador = aIsOperador;
    }

    public static boolean isIsUsuario() {
        return isUsuario;
    }

    public static void setIsUsuario(boolean aIsUsuario) {
        isUsuario = aIsUsuario;
    }

}