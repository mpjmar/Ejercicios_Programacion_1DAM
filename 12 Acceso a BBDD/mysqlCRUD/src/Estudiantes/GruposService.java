package Estudiantes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;

import dataset.DataSetInterface;

public class GruposService implements CRUD<Grupo>, DataSetInterface {
    
	Connection conn;

    public GruposService(Connection conn){
        this.conn = conn;
    }

    public ArrayList<Grupo> requestAll() throws SQLException{
        ArrayList<Grupo> result = new ArrayList<Grupo>();

		String sql = "SELECT id, nombre, profesor FROM grupos";
		PreparedStatement prepst = this.conn.prepareStatement(sql);
        
		// Ejecución de la consulta
        ResultSet querySet = prepst.executeQuery(sql);
        
		// Recorrido del resultado de la consulta
        while(querySet.next()) {
            int id = querySet.getInt("id");
            String nombre = querySet.getString("nombre");
            String profesor = querySet.getString("profesor");

			result.add(new Grupo(id, nombre, profesor));
        } 
        prepst.close();    
        return result;
    }

    public Grupo requestById(long id) throws SQLException{
        Grupo result = null;

		String sqlaux = String.format("SELECT id, nombre, profesor FROM grupos WHERE id = ?");
		PreparedStatement prepst = this.conn.prepareStatement(sqlaux);
		prepst.setLong(1, id);

        // Ejecución de la consulta
        ResultSet querySet = prepst.executeQuery();

        // Recorrido del resultado de la consulta
        if(querySet.next()) {
            String nombre = querySet.getString("nombre");
            String profesor = querySet.getString("profesor");

			result = new Grupo(id, nombre, profesor);
        }
        prepst.close();
        return result;
    }

    public long create(Grupo grupo) throws SQLException{
		String sqlaux = String.format("INSERT INTO grupos (nombre, profesor) VALUES (?, ?)");
		PreparedStatement prepst = this.conn.prepareStatement(sqlaux, Statement.RETURN_GENERATED_KEYS);
		prepst.setString(1, grupo.getNombre());
		prepst.setString(2, grupo.getProfesor());

        // Ejecución de la consulta
		prepst.execute();

		ResultSet keys = prepst.getGeneratedKeys();
		if (keys.next()) {
			long id = keys.getLong(1);
			prepst.close();
			return id;
		}
		else {
			prepst.close();
			throw new SQLException("Creating group failed, no rows affected.");
		}
    }

    public int update(Grupo grupo) throws SQLException{
        String sqlaux = String.format("UPDATE grupos SET nombre = ?, profesor = ? WHERE id = ?");
		PreparedStatement prepst = this.conn.prepareStatement(sqlaux);
		prepst.setString(1, grupo.getNombre());
		prepst.setString(2, grupo.getProfesor());
		prepst.setLong(3, grupo.getId());

        // Ejecución de la consulta
		int affectedRows = prepst.executeUpdate();
		prepst.close();

        if (affectedRows == 0)
            throw new SQLException("Creating group failed, no rows affected.");
        else
            return affectedRows;
    }

    public boolean delete(long id) throws SQLException{
		String sqlaux = String.format("DELETE FROM grupos WHERE id = ?");
		PreparedStatement prepst = this.conn.prepareStatement(sqlaux);
		prepst.setLong(1, id);

        // Ejecución de la consulta
        int result = prepst.executeUpdate();
        prepst.close();
        return result == 1;
    }

    @Override
    public void importFromCSV(String file) throws Exception {
        BufferedReader br = null;
        PreparedStatement prep = null;
        try {
            br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
            String line = "";
            while((line = br.readLine()) != null){
                Grupo gr = new Grupo(line);
                String sql = "INSERT INTO grupos (id, nombre, profesor) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE nombre=VALUES(nombre), profesor=VALUES(profesor)";
                prep = this.conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                prep.setInt(1, (int)gr.id);
                prep.setString(2, gr.nombre);
                prep.setString(3, gr.profesor);
                prep.execute();
            }    
        } catch (IOException e) {
            throw new Exception("Ocurrión un error de E/S"+ e.toString());
        } catch (SQLTimeoutException e){
            throw new Exception("Ocurrión un error al acceder a la base de datos"+ e.toString());
        } catch (SQLException e){
            throw new Exception("Ocurrión un error al acceder a la base de datos"+ e.toString());
        } catch (Exception e){
            throw new Exception("Ocurrión un error "+ e.toString());
        } finally {
            if(prep != null)
                prep.close();
            if(br != null)
                br.close();
        }
    }

    @Override
    public void exportToCSV(String file) throws Exception {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8));
            ArrayList<Grupo> grupos = this.requestAll();
            for(Grupo gr : grupos){
                bw.write(gr.serialize() + "\n");
            }
            bw.close();
        } catch(IOException e){
            throw new Exception("Ocurrión un error de E/S "+ e.toString());
        } catch(SQLException e){
            throw new Exception("Ocurrión un error al acceder a la base de datos "+ e.toString());
        }catch (Exception e) {
            throw new Exception("Ocurrión un error "+ e.toString());
        } finally {
            if(bw!=null)
                bw.close();
        }
    }
}
