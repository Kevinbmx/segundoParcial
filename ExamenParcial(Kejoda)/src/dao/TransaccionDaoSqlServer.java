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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Uway
 */
public class TransaccionDaoSqlServer extends TransaccionDao {

    public int insert(Transaccion obj) throws Exception {

        Conexion objConexion = Conexion.getOrCreate();
        int id = 0;
        PreparedStatement ps = objConexion.getObjConnection().prepareStatement("exec InsertarTransaccion ?,?,?,?,?,?");
        ps.setFloat(1,obj.getMonto());
        ps.setString(2, obj.getFecha());
        ps.setInt(3, obj.getFK_idCategoria());
        ps.setInt(4, obj.getFk_idcuenta());
        ps.setString(5, obj.getTipo());
        ps.setString(6,obj.getHora());
        int rpt = ps.executeUpdate();
        ps.getMoreResults();
        if (rpt == 1) {
            System.out.println("insertado");
        }
        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(Transaccion obj) throws Exception {
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
        objConexion.desconectar(); }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return registros;
    }
 public ArrayList<Transaccion> getListFecha(String fecha, int id) {
        ArrayList<Transaccion> registros = new ArrayList<Transaccion>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "exec buscarTransaccionFecha "+"'"+fecha+"',"+id+"";
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
        } catch (Exception ex) {
            ex.printStackTrace();
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
        } catch (Exception ex) {
            ;
        }
        return null;
    }
}
