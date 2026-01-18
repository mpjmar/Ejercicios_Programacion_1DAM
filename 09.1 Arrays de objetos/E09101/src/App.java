public class App {
    public static void main(String[] args) throws Exception {
        Gato[] gatos = solicitaDatos(4);
		muestraArray(gatos);
    }

	public static Gato[] solicitaDatos(int cantidad) {
		System.out.println("Por favor, introduzca los datos de los gatos.\n");
		Gato[] gatos = new Gato[cantidad];
		for (int i = 0; i < cantidad; i++)
			gatos[i] = creaGato();
		return gatos;
	}

	public static Gato creaGato() {
		Gato gatito = new Gato();
		System.out.println("Gato nº " + gatito.getNumero());
		gatito.setNombre(System.console().readLine("Nombre: "));
		gatito.setColor(System.console().readLine("Color: "));
		gatito.setRaza(System.console().readLine("Raza: "));
		System.out.println();
		return gatito;
	}

	public static void muestraArray(Gato[] gatos) {
		System.out.println("Datos de los gatos: \n");
		for (int i = 0; i < gatos.length; i++)
			System.out.println(gatos[i]);
	}
}
