public class App {

	public static void imprimeEscalones(int escalones, int altura) {

		for (int i = 1; i <= escalones; i++) {
			for (int j = 0; j < altura ; j++) {
				for (int k = 0; k < i; k++)
					System.out.print("****");
				System.out.println();
			}
		}
	}

    public static void main(String[] args) throws Exception {

		int escalones = 0, altura = 0;

		try {
			System.out.print("Introduzca el número de escalones: ");
			escalones = Integer.parseInt(System.console().readLine());
			System.out.print("Introduzca la altura de cada escalón: ");
			altura = Integer.parseInt(System.console().readLine());
		}
		catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero.");
		}
		catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}
		imprimeEscalones(escalones, altura);
	}
}
