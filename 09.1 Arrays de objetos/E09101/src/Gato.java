public class Gato {
	
	private String nombre;
	private String color;
	private String raza;
	private int numero;
	public static int orden = 0;

	public Gato(String nombre, String color, String raza) {
		this.nombre = nombre;
		this.color = color;
		this.raza = raza;
		this.numero = ++orden;
	}

	public Gato() {
		this.numero = ++orden;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getNumero() {
		return this.numero;
	}

	@Override
	public String toString() {
		return String.format("Gato nº %d%nNombre: %s%nColor: %s%nRaza: %s%n%n",
			numero, nombre, color, raza);
	}
}
