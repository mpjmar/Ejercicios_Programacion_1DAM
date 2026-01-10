public class App {
    public static void main(String[] args) throws Exception {
		
		int filas = 0, columnas = 0;
		boolean correcto = false;

		System.out.println("Intoduce las medidas del tablero.");
		try {
			do {
				System.out.print("Introduce las filas: ");
				filas = Integer.parseInt(System.console().readLine());
				System.out.print("Introduce las columnas: ");
				columnas = Integer.parseInt(System.console().readLine());
				correcto = filas > 0 && columnas > 0;
				if (!correcto) System.out.println("Las dimensiones deben ser mayores que 0.");
			} while (!correcto);
		} catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero.");
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}
		
		int[][] tablero = new int[filas][columnas];
		Mapa.colocaObjetos(tablero);
		Mapa.muestraMapa(tablero);
		Tablero.juega(tablero);
		Tablero.imprimeFin(tablero);
		System.out.println("\n¡¡FIN DEL JUEGO!!");
    }

}
