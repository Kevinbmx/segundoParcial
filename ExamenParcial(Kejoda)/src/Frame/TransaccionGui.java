/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import dal.Conexion;
import dao.CategoriaDao;
import dao.CuentaDao;
import dao.TransaccionDao;
import dto.Categoria;
import dto.Cuenta;
import dto.Transaccion;
import factory.FactoryDao;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import org.apache.log4j.LogManager;

/**
 *
 * @author Uway
 */
public class TransaccionGui extends javax.swing.JInternalFrame {

    int id0;
Date ne=  new Date(System.currentTimeMillis());
 private static final org.apache.log4j.Logger logger = LogManager.getRootLogger();
    public TransaccionGui() {
        initComponents();
        mostrarDatos();
        llenarCombocuenta();
        llenarCombocategoria();
        jButton1.setEnabled(false);
        txtfecha.setVisible(false);
        jLabel4.setText(""+ne);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        actualizar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        txtMonto = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JButton();
        cmbidcategoria = new javax.swing.JComboBox<>();
        cmbidcuenta = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelcategoria = new javax.swing.JLabel();
        labelcuenta = new javax.swing.JLabel();
        cmbtipo = new javax.swing.JComboBox<>();
        cmbHora = new javax.swing.JComboBox<>();
        cmbminuto = new javax.swing.JComboBox<>();
        cmbAmPm = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btneliminar = new javax.swing.JButton();

        actualizar.setText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(actualizar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Transaccion");

        jLabel1.setText("Monto");

        jLabel2.setText("Fecha");

        jLabel3.setText("Tipo");

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(Tabla);

        txtfecha.setText(" ");

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        cmbidcategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));
        cmbidcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbidcategoriaActionPerformed(evt);
            }
        });

        cmbidcuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));
        cmbidcuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbidcuentaActionPerformed(evt);
            }
        });

        jLabel5.setText("Categoria");

        jLabel6.setText("Cuenta");

        labelcategoria.setText(".");

        labelcuenta.setText(".");

        cmbtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasto", "Ingreso" }));

        cmbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cmbminuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60" }));

        cmbAmPm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Presione click derecho");

        jLabel8.setText("En la tabla para actualizar");

        jLabel4.setText("jLabel4");

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6)
                                            .addComponent(cmbidcategoria, 0, 97, Short.MAX_VALUE)
                                            .addComponent(cmbidcuenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbminuto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbAmPm, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInsertar)
                            .addComponent(jButton1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(btneliminar))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbminuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbAmPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbidcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelcategoria))
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelcuenta)
                            .addComponent(cmbidcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInsertar)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addGap(30, 30, 30)
                                .addComponent(jButton1)))))
                .addGap(15, 15, 15)
                .addComponent(btneliminar)
                .addGap(83, 83, 83))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        
        String fechacompleta = (String.valueOf(ne));
        txtfecha.setText(fechacompleta);
        String hora = (cmbHora.getSelectedItem().toString() + ":" + cmbminuto.getSelectedItem().toString() + " " + cmbAmPm.getSelectedItem().toString());
        try {
            TransaccionDao objDao = FactoryDao.getFactoryInstance().geTransaccionDao();
            Transaccion obj = new Transaccion();
            obj.setMonto(Float.parseFloat(txtMonto.getText()));
            obj.setFecha(txtfecha.getText());
            obj.setHora(hora);
            obj.setFK_idCategoria(Integer.parseInt(labelcategoria.getText()));
            obj.setFk_idcuenta(Integer.parseInt(labelcuenta.getText()));
            obj.setTipo(cmbtipo.getSelectedItem().toString());

            objDao.insert(obj);
        } catch (Exception ex) {
            logger.error("error boton insertar "+ex);
        }
        mostrarDatos();
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void cmbidcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbidcategoriaActionPerformed
        try {
            CategoriaDao objDao = FactoryDao.getFactoryInstance().getNewCategoriaDao();
            Categoria obj = new Categoria();
            obj = objDao.obtenernombreid(cmbidcategoria.getSelectedItem().toString());
            labelcategoria.setText("" + obj.getCategoriaId());

        } catch (Exception e) {
            System.out.print(e);
            logger.error("error combocategoria "+e);
        }
    }//GEN-LAST:event_cmbidcategoriaActionPerformed

    private void cmbidcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbidcuentaActionPerformed
        try {
            CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
            Cuenta obj = new Cuenta();
            obj = objDao.obtenernobbreid(cmbidcuenta.getSelectedItem().toString());
            labelcuenta.setText("" + obj.getCuentaId());

        } catch (Exception e) {
            System.out.print(e);
            logger.error("error combocuenta "+e);
        }
    }//GEN-LAST:event_cmbidcuentaActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        int fila = Tabla.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "seleccione una fila para poder editar");
        } else {
            Transaccion obj = new Transaccion();
            TransaccionDao objDao = FactoryDao.getFactoryInstance().geTransaccionDao();
            String idetabla = (String) Tabla.getValueAt(fila, 4).toString();
            int id = Integer.parseInt(idetabla);
            System.out.println("iddddddd" + idetabla);
            System.out.println(id);
            obj = objDao.get(id);
            id0=id;
            txtMonto.setText(obj.getMonto() + "");
            txtfecha.setText(obj.getFecha());
            jButton1.setEnabled(true);
        }
    }//GEN-LAST:event_actualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String hora = (cmbHora.getSelectedItem().toString() + ":" + cmbminuto.getSelectedItem().toString() + " " + cmbAmPm.getSelectedItem().toString());
        try {
            TransaccionDao objDao = FactoryDao.getFactoryInstance().geTransaccionDao();

            Transaccion obj = new Transaccion();
            obj.setIdTransaccion(id0);
            obj.setFecha(txtfecha.getText());
            obj.setHora(hora);
            obj.setTipo(String.valueOf(cmbtipo.getSelectedItem()));
            obj.setMonto(Float.parseFloat(txtMonto.getText()));
            obj.setFk_idcuenta(Integer.parseInt(labelcuenta.getText()));
            obj.setFK_idCategoria(Integer.parseInt(labelcategoria.getText()));
            objDao.update(obj);
            System.out.println("entro");
            jButton1.setEnabled(false);
            mostrarDatos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se actualizo la Transaccion");
            logger.error("error boton actualizar "+ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
       int fila = Tabla.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "seleccione una fila para poder editar");
        } else {
            
            TransaccionDao objDao = FactoryDao.getFactoryInstance().geTransaccionDao();
            String idetabla = (String) Tabla.getValueAt(fila, 4).toString();
            int id = Integer.parseInt(idetabla);
           
           objDao.delete(id);
           mostrarDatos();
            
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    public void mostrarDatos() {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("tipo");
        modelo.addColumn("Monto");
        modelo.addColumn("ID");
        Tabla.setModel(modelo);

        String[] datos = new String[5];
        TransaccionDao objDao = FactoryDao.getFactoryInstance().geTransaccionDao();
        List<Transaccion> lista = new ArrayList();
        lista = objDao.getList();
        for (int i = 0; i < lista.size(); i++) {

            datos[1] = String.valueOf(lista.get(i).getHora());
            datos[0] = lista.get(i).getFecha();
            datos[2] = lista.get(i).getTipo();
            datos[3] = String.valueOf(lista.get(i).getMonto());
            datos[4] = String.valueOf(lista.get(i).getIdTransaccion());
            modelo.addRow(datos);
        }

        Tabla.setModel(modelo);
    }

    public void llenarCombocuenta() {
        this.cmbidcuenta.removeAllItems();
        try {
            CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
            List<Cuenta> lista = new ArrayList();
            lista = objDao.getList();
            for (int i = 0; i < lista.size(); i++) {
                String cuenta = String.valueOf(lista.get(i).getNombreCuenta());
                cmbidcuenta.addItem(cuenta);
                //System.out.println("/////"+cuenta);
            }

        } catch (Exception e) {
            System.out.print(e);
            logger.error("error llenar combocuenta "+e);
        }

    }

    public void llenarCombocategoria() {
        this.cmbidcategoria.removeAllItems();
        try {
            CategoriaDao objDao = FactoryDao.getFactoryInstance().getNewCategoriaDao();
            List<Categoria> lista = new ArrayList();
            lista = objDao.getList();
            for (int i = 0; i < lista.size(); i++) {
                String categoria = String.valueOf(lista.get(i).getNombreCategoria());
                cmbidcategoria.addItem(categoria);
                //System.out.println("/////"+cuenta);
            }

        } catch (Exception e) {
            System.out.print(e);
            logger.error("error llenarcombocategoria "+e);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JMenuItem actualizar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JComboBox<String> cmbAmPm;
    private javax.swing.JComboBox<String> cmbHora;
    private javax.swing.JComboBox<String> cmbidcategoria;
    private javax.swing.JComboBox<String> cmbidcuenta;
    private javax.swing.JComboBox<String> cmbminuto;
    private javax.swing.JComboBox<String> cmbtipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelcategoria;
    private javax.swing.JLabel labelcuenta;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtfecha;
    // End of variables declaration//GEN-END:variables
}
