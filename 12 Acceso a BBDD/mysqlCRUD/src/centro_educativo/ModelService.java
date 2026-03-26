package centro_educativo;

import dataset.DataSetInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;

public class ModelService<T extends MySerializer> implements CRUD<T>, DataSetInterface{

    protected Connection conn;

    public ModelService(Connection conn) {
        this.conn = conn;
    }

    /* ============================== CRUD genérico ============================== */

    @Override
    public ArrayList<T> requestAll(String tableName, String[] columns) throws SQLException {
        ArrayList<T> result = new ArrayList<>();

		String sqlColumns = "";
		for (String s : columns)
			sqlColumns += s + ", ";
		sqlColumns = sqlColumns.substring(0, sqlColumns.length() - 2);
        String sql = String.format("SELECT %s FROM %s;", sqlColumns, tableName);

        PreparedStatement prepst = this.conn.prepareStatement(sql);
        ResultSet rs = prepst.executeQuery();

        while (rs.next()) {
            result.add(resultSetToObject(rs, tableName));
        }

        rs.close();
        prepst.close();
        return result;
    }

    @Override
    public T requestById(String tableName, String[] columns, long id) throws SQLException {
        T result = null;

		String sqlColumns = "";
		for (String s : columns)
			sqlColumns += s + ", ";
		sqlColumns = sqlColumns.substring(0, sqlColumns.length() - 2);
        String sql = String.format("SELECT %s FROM %s WHERE id = ?;", sqlColumns, tableName);

        PreparedStatement prepst = this.conn.prepareStatement(sql);
        prepst.setLong(1, id);

        ResultSet querySet = prepst.executeQuery();
        if (querySet.next()) {
            result = resultSetToObject(querySet, tableName);
        }

        querySet.close();
        prepst.close();
        return result;
    }

    @Override
    public long create(String tableName, String[] columns, T object) throws SQLException {
		String sqlColumns = "";
		String sqlValues = "";
		for (String s : columns) {
			sqlColumns += s + ", ";
			sqlValues += "?, ";
		}
		sqlColumns = sqlColumns.substring(0, sqlColumns.length() - 2);
		sqlValues = sqlValues.substring(0, sqlValues.length() - 2);
        String sql = String.format("INSERT INTO %s(%s) VALUES(%s);", tableName, sqlColumns, sqlValues);
        
		PreparedStatement prepst = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        fillInsertStatement(prepst, object);

        int affectedRows = prepst.executeUpdate();
        if (affectedRows == 0) {
            prepst.close();
            throw new SQLException("Creating object failed, no rows affected.");
        }

		// Obtenemos el ID generado por la BBDD
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

    @Override
    public int update(String tableName, String[] columns, T object) throws SQLException {
		String sqlColumns = "";
		for (String s : columns)
			sqlColumns += s + " = ?, ";
		sqlColumns = sqlColumns.substring(0, sqlColumns.length() - 2);
        String sql = String.format("UPDATE %s SET %s WHERE id = ?;", tableName, sqlColumns);

		PreparedStatement prepst = this.conn.prepareStatement(sql);

        fillUpdateStatement(prepst, object);

        int affectedRows = prepst.executeUpdate();
        prepst.close();

        return affectedRows;
    }

    @Override
    public boolean delete(String tableName, long id) throws SQLException {
        String sql = String.format("DELETE FROM %s WHERE id = ?;", tableName);
                   
        PreparedStatement prepst = this.conn.prepareStatement(sql);
        prepst.setLong(1, id);

        int result = prepst.executeUpdate();
        prepst.close();

        return result == 1;
    }

    /* =========================== Import / Export CSV =========================== */

    @Override
    public void importFromCSV(String file, String tableName, String[] columns) throws Exception {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
            String line;
            while ((line = br.readLine()) != null) {
                T object = fromCsvLine(line, tableName);
                create(tableName, columns, object);
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

    @Override
    public void exportToCSV(String file, String tableName, String[] columns) throws Exception {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8));
            ArrayList<T> list = this.requestAll(tableName, columns);
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

    /* =========================== OBJETOS =========================== */

    // Pasamos de ResultSet (una fila) a un objeto T
    private T resultSetToObject(ResultSet rs, String tableName) throws SQLException {
        switch (tableName) {
            case "alumno" -> { 
                Alumno alumno = new Alumno();
                alumno.resultSetToAlumno(rs);
                return (T) alumno ; 
            }
            case "grupo" -> {
                Grupo grupo = new Grupo();
                grupo.resultSetToGrupo(rs);
                return (T) grupo; 
            }
            default -> { 
                return null; 
            }
        }
    }

    // Rellenamos el PreparedStatement de INSERT a partir del objeto
    private void fillInsertStatement(PreparedStatement prepst, T object) throws SQLException {
        switch (object.getClass().getSimpleName().toLowerCase()) {
            case "alumno" -> { 
                Alumno alumno = (Alumno) object;
                prepst.setString(1, alumno.getNombre());
                prepst.setString(2, alumno.getApellidos());
                if (alumno.getGrupoId() == null)
                    prepst.setNull(3, Types.INTEGER);
                else
                    prepst.setLong(3, alumno.getGrupoId());
            }
            case "grupo" -> {
                Grupo grupo = (Grupo) object;
                prepst.setString(1, grupo.getNombre());
		        prepst.setString(2, grupo.getProfesor());
            }
            default -> { 
            }
        }
    }

    // Rellenamos el PreparedStatement de UPDATE a partir del objeto
    private void fillUpdateStatement(PreparedStatement prepst, T object) throws SQLException {
        switch (object.getClass().getSimpleName().toLowerCase()) {
            case "alumno" -> { 
                Alumno alumno = (Alumno) object;
                prepst.setString(1, alumno.getNombre());
                prepst.setString(2, alumno.getApellidos());
                if (alumno.getGrupoId() == null)
                    prepst.setNull(3, Types.INTEGER);
                else
                    prepst.setLong(3, alumno.getGrupoId());
                prepst.setLong(4, alumno.getId());
            }
            case "grupo" -> {
                Grupo grupo = (Grupo) object;
                prepst.setString(1, grupo.getNombre());
                prepst.setString(2, grupo.getProfesor());
                prepst.setLong(3, grupo.getId());
            }
            default -> { 
            }
        }
    }

    // Creamos la entidad a partir de una línea CSV
    private T fromCsvLine(String line, String tableName) throws Exception {
        switch (tableName) {
            case "alumno" -> { return (T) new Alumno(line); }
            case "grupo" -> { return (T) new Grupo(line); }
            default -> { return null; }
        }
	}
}