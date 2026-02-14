package metodos;

import java.util.ArrayList;

import articulo.Articulo;

public class GestionAlmacen {
	
	public static void listar(ArrayList<Articulo> articulos) {
		System.out.println("""
				
			LISTADO
			=======
			""");
		for (Articulo a : articulos)
			System.out.println(a);
	}

	public static void alta(ArrayList<Articulo> articulos) {
		System.out.println("""
				
			NUEVO ARTÍCULO
			==============
			""");
		System.out.println("Por favor, introduzca los datos del artículo.");
		try {
			System.out.print("Código: ");
			String codigo = System.console().readLine();
			for (Articulo a : articulos) {
				if ((a.getCodigo().equals(codigo))) {
					System.out.println("El artículo ya existe.");
					return;
				}
			}
			Articulo nuevo = new Articulo();
			articulos.add(nuevo);
			nuevo.setCodigo(codigo);
			nuevo.setDescripcion(System.console().readLine("Descripción: "));
			nuevo.setPrecioCompra(Double.parseDouble(System.console().readLine("Precio de compra: ")));
			nuevo.setPrecioVenta(Double.parseDouble(System.console().readLine("Precio de venta: ")));
			nuevo.setStock(Integer.parseInt(System.console().readLine("Stock: ")));
		} catch (NumberFormatException e) {
			System.out.println("El número introducido debe ser un entero");
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}

	}

	public static String baja(ArrayList<Articulo> articulos) {
		System.out.println("""
				
			BAJA
			====
			""");
		System.out.println("Por favor, introduzca el código del artículo que quiere borrar.");
		String codigo = System.console().readLine("Código: ");
		for (Articulo a : articulos)
			if (a.getCodigo().equals(codigo)){
				System.out.println("Descripción: " + a.getDescripcion());
				String confirmacion = System.console().readLine("¿Confirma que desea borrar este artículo? (si / no): ");
				if (confirmacion.equalsIgnoreCase("si")) {
					articulos.remove(a);
					return "Artículo borrado";
				}
				else {
					return "No se ha borrado el artículo.";
				}
			}
		return "Lo siento, el código introducido no existe.";
	}

	public static String modificar(ArrayList<Articulo> articulos) {
		System.out.println("""
				
			MODIFICACIÓN
			============
			""");

		System.out.print("Por favor, introduzca el código del artículo: ");
		String codAModificar = System.console().readLine();


		for (Articulo a : articulos) {
			if (a.getCodigo().equals(codAModificar)) {
				System.out.println("Introduzca los nuevos datos del artículo o INTRO para dejarlos igual.");
				
				System.out.println("Código: " + a.getCodigo());
				String nuevoCodigo = System.console().readLine("Nuevo código: ");
				if (!nuevoCodigo.equals(""))
					a.setCodigo(nuevoCodigo);
		
				System.out.println("Descripción: " + a.getDescripcion());
				String nuevaDescripcion = System.console().readLine("Nueva descripción: ");
				if (!nuevaDescripcion.equals(""))
					a.setDescripcion(nuevaDescripcion);
		
				System.out.println("Precio de compra: " + a.getPrecioCompra());
				String nuevoPrecioCompra = System.console().readLine("Nuevo precio de compra: ");
				if (!nuevoPrecioCompra.equals(""))
					a.setPrecioCompra(Double.parseDouble(nuevoPrecioCompra));
		
				System.out.println("Precio de venta: " + a.getPrecioVenta());
				String nuevoPrecioVenta = System.console().readLine("Nuevo precio de venta: ");
				if (!nuevoPrecioVenta.equals(""))
					a.setPrecioVenta(Double.parseDouble(nuevoPrecioVenta));
		
				System.out.println("Stock: " + a.getStock());
				String nuevoStock = System.console().readLine("Nuevo stock: ");
				if (!nuevoStock.equals(""))
					a.setStock(Integer.parseInt(nuevoStock));
		
				return "Se han actualizado los datos.";
			}
		}
		return "Lo siento, el código introducido no existe.";
	}

	public static void entrada(ArrayList<Articulo> articulos) {
		System.out.println("""
			
			ENTRADA DE MERCANCÍA
			====================
			""");
		System.out.print("Por favor, introduzca el código del artículo: ");
		String codigo = System.console().readLine();
		for (Articulo a : articulos) {
			if (a.getCodigo().equals(codigo)) {
				System.out.println("Entrada de mercancía del siguiente artículo:\n" + a);
				System.out.print("Introduzca el número de unidades que entran: ");
				int unidades = Integer.parseInt(System.console().readLine());
				a.setStock(a.getStock() + unidades);
				System.out.println("La mercancía ha entrado en el almacén.");
				return;
			}
		}
		System.out.println("Código no encontrado.");
	}

	public static Articulo venta(ArrayList<Articulo> articulos) {
		System.out.println("""

			VENTA
			=====
			""");
		System.out.print("Por favor, introduzca el código del artículo: ");
		String codigo = System.console().readLine();
		for (Articulo a : articulos) {
			if (a.getCodigo().equals(codigo)) {
				System.out.println("Venta del siguiente artículo: \n" + a);
				a.setUnidVendidas(0);
				System.out.print("Introduzca el número de unidades que van a vender: ");
				int unidades = Integer.parseInt(System.console().readLine());
				if (unidades <= a.getStock()) {
					a.setUnidVendidas(unidades);
					a.setStock(a.getStock() - a.getUnidVendidas());
				}
				else 
					System.out.println("No hay suficientes unidades");
				System.out.println("Artículos añadidos al carrito.");
				return a;
			}
		}
		System.out.println("Código no encontrado.");
		return null;
	}
}
