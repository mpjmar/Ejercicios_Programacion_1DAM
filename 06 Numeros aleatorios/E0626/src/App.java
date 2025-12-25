public class App {
    public static void main(String[] args) throws Exception {

		int ancho = 0, alto = 0;

		try {
			System.out.print("Introduzca la anchura de la tableta: ");
			ancho = Integer.parseInt(System.console().readLine());
			System.out.print("Introduzca la altura de la tableta: ");
			alto = Integer.parseInt(System.console().readLine());
		} catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero.");
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}
		int contorno = ancho * 2 + (alto - 2) * 2;
		int bocado = (int)(Math.random() * contorno) + 1;
		int pos = 0;		
		for (int i = 1; i <= alto; i++) {
			for (int j = 1; j <= ancho; j++) {
				boolean esContorno = (i == 1 || i == alto || j == 1 || j == ancho);
				if (esContorno) pos++;
				System.out.print(pos == bocado && esContorno ? " " : "*");
			}
			System.out.println();
		}
	}
}
