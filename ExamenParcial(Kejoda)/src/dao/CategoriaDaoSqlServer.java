/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.Conexion;
import dto.Categoria;
import dto.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class CategoriaDaoSqlServer extends CategoriaDao {

    @Override
    public int insert(Categoria obj) throws Exception {

        Conexion objConexion = Conexion.getOrCreate();
        int id = 0;
        PreparedStatement ps = objConexion.getObjConnection().prepareStatement("exec insertarcategoria ?,?");
        ps.setString(1, obj.getNombreCategoria());
        ps.setString(2, obj.getDescripcion());
//        id = objConexion.ejecutarInsert(ps.toString());
        int rpt = ps.executeUpdate();
        ps.getMoreResults();
        if (rpt == 1) {
            System.out.println("insertado");
        }
        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(Categoria obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Categoria> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT idcategoria, nombrecategoria, descripcion FROM tblcategoria WHERE idcategoria = " + id;
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            if (objResultSet.next()) {
                Categoria obj = new Categoria();
                int _categoriaId = objResultSet.getInt("idcategoria");
                obj.setCategoriaId(_categoriaId);

                String _nombrecategoria = objResultSet.getString("nombrecategoria");
                obj.setNombreCategoria(_nombrecategoria);

                String _descripcion = objResultSet.getString("descripcion");
                obj.setDescripcion(_descripcion);

                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }

}
