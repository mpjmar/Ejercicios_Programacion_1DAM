package elementos;
public class Curso extends Elemento<String> {
	
	private int duracionHoras;

	public Curso(int id, String nombre, String informacion, int duracionHoras) {
		super(id, nombre, informacion);
		this.duracionHoras = duracionHoras;
	}

	public int getDuracionHoras() {
		return duracionHoras;
	}

	public void setDuracionHoras(int duracionHoras) {
		this.duracionHoras = duracionHoras;
	}

	@Override
	public String toString() {
		return super.toString() + "Duración: " + duracionHoras + " horas";
	}
}
