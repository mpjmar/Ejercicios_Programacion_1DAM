import java.security.spec.ECFieldF2m;

public class App {

	public static int longitud(long num) {
		int longitud = 0;

		while (num > 0) {
			longitud++;
			num /= 10;
		}
		return (longitud);
	}

	public static long invertido(long num) {
		
		long invertido = 0;
		
		while (num > 0) {
			invertido = invertido * 10 + num % 10;
			num /= 10;
		}
		return (invertido);
	}

	public static long insertarDigito(long num, int pos, int dig) {
		
		long invertido = invertido(num);
		long aux = 0;

		for (int i = 1; i < pos; i++) {
			aux = aux * 10 + invertido % 10; 
			invertido /= 10;
		}
		invertido = invertido * 10 + dig;

		for (int i = 1; i < pos; i++) {
			invertido = invertido * 10 + aux % 10;
			aux /= 10;
		}
		num = invertido(invertido);
		return (num);
	}

    public static void main(String[] args) throws Exception {
        
		boolean correcto = false;
		long num = 0, nuevoNum = 0;
		int pos = 0, len = 0, digito = 0;
		
		do {
			try {
				do {
					System.out.print("Por favor, introduzca un número entero positivo: ");
					num = (long)Integer.parseInt(System.console().readLine());
					correcto = num > 0;
					if (!correcto) System.out.println("El número debe ser un entero positivo");
				} while (!correcto);
				do {
					System.out.print("Introduzca la posición donde quiere insertar: ");
					pos = Integer.parseInt(System.console().readLine());
					len = longitud(num);
					if (pos > len + 1) System.out.println("La posición no puede ser superior a la longitud del número + 1.");
				} while (!correcto);
				do {
					System.out.print("Introduzca el dígito que quiere insertar (0-9): ");
					digito = Integer.parseInt(System.console().readLine());
					correcto = digito >= 0 && digito <= 9;
					if (!correcto) System.out.println("El dígito debe encontrarse entre el 0 y el 9.");
				} while (!correcto);
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		nuevoNum = insertarDigito(num, pos, digito);
		System.out.println("El número resultante es " + nuevoNum);
    }
}
