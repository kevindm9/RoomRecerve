/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.mycompany.hotel.cliente.presentacion;

import co.mycompany.hotel.cliente.domain.services.HotelService;
import co.mycompany.hotel.commons.domain.Hotel;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
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
        Image img = new ImageIcon(".\\src\\main\\java\\co\\mycompany\\hotel\\cliente\\resources\\FondoPlayita.png").getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(lbMainFondo.getWidth(), lbMainFondo.getHeight(), Image.SCALE_SMOOTH));
        Image fondo = new ImageIcon(".\\src\\main\\java\\co\\mycompany\\hotel\\cliente\\resources\\FondoEstrella.png").getImage();
        ImageIcon fondo2 = new ImageIcon(fondo.getScaledInstance(lbFondoInternal.getWidth(), lbFondoInternal.getHeight(), Image.SCALE_SMOOTH));
        Image barner = new ImageIcon(".\\src\\main\\java\\co\\mycompany\\hotel\\cliente\\resources\\Barner.png").getImage();
        ImageIcon barner2 = new ImageIcon(barner.getScaledInstance(lbBarner.getWidth(), lbBarner.getHeight(), Image.SCALE_SMOOTH));
        Image icono = new ImageIcon(".\\src\\main\\java\\co\\mycompany\\hotel\\cliente\\resources\\icono.png").getImage();
        ImageIcon icono2 = new ImageIcon(icono.getScaledInstance(95, 95, Image.SCALE_SMOOTH));
        this.setIconImage(icono2.getImage());

        
        lbMainFondo.setIcon(img2);
        lbFondoInternal.setIcon(fondo2);
        lbBarner.setIcon(barner2);

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
        jmmMainSesion.setVisible(false);
        jmmMainAdministradores.setVisible(false);
        jmmMainHabitaciones.setVisible(false);
        jmmMainHoteles.setVisible(false);
        jmmMainReservas.setVisible(false);
        jmiMainResEliminar.setVisible(false);
        jmiMainResModificar.setVisible(false);
        jmiMainResVisualizar.setVisible(false);

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
        for (int i = 0; i < hoteles.size(); i++) {
            if (id_hotel == hoteles.get(i).getId()) {
                cbxMainHoteles.setSelectedIndex(i + 1);
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
        lbMainLogin.setText("Cerrar Sesión");
    }

    public void cargarAdmMaster() {
        jmmMainSesion.setVisible(true);
        jmmMainAdministradores.setVisible(true);
        jmmMainHabitaciones.setVisible(true);
        jmmMainHoteles.setVisible(true);
        mostrarHoteles();
    }

    public void cargarAdmJunior() {
        jmmMainSesion.setVisible(true);
        jmmMainHabitaciones.setVisible(true);
        jmmMainReservas.setVisible(true);
        jmiMainResEliminar.setVisible(true);
        jmiMainResModificar.setVisible(true);
        jmiMainResVisualizar.setVisible(true);
        mostrarHoteles();
    }

    public void cargarCliente() {
        jmmMainSesion.setVisible(true);
        jmmMainReservas.setVisible(true);
        jmiMainResVisualizar.setVisible(true);
        jmmMainReservas.setVisible(true);
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
        lbBarner = new javax.swing.JLabel();
        pnlMainBusqueda = new javax.swing.JPanel();
        btnMainBuscar = new javax.swing.JButton();
        cbxMainHoteles = new javax.swing.JComboBox<>();
        jdcMainFechaFin = new com.toedter.calendar.JDateChooser();
        jdcMainFechaIni = new com.toedter.calendar.JDateChooser();
        lbMainFechaIni = new javax.swing.JLabel();
        lbMainFechaFin = new javax.swing.JLabel();
        IfmMainControl = new javax.swing.JInternalFrame();
        pnlMainControl = new javax.swing.JPanel();
        pnlFondoInterno = new javax.swing.JPanel();
        lbFondoInternal = new javax.swing.JLabel();
        jmbMainControl = new javax.swing.JMenuBar();
        jmmMainSesion = new javax.swing.JMenu();
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
        jmiMainAdmCrear = new javax.swing.JMenuItem();
        jmiMainAdmEliminar = new javax.swing.JMenuItem();
        jmmMainReservas = new javax.swing.JMenu();
        jmiMainResVisualizar = new javax.swing.JMenuItem();
        jmiMainResModificar = new javax.swing.JMenuItem();
        jmiMainResEliminar = new javax.swing.JMenuItem();
        lbMainFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Room Reserve Service");
        setMaximumSize(new java.awt.Dimension(2000, 2147483647));
        setPreferredSize(new java.awt.Dimension(752, 580));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlEstado.setOpaque(false);

        lbMainLogin.setText("Iniciar Sesión");
        lbMainLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMainLoginMouseClicked(evt);
            }
        });

        lbMainUsuario.setText("Crea tu cuenta");
        lbMainUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMainUsuarioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlEstadoLayout = new javax.swing.GroupLayout(pnlEstado);
        pnlEstado.setLayout(pnlEstadoLayout);
        pnlEstadoLayout.setHorizontalGroup(
            pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBarner, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184)
                .addComponent(lbMainUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lbMainLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        pnlEstadoLayout.setVerticalGroup(
            pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstadoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMainUsuario)
                    .addComponent(lbMainLogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBarner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 54));

        pnlMainBusqueda.setOpaque(false);
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

        getContentPane().add(pnlMainBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 56, 760, -1));

        IfmMainControl.setBorder(null);
        IfmMainControl.setForeground(new java.awt.Color(255, 255, 255));
        IfmMainControl.setEnabled(false);
        IfmMainControl.setFocusCycleRoot(false);
        IfmMainControl.setVerifyInputWhenFocusTarget(false);
        IfmMainControl.setVisible(true);

        pnlMainControl.setOpaque(false);
        pnlMainControl.setPreferredSize(new java.awt.Dimension(740, 400));
        pnlMainControl.setLayout(new java.awt.CardLayout());

        pnlFondoInterno.setPreferredSize(new java.awt.Dimension(740, 400));

        lbFondoInternal.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbFondoInternal.setPreferredSize(new java.awt.Dimension(740, 400));

        javax.swing.GroupLayout pnlFondoInternoLayout = new javax.swing.GroupLayout(pnlFondoInterno);
        pnlFondoInterno.setLayout(pnlFondoInternoLayout);
        pnlFondoInternoLayout.setHorizontalGroup(
            pnlFondoInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
            .addGroup(pnlFondoInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFondoInternoLayout.createSequentialGroup()
                    .addComponent(lbFondoInternal, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlFondoInternoLayout.setVerticalGroup(
            pnlFondoInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
            .addGroup(pnlFondoInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFondoInternoLayout.createSequentialGroup()
                    .addComponent(lbFondoInternal, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jmbMainControl.setToolTipText("Administrar");
        jmbMainControl.setOpaque(false);

        jmmMainSesion.setText("Sesión");

        jmiMainSecInicio.setText("Inicio");
        jmiMainSecInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainSecInicioActionPerformed(evt);
            }
        });
        jmmMainSesion.add(jmiMainSecInicio);
        jmmMainSesion.add(jSeparator1);

        jmiMainSecPerfil.setText("Ver perfil");
        jmiMainSecPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainSecPerfilActionPerformed(evt);
            }
        });
        jmmMainSesion.add(jmiMainSecPerfil);

        jmiMainSecModificar.setText("Modificar Perfil");
        jmiMainSecModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainSecModificarActionPerformed(evt);
            }
        });
        jmmMainSesion.add(jmiMainSecModificar);

        jmiMainSecPassword.setText("Modificar Contraseña");
        jmiMainSecPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainSecPasswordActionPerformed(evt);
            }
        });
        jmmMainSesion.add(jmiMainSecPassword);
        jmmMainSesion.add(jSeparator2);

        jmiMainSecCerrar.setText("Cerrar Sesión");
        jmiMainSecCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainSecCerrarActionPerformed(evt);
            }
        });
        jmmMainSesion.add(jmiMainSecCerrar);

        jmiMainSecSalir.setText("Salir");
        jmiMainSecSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainSecSalirActionPerformed(evt);
            }
        });
        jmmMainSesion.add(jmiMainSecSalir);

        jmbMainControl.add(jmmMainSesion);

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

        jmiMainAdmCrear.setText("Registrar Administrador Junior");
        jmiMainAdmCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainAdmCrearActionPerformed(evt);
            }
        });
        jmmMainAdministradores.add(jmiMainAdmCrear);

        jmiMainAdmEliminar.setText("Eliminar Asministrador Junior");
        jmiMainAdmEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainAdmEliminarActionPerformed(evt);
            }
        });
        jmmMainAdministradores.add(jmiMainAdmEliminar);

        jmbMainControl.add(jmmMainAdministradores);

        jmmMainReservas.setText("Reservas");

        jmiMainResVisualizar.setText("Historial de reservas");
        jmiMainResVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainResVisualizarActionPerformed(evt);
            }
        });
        jmmMainReservas.add(jmiMainResVisualizar);

        jmiMainResModificar.setText("Modificar reserva");
        jmiMainResModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainResModificarActionPerformed(evt);
            }
        });
        jmmMainReservas.add(jmiMainResModificar);

        jmiMainResEliminar.setText("Eliminar reserva");
        jmiMainResEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMainResEliminarActionPerformed(evt);
            }
        });
        jmmMainReservas.add(jmiMainResEliminar);

        jmbMainControl.add(jmmMainReservas);

        IfmMainControl.setJMenuBar(jmbMainControl);

        javax.swing.GroupLayout IfmMainControlLayout = new javax.swing.GroupLayout(IfmMainControl.getContentPane());
        IfmMainControl.getContentPane().setLayout(IfmMainControlLayout);
        IfmMainControlLayout.setHorizontalGroup(
            IfmMainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainControl, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(IfmMainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(IfmMainControlLayout.createSequentialGroup()
                    .addComponent(pnlFondoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        IfmMainControlLayout.setVerticalGroup(
            IfmMainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IfmMainControlLayout.createSequentialGroup()
                .addComponent(pnlMainControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(IfmMainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(IfmMainControlLayout.createSequentialGroup()
                    .addComponent(pnlFondoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        getContentPane().add(IfmMainControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 99, 760, 420));

        lbMainFondo.setMaximumSize(new java.awt.Dimension(740, 560));
        lbMainFondo.setMinimumSize(new java.awt.Dimension(740, 560));
        lbMainFondo.setPreferredSize(new java.awt.Dimension(740, 560));
        getContentPane().add(lbMainFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbMainLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMainLoginMouseClicked
        // TODO add your handling code here:
        sesion();
    }//GEN-LAST:event_lbMainLoginMouseClicked

    private void sesion() {
        if ("Iniciar Sesión".equals(lbMainLogin.getText())) {
            cargarLogin();
        } else {
            lbMainLogin.setText("Iniciar Sesión");
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
        sesion();
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

    private void jmiMainAdmCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainAdmCrearActionPerformed
        // TODO add your handling code here:
        cargarRegistrar("Junior");
    }//GEN-LAST:event_jmiMainAdmCrearActionPerformed

    private void btnMainBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainBuscarActionPerformed
        // TODO add your handling code here:
        try {
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
            System.out.println(hoteles.get(cbxMainHoteles.getSelectedIndex() - 1).getNombre());
            cargarReserva(hoteles.get(cbxMainHoteles.getSelectedIndex() - 1).getId(), fechaIni, fechaFin);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione primero un hotel, fecha de inicio y fecha de fin", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
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

    private void jmiMainSecPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainSecPasswordActionPerformed
        // TODO add your handling code here:
        PnlPerPassword panelPerpasword = new PnlPerPassword(usuario, tipo);
        pnlMainControl.removeAll();
        pnlMainControl.add(panelPerpasword);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();
    }//GEN-LAST:event_jmiMainSecPasswordActionPerformed

    private void jmiMainAdmEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainAdmEliminarActionPerformed
        // TODO add your handling code here:
        PnlPerEliminar panelPerEliminar = new PnlPerEliminar();
        pnlMainControl.removeAll();
        pnlMainControl.add(panelPerEliminar);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();
    }//GEN-LAST:event_jmiMainAdmEliminarActionPerformed

    private void jmiMainResVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainResVisualizarActionPerformed
        // TODO add your handling code here:
        PnlResVisualizar panelaux = new PnlResVisualizar(usuario);
        pnlMainControl.removeAll();
        pnlMainControl.add(panelaux);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();

    }//GEN-LAST:event_jmiMainResVisualizarActionPerformed

    private void jmiMainResModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainResModificarActionPerformed
        // TODO add your handling code here:
        PnlResUpdate panelaux = new PnlResUpdate(usuario);
        pnlMainControl.removeAll();
        pnlMainControl.add(panelaux);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();
    }//GEN-LAST:event_jmiMainResModificarActionPerformed

    private void jmiMainResEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMainResEliminarActionPerformed
        // TODO add your handling code here:
        PnlResEliminar panelaux = new PnlResEliminar(usuario);
        pnlMainControl.removeAll();
        pnlMainControl.add(panelaux);
        pnlMainControl.repaint();
        pnlMainControl.revalidate();

    }//GEN-LAST:event_jmiMainResEliminarActionPerformed

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
    private javax.swing.JMenuItem jmiMainAdmCrear;
    private javax.swing.JMenuItem jmiMainAdmEliminar;
    private javax.swing.JMenuItem jmiMainHabConsultar;
    private javax.swing.JMenuItem jmiMainHabCrear;
    private javax.swing.JMenuItem jmiMainHabEliminar;
    private javax.swing.JMenuItem jmiMainHabModificar;
    private javax.swing.JMenuItem jmiMainHotCrear;
    private javax.swing.JMenuItem jmiMainHotEliminar;
    private javax.swing.JMenuItem jmiMainHotModificar;
    private javax.swing.JMenuItem jmiMainResEliminar;
    private javax.swing.JMenuItem jmiMainResModificar;
    private javax.swing.JMenuItem jmiMainResVisualizar;
    private javax.swing.JMenuItem jmiMainSecCerrar;
    private javax.swing.JMenuItem jmiMainSecInicio;
    private javax.swing.JMenuItem jmiMainSecModificar;
    private javax.swing.JMenuItem jmiMainSecPassword;
    private javax.swing.JMenuItem jmiMainSecPerfil;
    private javax.swing.JMenuItem jmiMainSecSalir;
    private javax.swing.JMenu jmmMainAdministradores;
    private javax.swing.JMenu jmmMainHabitaciones;
    private javax.swing.JMenu jmmMainHoteles;
    private javax.swing.JMenu jmmMainReservas;
    private javax.swing.JMenu jmmMainSesion;
    private javax.swing.JLabel lbBarner;
    private javax.swing.JLabel lbFondoInternal;
    private javax.swing.JLabel lbMainFechaFin;
    private javax.swing.JLabel lbMainFechaIni;
    private javax.swing.JLabel lbMainFondo;
    private javax.swing.JLabel lbMainLogin;
    private javax.swing.JLabel lbMainUsuario;
    private javax.swing.JPanel pnlEstado;
    private javax.swing.JPanel pnlFondoInterno;
    private javax.swing.JPanel pnlMainBusqueda;
    private javax.swing.JPanel pnlMainControl;
    // End of variables declaration//GEN-END:variables
}
