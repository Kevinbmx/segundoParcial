package dal;

import java.sql.ResultSet;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public interface IConexion {

    public void conectar();

    public void comenzarTransaccion();

    public void terminarTransaccion();

    public void desconectar();

    /**
     * Ejecuta el query pasado en parámetro. EL resultado es un objeto de tipo
     * ResultSet. Este objeto representa un resultado de varias columnas con
     * varios registros donde cada uno indica el tipo de registro que
     * representa.
     *
     * @param query La ocnsulta en sql estándar, exclusivamente de tipo Select
     * @return El resultado en forma de objeto.
     */
    public ResultSet ejecutarSelect(String query);

    /**
     * La ejecución de un query de tipo Update, insert o delete.
     *
     * @param query El query en parámetro
     * @return El número de filas que han sido afectadas.
     */
    public int ejecutarSimple(String query);

    /**
     * Ejecuta un query de tipo insert para cuando se desea recuperar el id del
     * registro que se ha insertado.
     *
     * @param query La consulta de tipo insert
     * @return El id (llave primaria) del registro
     */
    public int ejecutarInsert(String query);

    /**
     * Indica si la conexión se encuentra abierta. Si no, se la abre.
     *
     * @return true o false
     */
    public boolean estaConectado();

}
