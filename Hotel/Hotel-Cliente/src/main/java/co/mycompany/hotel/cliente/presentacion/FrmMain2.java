/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.mycompany.hotel.cliente.presentacion;

import co.mycompany.hotel.cliente.domain.services.HotelService;

/**
 *
 * @author Jose Ricardo
 */
public class FrmMain2 extends javax.swing.JFrame {
    private HotelService service;
    private javax.swing.JPanel aux;
    private String usuario;
    private String tipo;
    /**
     * Creates new form frmMain
     */
    public FrmMain2() {
        service = new HotelService();
        aux = new javax.swing.JPanel();
        usuario = "";
        initComponents();
        mostrarSucursales();
        
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlControl = new javax.swing.JPanel();
        btnMainSalir = new javax.swing.JButton();
        lbMainLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("App Reservacion Hoteles");

        pnlControl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlControl.setPreferredSize(new java.awt.Dimension(700, 300));
        pnlControl.setLayout(new java.awt.CardLayout());

        btnMainSalir.setText("Salir");
        btnMainSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainSalirActionPerformed(evt);
            }
        });

        lbMainLogin.setText("Login");
        lbMainLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMainLoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlControl, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lbMainLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMainSalir)))
                .addContainerGap())
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMainSalir)
                    .addComponent(lbMainLogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMainSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnMainSalirActionPerformed

    private void lbMainLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMainLoginMouseClicked
        // TODO add your handling code here:
        if ("Login".equals(lbMainLogin.getText())){            
            cargarLogin();
        }
        else{
            lbMainLogin.setText("Login");
            usuario = "";
            mostrarSucursales();
        }
    }//GEN-LAST:event_lbMainLoginMouseClicked

    public void cargarLogin(){
        
        aux.removeAll();
        aux.add(pnlControl.getComponent(0));
        //PnlLogin panelLogin = new PnlLogin(this);        
        pnlControl.removeAll();
        //pnlControl.add(panelLogin);
        pnlControl.repaint();
        pnlControl.revalidate();
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    public String getTipo(){
        return this.usuario;
    }
    
    public void cargarUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public void cargarTipo(String tipo){
        this.tipo = tipo;
    }
    
//    public void cargarRegistrar(String tipo){
//        PnlAdmPersonaAdd panelAdmin = new PnlAdmPersonaAdd(this,tipo);
//        pnlControl.removeAll();
//        pnlControl.add(panelAdmin);
//        pnlControl.repaint();
//        pnlControl.revalidate();
//    }
    
    public void cargarAdmMaster(){
        lbMainLogin.setText("LogOut");
//        PnlAdmMaster panelAdmin = new PnlAdmMaster(this,usuario);
        pnlControl.removeAll();
//        pnlControl.add(panelAdmin);
        pnlControl.repaint();
        pnlControl.revalidate();
    }
    
//    public void cargarAdmJunior(){
//        lbMainLogin.setText("LogOut");
//        PnlAdmJunior panelJunior = new PnlAdmJunior(this,usuario);
//        pnlControl.removeAll();
//        pnlControl.add(panelJunior);
//        pnlControl.repaint();
//        pnlControl.revalidate();
//    }
    public void mostrarSucursales(){
        //PnlUsuHoteles panelSucursales = new PnlUsuHoteles(this);
        pnlControl.removeAll();
//        pnlControl.add(panelSucursales);
        pnlControl.repaint();
        pnlControl.revalidate();
    }
    
    public void cargarCliente(){
        lbMainLogin.setText("LogOut");
        pnlControl.removeAll();
        pnlControl.add(aux.getComponent(0));
        pnlControl.repaint();
        pnlControl.revalidate();
    }
    
    public void cargarReserva(int id_hotel){
//        PnlUsuHabitaciones panelHabitaciones = new PnlUsuHabitaciones(this,id_hotel,usuario);
        pnlControl.removeAll();
//        pnlControl.add(panelHabitaciones);
        pnlControl.repaint();
        pnlControl.revalidate();
    }
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
            java.util.logging.Logger.getLogger(FrmMain2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMainSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbMainLogin;
    private javax.swing.JPanel pnlControl;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
