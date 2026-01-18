public class Linea {
	
	private Punto punto1;
	private Punto punto2;

	public Linea(Punto p1, Punto p2) {
		this.punto1 = p1;
		this.punto2 = p2;
	}

	@Override
	public String toString() {
		return "Línea formada por los puntos" + punto1.toString() + " y " + punto2.toString();
	}
}
