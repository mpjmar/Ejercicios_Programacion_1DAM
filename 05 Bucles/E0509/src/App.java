public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.println("Este programa cuenta los dígitos de un número.");
			int num = Integer.parseInt(System.console().readLine("Introduzca un número entero: "));
			int n = Math.abs(num);
			int digitos = 0;
			while (n > 0) {
				n /= 10;
				digitos++;
			}
			System.out.printf("%d tiene %d digito/s.%n", num, digitos);
		}
		catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero");
		}
		catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado");
		}
    }
}
