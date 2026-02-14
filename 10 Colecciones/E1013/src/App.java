import metodos.GestionAlmacen;
import metodos.Utils;

import java.util.ArrayList;

import articulo.Articulo;
import excepciones.InvalidOptionException;

public class App {
    public static void main(String[] args) throws Exception {

		int opcion = -1;
		ArrayList<Articulo> articulos = new ArrayList<Articulo>();
		articulos.add(new Articulo("cho1", "chocolatina", 0.75, 2.25, 1000));
		articulos.add(new Articulo("pal2", "palomitas", 0.35, 1.25, 150));
		articulos.add(new Articulo("chi3", "chicle", 0.2, 0.9, 200));
		
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
				case 5:
					GestionAlmacen.entrada(articulos);
					break;
				case 6:
					ArrayList<Articulo> vendidos = new ArrayList<Articulo>();
					int opcionSub = 0;
					do {
						try {
							Utils.mostrarSubmenu();
							opcionSub = Integer.parseInt(System.console().readLine());
							Utils.validaOpcion(opcionSub, 1, 2);
							if (opcionSub == 1) {
								Articulo a = GestionAlmacen.venta(articulos);
								if (a != null)
									vendidos.add(a);
							}
						} catch (NumberFormatException e) {
							System.out.println("El número debe ser un entero");
						} catch (Exception e) {
							System.out.println("Ha ocurrido un error inesperado.");
						}
					} while (opcionSub != 2);
					if (vendidos.size() > 0)
						System.out.println(Utils.mostrarFactura(vendidos));
					break;
				default:
					break;
			}
		} while (opcion != 7);
	}
}
