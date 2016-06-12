/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Frame.TransaccionGui;
import dao.CuentaDao;
import dao.TransaccionDao;
import dao.TransferenciaDao;
import dto.Cuenta;
import dto.Transaccion;
import dto.Transferencia;
import factory.FactoryDao;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jonathan
 */
public class TransferenciaGUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form Transferencia
     */
    public TransferenciaGUI() {
        initComponents();
        setTitle("Transferencias");

        cargarTablasCuentas();
        cargarTablaTransferencias();
        limpiarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botontransferir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtmonto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacuentaorigen = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablacuentadestino = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaTransferencias = new javax.swing.JTable();
        botonEliminar = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Nueva Transferencia");

        jLabel2.setText("Cuenta destino:");

        botontransferir.setText("Transferir");
        botontransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botontransferirActionPerformed(evt);
            }
        });

        jLabel3.setText("Descripcion de transferencia:");

        txtmonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmontoActionPerformed(evt);
            }
        });

        tablacuentaorigen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablacuentaorigen);

        jLabel1.setText("Cuenta de origen:");

        tablacuentadestino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablacuentadestino);

        jLabel5.setText("Monto:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addGap(0, 111, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botontransferir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtmonto)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtdescripcion))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botontransferir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Registros de Transferencia");

        tablaTransferencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablaTransferencias);

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(253, 253, 253))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(botonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botontransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botontransferirActionPerformed
        try {
            int idOrigen = tablacuentaorigen.getSelectedRow();
            if (idOrigen >= 0) {
                idOrigen = Integer.parseInt((String) tablacuentaorigen.getValueAt(idOrigen, 0));
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una fila para la cuenta de origen.");
            }

            int idDestino = tablacuentadestino.getSelectedRow();
            if (idDestino >= 0) {
                idDestino = Integer.parseInt((String) tablacuentadestino.getValueAt(idDestino, 0));
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una fila para la cuenta destino.");
            }

            if (idOrigen != idDestino) {
                if (Float.parseFloat(txtmonto.getText().toLowerCase()) > 0) {
                    TransferenciaDao objDao = FactoryDao.getFactoryInstance().geTransferenciaDao();
                    Transferencia obj = new Transferencia();
                    obj.setIdcuentaorigen(idOrigen);
                    obj.setIdcuentadestino(idDestino);
                    obj.setDescripcion(txtdescripcion.getText().trim());
                    obj.setFecha(new Date(System.currentTimeMillis()));
                    obj.setMonto(Float.parseFloat(txtmonto.getText().toLowerCase()));

                    if (objDao.insert(obj) == 1) {
                        limpiarCampos();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El monto a transferir debe ser mayor a 0. Verifique los datos e intente nuevamente.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El origen de transferencia no puede ser el igual al destino. Verifique los datos e intente nuevamente.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "El monto es incorrecto. Verifique los datos e intente nuevamente.");
        }
    }//GEN-LAST:event_botontransferirActionPerformed

    private void txtmontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontoActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        try {
            int idEliminar = tablaTransferencias.getSelectedRow();
            if (idEliminar >= 0) {
                idEliminar = Integer.parseInt((String) tablaTransferencias.getValueAt(idEliminar, 0));
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla para eliminar el registro e intente nuevamente.");
            }

            TransferenciaDao objDao = FactoryDao.getFactoryInstance().geTransferenciaDao();
            if (objDao.delete(idEliminar) == 1) {
                cargarTablasCuentas();
                cargarTablaTransferencias();
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_botonEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botontransferir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaTransferencias;
    private javax.swing.JTable tablacuentadestino;
    private javax.swing.JTable tablacuentaorigen;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtmonto;
    // End of variables declaration//GEN-END:variables

    private void cargarTablasCuentas() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("CUENTA");
            modelo.addColumn("SALDO");
            modelo.addColumn("NOMBRE");
            tablacuentaorigen.setModel(modelo);
            tablacuentadestino.setModel(modelo);

            String[] datos = new String[3];
            CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
            List<Cuenta> lista = new ArrayList();
            lista = objDao.getList();
            for (int i = 0; i < lista.size(); i++) {
                datos[0] = String.valueOf(lista.get(i).getCuentaId());
                datos[1] = String.valueOf(lista.get(i).getMonto());
                datos[2] = lista.get(i).getNombreCuenta();
                modelo.addRow(datos);
            }

            tablacuentaorigen.setModel(modelo);
            tablacuentadestino.setModel(modelo);

            tablacuentaorigen.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tablacuentaorigen.doLayout();
            tablacuentadestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tablacuentadestino.doLayout();
        } catch (Exception e) {
        }
    }

    private void cargarTablaTransferencias() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("N.TRANSFERENCIA");
            modelo.addColumn("CUENTA ORIGEN");
            modelo.addColumn("CUENTA DESTINO");
            modelo.addColumn("DESCRIPCION");
            modelo.addColumn("FECHA");
            modelo.addColumn("MONTO");
            tablaTransferencias.setModel(modelo);

            String[] datos = new String[6];
            TransferenciaDao objDao = FactoryDao.getFactoryInstance().geTransferenciaDao();
            List<Transferencia> lista = new ArrayList();
            lista = objDao.getList();
            for (int i = 0; i < lista.size(); i++) {
                datos[0] = String.valueOf(lista.get(i).getIdtransferencia());
                datos[1] = String.valueOf(lista.get(i).getIdcuentaorigen());
                datos[2] = String.valueOf(lista.get(i).getIdcuentadestino());
                datos[3] = lista.get(i).getDescripcion();
                datos[4] = String.valueOf(lista.get(i).getFecha());
                datos[5] = String.valueOf(lista.get(i).getMonto());
                modelo.addRow(datos);
            }

            tablaTransferencias.setModel(modelo);

            tablaTransferencias.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tablaTransferencias.doLayout();
        } catch (Exception e) {
        }
    }

    private void limpiarCampos() {
        txtdescripcion.setText("");
        txtmonto.setText("");
        cargarTablasCuentas();
        cargarTablaTransferencias();
    }

}
