public class Incidencia {
	
	private int puesto;
	private int codIncidencia;
	private String comentario;
	private String solucion;
	private boolean pendiente;
	private static int codigo = 0;
	private static int incidenciasPtes = 0;

	public Incidencia(int puesto, String comentario) {
		this.puesto = puesto;
		this.comentario = comentario;
		this.pendiente = true;
		this.codIncidencia = ++codigo;
		incidenciasPtes++;
	}

	public static int getPendientes() {
		return incidenciasPtes;
	}

	public void resuelve(String solucion) {
		this.solucion = solucion;
		pendiente = false;
		incidenciasPtes--;
	}

	@Override
	public String toString() {
		return String.format("Incidencia %d - Puesto: %d - %s - %s", 
			codIncidencia, puesto, comentario, pendiente ? "Pendiente" : "Resuelta - " + solucion);
	}
}
