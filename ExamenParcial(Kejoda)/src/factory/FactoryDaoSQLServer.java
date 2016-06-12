package factory;

import dal.Configuracion;
import dao.*;

class FactoryDaoSQLServer extends FactoryDao {

    private FactoryDaoSQLServer() {
        dbEngine = "MySQL";
    }

    public static FactoryDao getFactoryInstance() {
        instancia = new FactoryDaoSQLServer();
        return instancia;
    }

    @Override
    public UsuarioDao getNewUsuarioDao() {
        return new UsuarioDaoSqlServer();
    }

    @Override
    public CategoriaDaoSqlServer getNewCategoriaDao() {
        return new CategoriaDaoSqlServer();
    }

    @Override
    public CuentaDao getNewCuentaDao() {
        return new CuentaDaoSqlServer();
    }

    @Override
    public TransaccionDao geTransaccionDao() {
        return new TransaccionDaoSqlServer();
    }

    @Override
    public TransferenciaDao geTransferenciaDao() {
        return new TransferenciaDaoSqlServer();
    }

}
