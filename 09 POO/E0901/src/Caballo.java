public class Caballo {
	String nombre;
	String raza;
	String color;
	int edad;
	int carrerasGanadas;

	public Caballo (String nombre, String raza, String color, int edad, int carrerasGanadas) {
		this.nombre = nombre;
		this.raza = raza;
		this.color = color;
		this.edad = edad;
		this.carrerasGanadas = carrerasGanadas;
	}

	public void rumia() {
		System.out.println("Ñam ñam ñam.");
	}

	public void trota() {
		System.out.println("Tocotó tocotó tocotó.");
	}

	public void relincha() {
		System.out.println("Hiiiiiiii.");
	}

	public String getNombre() {
		return this.nombre;
	}
}
