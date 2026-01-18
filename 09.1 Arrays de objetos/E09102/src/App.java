public class App {
    public static void main(String[] args) throws Exception {
        Gato[] gatos = solicitaDatos(4);
		muestraArray(gatos);
    }

	public static Gato[] solicitaDatos(int cantidad) {
		System.out.println("Por favor, introduzca los datos de los gatos.\n");
		Gato[] gatos = new Gato[cantidad];
		for (int i = 0; i < cantidad; i++) {
			gatos[i] = creaGato(Gato.orden);
			System.out.println();
		}
		return gatos;
	}

	public static Gato creaGato(int num) {
		System.out.println("Gato nº " + num);
		String nombre = System.console().readLine("Nombre: ");
		String color = System.console().readLine("Color: ");
		String raza = System.console().readLine("Raza: ");
		Gato gatito = new Gato(nombre, color, raza);
		return gatito;
	}

	public static void muestraArray(Gato[] gatos) {
		System.out.println("Datos de los gatos: \n");
		for (int i = 0; i < gatos.length; i++) 
			System.out.println(gatos[i]);
	}
}
