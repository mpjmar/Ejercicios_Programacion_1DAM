public class App {

	public static void pintaRectangulo(int ancho, int alto) {
		System.out.println();
		for (int i = 1; i <= alto; i++) {
			for (int j = 1; j <= ancho; j++)
				System.out.print((j == 1 || j == ancho || i == 1 || i == alto) ? "*" : " ");
			System.out.println("");
		}
	}
    public static void main(String[] args) throws Exception {

		int opcion = 0, ancho = 6, alto = 3;
		pintaRectangulo(ancho, alto);
		do {
			try {
				System.out.println("""
						1. Agrandarlo
						2. Achicarlo
						3. Cambiar la orientación
						4. Salir
						Indique qué quiere hacer con el rectángulo: """);
				opcion = Integer.parseInt(System.console().readLine());
				switch (opcion) {
					case 1:
						pintaRectangulo(++ancho, ++alto);
						break;
					case 2:
						if (ancho == 2 || alto == 2)
							System.out.println("El rectángulo no se puede achicar más.");
						else 
							pintaRectangulo(--ancho, --alto);
						break;
					case 3:
						int aux = ancho;
						ancho = alto;
						alto = aux;
						pintaRectangulo(ancho, alto);
						break;
					case 4:
						break;
					default:
						System.out.printf("La opción elegida no es correcta.%n");
						break;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (opcion !=4);
	}
}
