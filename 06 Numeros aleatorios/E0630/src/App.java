public class App {
    public static void main(String[] args) throws Exception {

		int alto = 0, ancho = 0;
		boolean correcto = false, distintos = true;
		int yPez = 0, xPez = 0, yCaball = 0, xCaball = 0, yCarac = 0, xCarac = 0;

		do {
			try {
				System.out.print("Por favor, introduzca la altura de la pecera (como mínimo 4): ");
				alto = Integer.parseInt(System.console().readLine());
				System.out.print("Ahora introduzca la anchura (como mínimo 4): ");
				ancho = Integer.parseInt(System.console().readLine());
				correcto = alto > 3 && ancho > 3;
				if (!correcto) System.out.println("Las dimensiones introducidas no son correctas.");
			} catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		yPez = (int)(Math.random() * (alto - 2)) + 2;
		xPez = (int)(Math.random() * (ancho - 2)) + 2;

		do {
			yCaball = (int)(Math.random() * (alto - 2)) + 2;
			xCaball = (int)(Math.random() * (ancho - 2)) + 2;
			distintos = yCaball == yPez && xCaball == xPez;
		} while (distintos);
		
		do {
			yCarac = (int)(Math.random() * (alto - 2)) + 2;
			xCarac = (int)(Math.random() * (ancho - 2)) + 2;
			distintos = (yCarac == yPez && xCarac == xPez) || (yCarac == yCaball && xCarac == xCaball);
		} while (distintos);

		for (int i = 1; i <= alto; i++) {
			for (int j = 1; j <= ancho; j++) {
				if (i == 1 || i == alto || j == 1 || j == ancho)
					System.out.print("*");
				else
					System.out.print((i == yPez && j == xPez) ? "&" : (i == yCaball && j == xCaball) ? "$" : (i == yCarac && j == xCarac) ? "@" : " ");
			}
			System.out.println();
		}
	}
}
