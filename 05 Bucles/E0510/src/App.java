public class App {
    public static void main(String[] args) throws Exception {
   
		System.out.printf(
			"""
				Este programa calcula la media de los números positivos introducidos.
				Para parar, introduzca un número negativo.
				Vaya introduciendo números:
					"""
		);
		double n = 0;
		double suma = 0;
		int cant = 0;
		do {
			try {
				n = Double.parseDouble(System.console().readLine());
				if (n >= 0) {
					suma += n;
					cant++;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("Los números deben ser números positivos");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado");
			}
		} while (n >= 0);

		System.out.println("La media de los números positivos introducidos es: " + suma / cant);

    }
}
