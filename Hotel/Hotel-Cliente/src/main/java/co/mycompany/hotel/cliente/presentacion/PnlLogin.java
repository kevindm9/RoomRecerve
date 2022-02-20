/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package co.mycompany.hotel.cliente.presentacion;

import co.mycompany.hotel.cliente.domain.services.UserService;

/**
 *
 * @author Jose Ricardo
 */
public class PnlLogin extends javax.swing.JPanel {

    private FrmMain panel;

    /**
     * Creates new form PnlLogin
     */
    public PnlLogin(FrmMain panel) {
        this.panel = panel;
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

        pnlLogLogin = new javax.swing.JPanel();
        lbLogTitulo = new javax.swing.JLabel();
        lbLogUsuario = new javax.swing.JLabel();
        lbLogPassword = new javax.swing.JLabel();
        txtLogUsuario = new javax.swing.JTextField();
        btnLogIniciar = new javax.swing.JButton();
        pwdLogPassword = new javax.swing.JPasswordField();

        pnlLogLogin.setPreferredSize(new java.awt.Dimension(700, 300));

        lbLogTitulo.setText("Iniciar Seccion");

        lbLogUsuario.setText("Usuario");

        lbLogPassword.setText("Password");

        btnLogIniciar.setText("Iniciar");
        btnLogIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLogLoginLayout = new javax.swing.GroupLayout(pnlLogLogin);
        pnlLogLogin.setLayout(pnlLogLoginLayout);
        pnlLogLoginLayout.setHorizontalGroup(
            pnlLogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogLoginLayout.createSequentialGroup()
                .addGroup(pnlLogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLogLoginLayout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addGroup(pnlLogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLogUsuario)
                            .addComponent(lbLogPassword))
                        .addGap(36, 36, 36)
                        .addGroup(pnlLogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLogUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(pwdLogPassword)))
                    .addGroup(pnlLogLoginLayout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addGroup(pnlLogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogIniciar)
                            .addComponent(lbLogTitulo))))
                .addContainerGap(224, Short.MAX_VALUE))
        );
        pnlLogLoginLayout.setVerticalGroup(
            pnlLogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogLoginLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lbLogTitulo)
                .addGap(18, 18, 18)
                .addGroup(pnlLogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLogUsuario)
                    .addComponent(txtLogUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLogPassword)
                    .addComponent(pwdLogPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLogIniciar)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlLogLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlLogLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogIniciarActionPerformed
        // TODO add your handling code here:
        try {
            String usuario = txtLogUsuario.getText();
            String password = pwdLogPassword.getText();
            if (UserService.autenticacion(usuario, password)) {
                System.out.println("Logeado");
                panel.cargarAdministrador();
            }
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos");
        }
    }//GEN-LAST:event_btnLogIniciarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogIniciar;
    private javax.swing.JLabel lbLogPassword;
    private javax.swing.JLabel lbLogTitulo;
    private javax.swing.JLabel lbLogUsuario;
    private javax.swing.JPanel pnlLogLogin;
    private javax.swing.JPasswordField pwdLogPassword;
    private javax.swing.JTextField txtLogUsuario;
    // End of variables declaration//GEN-END:variables
}
