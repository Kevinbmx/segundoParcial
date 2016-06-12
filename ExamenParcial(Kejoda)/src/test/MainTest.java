package test;

import dal.Conexion;
import dao.CategoriaDao;
import dao.CuentaDao;

import dao.UsuarioDao;
import dto.Categoria;
import dto.Cuenta;
import dto.Usuario;
import factory.FactoryDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainTest {

    public static void main(String[] args) {

        try {

//            CategoriaDao objDao = FactoryDao.getFactoryInstance().getNewCategoriaDao();
//            Categoria obj = new Categoria();
//            obj.setNombreCategoria("aloja3");
//            obj.setDescripcion("de casa a la Universidad");
//
//            int id = objDao.insert(obj);
//
//            obj = objDao.get(1);
//
//            System.out.println("Id:" + obj.getCategoriaId()
//                    + " | Nombrecategoria: " + obj.getNombreCategoria()
//                    + " | descripcion: " + obj.getDescripcion());
//            CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
//            Cuenta obj = new Cuenta();
//            obj.setCuentaId(0);
//            obj = objDao.update();
//            System.out.println(" "+obj.getNombreCuenta());
//            UsuarioDao objDao = FactoryDao.getFactoryInstance().getNewUsuarioDao();
//            Usuario obj = new Usuario();
//            obj.setNombre("juan perez");
//            obj.setTelefono("7265842");
//
//            int id = objDao.insert(obj);
//
//            obj = objDao.get(id);
//
//            System.out.println("Id: " + obj.getUsuarioId()
//                    + " | Nombre: " + obj.getNombre()
//                    + " | Telefono: " + obj.getTelefono());
//            CategoriaDao objDao = FactoryDao.getFactoryInstance().getNewCategoriaDao();
//            Categoria obj = new Categoria();
//            obj=objDao.get(12);
//            System.out.println("nombre"+ obj.getNombreCategoria());
            CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
             Cuenta obj = new Cuenta();
            obj.setCuentaId(1);
            obj.setNombreCuenta("halor");
            obj.setMonto(3002);
            obj.setUsuarioId(1);
            
            objDao.update(obj);
             System.out.println(" "+obj.getNombreCuenta());
            System.out.println("entro");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
