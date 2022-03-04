/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package co.mycompany.hotel.cliente.presentacion;

import co.mycompany.hotel.cliente.domain.services.HotelService;

/**
 *
 * @author Jose Ricardo
 */
public class PnlAdmMaster extends javax.swing.JPanel {

    private FrmMain panel;
    private HotelService service;
    private String usuario;

    /**
     * Creates new form PnlAdm
     */
    public PnlAdmMaster(FrmMain panel, String usuario) {
        this.usuario = usuario;
        this.service = new HotelService();
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

        GrupoHab = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlAdmPrincipal = new javax.swing.JPanel();
        tbpMadMenu = new javax.swing.JTabbedPane();
        pnlAdmHabitaciones = new javax.swing.JPanel();
        pnlAdmHabMain = new javax.swing.JPanel();
        bgAdmHabCrear = new javax.swing.JRadioButton();
        bgAdmHabModificar = new javax.swing.JRadioButton();
        bgAdmHabEliminar = new javax.swing.JRadioButton();
        bgAdmHabConsultar = new javax.swing.JRadioButton();
        pnlAdmHabControl = new javax.swing.JPanel();
        pnlAdmSucursales = new javax.swing.JPanel();
        pnlAdmHabControl1 = new javax.swing.JPanel();
        pnlAdmHabMain4 = new javax.swing.JPanel();
        bgAdmHotCrear = new javax.swing.JRadioButton();
        bgAdmHotModificar = new javax.swing.JRadioButton();
        bgAdmHotEliminar = new javax.swing.JRadioButton();
        bgAdmHotCons = new javax.swing.JRadioButton();
        pnlAdmHabitaciones1 = new javax.swing.JPanel();
        pnlAdmHabMain2 = new javax.swing.JPanel();
        bgAdmJunCrear = new javax.swing.JRadioButton();
        bgAdmHabModificar2 = new javax.swing.JRadioButton();
        bgAdmHabEliminar2 = new javax.swing.JRadioButton();
        bgAdmHabConsultar1 = new javax.swing.JRadioButton();
        pnlAdmHabControl2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        pnlAdmPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlAdmPrincipal.setPreferredSize(new java.awt.Dimension(700, 300));

        pnlAdmHabMain.setBorder(javax.swing.BorderFactory.createTitledBorder("Procesos"));

        GrupoHab.add(bgAdmHabCrear);
        bgAdmHabCrear.setText("Crear");
        bgAdmHabCrear.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bgAdmHabCrearStateChanged(evt);
            }
        });

        GrupoHab.add(bgAdmHabModificar);
        bgAdmHabModificar.setText("Modificar");
        bgAdmHabModificar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bgAdmHabModificarStateChanged(evt);
            }
        });

        GrupoHab.add(bgAdmHabEliminar);
        bgAdmHabEliminar.setText("Eliminar");

        GrupoHab.add(bgAdmHabConsultar);
        bgAdmHabConsultar.setText("Consutar");
        bgAdmHabConsultar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bgAdmHabConsultarStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlAdmHabMainLayout = new javax.swing.GroupLayout(pnlAdmHabMain);
        pnlAdmHabMain.setLayout(pnlAdmHabMainLayout);
        pnlAdmHabMainLayout.setHorizontalGroup(
            pnlAdmHabMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdmHabMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAdmHabMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bgAdmHabEliminar)
                    .addComponent(bgAdmHabModificar)
                    .addComponent(bgAdmHabCrear)
                    .addComponent(bgAdmHabConsultar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAdmHabMainLayout.setVerticalGroup(
            pnlAdmHabMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdmHabMainLayout.createSequentialGroup()
                .addComponent(bgAdmHabCrear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bgAdmHabConsultar)
                .addGap(5, 5, 5)
                .addComponent(bgAdmHabModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bgAdmHabEliminar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pnlAdmHabControl.setRequestFocusEnabled(false);
        pnlAdmHabControl.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout pnlAdmHabitacionesLayout = new javax.swing.GroupLayout(pnlAdmHabitaciones);
        pnlAdmHabitaciones.setLayout(pnlAdmHabitacionesLayout);
        pnlAdmHabitacionesLayout.setHorizontalGroup(
            pnlAdmHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdmHabitacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAdmHabMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlAdmHabControl, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlAdmHabitacionesLayout.setVerticalGroup(
            pnlAdmHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAdmHabControl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlAdmHabitacionesLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(pnlAdmHabMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        tbpMadMenu.addTab("Habitaciones", pnlAdmHabitaciones);

        pnlAdmHabControl1.setRequestFocusEnabled(false);
        pnlAdmHabControl1.setLayout(new java.awt.CardLayout());

        pnlAdmHabMain4.setBorder(javax.swing.BorderFactory.createTitledBorder("Procesos"));

        GrupoHab.add(bgAdmHotCrear);
        bgAdmHotCrear.setText("Crear");
        bgAdmHotCrear.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bgAdmHotCrearStateChanged(evt);
            }
        });

        GrupoHab.add(bgAdmHotModificar);
        bgAdmHotModificar.setText("Modificar");
        bgAdmHotModificar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bgAdmHotModificarStateChanged(evt);
            }
        });

        GrupoHab.add(bgAdmHotEliminar);
        bgAdmHotEliminar.setText("Eliminar");

        GrupoHab.add(bgAdmHotCons);
        bgAdmHotCons.setText("Consutar");
        bgAdmHotCons.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bgAdmHotConsStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlAdmHabMain4Layout = new javax.swing.GroupLayout(pnlAdmHabMain4);
        pnlAdmHabMain4.setLayout(pnlAdmHabMain4Layout);
        pnlAdmHabMain4Layout.setHorizontalGroup(
            pnlAdmHabMain4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdmHabMain4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAdmHabMain4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bgAdmHotEliminar)
                    .addComponent(bgAdmHotModificar)
                    .addComponent(bgAdmHotCrear)
                    .addComponent(bgAdmHotCons))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAdmHabMain4Layout.setVerticalGroup(
            pnlAdmHabMain4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdmHabMain4Layout.createSequentialGroup()
                .addComponent(bgAdmHotCrear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bgAdmHotCons)
                .addGap(5, 5, 5)
                .addComponent(bgAdmHotModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bgAdmHotEliminar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlAdmSucursalesLayout = new javax.swing.GroupLayout(pnlAdmSucursales);
        pnlAdmSucursales.setLayout(pnlAdmSucursalesLayout);
        pnlAdmSucursalesLayout.setHorizontalGroup(
            pnlAdmSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdmSucursalesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlAdmHabMain4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlAdmHabControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlAdmSucursalesLayout.setVerticalGroup(
            pnlAdmSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAdmHabControl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
            .addGroup(pnlAdmSucursalesLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(pnlAdmHabMain4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbpMadMenu.addTab("Sucursales", pnlAdmSucursales);

        pnlAdmHabMain2.setBorder(javax.swing.BorderFactory.createTitledBorder("Procesos"));

        GrupoHab.add(bgAdmJunCrear);
        bgAdmJunCrear.setText("Crear");
        bgAdmJunCrear.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bgAdmJunCrearStateChanged(evt);
            }
        });

        GrupoHab.add(bgAdmHabModificar2);
        bgAdmHabModificar2.setText("Modificar");

        GrupoHab.add(bgAdmHabEliminar2);
        bgAdmHabEliminar2.setText("Eliminar");

        GrupoHab.add(bgAdmHabConsultar1);
        bgAdmHabConsultar1.setText("Consutar");
        bgAdmHabConsultar1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bgAdmHabConsultar1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlAdmHabMain2Layout = new javax.swing.GroupLayout(pnlAdmHabMain2);
        pnlAdmHabMain2.setLayout(pnlAdmHabMain2Layout);
        pnlAdmHabMain2Layout.setHorizontalGroup(
            pnlAdmHabMain2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdmHabMain2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAdmHabMain2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bgAdmHabEliminar2)
                    .addComponent(bgAdmHabModificar2)
                    .addComponent(bgAdmJunCrear)
                    .addComponent(bgAdmHabConsultar1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAdmHabMain2Layout.setVerticalGroup(
            pnlAdmHabMain2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdmHabMain2Layout.createSequentialGroup()
                .addComponent(bgAdmJunCrear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bgAdmHabConsultar1)
                .addGap(5, 5, 5)
                .addComponent(bgAdmHabModificar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bgAdmHabEliminar2)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pnlAdmHabControl2.setRequestFocusEnabled(false);
        pnlAdmHabControl2.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout pnlAdmHabitaciones1Layout = new javax.swing.GroupLayout(pnlAdmHabitaciones1);
        pnlAdmHabitaciones1.setLayout(pnlAdmHabitaciones1Layout);
        pnlAdmHabitaciones1Layout.setHorizontalGroup(
            pnlAdmHabitaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdmHabitaciones1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAdmHabMain2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(pnlAdmHabControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlAdmHabitaciones1Layout.setVerticalGroup(
            pnlAdmHabitaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAdmHabControl2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlAdmHabitaciones1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(pnlAdmHabMain2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        tbpMadMenu.addTab("Administradores Junior", pnlAdmHabitaciones1);

        jLabel1.setText("Menu Administracion");

        javax.swing.GroupLayout pnlAdmPrincipalLayout = new javax.swing.GroupLayout(pnlAdmPrincipal);
        pnlAdmPrincipal.setLayout(pnlAdmPrincipalLayout);
        pnlAdmPrincipalLayout.setHorizontalGroup(
            pnlAdmPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdmPrincipalLayout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(jLabel1)
                .addContainerGap(327, Short.MAX_VALUE))
            .addGroup(pnlAdmPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbpMadMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlAdmPrincipalLayout.setVerticalGroup(
            pnlAdmPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAdmPrincipalLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbpMadMenu)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlAdmPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlAdmPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bgAdmHabConsultar1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bgAdmHabConsultar1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_bgAdmHabConsultar1StateChanged

    private void bgAdmJunCrearStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bgAdmJunCrearStateChanged
        // TODO add your handling code here:
        if (bgAdmJunCrear.isSelected()) {
            PnlAdmPersonaAdd panelPersAdd = new PnlAdmPersonaAdd(null,"Junior");
            pnlAdmHabControl2.removeAll();
            pnlAdmHabControl2.add(panelPersAdd);
            pnlAdmHabControl2.repaint();
            pnlAdmHabControl2.revalidate();
        }
    }//GEN-LAST:event_bgAdmJunCrearStateChanged

    private void bgAdmHabConsultarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bgAdmHabConsultarStateChanged
        // TODO add your handling code here:
        if (bgAdmHabConsultar.isSelected()) {
            PnlVistaHabitaciones panelHabVista = new PnlVistaHabitaciones();
            pnlAdmHabControl.removeAll();
            pnlAdmHabControl.add(panelHabVista);
            pnlAdmHabControl.repaint();
            pnlAdmHabControl.revalidate();
        }
    }//GEN-LAST:event_bgAdmHabConsultarStateChanged

    private void bgAdmHabCrearStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bgAdmHabCrearStateChanged
        // TODO add your handling code here:
        if (bgAdmHabCrear.isSelected()) {
            PnlAdmHabAdd panelHabAdd = new PnlAdmHabAdd(usuario);
            pnlAdmHabControl.removeAll();
            pnlAdmHabControl.add(panelHabAdd);
            pnlAdmHabControl.repaint();
            pnlAdmHabControl.revalidate();
        }
    }//GEN-LAST:event_bgAdmHabCrearStateChanged

    private void bgAdmHabModificarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bgAdmHabModificarStateChanged
        // TODO add your handling code here:
        if (bgAdmHabModificar.isSelected()) {
            PnlAdmHabModificar panelHabAdd = new PnlAdmHabModificar(usuario);
            pnlAdmHabControl.removeAll();
            pnlAdmHabControl.add(panelHabAdd);
            pnlAdmHabControl.repaint();
            pnlAdmHabControl.revalidate();
        }
    }//GEN-LAST:event_bgAdmHabModificarStateChanged

    private void bgAdmHotCrearStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bgAdmHotCrearStateChanged
        // TODO add your handling code here:
        if (bgAdmHotCrear.isSelected()) {
            PnlAdmHotelAdd panelHotAdd = new PnlAdmHotelAdd(usuario);
            pnlAdmHabControl1.removeAll();
            pnlAdmHabControl1.add(panelHotAdd);
            pnlAdmHabControl1.repaint();
            pnlAdmHabControl1.revalidate();
        }
    }//GEN-LAST:event_bgAdmHotCrearStateChanged

    private void bgAdmHotModificarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bgAdmHotModificarStateChanged
        // TODO add your handling code here:
        if (bgAdmHotModificar.isSelected()) {
            PnlAdmHotelUpdate panelUpdate = new PnlAdmHotelUpdate(usuario);
            pnlAdmHabControl1.removeAll();
            pnlAdmHabControl1.add(panelUpdate);
            pnlAdmHabControl1.repaint();
            pnlAdmHabControl1.revalidate();
        }
        
    }//GEN-LAST:event_bgAdmHotModificarStateChanged

    private void bgAdmHotConsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bgAdmHotConsStateChanged
        // TODO add your handling code here:
        if (bgAdmHotCons.isSelected()) {
            PnlUsuSucursales panelHot = new PnlUsuSucursales(panel);
            pnlAdmHabControl1.removeAll();
            pnlAdmHabControl1.add(panelHot);
            pnlAdmHabControl1.repaint();
            pnlAdmHabControl1.revalidate();
        }
    }//GEN-LAST:event_bgAdmHotConsStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoHab;
    private javax.swing.JRadioButton bgAdmHabConsultar;
    private javax.swing.JRadioButton bgAdmHabConsultar1;
    private javax.swing.JRadioButton bgAdmHabCrear;
    private javax.swing.JRadioButton bgAdmHabEliminar;
    private javax.swing.JRadioButton bgAdmHabEliminar2;
    private javax.swing.JRadioButton bgAdmHabModificar;
    private javax.swing.JRadioButton bgAdmHabModificar2;
    private javax.swing.JRadioButton bgAdmHotCons;
    private javax.swing.JRadioButton bgAdmHotCrear;
    private javax.swing.JRadioButton bgAdmHotEliminar;
    private javax.swing.JRadioButton bgAdmHotModificar;
    private javax.swing.JRadioButton bgAdmJunCrear;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlAdmHabControl;
    private javax.swing.JPanel pnlAdmHabControl1;
    private javax.swing.JPanel pnlAdmHabControl2;
    private javax.swing.JPanel pnlAdmHabMain;
    private javax.swing.JPanel pnlAdmHabMain2;
    private javax.swing.JPanel pnlAdmHabMain4;
    private javax.swing.JPanel pnlAdmHabitaciones;
    private javax.swing.JPanel pnlAdmHabitaciones1;
    private javax.swing.JPanel pnlAdmPrincipal;
    private javax.swing.JPanel pnlAdmSucursales;
    private javax.swing.JTabbedPane tbpMadMenu;
    // End of variables declaration//GEN-END:variables
}
