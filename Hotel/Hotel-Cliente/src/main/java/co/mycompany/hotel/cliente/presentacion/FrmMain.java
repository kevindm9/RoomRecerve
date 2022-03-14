/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.mycompany.hotel.cliente.presentacion;

import co.mycompany.hotel.cliente.domain.services.HotelService;
import co.mycompany.hotel.commons.domain.Hotel;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Ricardo, Yaquelin Gomez, Kevin Morales
 */
public class FrmMain extends javax.swing.JFrame {

    ArrayList<Hotel> hoteles;
    private final HotelService service;
    private javax.swing.JPanel aux;
    private String usuario;
    private String tipo;

    public FrmMain() {
        initComponents();
        service = new HotelService();
        aux = new javax.swing.JPanel();
        tipo = "Visitante";
        ocultarMenu();
        iniciar();
    }

    private void iniciar() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.IfmMainControl.getUI()).setNorthPane(null);
        //TipoHabitacion tipos[] = TipoHabitacion.values();
        hoteles = service.getHotels("All_Hotels");
        cbxMainHoteles.removeAllItems();
        cbxMainHoteles.addItem("Reserva en tu hotel favorito");
        if (hoteles != null) {
            for (int i = 0; i < hoteles.size(); i++) {
                cbxMainHoteles.addItem(hoteles.get(i).getNombre());
            }
        }
        mostrarHoteles();
    }

    private void ocultarMenu() {
        jmbMainControl.setVisible(false);
        jmmMainSeccion.setVisible(false);
        jmmMainAdministradores.setVisible(false);
        jmmMainHabitaciones.setVisible(false);
        jmmMainHoteles.setVisible(false);
        jmmMainReservas.setVisible(false);

    }

    public void mostrarHoteles() {

        PnlUsuHoteles panelHoteles = new PnlUsuHoteles(this, usuario);
        pnlMainControl.removeAll();
        pnlMainControl.add(panelHoteles);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();
    }

    public void cargarReserva(int id_hotel, Date fechaIni, Date fechaFin) {
        PnlUsuHabitaciones panelHabitaciones = new PnlUsuHabitaciones(this, id_hotel, usuario, fechaIni, fechaFin);
        for(int i = 0 ; i< hoteles.size();i++){
            if(id_hotel == hoteles.get(i).getId()){
                cbxMainHoteles.setSelectedIndex(i+1);
                break;
            }
        }

        pnlMainControl.removeAll();
        pnlMainControl.add(panelHabitaciones);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();
    }

    public void cargarLogin() {
        aux.removeAll();
        aux.add(pnlMainControl.getComponent(0));
        PnlLogin panelLogin = new PnlLogin(this);
        pnlMainControl.removeAll();
        pnlMainControl.add(panelLogin);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();

    }

    public String getUsuario() {
        return this.usuario;
    }

    public void cargarUsuario(String usuario) {
        jmbMainControl.setVisible(true);
        this.usuario = usuario;
        lbMainUsuario.setText(usuario);
        lbMainLogin.setText("LogOut");
    }

    public void cargarAdmMaster() {
        jmmMainSeccion.setVisible(true);
        jmmMainAdministradores.setVisible(true);
        jmmMainHabitaciones.setVisible(true);
        jmmMainHoteles.setVisible(true);
        mostrarHoteles();
    }

    public void cargarAdmJunior() {
        jmmMainSeccion.setVisible(true);
        jmmMainHabitaciones.setVisible(true);
        jmmMainReservas.setVisible(false);
        mostrarHoteles();
    }

    public void cargarCliente() {
        pnlMainControl.removeAll();
        pnlMainControl.add(aux.getComponent(0));
        pnlMainControl.repaint();
        pnlMainControl.revalidate();
    }

    public void cargarRegistrar(String tipo) {
        PnlPerRegistrar panelAdmin = new PnlPerRegistrar(this, tipo);
        pnlMainControl.removeAll();
        pnlMainControl.add(panelAdmin);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEstado = new javax.swing.JPanel();
        lbMainLogin = new javax.swing.JLabel();
        lbMainUsuario = new javax.swing.JLabel();
        IfmMainControl = new javax.swing.JInternalFrame();
        pnlMainControl = new javax.swing.JPanel();
        jmbMainControl = new javax.swing.JMenuBar();
        jmmMainSeccion = new javax.swing.JMenu();
        jmiMainSecInicio = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiMainSecPerfil = new javax.swing.JMenuItem();
        jmiMainSecModificar = new javax.swing.JMenuItem();
        jmiMainSecPassword = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmiMainSecCerrar = new javax.swing.JMenuItem();
        jmiMainSecSalir = new javax.swing.JMenuItem();
        jmmMainHoteles = new javax.swing.JMenu();
        jmiMainHotCrear = new javax.swing.JMenuItem();
        jmiMainHotModificar = new javax.swing.JMenuItem();
        jmiMainHotEliminar = new javax.swing.JMenuItem();
        jmmMainHabitaciones = new javax.swing.JMenu();
        jmiMainHabCrear = new javax.swing.JMenuItem();
        jmiMainHabConsultar = new javax.swing.JMenuItem();
        jmiMainHabModificar = new javax.swing.JMenuItem();
        jmiMainHabEliminar = new javax.swing.JMenuItem();
        jmmMainAdministradores = new javax.swing.JMenu();
        jmmMainAdmCrear = new javax.swing.JMenuItem();
        jmmMainReservas = new javax.swing.JMenu();
        pnlMainBusqueda = new javax.swing.JPanel();
        btnMainBuscar = new javax.swing.JButton();
        cbxMainHoteles = new javax.swing.JComboBox<>();
        jdcMainFechaFin = new com.toedter.calendar.JDateChooser();
        jdcMainFechaIni = new com.toedter.calendar.JDateChooser();
        lbMainFechaIni = new javax.swing.JLabel();
        lbMainFechaFin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Room Reserve Service");
        setMaximumSize(new java.awt.Dimension(2000, 2147483647));
        setPreferredSize(new java.awt.Dimension(752, 580));

        pnlEstado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbMainLogin.setText("Login");
        lbMainLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMainLoginMouseClicked(evt);
            }
        });
        pnlEstado.add(lbMainLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 47, -1));

        lbMainUsuario.setText("Crea tu cuenta");
        lbMainUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMainUsuarioMouseClicked(evt);
            }
        });
        pnlEstado.add(lbMainUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, -1));

        IfmMainControl.setBorder(null);
        IfmMainControl.setForeground(new java.awt.Color(255, 255, 255));
        IfmMainControl.setEnabled(false);
        IfmMainControl.setFocusCycleRoot(false);
        IfmMainControl.setFocusable(false);
        IfmMainControl.setRequestFocusEnabled(false);
        IfmMainControl.setVerifyInputWhenFocusTarget(false);
        IfmMainControl.setVisible(true);

        pnlMainControl.setPreferredSize(new java.awt.Dimension(740, 400));
        pnlMainControl.setLayout(new java.awt.CardLayout());

        jmbMainControl.setToolTipText("Administrar");
        jmbMainControl.setOpaque(false);

        jmmMainSeccion.setText("Seccion");

        jmiMainSecInicio.setText("Inicio");
        jmiMainSecInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainSecInicioActionPerformed(evt);
            }
        });
        jmmMainSeccion.add(jmiMainSecInicio);
        jmmMainSeccion.add(jSeparator1);

        jmiMainSecPerfil.setText("Ver perfil");
        jmiMainSecPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainSecPerfilActionPerformed(evt);
            }
        });
        jmmMainSeccion.add(jmiMainSecPerfil);

        jmiMainSecModificar.setText("Modificar Perfil");
        jmiMainSecModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainSecModificarActionPerformed(evt);
            }
        });
        jmmMainSeccion.add(jmiMainSecModificar);

        jmiMainSecPassword.setText("Modificar Contraseña");
        jmmMainSeccion.add(jmiMainSecPassword);
        jmmMainSeccion.add(jSeparator2);

        jmiMainSecCerrar.setText("Cerrar Seccion");
        jmiMainSecCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainSecCerrarActionPerformed(evt);
            }
        });
        jmmMainSeccion.add(jmiMainSecCerrar);

        jmiMainSecSalir.setText("Salir");
        jmiMainSecSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainSecSalirActionPerformed(evt);
            }
        });
        jmmMainSeccion.add(jmiMainSecSalir);

        jmbMainControl.add(jmmMainSeccion);

        jmmMainHoteles.setText("Hoteles");

        jmiMainHotCrear.setText("Crear Hotel");
        jmiMainHotCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainHotCrearActionPerformed(evt);
            }
        });
        jmmMainHoteles.add(jmiMainHotCrear);

        jmiMainHotModificar.setText("Modificar Hotel");
        jmiMainHotModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainHotModificarActionPerformed(evt);
            }
        });
        jmmMainHoteles.add(jmiMainHotModificar);

        jmiMainHotEliminar.setText("Eliminar Hotel");
        jmiMainHotEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainHotEliminarActionPerformed(evt);
            }
        });
        jmmMainHoteles.add(jmiMainHotEliminar);

        jmbMainControl.add(jmmMainHoteles);

        jmmMainHabitaciones.setText("Habitaciones");

        jmiMainHabCrear.setText("Crear habitación");
        jmiMainHabCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainHabCrearActionPerformed(evt);
            }
        });
        jmmMainHabitaciones.add(jmiMainHabCrear);

        jmiMainHabConsultar.setText("Consultar habitaciones");
        jmiMainHabConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainHabConsultarActionPerformed(evt);
            }
        });
        jmmMainHabitaciones.add(jmiMainHabConsultar);

        jmiMainHabModificar.setText("Modificar habitación");
        jmiMainHabModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainHabModificarActionPerformed(evt);
            }
        });
        jmmMainHabitaciones.add(jmiMainHabModificar);

        jmiMainHabEliminar.setText("Eliminar habitación");
        jmiMainHabEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainHabEliminarActionPerformed(evt);
            }
        });
        jmmMainHabitaciones.add(jmiMainHabEliminar);

        jmbMainControl.add(jmmMainHabitaciones);

        jmmMainAdministradores.setText("Administradores");
        jmmMainAdministradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmmMainAdministradoresActionPerformed(evt);
            }
        });

        jmmMainAdmCrear.setText("Registrar Administrador Junior");
        jmmMainAdmCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmmMainAdmCrearActionPerformed(evt);
            }
        });
        jmmMainAdministradores.add(jmmMainAdmCrear);

        jmbMainControl.add(jmmMainAdministradores);

        jmmMainReservas.setText("Reservas");
        jmbMainControl.add(jmmMainReservas);

        IfmMainControl.setJMenuBar(jmbMainControl);

        javax.swing.GroupLayout IfmMainControlLayout = new javax.swing.GroupLayout(IfmMainControl.getContentPane());
        IfmMainControl.getContentPane().setLayout(IfmMainControlLayout);
        IfmMainControlLayout.setHorizontalGroup(
            IfmMainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        IfmMainControlLayout.setVerticalGroup(
            IfmMainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainControl, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );

        pnlMainBusqueda.setPreferredSize(new java.awt.Dimension(740, 37));
        pnlMainBusqueda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMainBuscar.setText("Buscar");
        btnMainBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainBuscarActionPerformed(evt);
            }
        });
        pnlMainBusqueda.add(btnMainBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 100, -1));

        cbxMainHoteles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlMainBusqueda.add(cbxMainHoteles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 220, -1));
        pnlMainBusqueda.add(jdcMainFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 120, -1));
        pnlMainBusqueda.add(jdcMainFechaIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 120, -1));

        lbMainFechaIni.setText("Desde");
        pnlMainBusqueda.add(lbMainFechaIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        lbMainFechaFin.setText("Hasta");
        pnlMainBusqueda.add(lbMainFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IfmMainControl, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(pnlMainBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(pnlMainBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(IfmMainControl))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbMainLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMainLoginMouseClicked
        // TODO add your handling code here:
        seccion();
    }//GEN-LAST:event_lbMainLoginMouseClicked

    private void seccion() {
        if ("Login".equals(lbMainLogin.getText())) {
            cargarLogin();
        } else {
            lbMainLogin.setText("Login");
            usuario = "";
            tipo = "Visitante";
            lbMainUsuario.setText("Crea tu cuenta");
            ocultarMenu();
            mostrarHoteles();
        }
    }

    private void jmiMainHabCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainHabCrearActionPerformed
        // TODO add your handling code here:

        PnlHabAdd panelHabAdd = new PnlHabAdd(usuario);
        pnlMainControl.removeAll();
        pnlMainControl.add(panelHabAdd);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();
    }//GEN-LAST:event_jmiMainHabCrearActionPerformed

    private void jmiMainHabModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainHabModificarActionPerformed
        // TODO add your handling code here:
        PnlHabModificar panelHabAdd = new PnlHabModificar(usuario);
        pnlMainControl.removeAll();
        pnlMainControl.add(panelHabAdd);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();

    }//GEN-LAST:event_jmiMainHabModificarActionPerformed

    private void jmiMainHabEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainHabEliminarActionPerformed
        PnlHabEliminar panelHabDel = new PnlHabEliminar(usuario);
        pnlMainControl.removeAll();
        pnlMainControl.add(panelHabDel);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();
    }//GEN-LAST:event_jmiMainHabEliminarActionPerformed

    private void jmiMainHabConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainHabConsultarActionPerformed
        // TODO add your handling code here:
        consultarHabitaciones();
    }//GEN-LAST:event_jmiMainHabConsultarActionPerformed

    private void jmiMainSecSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainSecSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jmiMainSecSalirActionPerformed

    private void jmiMainSecCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainSecCerrarActionPerformed
        // TODO add your handling code here:
        seccion();
    }//GEN-LAST:event_jmiMainSecCerrarActionPerformed

    private void jmiMainSecInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainSecInicioActionPerformed
        // TODO add your handling code here:
        mostrarHoteles();
    }//GEN-LAST:event_jmiMainSecInicioActionPerformed

    private void jmiMainHotCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainHotCrearActionPerformed
        // TODO add your handling code here:
        PnlHotelAdd panelHotAdd = new PnlHotelAdd(usuario);
        pnlMainControl.removeAll();
        pnlMainControl.add(panelHotAdd);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();
    }//GEN-LAST:event_jmiMainHotCrearActionPerformed

    private void lbMainUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMainUsuarioMouseClicked
        // TODO add your handling code here:
        cargarRegistrar("Cliente");
    }//GEN-LAST:event_lbMainUsuarioMouseClicked

    private void jmmMainAdministradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmmMainAdministradoresActionPerformed
        // TODO add your handling code here:
        PnlPerRegistrar panelRegistrar = new PnlPerRegistrar(this, "Junior");
        pnlMainControl.removeAll();
        pnlMainControl.add(panelRegistrar);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();

    }//GEN-LAST:event_jmmMainAdministradoresActionPerformed

    private void jmiMainHotModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainHotModificarActionPerformed
        // TODO add your handling code here:
        PnlHotelUpdate panelUpdate = new PnlHotelUpdate(usuario);
        pnlMainControl.removeAll();
        pnlMainControl.add(panelUpdate);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();
    }//GEN-LAST:event_jmiMainHotModificarActionPerformed

    private void jmmMainAdmCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmmMainAdmCrearActionPerformed
        // TODO add your handling code here:
        cargarRegistrar("junior");
    }//GEN-LAST:event_jmmMainAdmCrearActionPerformed

    private void btnMainBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainBuscarActionPerformed
        // TODO add your handling code here:
        try{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = simpleDateFormat.format(jdcMainFechaIni.getDate());
        //dccUsuHabInicio.getDateFormatString()
        Date fechaIni = Date.valueOf(formattedDate);
        formattedDate = simpleDateFormat.format(jdcMainFechaFin.getDate());
        Date fechaFin = Date.valueOf(formattedDate);

        if (fechaFin.before(fechaIni)) {
            JOptionPane.showMessageDialog(null,
                    "Periodo de tiempo no valido", "Datos invalidos",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        System.out.println(hoteles.get(cbxMainHoteles.getSelectedIndex()-1).getNombre());
        cargarReserva(hoteles.get(cbxMainHoteles.getSelectedIndex()-1).getId(),fechaIni,fechaFin);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Seleccione primero un hotel, fecha de inicio y fecha de fin","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnMainBuscarActionPerformed

    private void jmiMainHotEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainHotEliminarActionPerformed
        // TODO add your handling code here:
        PnlHotelDelete panelHotelEliminar = new PnlHotelDelete(usuario);
        pnlMainControl.removeAll();
        pnlMainControl.add(panelHotelEliminar);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();
    }//GEN-LAST:event_jmiMainHotEliminarActionPerformed

    private void jmiMainSecPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainSecPerfilActionPerformed
        // TODO add your handling code here:
        PnlPerPerfil panelPerPerfil = new PnlPerPerfil(usuario);
        pnlMainControl.removeAll();
        pnlMainControl.add(panelPerPerfil);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();
        
    }//GEN-LAST:event_jmiMainSecPerfilActionPerformed

    private void jmiMainSecModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainSecModificarActionPerformed
        // TODO add your handling code here:
        PnlPerModificar panelPerModificar = new PnlPerModificar(usuario, tipo);
        pnlMainControl.removeAll();
        pnlMainControl.add(panelPerModificar);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();
    }//GEN-LAST:event_jmiMainSecModificarActionPerformed

    private void consultarHabitaciones() {
        PnlHabConsultar panelHabVista = new PnlHabConsultar(usuario);
        pnlMainControl.removeAll();
        pnlMainControl.add(panelHabVista);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame IfmMainControl;
    private javax.swing.JButton btnMainBuscar;
    private javax.swing.JComboBox<String> cbxMainHoteles;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private com.toedter.calendar.JDateChooser jdcMainFechaFin;
    private com.toedter.calendar.JDateChooser jdcMainFechaIni;
    private javax.swing.JMenuBar jmbMainControl;
    private javax.swing.JMenuItem jmiMainHabConsultar;
    private javax.swing.JMenuItem jmiMainHabCrear;
    private javax.swing.JMenuItem jmiMainHabEliminar;
    private javax.swing.JMenuItem jmiMainHabModificar;
    private javax.swing.JMenuItem jmiMainHotCrear;
    private javax.swing.JMenuItem jmiMainHotEliminar;
    private javax.swing.JMenuItem jmiMainHotModificar;
    private javax.swing.JMenuItem jmiMainSecCerrar;
    private javax.swing.JMenuItem jmiMainSecInicio;
    private javax.swing.JMenuItem jmiMainSecModificar;
    private javax.swing.JMenuItem jmiMainSecPassword;
    private javax.swing.JMenuItem jmiMainSecPerfil;
    private javax.swing.JMenuItem jmiMainSecSalir;
    private javax.swing.JMenuItem jmmMainAdmCrear;
    private javax.swing.JMenu jmmMainAdministradores;
    private javax.swing.JMenu jmmMainHabitaciones;
    private javax.swing.JMenu jmmMainHoteles;
    private javax.swing.JMenu jmmMainReservas;
    private javax.swing.JMenu jmmMainSeccion;
    private javax.swing.JLabel lbMainFechaFin;
    private javax.swing.JLabel lbMainFechaIni;
    private javax.swing.JLabel lbMainLogin;
    private javax.swing.JLabel lbMainUsuario;
    private javax.swing.JPanel pnlEstado;
    private javax.swing.JPanel pnlMainBusqueda;
    private javax.swing.JPanel pnlMainControl;
    // End of variables declaration//GEN-END:variables
}
