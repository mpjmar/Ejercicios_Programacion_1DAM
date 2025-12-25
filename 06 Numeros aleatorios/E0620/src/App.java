public class App {
    public static void main(String[] args) throws Exception {

		int capacidad = 0, ancho = 6;

		try {
			System.out.print("Por favor, indique la capacidad de la cuba en litros: ");
			capacidad = Integer.parseInt(System.console().readLine());
		} catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero.");
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}
		int contenido = (int)(Math.random() * (capacidad + 1));
		System.out.println();
		for (int i = capacidad; i > 0; i--) {
			for (int j = 1; j <= ancho; j++)
				System.out.print((j == 1 || j == ancho) ? "#" : i > contenido ? " " : "=");
			System.out.println();
		}
		for (int i = 1; i <= ancho; i++)
			System.out.print("#");
		System.out.println();
	}
}
