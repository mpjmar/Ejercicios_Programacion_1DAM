public class App {
    public static void main(String[] args) throws Exception {

		int longitud = 0, pos = 13;
		System.out.println("Este programa pinta una serpiente.");

		try {
			System.out.print("Por favor, introduzca su longitud: ");
			longitud = Integer.parseInt(System.console().readLine());
		} catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero.");
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}
		System.out.println();
		for (int i = 0; i < longitud; i++) {
			for (int j = 0; j < pos; j++)
				System.out.print(" ");
			System.out.println(i == 0 ? "@" : "#");
			pos += (int)(Math.random() * 3) - 1;
		}
	}
}
