/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.Conexion;
import dto.Categoria;
import dto.Cuenta;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class CuentaDaoSqlServer extends CuentaDao {

    ArrayList<Cuenta> cuenta;

    @Override
    public int insert(Cuenta obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
