
package centro_educativo;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interfaz genérica para operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre modelos de base de datos.
 * Permite definir métodos estándar para manipular entidades de cualquier tipo.
 *
 * @param <T> Tipo de entidad que extiende MySerializer
 */
public interface CRUD<T> {

    /**
     * Obtiene todos los registros de la tabla especificada y los devuelve como una lista de objetos del modelo.
     *
	 * @param tableName Nombre de la tabla en la base de datos.
     * @param columns   Array con los nombres de las columnas a recuperar.
     * @return Lista de objetos del modelo recuperados de la base de datos.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    ArrayList<T> requestAll( String tableName, String[] column) throws SQLException;

    /**
     * Obtiene un registro del modelo dado su identificador (clave primaria).
     *
     * @param tableName Nombre de la tabla en la base de datos.
     * @param columns   Array con los nombres de las columnas a recuperar (el primero debe ser la clave primaria).
     * @param id        Valor de la clave primaria del registro a buscar.
     * @return Objeto del modelo correspondiente al registro encontrado, o null si no existe.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    T requestById(String tableName, String[] columns, long id) throws SQLException;

    /**
     * Crea un nuevo registro en la base de datos para el modelo especificado.
     *
     * @param tableName Nombre de la tabla en la base de datos.
     * @param columns   Array con los nombres de las columnas a insertar.
     * @param object    Objeto del modelo a insertar.
     * @return El identificador generado para el nuevo registro.
     * @throws SQLException Si ocurre un error al insertar el registro.
     */
    long create(String tableName, String[] columns, T object) throws SQLException;

    /**
     * Actualiza la información de un registro existente en la base de datos.
     *
     * @param tableName Nombre de la tabla en la base de datos.
     * @param columns   Array con los nombres de las columnas a actualizar (el primero debe ser la clave primaria).
     * @param object    Objeto del modelo con los nuevos valores.
     * @return El número de registros afectados (debería ser 1 si la actualización fue exitosa).
     * @throws SQLException Si ocurre un error al actualizar el registro.
     */
    int update(String tableName, String[] columns, T object) throws SQLException;

    /**
     * Elimina un registro del modelo dado su identificador (clave primaria).
     *
     * @param tableName Nombre de la tabla en la base de datos.
     * @param id        Valor de la clave primaria del registro a eliminar.
     * @return true si el registro fue eliminado correctamente, false en caso contrario.
     * @throws SQLException Si ocurre un error al eliminar el registro.
     */
    boolean delete(String tableName, long id) throws SQLException;
}
