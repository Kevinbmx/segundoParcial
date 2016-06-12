/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.Conexion;
import dto.Categoria;
import dto.Cuenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class CuentaDaoSqlServer extends CuentaDao {

    ArrayList<Cuenta> cuenta;
    private float montototal;

    @Override
    public int insert(Cuenta obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();
        int id = 0;
        PreparedStatement ps = objConexion.getObjConnection().prepareStatement("exec insertarcuentas ?,?,?");
        ps.setFloat(1, obj.getMonto());
        ps.setString(2, obj.getNombreCuenta());
        ps.setInt(3, obj.getUsuarioId());
        int rpt = ps.executeUpdate();
        ps.getMoreResults();
        if (rpt == 1) {
            System.out.println("insertado");
        }
        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(Cuenta obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();
        PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC [actualizarcuenta] ?,?,?,?");
        ps.setInt(1, obj.getCuentaId());
        ps.setFloat(2, obj.getMonto());
        ps.setString(3, obj.getNombreCuenta());
        ps.setInt(4, obj.getUsuarioId());
        int rpt = ps.executeUpdate();
        ps.getMoreResults();
        if (rpt == 1) {
            JOptionPane.showMessageDialog(null, "Tu cuenta fue editada");
            System.out.println("editado");
        }
        objConexion.desconectar();
    }

    @Override
    public void delete(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC [eliminarcuenta] ?");
            ps.setInt(1, id);
            int rpt = ps.executeUpdate();
            ps.getMoreResults();
            if (rpt == 1) {
                JOptionPane.showMessageDialog(null, "Tu cuenta fue eliminada");
                System.out.println("eliminado");
            } else if (rpt==0) {
                System.out.println("no eliminado");
                JOptionPane.showMessageDialog(null, "Tu cuenta no pudo ser eliminada /n"
                        + "puede estar utilizasa por una transferencia o transaccion");
                objConexion.desconectar();
            }
        } catch (SQLException ex) {
        }
    }

    @Override
    public ArrayList<Cuenta> getList() {

        cuenta = new ArrayList<Cuenta>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "select*from [fn_listatablacuenta]()";
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            while (objResultSet.next()) {
                Cuenta obj = new Cuenta();
                int _cuentaId = objResultSet.getInt("idcuenta");
                obj.setCuentaId(_cuentaId);

                String _nombre = objResultSet.getString("nombrecuenta");
                obj.setNombreCuenta(_nombre);

                int _monto = objResultSet.getInt("montototal");
                obj.setMonto(_monto);

                cuenta.add(obj);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cuenta;
    }

    @Override
    public Cuenta get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "select*from [fn_cuentaid](" + id + ")";
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            if (objResultSet.next()) {
                Cuenta obj = new Cuenta();
                int _cuentaId;
                _cuentaId = objResultSet.getInt("idcuenta");
                obj.setCuentaId(_cuentaId);

                float _monto = objResultSet.getFloat("montototal");
                obj.setMonto(_monto);

                String _nombre = objResultSet.getString("nombrecuenta");
                obj.setNombreCuenta(_nombre);

                int _idusuario = objResultSet.getInt("idusuario");
                obj.setUsuarioId(_idusuario);
                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }

    public float getMontototal() {
        return montototal;
    }

    public void setMontototal(float montototal) {
        this.montototal = montototal;
    }

    @Override
    public float montoTotal() {
        Conexion objConexion = Conexion.getOrCreate();
        String query = "select sum(montototal)as total from tblCuenta ";
        float resultado = objConexion.ejecutarSimple(query);
        objConexion.desconectar();
        return resultado;
    }

    @Override
    public Cuenta obtenernobbreid(String nombrecuenta) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "select*from [fn_cuentanombreid] ('" + nombrecuenta + "')";
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            if (objResultSet.next()) {
                Cuenta obj = new Cuenta();
                int _cuentaId;
                _cuentaId = objResultSet.getInt("idcuenta");
                obj.setCuentaId(_cuentaId);
                String _nombrecuenta = objResultSet.getString("nombrecuenta");
                obj.setNombreCuenta(_nombrecuenta);
                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }

}
