package Estudiantes;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dataset.DataSetInterface;

public class GruposService extends ModelService<Grupo> {
    
    public GruposService(Connection conn){
        super(conn);
    }

	// Nombre de la tabla
	@Override
	protected String getTableName() {

	}

	// Columnas que queremos seleccionar
	@Override
	protected String getSelectColumns() {

	}

	// Pasamos de ResultSet (la fila que devuelve la consulta) a un objeto Grupo
	@Override
	protected T resultSetToObject(ResultSet rs) throws SQLException {

	}

	// SQL para INSERT con ?, sin el id si es autoincremental
	@Override
	protected String getInsertSql() {

	}

	// Rellenamos el PreparedStatement de INSERT a partir del Grupo
	@Override
	protected void fillInsertStatement(PreparedStatement prepst, T object) throws SQLException {

	}

	// Generamos el SQL para UPDATE
	@Override
	protected String getUpdateSql() {

	}

	// Rellenamos el PreparedStatement de UPDATE a partir del Grupo
	@Override
	protected void fillUpdateStatement(PreparedStatement prepst, T object) throws SQLException {

	}

	// Creamos el Grupo a partir de una línea CSV
	@Override
	protected T fromCsvLine(String line) throws Exception {

	}
}
