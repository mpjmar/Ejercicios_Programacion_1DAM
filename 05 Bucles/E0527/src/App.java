public class App {
    public static void main(String[] args) throws Exception {
        
		int numero = 0;
		boolean correcto = false;
		do {
			try {
				numero = Integer.parseInt(System.console().readLine("Introduzca un número entero mayor que 1: "));
				System.out.println(numero > 1 ? correcto = true : "El número debe ser mayor que 1.");
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		int contador = 1;
		int suma = 0;
		while (contador <= numero) {
			if (contador % 3 == 0) {
				suma += contador;
				System.out.print(contador + " ");
			}
			contador++;
		}
		System.out.printf("%nDesde 1 hasta %d hay %d múltiplos de 3 y suman %d.%n", numero, contador, suma);
    }
}
