package centro_educativo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GruposService extends ModelService<Grupo> {
    
    public GruposService(Connection conn){
        super(conn);
    }

	// Nombre de la tabla
	@Override
	protected String getTableName() {
		return "grupos";
	}

	// Columnas que queremos seleccionar
	@Override
	protected String getSelectColumns() {
		return "id, nombre, profesor";
	}

	// Pasamos de ResultSet (la fila que devuelve la consulta) a un objeto Grupo
	@Override
	protected Grupo resultSetToObject(ResultSet rs) throws SQLException {
		long id = rs.getLong("id");
		String nombre = rs.getString("nombre");
		String profesor = rs.getString("profesor");

		return new Grupo(id, nombre, profesor);
	}

	// SQL para INSERT con ?, sin el id si es autoincremental
	@Override
	protected String getInsertSql() {
		return "INSERT INTO grupos(nombre, profesor) VALUES(?, ?)";
	}

	// Rellenamos el PreparedStatement de INSERT a partir del Grupo
	@Override
	protected void fillInsertStatement(PreparedStatement prepst, Grupo grupo) throws SQLException {
		prepst.setString(1, grupo.getNombre());
		prepst.setString(2, grupo.getProfesor());
	}

	// Generamos la sentencia SQL para UPDATE
	@Override
	protected String getUpdateSql() {
		return "UPDATE grupos SET nombre = ?, profesor = ? WHERE id = ?";
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
