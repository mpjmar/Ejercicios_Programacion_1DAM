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
			Utils.desplazaArticulos(articulos, pos);
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
		
		System.out.println("Código: " + articulos[pos].getCodigo());
		String nuevoCodigo = System.console().readLine("Nuevo código: ");
		if (!nuevoCodigo.equals(""))
			articulos[pos].setCodigo(nuevoCodigo);

		System.out.println("Descripción: " + articulos[pos].getDescripcion());
		String nuevaDescripcion = System.console().readLine("Nueva descripción: ");
		if (!nuevaDescripcion.equals(""))
			articulos[pos].setDescripcion(nuevaDescripcion);

		System.out.println("Precio de compra: " + articulos[pos].getPrecioCompra());
		String nuevoPrecioCompra = System.console().readLine("Nuevo precio de compra: ");
		if (!nuevoPrecioCompra.equals(""))
			articulos[pos].setPrecioCompra(Double.parseDouble(nuevoPrecioCompra));

		System.out.println("Precio de venta: " + articulos[pos].getPrecioVenta());
		String nuevoPrecioVenta = System.console().readLine("Nuevo precio de venta: ");
		if (!nuevoPrecioVenta.equals(""))
			articulos[pos].setPrecioVenta(Double.parseDouble(nuevoPrecioVenta));

		System.out.println("Stock: " + articulos[pos].getStock());
		String nuevoStock = System.console().readLine("Nuevo stock: ");
		if (!nuevoStock.equals(""))
			articulos[pos].setStock(Integer.parseInt(nuevoStock));

		return "Se han actualizado los datos.";
	}

	public static void entrada(Articulo[] articulos) {
		System.out.println("""
			
			ENTRADA DE MERCANCÍA
			====================
			""");
		System.out.print("Por favor, introduzca el código del artículo: ");
		String codigo = System.console().readLine();
		int pos = Utils.buscaArticulo(articulos, codigo);
		System.out.println("Entrada de mercancía del siguiente artículo:\n" + articulos[pos]);
		System.out.print("Introduzca el número de unidades que entran: ");
		int unidades = Integer.parseInt(System.console().readLine());
		articulos[pos].setStock(articulos[pos].getStock() + unidades);
		System.out.println("La mercancía ha entrado en el almacén.");
	}

	public static void salida(Articulo[] articulos) {
		System.out.println("""

			SALIDA DE MERCANCÍA
			===================
			""");
		System.out.print("Por favor, introduzca el código del artículo: ");
		String codigo = System.console().readLine();
		int pos = Utils.buscaArticulo(articulos, codigo);
		System.out.println("Salida de mercancía del siguiente artículo: \n" + articulos[pos]);
		System.out.print("Introduzca el número de unidades que salen: ");
		int unidades = Integer.parseInt(System.console().readLine());
		articulos[pos].setStock(articulos[pos].getStock() - unidades);
		System.out.println("La mercancía ha salido del almacén.");
	}
}
