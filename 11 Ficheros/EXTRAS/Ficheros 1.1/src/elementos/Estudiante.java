package elementos;
public class Estudiante extends Elemento<Integer> {
	
	private String email;

	public Estudiante(int id, String nombre, Integer informacion, String email) {
		super(id, nombre, informacion);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return super.toString() + " Email: " + email;
	}
}
