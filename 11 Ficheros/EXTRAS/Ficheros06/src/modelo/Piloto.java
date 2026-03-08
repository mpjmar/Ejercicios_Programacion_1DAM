package modelo;

public class Piloto implements Comparable<Piloto> {
	
	private String nombre;
	private String equipo;
	private int numero;
	private String nacionalidad;
	private int puntos;

	public Piloto(String nombre, String equipo, int numero, String nacionalidad, int puntos) {
		this.nombre = nombre;
		this.equipo = equipo;
		this.numero = numero;
		this.nacionalidad = nacionalidad;
		this.puntos = puntos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEquipo() {
		return this.equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNacionallidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getPuntos() {
		return this.puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "NOMBRE: " + nombre + " EQUIPO: " + equipo + " NUMERO: " + numero + " NACIONALIDAD: " + nacionalidad + " PUNTOS: " + puntos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Piloto))
			return false;
		Piloto other = (Piloto) o;
		return this.numero == other.getNumero() && this.nombre.toLowerCase().equals(other.getNombre().toLowerCase());
	}

	@Override
	public int compareTo(Piloto p) {
		return ((Integer)p.puntos).compareTo((Integer)this.getPuntos());
	}
}
