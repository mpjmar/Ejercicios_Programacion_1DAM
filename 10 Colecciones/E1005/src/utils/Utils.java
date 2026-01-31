package utils;

import disco.*;

public class Utils {

	public static int mostrarMenuPrincipal() {

		int opcion = -1;

		System.out.println("""

			====== MENÚ PRINCIPAL ======
			Seleccione una opción:
			1. Listar discos
			2. Añadir disco
			3. Borrar disco
			4. Modificar disco
			5. Salir
			""");
		opcion = Lectura.leerEntero(1, 5);

		return opcion;
	}

	public static int mostrarMenuBusq() {

		int opcion = -1;
		
		System.out.println("""

				¿Qué dato quiere introducir?
				1. Código
				2. Título
				3. Salir
				""");
		opcion = Lectura.leerEntero(1, 3);
		return opcion;
	}
}
