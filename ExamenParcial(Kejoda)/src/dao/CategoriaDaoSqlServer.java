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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.LogManager;

/**
 *
 * @author kevin
 */
public class CategoriaDaoSqlServer extends CategoriaDao {

    ArrayList<Categoria> categorias;
    private static final org.apache.log4j.Logger logger = LogManager.getRootLogger();

    @Override
    public int insert(Categoria obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();
        int id = 0;
        PreparedStatement ps = objConexion.getObjConnection().prepareStatement("exec insertarcategoria ?,?");
        ps.setString(1, obj.getNombreCategoria());
        ps.setString(2, obj.getDescripcion());
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
        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC [actualizarcategoria] ?,?,?");
            ps.setInt(1, obj.getCategoriaId());
            ps.setString(2, obj.getNombreCategoria());
            ps.setString(3, obj.getDescripcion());
            int rpt = ps.executeUpdate();
            ps.getMoreResults();
            if (rpt == 1) {
                JOptionPane.showMessageDialog(null, "Tu categoria fue editada");
                System.out.println("editado");
            }
            objConexion.desconectar();
            logger.info("actualizacion correctamente");
        } catch (Exception e) {
            logger.warn("no se actualizo correctamente");
        }
    }

    @Override
    public void delete(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            PreparedStatement ps = objConexion.getObjConnection().prepareStatement("EXEC [eliminarcategoria] ?");
            ps.setInt(1, id);
            int rpt = ps.executeUpdate();
            ps.getMoreResults();
            if (rpt == 1) {
                JOptionPane.showMessageDialog(null, "Tu categoria fue eliminada");
                  logger.info("tu categoria fue eliminada");
                System.out.println("eliminado");
            }
            System.out.println("no eliminado");
            objConexion.desconectar();
        } catch (SQLException ex) {
             logger.info("Tu categoria no puede ser eliminada por que esta siendo utilizada por alguna transaccion");
            JOptionPane.showMessageDialog(null, "Tu categoria no puede ser eliminada por que esta siendo utilizada por alguna transaccion");
        }
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
            logger.info("obtiene lista categoria");
        } catch (Exception ex) {
            logger.info("no obtiene lista categoria");
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
            logger.info("obtubo por id categoria");
        } catch (Exception ex) {
             logger.info("no obtubo por id categoria");
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

    @Override
    public Categoria obtenernombreid(String nombrecategoria) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "select*from [fn_categorianombreid] ('" + nombrecategoria + "')";
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            if (objResultSet.next()) {
                Categoria obj = new Categoria();
                int _categoriaId;
                _categoriaId = objResultSet.getInt("idcategoria");
                obj.setCategoriaId(_categoriaId);
                String _nombrecategoria = objResultSet.getString("nombrecategoria");
                obj.setNombreCategoria(_nombrecategoria);
                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;

    }

}
