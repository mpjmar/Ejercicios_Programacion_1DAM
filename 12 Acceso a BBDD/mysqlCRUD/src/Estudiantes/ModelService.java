package Estudiantes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;

import dataset.DataSetInterface;

public abstract class ModelService<T extends MySerializer> implements CRUD<T>, DataSetInterface{

    protected Connection conn;

    public ModelService(Connection conn) {
        this.conn = conn;
    }

    /* ====================== Métodos que define cada subclase ====================== */

    // Nombre de la tabla
    protected abstract String getTableName();

    // Columnas que queremos seleccionar 
    protected abstract String getSelectColumns();

    // Pasamos de ResultSet (una fila) a un objeto T
    protected abstract T resultSetToObject(ResultSet rs) throws SQLException;

    // Nombre de la columna ID. Normalmente "id"
    protected String getIdColumnName() {
        return "id";
    }

    // Generamos SQL para INSERT con ?, sin el id si es autoincremental
    protected abstract String getInsertSql();

    // Rellenamos el PreparedStatement de INSERT a partir del objeto
    protected abstract void fillInsertStatement(PreparedStatement prepst, T object) throws SQLException;

    // Generamos SQL para UPDATE
    protected abstract String getUpdateSql();

    // Rellenamos el PreparedStatement de UPDATE a partir del objeto
    protected abstract void fillUpdateStatement(PreparedStatement prepst, T object) throws SQLException;

    // Creamos la entidad a partir de una línea CSV
    protected abstract T fromCsvLine(String line) throws Exception;

    /* ============================== CRUD genérico ============================== */

    public ArrayList<T> requestAll() throws SQLException {
        ArrayList<T> result = new ArrayList<>();

        String sql = "SELECT " + getSelectColumns() + " FROM " + getTableName();
        PreparedStatement prepst = this.conn.prepareStatement(sql);
        ResultSet rs = prepst.executeQuery();

        while (rs.next()) {
            result.add(resultSetToObject(rs));
        }

        rs.close();
        prepst.close();
        return result;
    }

    public T requestById(long id) throws SQLException {
        T result = null;
        String sql = "SELECT " + getSelectColumns()
                   + " FROM " + getTableName()
                   + " WHERE " + getIdColumnName() + " = ?";

        PreparedStatement prepst = this.conn.prepareStatement(sql);
        prepst.setLong(1, id);

        ResultSet querySet = prepst.executeQuery();
        if (querySet.next()) {
            result = resultSetToObject(querySet);
        }

        querySet.close();
        prepst.close();
        return result;
    }

    public long create(T object) throws SQLException {
        String sql = getInsertSql();
        PreparedStatement prepst = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        fillInsertStatement(prepst, object);

        int affectedRows = prepst.executeUpdate();
        if (affectedRows == 0) {
            prepst.close();
            throw new SQLException("Creating object failed, no rows affected.");
        }

        ResultSet keys = prepst.getGeneratedKeys();
        if (keys.next()) {
            long id = keys.getLong(1);
            keys.close();
            prepst.close();
            return id;
        } else {
            keys.close();
            prepst.close();
            throw new SQLException("Creating object failed, no ID obtained.");
        }
    }

    public int update(T object) throws SQLException {
        String sql = getUpdateSql();
        PreparedStatement prepst = this.conn.prepareStatement(sql);

        fillUpdateStatement(prepst, object);

        int affectedRows = prepst.executeUpdate();
        prepst.close();

        return affectedRows;
    }

    public boolean delete(long id) throws SQLException {
        String sql = "DELETE FROM " + getTableName()
                   + " WHERE " + getIdColumnName() + " = ?";

        PreparedStatement prepst = this.conn.prepareStatement(sql);
        prepst.setLong(1, id);

        int result = prepst.executeUpdate();
        prepst.close();

        return result == 1;
    }

    /* =========================== Import / Export CSV =========================== */

    public void importFromCSV(String file) throws Exception {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
            String line;
            while ((line = br.readLine()) != null) {
                T object = fromCsvLine(line);
                create(object);
            }
        } catch (IOException e) {
            throw new Exception("Ocurrió un error de E/S " + e.toString());
        } catch (SQLTimeoutException e) {
            throw new Exception("Ocurrió un error al acceder a la base de datos " + e.toString());
        } catch (SQLException e) {
            throw new Exception("Ocurrió un error al acceder a la base de datos " + e.toString());
        } catch (Exception e) {
            throw new Exception("Ocurrió un error " + e.toString());
        } finally {
            if (br != null) {
				br.close(); 
            }
        }
    }

    public void exportToCSV(String file) throws Exception {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8));
            ArrayList<T> list = this.requestAll();
            for (T object : list) {
                bw.write(object.serialize() + "\n");
            }
			bw.close();
        } catch (IOException e) {
            throw new Exception("Ocurrió un error de E/S " + e.toString());
        } catch (SQLException e) {
            throw new Exception("Ocurrió un error al acceder a la base de datos " + e.toString());
        } catch (Exception e) {
            throw new Exception("Ocurrió un error " + e.toString());
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }
}