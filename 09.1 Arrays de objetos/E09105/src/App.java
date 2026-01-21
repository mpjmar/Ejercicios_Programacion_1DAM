import metodos.GestionAlmacen;
import metodos.Utils;
import articulo.Articulo;
import excepciones.InvalidOptionException;

public class App {
    public static void main(String[] args) throws Exception {

		int opcion = -1;
		Articulo[] articulos = new Articulo[100];
		agregarArticulos(articulos);
		
		do {
			try {
				Utils.mostrarMenu();
				opcion = Integer.parseInt(System.console().readLine("Introduzca una opción: "));
				Utils.validaOpcion(opcion, 1, 7);
			} catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			} catch (InvalidOptionException e) {
				System.out.println(e.getMessage());
			}
			switch (opcion) {
				case 1: 
					GestionAlmacen.listar(articulos);
					break;
				case 2:
					GestionAlmacen.alta(articulos);
					break;
				case 3:
					System.out.println(GestionAlmacen.baja(articulos));
					break;
				case 4:
					System.out.println(GestionAlmacen.modificar(articulos));
					break;
				/* case 5:
					GestionAlmacen.entrada(articulos);
					break;
				case 6:
					GestionAlmacen.salida(articulos);
					break; */
				default:
					break;
			}
		} while (opcion != 7);
	}

	public static void agregarArticulos(Articulo[] articulos) {
		articulos[0] = new Articulo("cho1", "chocolatina", 0.75, 2.25, 1000);
		articulos[2] = new Articulo("pal2", "palomitas", 0.35, 1.25, 150);
		articulos[7] = new Articulo("chi3", "chicle", 0.2, 0.9, 200);
	}
}
