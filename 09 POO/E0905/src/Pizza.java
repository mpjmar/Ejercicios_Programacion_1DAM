public class Pizza {

	private static int pizzasPedidas = 0;
	private static int pizzasServidas = 0;

	private String tamanio;
	private String tipo;
	private String estado;

	public Pizza(String tipo, String tamanio) {
		this.tipo = tipo;
		this.tamanio = tamanio;
		this.estado = "pedida";
		pizzasPedidas++;
	}

	public static int getTotalPedidas() {
		return pizzasPedidas;
	}

	public static int getTotalServidas() {
		return pizzasServidas;
	}

	public boolean sirve() {
		if (this.estado.equals("pedida")) {
			this.estado = "servida";
			pizzasServidas++;
		}
		else
			return false;
		return true;
	}

	public String toString() {
		return String.format("pizza " + tipo + " " + tamanio + ", " + estado);
	}
}
