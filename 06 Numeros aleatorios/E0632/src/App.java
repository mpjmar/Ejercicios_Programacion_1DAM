public class App {
    public static void main(String[] args) throws Exception {

		int longitud = 0, obstaculo = 0, inicio = 7, tipo = 0, pos = 0;
		final int ANCHO = 6;
		String tipoObs = "";

		try {
			System.out.print("Introduzca la longitud del sendero en metros: ");
			longitud = Integer.parseInt(System.console().readLine());
		} catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero.");
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}
		for (int i = 1; i <= longitud; i++) {
			for (int j = 1; j <= inicio; j++)
				System.out.print(" ");
			
			obstaculo = (int)(Math.random() * 2 + 1);
			if (obstaculo == 1) {
				tipo = (int)(Math.random() * 2 + 1);
				tipoObs = switch (tipo) {
					case 1 -> "*";
					case 2 -> "o";
					default -> "";
				};
				pos = (int)(Math.random() * 4 + 2);
			}

			for (int j = 1; j <= ANCHO; j++) {
				if (j == 1 || j == ANCHO)
					System.out.print("|");
				else 
					System.out.print(obstaculo == 1 ? j == pos ? tipoObs : " " : " ");
			}
			inicio += (int)(Math.random() * 3) - 1;
			System.out.println();
		}
	}
}
