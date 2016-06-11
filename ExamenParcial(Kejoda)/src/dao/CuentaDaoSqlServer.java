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
import java.util.ArrayList;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            String query = "select*from [fn_cuentaid] (" + id + ")";
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            if (objResultSet.next()) {
                Cuenta obj = new Cuenta();
                float _categoriaId;
                _categoriaId = objResultSet.getInt("idcategoria");
                obj.setMonto(_categoriaId);

                String _nombrecuenta = objResultSet.getString("nombrecategoria");
                obj.setNombreCuenta(_nombrecuenta);

                int _idusuario = objResultSet.getInt("descripcion");
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
    public float montoTotal(Cuenta obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cuenta obtenernobbreid(String nombrecuenta) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "select*from [fn_categorianombreid] (" + nombrecuenta + ")";
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            if (objResultSet.next()) {
                Cuenta obj = new Cuenta();
                int _cuentaId;
                _cuentaId = objResultSet.getInt("idcategoria");
                obj.setCuentaId(_cuentaId);
                String _nombrecuenta = objResultSet.getString("nombrecategoria");
                obj.setNombreCuenta(_nombrecuenta);
                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }

}
