public class Texto {
	
	private String nombre;
	private String contenido;

	public Texto(String nombre, String contenido) {
		this.nombre = nombre;
		this.contenido = contenido;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || !(o instanceof Texto))
			return false;
		Texto t = (Texto) o;
		return this.contenido.equals(t.contenido);
	}

}
