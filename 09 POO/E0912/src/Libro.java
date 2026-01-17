public class Libro extends Publicacion implements Prestable {
	
	private boolean prestado;

	public Libro(String isbn, String titulo, int anio) {
		super(isbn, titulo, anio);
		prestado = false;
	}

	@Override
	public void presta() {
		if (prestado)
			System.out.println("Lo siento, ese libro ya está prestado.");
		else
			prestado = true;
	}

	@Override
	public void devuelve() {
		prestado = false;
	}

	@Override
	public boolean estaPrestado() {
		return prestado;
	}

	@Override
	public String toString() {
		return String.format(super.toString() + "(%sprestado)", prestado ? "" : "no ");
	}
}
