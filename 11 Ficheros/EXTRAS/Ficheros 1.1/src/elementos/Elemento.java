package elementos;
public class Elemento <T> {
	
	private int id;
	private String nombre;
	private T informacion;

	public Elemento(int id, String nombre, T informacion) {
		this.id = id;
		this.nombre = nombre;
		this.informacion = informacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public T getInformacion() {
		return informacion;
	}

	public void setInformacion(T informacion) {
		this.informacion = informacion;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + " Nombre: " + this.nombre + " Información: " + this.informacion;
	}

	public T getInfo() {
		return informacion;
	}
}
