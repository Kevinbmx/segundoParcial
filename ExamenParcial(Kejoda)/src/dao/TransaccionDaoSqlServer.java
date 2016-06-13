/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.Conexion;
import dto.Transaccion;
import dto.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.log4j.LogManager;

/**
 *
 * @author Uway
 */
public class TransaccionDaoSqlServer extends TransaccionDao {

    private static final org.apache.log4j.Logger logger = LogManager.getRootLogger();

    public int insert(Transaccion obj) throws Exception {
        int id = 0;
        try {
            Conexion objConexion = Conexion.getOrCreate();

            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("exec InsertarTransaccion ?,?,?,?,?,?");
            ps.setFloat(1, obj.getMonto());
            ps.setString(2, obj.getFecha());
            ps.setInt(3, obj.getFK_idCategoria());
            ps.setInt(4, obj.getFk_idcuenta());
            ps.setString(5, obj.getTipo());
            ps.setString(6, obj.getHora());
            int rpt = ps.executeUpdate();
            ps.getMoreResults();
            if (rpt == 1) {
                System.out.println("insertado");
            }
            objConexion.desconectar();

        } catch (SQLException e) {
            logger.error(e + "error al insertar");
        }
        return id;

    }

    @Override
    public void update(Transaccion obj) throws Exception {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC [actualizarTransaccion] ?,?,?,?,?,?,?");
            ps.setInt(1, obj.getIdTransaccion());
            ps.setString(2, obj.getFecha());
            ps.setString(3, obj.getHora());
            ps.setString(4, obj.getTipo());
            ps.setFloat(5, obj.getMonto());
            ps.setInt(6, obj.getFk_idcuenta());
            ps.setInt(7, obj.getFK_idCategoria());
            int rpt = ps.executeUpdate();
            ps.getMoreResults();
            if (rpt == 1) {
                JOptionPane.showMessageDialog(null, "Tu cuenta fue editada");
                System.out.println("editado");
            }
            objConexion.desconectar();
        } catch (SQLException e) {
            logger.error("error al actualizar "+e);
        }

    }

    @Override
    public void delete(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC [eliminarTransaccion] ?");
            ps.setInt(1, id);
            int rpt = ps.executeUpdate();
            ps.getMoreResults();
            if (rpt == 1) {
                JOptionPane.showMessageDialog(null, "se elimino transaccion");
                logger.info("eliminado con exito");
                System.out.println("eliminado");
            } else if (rpt == 0) {
                System.out.println("no eliminado");
                JOptionPane.showMessageDialog(null, "eliminado");
                objConexion.desconectar();
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "no se puede eliminar");
            logger.error("error al eliminar "+ex);
        }
    }

    @Override
    public ArrayList<Transaccion> getList() {
        ArrayList<Transaccion> registros = new ArrayList<Transaccion>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "exec SeleccionarTransaccion";
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            while (objResultSet.next()) {

                Transaccion obj = new Transaccion();
                int _transaccionId = objResultSet.getInt("idtransaccion");
                obj.setIdTransaccion(_transaccionId);

                int _monto = objResultSet.getInt("monto");
                obj.setMonto(_monto);

                String _fecha = objResultSet.getString("fecha");
                obj.setFecha(_fecha);

                int _idcategoria = objResultSet.getInt("idcatergoria");
                obj.setFK_idCategoria(_idcategoria);

                int _idcuenta = objResultSet.getInt("idcuenta");
                obj.setFk_idcuenta(_idcuenta);

                String _tipo = objResultSet.getString("tipo");
                obj.setTipo(_tipo);

                String _hora = objResultSet.getString("hora");
                obj.setHora(_hora);

                registros.add(obj);
            }
        } catch (SQLException ex) {
            
            logger.error("error "+ex);
        }
        return registros;
    }

    public ArrayList<Transaccion> getListFecha(String fecha, int id) {
        ArrayList<Transaccion> registros = new ArrayList<Transaccion>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "exec buscarTransaccionFecha " + "'" + fecha + "'," + id + "";
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            while (objResultSet.next()) {

                Transaccion obj = new Transaccion();
                int _transaccionId = objResultSet.getInt("idtransaccion");
                obj.setIdTransaccion(_transaccionId);

                int _monto = objResultSet.getInt("monto");
                obj.setMonto(_monto);

                String _fecha = objResultSet.getString("fecha");
                obj.setFecha(_fecha);

                int _idcategoria = objResultSet.getInt("idcatergoria");
                obj.setFK_idCategoria(_idcategoria);

                int _idcuenta = objResultSet.getInt("idcuenta");
                obj.setFk_idcuenta(_idcuenta);

                String _tipo = objResultSet.getString("tipo");
                obj.setTipo(_tipo);

                String _hora = objResultSet.getString("hora");
                obj.setHora(_hora);

                registros.add(obj);
            }
        } catch (SQLException ex) {
            logger.error("error"+ex);
        }
        return registros;
    }

    @Override
    public Transaccion get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "exec selectbyId " + id;
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            if (objResultSet.next()) {
                Transaccion obj = new Transaccion();

                int _transaccionId = objResultSet.getInt("idtransaccion");
                obj.setIdTransaccion(_transaccionId);

                int _monto = objResultSet.getInt("monto");
                obj.setMonto(_monto);

                String _fecha = objResultSet.getString("fecha");
                obj.setFecha(_fecha);

                int _idcategoria = objResultSet.getInt("idcatergoria");
                obj.setFK_idCategoria(_idcategoria);

                int _idcuenta = objResultSet.getInt("idcuenta");
                obj.setFk_idcuenta(_idcuenta);

                String _tipo = objResultSet.getString("tipo");
                obj.setTipo(_tipo);

                String _hora = objResultSet.getString("hora");
                obj.setHora(_hora);
                return obj;
            }
        } catch (SQLException ex) {
            logger.error("Error"+ex);
        }
        return null;
    }
}
