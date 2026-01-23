package disco;
public class Disco {
	
	private String codigo;
	private String autor;
	private String titulo;
	private String genero;
	private int duracion;

	public Disco(String codigo, String autor, String titulo, String genero, int duracion) {
		this.codigo = codigo;
		this.autor = autor;
		this.titulo = titulo;
		this.genero = genero;
		this.duracion = duracion;
	}

	public Disco(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getAutor() {
		return this.autor;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getGenero() {
		return this.genero;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return String.format("""
				---------------------------------------------------
				Código: %s
				Autor: %s
				Título: %s
				Género: %s
				Duración: %d
				---------------------------------------------------

				""", codigo, autor, titulo, genero, duracion);
	}
}
