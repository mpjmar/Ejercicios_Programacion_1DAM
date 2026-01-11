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

	public void sirve() {
		if (this.estado.equals("pedida")) {
			this.estado = "servida";
			pizzasServidas++;
		}
		else
			System.out.println("esa pizza ya se ha servido");
	}

	public static int getTotalPedidas() {
		return pizzasPedidas;
	}

	public static int getTotalServidas() {
		return pizzasServidas;
	}

	public String toString() {
		String res = "";
		return "pizza " + this.tipo + " " + this.tamanio + ", " + this.estado;
	}
}
