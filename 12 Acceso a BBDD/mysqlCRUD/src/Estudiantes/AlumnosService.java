package Estudiantes;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import dataset.DataSetInterface;

public class AlumnosService extends ModelService<Alumno> {
    
	public AlumnosService(Connection conn){
        super(conn);
    }

	// Creamos el nombre de la tabla
	@Override
	protected String getTableName() {
		return "alumnos";
	}

	// Creamos los campos que queremos seleccionar
	@Override
	protected String getSelectColumns() {
		return "id, nombre, apellidos, grupo_id";
	}

	// Pasamos de ResultSet (la fila que devuelve la consulta) a un objeto Alumno
	@Override
	protected Alumno resultSetToObject(ResultSet rs) throws SQLException {
		long id = rs.getLong("id");
		String nombre = rs.getString("nombre");
		String apellidos = rs.getString("apellidos");
		Long grupo_id = rs.getLong("grupo_id") == 0 ? null : rs.getLong("grupo_id");
		return new Alumno(id, nombre, apellidos, grupo_id);
	}

	// Creamos la sentencia INSERT con ?, sin el id si es autoincremental
	@Override
	protected String getInsertSql() {
		return "INSERT INTO alumnos(nombre, apellidos, grupo_id) VALUES(?, ?, ?)";
	}

	// Rellenamos el PreparedStatement de INSERT a partir del Alumno
	@Override
	protected void fillInsertStatement(PreparedStatement prepst, Alumno alumno) throws SQLException {
		prepst.setString(1, alumno.getNombre());
		prepst.setString(2, alumno.getApellidos());
		if (alumno.getGrupoId() == null)
			prepst.setNull(3, Types.INTEGER);
		else
			prepst.setLong(3, alumno.getGrupoId());
	}

	// Creamos la sentencia UPDATE
	@Override
	protected String getUpdateSql() {
		return "UPDATE alumnos SET nombre = ?, apellidos = ?, grupo_id = ? WHERE id = ?";
	}

	// Rellenamos el PreparedStatement de UPDATE a partir del objeto
	@Override
	protected void fillUpdateStatement(PreparedStatement prepst, Alumno alumno) throws SQLException {
		prepst.setString(1, alumno.getNombre());
		prepst.setString(2, alumno.getApellidos());
		if (alumno.getGrupoId() == null)
			prepst.setNull(3, Types.INTEGER);
		else
			prepst.setLong(3, alumno.getGrupoId());
		prepst.setLong(4, alumno.getId());
	}

	// Creamos el Alumno a partir de una línea CSV
	@Override
	protected Alumno fromCsvLine(String line) throws Exception {
		return new Alumno(line);
	}
}
