import Excepciones.InvalidOption;
import disco.Disco;
import disco.Utils;

public class App {
    public static void main(String[] args) throws Exception {
		
		boolean correcto = false;
		int opcion = -1;
		Disco[] coleccion = new Disco[100];
		agregaEjemplo(coleccion, "Them Crooked Vultures", "New Fang", "Rock", 20);
		agregaEjemplo(coleccion, "Queens of the Stone Age", "Lullabies To Paralize", "Stoner rock", 110);
		agregaEjemplo(coleccion, "Placebo", "Meds", "Rock", 95);
		do {
			try {
				Utils.muestraMenu();
				opcion = Integer.parseInt(System.console().readLine("Introduzca una opción: "));
				correcto = Utils.validaOpcion(opcion);
				switch (opcion) {
					case 1:
						muestraColeccion(coleccion);
						break;
					case 2:
						agregaDisco(coleccion);
						break;
					case 3:
						modificaDisco(coleccion);
						break;
					case 4:
						borraDisco(coleccion);
						break;
					default:
						break;
				}
			} catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			} catch (InvalidOption e) {
				System.out.println(e.getMessage());
			}
		} while (opcion != 5 || !correcto);
    }
	
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

	public static void agregaDisco(Disco[] coleccion) {
		System.out.println("""

				NUEVO DISCO
				===========
				""");
		int pos = Utils.buscaPosLibre(coleccion);
		if (pos < 0) {
			System.out.println("Lo siento, no hay espacio disponible.");
			return;
		}
		coleccion[pos] = new Disco();
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
		if (!nuevoCod.equals(""))
			coleccion[pos].setCodigo(nuevoCod);

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
		coleccion[pos] = new Disco();
		coleccion[pos].setAutor(autor);
		coleccion[pos].setTitulo(titulo);
		coleccion[pos].setGenero(genero);
		coleccion[pos].setDuracion(duracion);
	}

}
