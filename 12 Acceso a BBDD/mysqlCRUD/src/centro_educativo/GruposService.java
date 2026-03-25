package centro_educativo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GruposService {

	// Pasamos de ResultSet (la fila que devuelve la consulta) a un objeto Grupo
	@Override
	protected Grupo resultSetToObject(ResultSet rs) throws SQLException {
		long id = rs.getLong("id");
		String nombre = rs.getString("nombre");
		String profesor = rs.getString("profesor");

		return new Grupo(id, nombre, profesor);
	}

	// Rellenamos el PreparedStatement de INSERT a partir del Grupo
	@Override
	protected void fillInsertStatement(PreparedStatement prepst, Grupo grupo) throws SQLException {
		prepst.setString(1, grupo.getNombre());
		prepst.setString(2, grupo.getProfesor());
	}

	// Rellenamos el PreparedStatement de UPDATE a partir del Grupo
	@Override
	protected void fillUpdateStatement(PreparedStatement prepst, Grupo grupo) throws SQLException {
		prepst.setString(1, grupo.getNombre());
		prepst.setString(2, grupo.getProfesor());
		prepst.setLong(3, grupo.getId());
	}

	// Creamos el Grupo a partir de una línea CSV
	@Override
	protected Grupo fromCsvLine(String line) throws Exception {
		return new Grupo(line);
	}
}
