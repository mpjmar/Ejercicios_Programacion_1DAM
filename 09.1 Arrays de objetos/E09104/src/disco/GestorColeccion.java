package disco;

public class GestorColeccion {
	public static void muestraColeccion(Disco[] coleccion) {
		System.out.println("""

				LISTADO
				=======
				""");
		for (int i = 0; i < coleccion.length; i++) {
			if (coleccion[i] != null)
				System.out.println(coleccion[i]);
		}
	}

	public static void muestraColeccion(Disco[] coleccion, String filtro, String eleccion) {
		String titulo = "LISTADO POR " + filtro.toUpperCase();
		int len = titulo.length();
		System.out.printf("""
				
				%s
				%s

				""", 
				titulo, "=".repeat(len));

		for (int i = 0; i < coleccion.length; i++) {
			if (coleccion[i] != null) {
				switch (filtro) {
					case "autor":
						if (coleccion[i].getAutor().equalsIgnoreCase(eleccion))
							System.out.println(coleccion[i]);
						break;
					case "genero":
						if (coleccion[i].getGenero().equalsIgnoreCase(eleccion))
							System.out.println(coleccion[i]);
						break;
					default:
						break;
				}
			}
		}
	}

	public static void muestraColeccion(Disco[] coleccion, int min, int max) {
		System.out.printf("""
				
				LISTADO POR INTERVALO
				=====================
				""");
		for (int i = 0; i < coleccion.length; i++) {
			if (coleccion[i] != null)
				if (coleccion[i].getDuracion() >= min && coleccion[i].getDuracion() <= max)
					System.out.println(coleccion[i]);
		}
	}

	public static void agregaDisco(Disco[] coleccion) {
		System.out.println("""

				NUEVO DISCO
				===========
				""");
		int pos = Utils.buscaPosLibre(coleccion);
		if (pos < 0) {
			System.out.println("Lo siento, no hay espacio disponible.");
			System.out.println("Debe borrar algún disco para introducir otro.");
			return;
		}
		String codigo = Utils.asignaCodigo(coleccion);
		coleccion[pos] = new Disco(codigo);
		System.out.println("Por favor, introduzca los datos del disco: ");
		System.out.println("Código: " + coleccion[pos].getCodigo());
		coleccion[pos].setAutor(System.console().readLine("Autor: "));
		coleccion[pos].setTitulo(System.console().readLine("Título: "));
		coleccion[pos].setGenero(System.console().readLine("Género: "));
		coleccion[pos].setDuracion(Integer.parseInt(System.console().readLine("Duración: ")));
	}

	public static void modificaDisco(Disco[] coleccion) {
		System.out.println("""

				MODIFICAR
				=========
				""");
		System.out.print("Introduzca el código del disco que desea cambiar: ");
		String codABuscar = System.console().readLine();
		int pos = Utils.buscaCodigo(coleccion, codABuscar);
		if (pos < 0) {
			System.out.println("Disco no encontrado");
			return;
		}
		System.out.println("Introduzca los nuevos datos del disco o INTRO para dejarlos igual.");
		System.out.println("Código: " + coleccion[pos].getCodigo());
		System.out.print("Nuevo código: ");
		String nuevoCod = System.console().readLine();
		if (!nuevoCod.equals("")) {
			if (Utils.buscaCodigo(coleccion, nuevoCod) < 0)
				coleccion[pos].setCodigo(nuevoCod);
			else
				System.out.println("El código introducido ya existe.");
		}

		System.out.println("Autor: " + coleccion[pos].getAutor());
		System.out.print("Nuevo autor: ");
		String nuevoAutor = System.console().readLine();
		if (!nuevoAutor.equals(""))
			coleccion[pos].setAutor(nuevoAutor);

		System.out.println("Título: " + coleccion[pos].getTitulo());
		System.out.print("Nuevo título: ");
		String nuevoTitulo = System.console().readLine();
		if (!nuevoTitulo.equals(""))
			coleccion[pos].setTitulo(nuevoTitulo);

		System.out.println("Género: " + coleccion[pos].getGenero());
		System.out.print("Nuevo género: ");
		String nuevoGenero = System.console().readLine();
		if (!nuevoGenero.equals(""))
			coleccion[pos].setGenero(nuevoGenero);

		System.out.println("Duración: " + coleccion[pos].getDuracion());
		System.out.print("Duración: ");
		String nuevaDuracion = System.console().readLine();
		if (!nuevaDuracion.equals(""))
			coleccion[pos].setDuracion(Integer.parseInt(nuevaDuracion));
	}

	public static void borraDisco(Disco[] coleccion) {
		System.out.println("""

				BORRAR
				======
				""");
		System.out.print("Por favor, introduzca el código del disco que desea borrar: ");
		String codABorrar = System.console().readLine();
		int pos = Utils.buscaCodigo(coleccion, codABorrar);
		if (pos < 0) {
			System.out.println("Disco no encontrado");
			return;
		}
		coleccion[pos] = null;
		System.out.println("Album borrado.");
	}

	public static void agregaEjemplo(Disco[] coleccion, String autor, String titulo, String genero, int duracion) {
		int pos = Utils.buscaPosLibre(coleccion);
		String codigo = Utils.asignaCodigo(coleccion);
		coleccion[pos] = new Disco(codigo);
		coleccion[pos].setAutor(autor);
		coleccion[pos].setTitulo(titulo);
		coleccion[pos].setGenero(genero);
		coleccion[pos].setDuracion(duracion);
	}

}
