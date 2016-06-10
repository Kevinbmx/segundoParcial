package dao;

import dal.Conexion;
import dto.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDaoSqlServer extends UsuarioDao {

    @Override
    public int insert(Usuario obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();
        int id = 0;
        StringBuilder query = new StringBuilder("INSERT INTO tblUsuarios (nombreusuario, telefono) VALUES (");
        query.append("'" + obj.getNombre() + "',");
        query.append("'" + obj.getTelefono() + "' ");
        query.append(")");
        id = objConexion.ejecutarInsert(query.toString());
        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(Usuario obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        StringBuilder query = new StringBuilder("UPDATE tblusuarios SET ");
        query.append("nombreusuarios = '" + obj.getNombre() + "',");
        query.append("telefono = '" + obj.getTelefono() + "' ");
        query.append("WHERE idusuario = " + obj.getUsuarioId());
        int upd = objConexion.ejecutarSimple(query.toString());
        if (upd == 0) {
            throw new Exception("El registro no pudo ser actualizado");
        }

        objConexion.desconectar();
    }

    @Override
    public void delete(int id) {
        Conexion objConexion = Conexion.getOrCreate();
        StringBuffer query = new StringBuffer("DELETE FROM tblusuarios ");
        query.append("WHERE idusuario = " + id);
        objConexion.ejecutarSimple(query.toString());
        objConexion.desconectar();
    }

    @Override
    public ArrayList<Usuario> getList() {
        ArrayList<Usuario> registros = new ArrayList<Usuario>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT idusuario, nombreusuario, telefono FROM tblusuarios";
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            while (objResultSet.next()) {
                Usuario obj = new Usuario();
                int _contactoId = objResultSet.getInt("idusuario");
                obj.setUsuarioId(_contactoId);

                String _nombre = objResultSet.getString("nombreusuario");
                obj.setNombre(_nombre);

                String _telefono = objResultSet.getString("telefono");
                obj.setTelefono(_telefono);

                registros.add(obj);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return registros;
    }

    @Override
    public Usuario get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT idusuario, nombreusuario, telefono FROM tblUsuarios WHERE idusuario = " + id;
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            if (objResultSet.next()) {
                Usuario obj = new Usuario();
                int _contactoId = objResultSet.getInt("idusuario");
                obj.setUsuarioId(_contactoId);

                String _nombre = objResultSet.getString("nombreusuario");
                obj.setNombre(_nombre);

                String _telefono = objResultSet.getString("telefono");
                obj.setTelefono(_telefono);

                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }

}
