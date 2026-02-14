package metodos;
import java.util.ArrayList;

import articulo.Articulo;
import excepciones.InvalidOptionException;

public class Utils {
	
	public static void mostrarMenu() {
		System.out.println("""
				
			G E S T I S I M A L
			===================
			1. Listado
			2. Alta
			3. Baja
			4. Modificación
			5. Entrada de mercancía
			6. Venta
			7. Salir
			""");
	}

	public static void validaOpcion(int opcion, int min, int max) throws InvalidOptionException {
		if (opcion < min || opcion > max)
			throw new InvalidOptionException("Opción no válida. Por favor, seleccione una opción del menú.");
	}

	public static void mostrarSubmenu() {
		System.out.println("""
			
			1. Introducir artículo
			2. Check out
			""");
	}

	public static String mostrarFactura(ArrayList<Articulo> vendidos) {
		double suma = 0;
		double iva = 0.21;
		String factura = """
			Producto    Precio  Cantidad Subtotal
			-------------------------------------
			""";
		for (Articulo a : vendidos) {
			double precio = a.getPrecioVenta();
			int unidades = a.getUnidVendidas();
			suma += precio * unidades;
			factura += String.format("%-10s %7.2f %6d %11.2f %n", 
				a.getDescripcion(), precio, unidades, suma);
		}
		factura += "-------------------------------------\n";
		factura += String.format("%-30s %.2f %n", "IVA (12%):", suma * iva);
		factura += String.format("%-30s %.2f %n", "TOTAL", suma + suma * iva);
		return factura;
	}

}
