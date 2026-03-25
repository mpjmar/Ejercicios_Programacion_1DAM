package centro_educativo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class AlumnosService {

	// Pasamos de ResultSet (la fila que devuelve la consulta) a un objeto Alumno
	protected Alumno resultSetToObject(ResultSet rs) throws SQLException {
		long id = rs.getLong("id");
		String nombre = rs.getString("nombre");
		String apellidos = rs.getString("apellidos");
		Long grupo_id = rs.getLong("grupo_id") == 0 ? null : rs.getLong("grupo_id");
		return new Alumno(id, nombre, apellidos, grupo_id);
	}

	// Rellenamos el PreparedStatement de INSERT a partir del Alumno
	protected void fillInsertStatement(PreparedStatement prepst, Alumno alumno) throws SQLException {
		prepst.setString(1, alumno.getNombre());
		prepst.setString(2, alumno.getApellidos());
		if (alumno.getGrupoId() == null)
			prepst.setNull(3, Types.INTEGER);
		else
			prepst.setLong(3, alumno.getGrupoId());
	}

	// Rellenamos el PreparedStatement de UPDATE a partir del objeto
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
	protected Alumno fromCsvLine(String line) throws Exception {
		return new Alumno(line);
	}
}
