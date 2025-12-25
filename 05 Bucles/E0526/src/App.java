public class App {
    public static void main(String[] args) throws Exception {
        
		boolean correcto = false;
		int numero = 0;
		int digito = 0;
		do {
			try {
				numero = Integer.parseInt(System.console().readLine("Introduzca un número entero: "));
				digito = Integer.parseInt(System.console().readLine("Introduzca un dígito: "));
				correcto = true;
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		System.out.printf("Contando e izquierda a derecha, el %d aparece dentro de %d en las siguientes posiciones: ", digito, numero);
		
		int reves = 0;
		int pos = 1;
		while (numero > 0) {
			reves = reves * 10 + numero % 10;
			numero /= 10;
			pos++;
		}
		for (int i = 1; i < pos; i++) {
			System.out.print(reves % 10 == digito ? (i + " ") : "");
			reves /= 10;
		}
		System.out.println();
    }
}
