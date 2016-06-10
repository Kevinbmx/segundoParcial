package Frame;

public class Inicio extends javax.swing.JFrame {

    public Inicio() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jmenucuentacategoria = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmenucreartransferencia = new javax.swing.JMenuItem();
        jmenulistaTranferencia = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmenucreartransaccion = new javax.swing.JMenuItem();
        jmenulistatransaccion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 858, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        jMenu1.setText("Acerca");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cuenta y Categoria");

        jmenucuentacategoria.setText("Crear cuenta y categoria");
        jmenucuentacategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenucuentacategoriaActionPerformed(evt);
            }
        });
        jMenu2.add(jmenucuentacategoria);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Transferencia");

        jmenucreartransferencia.setText("Crear transferencia");
        jmenucreartransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenucreartransferenciaActionPerformed(evt);
            }
        });
        jMenu3.add(jmenucreartransferencia);

        jmenulistaTranferencia.setText("Transferencia");
        jMenu3.add(jmenulistaTranferencia);

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
        jMenu4.add(jmenulistatransaccion);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmenucuentacategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenucuentacategoriaActionPerformed
        try {
            CuentaCategoria cc = new CuentaCategoria();
            jDesktopPane1.add(cc);
            cc.show();
            cc.setLocation(50, 5);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jmenucuentacategoriaActionPerformed

    private void jmenucreartransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenucreartransferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmenucreartransferenciaActionPerformed

    private void jmenucreartransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenucreartransaccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmenucreartransaccionActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmenucreartransaccion;
    private javax.swing.JMenuItem jmenucreartransferencia;
    private javax.swing.JMenuItem jmenucuentacategoria;
    private javax.swing.JMenuItem jmenulistaTranferencia;
    private javax.swing.JMenuItem jmenulistatransaccion;
    // End of variables declaration//GEN-END:variables
}
