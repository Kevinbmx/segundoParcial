/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.Conexion;
import dto.Cuenta;
import dto.Transferencia;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.log4j.LogManager;

/**
 *
 * @author Jonathan
 */
public class TransferenciaDaoSqlServer extends TransferenciaDao {

    private static final org.apache.log4j.Logger logger = LogManager.getRootLogger();    
    
    @Override
    public int insert(Transferencia obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();
        int id = 0;
        PreparedStatement ps = objConexion.getObjConnection().prepareStatement("exec insertTransferencia ?,?,?,?,?");
        ps.setInt(1, obj.getIdcuentaorigen());
        ps.setInt(2, obj.getIdcuentadestino());
        ps.setString(3, obj.getDescripcion());
        ps.setDate(4, obj.getFecha());
        ps.setFloat(5, obj.getMonto());
//        id = objConexion.ejecutarInsert(ps.toString());
        int rpt = ps.executeUpdate();
        ps.getMoreResults();
        if (rpt == 1) {
            JOptionPane.showMessageDialog(null, "Se ha registrado una transferencia.");
            id = 1;
            logger.info("Se ha registrado una transferencia.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al hacer transferencia. Puede que no tengas el dinero solicitado en la cuenta de origeen de la transferencia.");
            logger.info("Error al hacer transferencia. Puede que no tengas el dinero solicitado en la cuenta de origeen de la transferencia.");
        }
        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(Transferencia obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int idEliminar) {
        Conexion objConexion = Conexion.getOrCreate();
        int id = 0;
        try {
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("exec dbo.deleteTransferencia ?");
            ps.setInt(1, idEliminar);
            int rpt = ps.executeUpdate();
            ps.getMoreResults();
            if (rpt == 1) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado el registro exitosamente.");
                id = 1;
                logger.info("Se ha eliminado el registro exitosamente.");
            }
            objConexion.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar transferencia. Puede que ya no tengas el dinero transferido en la cuenta de destino, por tanto no podras revirtir la transferencia.");
            logger.info("Error al eliminar transferencia. Puede que ya no tengas el dinero transferido en la cuenta de destino, por tanto no podras revirtir la transferencia. "+ ex.getMessage());
        }
        return id;
    }

    @Override
    public ArrayList<Transferencia> getList() {
        ArrayList<Transferencia> listaTransferencias = new ArrayList<Transferencia>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM selectTransferencia()";
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            while (objResultSet.next()) {
                Transferencia obj = new Transferencia();
                int _idtransferencia = objResultSet.getInt("idtransferencia");
                obj.setIdtransferencia(_idtransferencia);

                int _origen = objResultSet.getInt("idcuentaorigen");
                obj.setIdcuentaorigen(_origen);

                int _destino = objResultSet.getInt("idcuentadestino");
                obj.setIdcuentadestino(_destino);

                String _descripcion = objResultSet.getString("descripcion");
                obj.setDescripcion(_descripcion);

                Date fecha = objResultSet.getDate("fecha");
                obj.setFecha(fecha);

                float _monto = objResultSet.getFloat("monto");
                obj.setMonto(_monto);

                listaTransferencias.add(obj);
                logger.info("consultando tabla transferencias");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.info("error al consultar tabla transferencias. "+ ex.getMessage());
        }
        return listaTransferencias;
    }

    @Override
    public ArrayList<Transferencia> ListCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transferencia get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
