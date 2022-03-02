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
public class FrmMain extends javax.swing.JFrame {
    private HotelService service;
    /**
     * Creates new form frmMain
     */
    public FrmMain() {
        service = new HotelService();
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
        lbMainAdministrar = new javax.swing.JLabel();

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

        lbMainAdministrar.setText("Login");
        lbMainAdministrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMainAdministrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lbMainAdministrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMainSalir)))
                .addContainerGap())
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbMainAdministrar)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(pnlControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMainSalir)))
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

    private void lbMainAdministrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMainAdministrarMouseClicked
        // TODO add your handling code here:
        cargarLogin();
    }//GEN-LAST:event_lbMainAdministrarMouseClicked

    public void cargarLogin(){
        PnlLogin panelLogin = new PnlLogin(this);
        pnlControl.removeAll();
        pnlControl.add(panelLogin);
        pnlControl.repaint();
        pnlControl.revalidate();
    }
    
    public void cargarAdministrador(){
        PnlAdministrador panelAdmin = new PnlAdministrador(this,service);
        pnlControl.removeAll();
        pnlControl.add(panelAdmin);
        pnlControl.repaint();
        pnlControl.revalidate();
    }
    
    public void mostrarSucursales(){
        PnlUsuSucursales panelSucursales = new PnlUsuSucursales(this,service);
        pnlControl.removeAll();
        pnlControl.add(panelSucursales);
        pnlControl.repaint();
        pnlControl.revalidate();
    }
    
    public void cargarReserva(int id_hotel){
        PnlUsuHabitaciones panelHabitaciones = new PnlUsuHabitaciones(this,service,id_hotel);
        pnlControl.removeAll();
        pnlControl.add(panelHabitaciones);
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
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMainSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbMainAdministrar;
    private javax.swing.JPanel pnlControl;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
