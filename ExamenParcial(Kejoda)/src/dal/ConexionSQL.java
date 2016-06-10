package dal;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

class ConexionSQL extends Conexion {

    public static Conexion getOrCreate() {
        if (objSingleton == null) {
            objSingleton = new ConexionSQL();
        }
        return objSingleton;
    }

    private ConexionSQL() {
        Configuracion objConfiguracion
                = Configuracion.getConfiguracion();
        this.host = objConfiguracion.getDbHost();
        this.dataBase = objConfiguracion.getDbName();
        this.instance = objConfiguracion.getDbInstace();
        this.port = objConfiguracion.getDbPort();
        this.userName = objConfiguracion.getDbUser();
        this.password = objConfiguracion.getDbPassword();
    }

    public void conectar() {
        if (this.estaConectado()) {
            return;
        } else {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                String sUrl = "jdbc:sqlserver://" + this.host + ":" + this.port + ";"
                        + "databaseName= " + this.dataBase + ";";
                System.out.println(sUrl);
                objConnection = DriverManager.getConnection(sUrl, userName, password);
                if (objConnection == null) {
                    System.out.println("conexion fallida" + this.dataBase + this.password);
                } else {
                    System.out.println("conexion con exito " + this.dataBase);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void comenzarTransaccion() {
        if (!this.estaConectado()) {
            this.conectar();
        }

        try {
            objConnection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void terminarTransaccion() {
        try {
            objConnection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void desconectar() {
        try {
            if (this.estaConectado()) {
                objConnection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet ejecutarSelect(String query) {
        try {
            Statement stmt = objConnection.createStatement();
            ResultSet res = stmt.executeQuery(query);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean estaConectado() {
        if (this.objConnection == null) {
            return false;
        }
        try {
            if (this.objConnection.isClosed()) {
                return false;
            }
        } catch (SQLException e) {
            this.objConnection = null;
            return false;
        }
        return true;
    }

    public int ejecutarSimple(String query) {
        try {
            Statement stmt = objConnection.createStatement();
            int nb = stmt.executeUpdate(query);
            return nb;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int ejecutarInsert(String query) {
        try {
            Statement stmt = objConnection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("error al ejecutar" + e.toString());
//            e.printStackTrace();
            return 0;
        }
    }
}
