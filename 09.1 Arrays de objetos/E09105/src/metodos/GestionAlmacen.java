package metodos;

import articulo.Articulo;

public class GestionAlmacen {
	
	public static void listar(Articulo[] articulos) {
		System.out.println("""
				
			LISTADO
			=======
			""");
		for (int i = 0; i < articulos.length; i++)
			if (articulos[i] != null)
				System.out.println(articulos[i]);
	}

	public static void alta(Articulo[] articulos) {
		System.out.println("""
				
			NUEVO ARTÍCULO
			==============
			""");
		boolean correcto = false;
		int pos = Utils.buscaPosLibre(articulos);
		if (pos < 0) {
			System.out.println("Lo siento, no hay espacio disponible en el almacén.");
			return;
		}
		
		articulos[pos] = new Articulo();
		System.out.println("Por favor, introduzca los datos del artículo.");
		do {
			try {
				articulos[pos].setCodigo(System.console().readLine("Código: "));
				articulos[pos].setDescripcion(System.console().readLine("Descripción: "));
				articulos[pos].setPrecioCompra(Double.parseDouble(System.console().readLine("Precio de compra: ")));
				articulos[pos].setPrecioVenta(Double.parseDouble(System.console().readLine("Precio de venta: ")));
				articulos[pos].setStock(Integer.parseInt(System.console().readLine("Stock: ")));
				correcto = true;
			} catch (NumberFormatException e) {
				System.out.println("El número introducido debe ser un entero");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);
	}

	public static String baja(Articulo[] articulos) {
		System.out.println("""
				
			BAJA
			====
			""");
		System.out.println("Por favor, introduzca el código del artículo que quiere borrar.");
		String codigo = System.console().readLine("Código: ");
		int pos = Utils.buscaArticulo(articulos, codigo);
		if (pos < 0)
			return "Lo siento, el código introducido no existe.";
		System.out.println("Descripción: " + articulos[pos].getDescripcion());
		String confirmacion = System.console().readLine("¿Confirma que desea borrar este artículo? (si / no): ");
		if (confirmacion.equalsIgnoreCase("si")) {
			articulos[pos] = null;
			return "Artículo borrado";
		}
		else {
			return "No se ha borrado el artículo.";
		}
	}

	public static String modificar(Articulo[] articulos) {
		System.out.println("""
				
			MODIFICACIÓN
			============
			""");
		System.out.print("Por favor, introduzca el código del artículo: ");
		String codAModificar = System.console().readLine();
		int pos = Utils.buscaArticulo(articulos, codAModificar);
		if (pos < 0)
			return "Lo siento, el código introducido no existe.";
		System.out.println("Introduzca los nuevos datos del artículo o INTRO para dejarlos igual.");
		
		/* Código: cho1
		Nuevo código:
		Descripción: chocolatina
		Nueva descripción:
		Precio de compra: 0.75
		Nuevo precio de compra:
		Precio de venta: 2.25
		Nuevo precio de venta: 2.95
		Stock: 1250
		Nuevo stock: */

		return "Se han actualizado los datos.";
	}
}
