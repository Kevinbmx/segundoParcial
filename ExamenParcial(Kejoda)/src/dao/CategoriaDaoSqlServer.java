/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.Conexion;
import dto.Categoria;
import dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class CategoriaDaoSqlServer extends CategoriaDao {

    ArrayList<Categoria> categorias;

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

        categorias = new ArrayList<Categoria>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "select*from [fn_listatablacategoria]()";
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            while (objResultSet.next()) {
                Categoria obj = new Categoria();
                int _categoriaId = objResultSet.getInt("idcategoria");
                obj.setCategoriaId(_categoriaId);

                String _nombre = objResultSet.getString("nombrecategoria");
                obj.setNombreCategoria(_nombre);

                String _descripcion = objResultSet.getString("descripcion");
                obj.setDescripcion(_descripcion);

                categorias.add(obj);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return categorias;
    }

    @Override
    @SuppressWarnings("empty-statement")
    public Categoria get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "select*from [fn_categoriaid] (" + id + ")";
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            if (objResultSet.next()) {
                Categoria obj = new Categoria();
                int _categoriaId;
                _categoriaId = objResultSet.getInt("idcategoria");
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

    @Override
    public ArrayList<Categoria> ListCategoria() {
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "select*from [fn_listacategoria]()";
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            while (objResultSet.next()) {
                Categoria obj = new Categoria();
                categorias.add(obj);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return categorias;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

}
