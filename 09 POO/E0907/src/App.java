import expocoches.interfaces.VentaEntradas;
import expocoches.entradas.Zona;
import expocoches.excepciones.*;
import expocoches.utils.Lectura;

public class App {

	public static final int AVAILABLE_ZONES = 3;
	public static VentaEntradas[] zonas = new VentaEntradas[AVAILABLE_ZONES];
	public static String[] nombresZonas = {"Zona Principal", "Zona Compra-Venta", "Zona Vip"};
	public static final String MENU = 
	"""
		1. Mostrar número de entradas libres.
		2. Vender entradas.
		3. Salir.
	""";
	public static final String SUBMENU = 
	"""
		1. Zona Principal
    	2. Zona Compra-Venta
    	3. Zona Vip	
	""";

	public static void inicializaZonas() {
		zonas[0] = new Zona(1000);
		zonas[1] = new Zona(200);
		zonas[2] = new Zona(25);
	}
			
    public static void main(String[] args) throws Exception {
		int opcion1 = -1;
		int opcion2 = -1;
		inicializaZonas();
		
		do {
			System.out.println("\n" + MENU);
			opcion1 = Lectura.leeEntero("Seleccione una opción: ", 1, 3);
			switch (opcion1) {
				case 1:
					System.out.println("\nEntradas disponibles: \n");
					for (int i = 0; i < zonas.length; i++)
						System.out.printf("%s: %d%n", nombresZonas[i], zonas[i].getEntradasPorVender());
					break;
				case 2:
					opcion2 = Lectura.leeEntero("\nElija la zona:\n\n" + SUBMENU, 1, 3);
					int entradas = Lectura.leeEntero("¿Cuántas entradas quiere?: ", 1, Integer.MAX_VALUE);
					zonas[opcion2 - 1].vender(entradas);
			}
		} while (opcion1 != 3);
		System.out.println("Muchas gracias.");
	}
}
