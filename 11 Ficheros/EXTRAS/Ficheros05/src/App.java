import java.io.IOException;

import diario.DiarioMagico;
import hechicera.AprendizHechicera;

public class App {
    public static void main(String[] args) throws Exception {

		System.out.println("La aprendiz de hechicera:");

		DiarioMagico diario = new DiarioMagico("diario.txt");
		AprendizHechicera aprendiz = new AprendizHechicera();
		try {
			if (diario.crearDiario())
				System.out.println("El diario mágico ha sido creado");
			else
				System.out.println("Ya existe el diario mágico.");
		} catch (IOException ioe) {
			System.out.println("Ha ocurrido un error: " + ioe.getMessage());
		}

		int opcion;
        do {
            System.out.println("\n--- DIARIO DE ELARA ---");
            System.out.println("1. Añadir entrada");
            System.out.println("2. Listar entradas pendientes");
            System.out.println("3. Guardar entradas en el diario");
            System.out.println("4. Leer diario");
            System.out.println("5. Modificar entrada");
            System.out.println("6. Eliminar entrada");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(System.console().readLine());

            try {

                switch (opcion) {

                    case 1:
                        System.out.println("Escribe la entrada:");
                        String entrada = System.console().readLine();
                        aprendiz.añadirEntrada(entrada);
                        break;

                    case 2:
                        aprendiz.listarEntradas();
                        break;

                    case 3:
                        aprendiz.guardarEntradasEnDiario(diario);
                        break;

                    case 4:
                        diario.leerDiario();
                        break;

                    case 5:
                        System.out.print("Índice de la entrada a modificar: ");
                        int indiceMod = Integer.parseInt(System.console().readLine());

                        System.out.print("Nueva entrada: ");
                        String nuevaEntrada = System.console().readLine();

                        diario.modificarEntrada(indiceMod, nuevaEntrada);
                        break;

                    case 6:
                        System.out.print("Índice de la entrada a eliminar: ");
                        int indiceElim = Integer.parseInt(System.console().readLine());
                        diario.eliminarEntrada(indiceElim);
                        break;

                    case 0:
                        System.out.println("Elara cierra su diario mágico...");
                        break;

                    default:
                        System.out.println("Opción no válida.");

                }

            } catch (IOException e) {
                System.out.println("Error al operar con el diario.");
            } catch (NumberFormatException e) {
				System.out.println("La opción debe ser un número entero.");
			}

        } while (opcion != 0);
	}
}
