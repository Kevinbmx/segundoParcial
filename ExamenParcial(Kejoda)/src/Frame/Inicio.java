package Frame;

import dal.Conexion;
import dao.CuentaDao;
import dao.UsuarioDao;
import dto.Cuenta;
import dto.Usuario;
import factory.FactoryDao;
import java.awt.Color;
import java.awt.Dimension;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

public class Inicio extends javax.swing.JFrame {

    private String idetabla = "";
    private static final org.apache.log4j.Logger logger = LogManager.getRootLogger();

    public Inicio() {
        initComponents();
        llenarTablacuenta();
        llenarTablaTotal();
        llenarusuario();
        logger.info("SE HA INICIADO LA VENTANA PRINCIPAL DEL SISTEMA.");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogCrearcuenta = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtmonto = new javax.swing.JTextField();
        btnaceptar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jDialogEditarcuenta = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtnombreeditar = new javax.swing.JTextField();
        txtmontoeditar = new javax.swing.JTextField();
        btneditarcuenta = new javax.swing.JButton();
        btncancelar1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtnumid = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txttotal = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labeltelefono = new javax.swing.JLabel();
        labelnombre = new javax.swing.JLabel();
        btnañadircuenta = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblcuentas = new javax.swing.JTable();
        btneditar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jmenucuentacategoria = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmenucreartransferencia = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmenucreartransaccion = new javax.swing.JMenuItem();
        jmenulistatransaccion = new javax.swing.JMenuItem();

        jDialogCrearcuenta.setResizable(false);
        jDialogCrearcuenta.setSize(new java.awt.Dimension(337, 300));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Ingresar"));

        jLabel7.setText("Monto");

        jLabel10.setText("Nombre de Cuenta");

        btnaceptar.setText("Aceptar");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel10))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnaceptar)
                        .addGap(63, 63, 63)
                        .addComponent(btncancelar))
                    .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(66, 66, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btncancelar)
                            .addComponent(btnaceptar))
                        .addGap(20, 20, 20))))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("CUENTA");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialogCrearcuentaLayout = new javax.swing.GroupLayout(jDialogCrearcuenta.getContentPane());
        jDialogCrearcuenta.getContentPane().setLayout(jDialogCrearcuentaLayout);
        jDialogCrearcuentaLayout.setHorizontalGroup(
            jDialogCrearcuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCrearcuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogCrearcuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDialogCrearcuentaLayout.setVerticalGroup(
            jDialogCrearcuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCrearcuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDialogEditarcuenta.setPreferredSize(new java.awt.Dimension(337, 300));
        jDialogEditarcuenta.setResizable(false);
        jDialogEditarcuenta.setSize(new java.awt.Dimension(337, 300));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Ingresar"));

        jLabel9.setText("Monto");

        jLabel11.setText("Nombre de Cuenta");

        btneditarcuenta.setText("Editar");
        btneditarcuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarcuentaActionPerformed(evt);
            }
        });

        btncancelar1.setText("Cancelar");
        btncancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelar1ActionPerformed(evt);
            }
        });

        jLabel14.setText("Nº Cuenta");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btneditarcuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(btncancelar1)
                        .addGap(56, 56, 56))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel11))
                            .addComponent(txtmontoeditar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombreeditar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtnumid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel11))
                    .addComponent(txtnumid, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtnombreeditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txtmontoeditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btncancelar1)
                            .addComponent(btneditarcuenta))
                        .addGap(20, 20, 20))))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setText("CUENTA");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialogEditarcuentaLayout = new javax.swing.GroupLayout(jDialogEditarcuenta.getContentPane());
        jDialogEditarcuenta.getContentPane().setLayout(jDialogEditarcuentaLayout);
        jDialogEditarcuentaLayout.setHorizontalGroup(
            jDialogEditarcuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditarcuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogEditarcuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDialogEditarcuentaLayout.setVerticalGroup(
            jDialogEditarcuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditarcuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("ADMINISTRADOR");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("DE");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("DINERO");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dinero"));

        jLabel12.setText("TOTAL");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel5.setText("Lista de Cuentas");

        jLabel6.setText("Nombre");

        jLabel8.setText("Telefono");

        btnañadircuenta.setText("Añadir");
        btnañadircuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnañadircuentaActionPerformed(evt);
            }
        });

        tblcuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblcuentas.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tblcuentas);

        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Disco A\\universidad\\Universidad Nur\\software 3\\segundo examen parcial(kejoda)\\ExamenParcial(Kejoda)\\src\\actualizar.png")); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labeltelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                    .addComponent(labelnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnañadircuenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btneditar)
                                .addGap(26, 26, 26)
                                .addComponent(btneliminar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(labelnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(labeltelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btneliminar)
                            .addComponent(btneditar)
                            .addComponent(btnañadircuenta)))
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(307, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1624, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("Acerca");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Categoria");

        jmenucuentacategoria.setText("Lista Categoria");
        jmenucuentacategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenucuentacategoriaActionPerformed(evt);
            }
        });
        jMenu2.add(jmenucuentacategoria);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Transferencia");

        jmenucreartransferencia.setText("Listas de transferencia");
        jmenucreartransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenucreartransferenciaActionPerformed(evt);
            }
        });
        jMenu3.add(jmenucreartransferencia);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Transaccion");

        jmenucreartransaccion.setText("Crear Transaccion");
        jmenucreartransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenucreartransaccionActionPerformed(evt);
            }
        });
        jMenu4.add(jmenucreartransaccion);

        jmenulistatransaccion.setText("transaccion");
        jmenulistatransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenulistatransaccionActionPerformed(evt);
            }
        });
        jMenu4.add(jmenulistatransaccion);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmenucuentacategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenucuentacategoriaActionPerformed
        try {
            CategoriaFrame cc = new CategoriaFrame();
            Dimension desktopSize = jDesktopPane1.getSize();
            Dimension FrameSize = cc.getSize();
            jDesktopPane1.add(cc);
            cc.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            cc.show();
            logger.info("abrio correctamenteinternal frame categoria");
        } catch (Exception e) {
            logger.error("Error al abrir el internal frame categoria", e);
        }

    }//GEN-LAST:event_jmenucuentacategoriaActionPerformed

    private void jmenucreartransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenucreartransferenciaActionPerformed
        try {
            TransferenciaGUI vt = new TransferenciaGUI();
            jDesktopPane1.add(vt);
            vt.setLocation(50, 50);
            vt.show();
            logger.info("llamando a ventana transferencia.");
        } catch (Exception e) {
            logger.error("Error al abrir ventana transferencia.", e);
        }
    }//GEN-LAST:event_jmenucreartransferenciaActionPerformed

    private void jmenucreartransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenucreartransaccionActionPerformed
        try {
            TransaccionGui t = new TransaccionGui();
            jDesktopPane1.add(t);
            t.show();
            t.setLocation(50, 5);
            logger.info("abrio correctamenteinternal frame transaccion");
        } catch (Exception e) {
            logger.error("Error al abrir el internal frame transaccion", e);
        }
    }//GEN-LAST:event_jmenucreartransaccionActionPerformed

    private void jmenulistatransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenulistatransaccionActionPerformed
        try {
            TransaccionBusqueda t = new TransaccionBusqueda();
            jDesktopPane1.add(t);
            t.show();
            t.setLocation(50, 5);
            logger.info("abrio correctamenteinternal frame transaccion");
        } catch (Exception e) {
            logger.error("Error al abrir el internal frame busqueda transaccion ", e);
        }
    }//GEN-LAST:event_jmenulistatransaccionActionPerformed

    private void btnañadircuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnañadircuentaActionPerformed
        llenarTablacuenta();
        llenarTablaTotal();
        jDialogCrearcuenta.setVisible(true);
        jDialogCrearcuenta.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnañadircuentaActionPerformed

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        try {
            CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
            Cuenta obj = new Cuenta();
            obj.setNombreCuenta((txtnombre.getText()));
            obj.setMonto(Float.valueOf(txtmonto.getText()));
            obj.setUsuarioId(1);
            objDao.insert(obj);
            JOptionPane.showMessageDialog(null, "Tu cuenta fue insertada");
            vaciarcamposcrear();
            logger.info("cuenta no insertada");
        } catch (Exception e) {
            logger.error("Error cuenta no insertada", e);
            JOptionPane.showMessageDialog(null, "Tu cuenta no fue insertada");
        }
        llenarTablacuenta();
        llenarTablaTotal();
        jDialogCrearcuenta.setVisible(false);
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        jDialogCrearcuenta.setVisible(false);
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btneditarcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarcuentaActionPerformed
        jDialogEditarcuenta.setVisible(false);
        try {
            CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
            Cuenta obj = new Cuenta();
            obj.setCuentaId(Integer.parseInt(txtnumid.getText()));
            obj.setNombreCuenta(txtnombreeditar.getText());
            obj.setMonto(Float.parseFloat(txtmontoeditar.getText()));
            obj.setUsuarioId(1);
            objDao.update(obj);
            System.out.println("entro");
            vaciarcamposeditar();
            llenarTablacuenta();
            llenarTablaTotal();
            logger.info("cuenta no actualizada");
        } catch (Exception e) {
            logger.error("Error cuenta no actualizada", e);
            JOptionPane.showMessageDialog(null, "No se actualizar la cuenta");
        }
    }//GEN-LAST:event_btneditarcuentaActionPerformed

    private void btncancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelar1ActionPerformed
        jDialogEditarcuenta.setVisible(false);
    }//GEN-LAST:event_btncancelar1ActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        try {
            int fila = tblcuentas.getSelectedRow();
            if (fila < 0) {
                JOptionPane.showMessageDialog(null, "seleccione una fila para poder editar");
            } else {

                Cuenta obj = new Cuenta();
                CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
                idetabla = (String) tblcuentas.getValueAt(fila, 0).toString();
                int id = Integer.parseInt(idetabla);
                System.out.println(idetabla);
                System.out.println(id);
                obj = objDao.get(id);
                txtnumid.setText(obj.getCuentaId() + "");
                txtnombreeditar.setText(obj.getNombreCuenta());
                txtmontoeditar.setText(obj.getMonto() + "");
                jDialogEditarcuenta.setVisible(true);
                jDialogEditarcuenta.setLocationRelativeTo(null);
            }
            logger.info("se lleno los campos para editar cuenta");
        } catch (Exception e) {
            logger.error("Error no se pudo llenar los campos para editar cuenta", e);
            JOptionPane.showMessageDialog(null, "no ha sido editado su cuenta");
        }
    }//GEN-LAST:event_btneditarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

        try {
            int fila = tblcuentas.getSelectedRow();
            if (fila < 0) {
                JOptionPane.showMessageDialog(null, "seleccione una fila para poder eliminar");
            } else {
                CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
                idetabla = (String) tblcuentas.getValueAt(fila, 0).toString();
                int id = Integer.parseInt(idetabla);
                JOptionPane.showMessageDialog(null, "estas seguro que quieres eliminar una cuenta");
                objDao.delete(id);
                llenarTablacuenta();
                llenarTablaTotal();
            }
            logger.info("se pudo eliminar la cuenta correctamente");
        } catch (Exception e) {
            logger.error("Error no se pudo eliminar la cuenta", e);
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        llenarTablaTotal();
        llenarTablacuenta();
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        String resource
                = "/auditoria.properties";
        URL configFileResource;
        configFileResource = Inicio.class.getResource(resource);
        PropertyConfigurator.configure(configFileResource);

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    public void llenarTablacuenta() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("MONTO");
            String[] datos = new String[4];
            CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
            List<Cuenta> lista = new ArrayList();
            lista = objDao.getList();
            for (int i = 0; i < lista.size(); i++) {
                datos[0] = String.valueOf(lista.get(i).getCuentaId());
                datos[1] = lista.get(i).getNombreCuenta();
                datos[2] = String.valueOf(lista.get(i).getMonto());
                modelo.addRow(datos);
            }
            tblcuentas.setModel(modelo);
            logger.info("lleno de tablacuenta");
        } catch (Exception e) {
            logger.warn("no llenada de tabla cuenta");
        }
    }

    public void llenarTablaTotal() {
        try {
            float montototal = 0;
            CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
            List<Cuenta> lista = new ArrayList();
            lista = objDao.getList();
            for (int i = 0; i < lista.size(); i++) {
                montototal = montototal + lista.get(i).getMonto();
            }
            txttotal.setText(" " + montototal + " Bs");
            logger.info("llenar monto total");
        } catch (Exception e) {
            logger.warn("error al llenar monto total");
        }
    }

    public void llenarusuario() {
        try {
            UsuarioDao objDao = FactoryDao.getFactoryInstance().getNewUsuarioDao();
            List<Usuario> lista = new ArrayList();
            lista = objDao.getList();
            labelnombre.setText(lista.get(0).getNombre());
            labeltelefono.setText(lista.get(0).getTelefono());
            logger.info("llenar campo de usuario");
        } catch (Exception e) {
            logger.warn("error al llenar el campo de usuario");
        }
    }

    public void vaciarcamposcrear() {
        txtnombre.setText("");
        txtmonto.setText("");
    }

    public void vaciarcamposeditar() {
        txtnombreeditar.setText("");
        txtmontoeditar.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btnañadircuenta;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btncancelar1;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneditarcuenta;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton jButton7;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDialog jDialogCrearcuenta;
    private javax.swing.JDialog jDialogEditarcuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JMenuItem jmenucreartransaccion;
    private javax.swing.JMenuItem jmenucreartransferencia;
    private javax.swing.JMenuItem jmenucuentacategoria;
    private javax.swing.JMenuItem jmenulistatransaccion;
    private javax.swing.JLabel labelnombre;
    private javax.swing.JLabel labeltelefono;
    private javax.swing.JTable tblcuentas;
    private javax.swing.JTextField txtmonto;
    private javax.swing.JTextField txtmontoeditar;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnombreeditar;
    private javax.swing.JLabel txtnumid;
    private javax.swing.JLabel txttotal;
    // End of variables declaration//GEN-END:variables
}
