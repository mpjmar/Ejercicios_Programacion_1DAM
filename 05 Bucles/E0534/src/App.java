public class App {
    public static void main(String[] args) throws Exception {
        
		int n = 0, n1 = 0, n2 = 0;
		long par = 0, impar = 0;
		boolean correcto = false;

		do {
			try {
				n1 = Integer.parseInt(System.console().readLine("Por favor, introduzca un número: "));
				n2 = Integer.parseInt(System.console().readLine("Introduzca otro número: "));
				correcto = true;
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			} 
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		int reves1 = 0, reves2 = 0;
		for (int i = 1; i < 3; i++) {
			n = i == 1 ? n1 : n2;
			int reves = 0;
			while (n > 0) {
				reves = reves * 10 + n % 10;
				n /= 10;
			}
			if (i == 1) reves1 = reves;
			else reves2 = reves;
		}
		int digito1 = 0, digito2 = 0;
		while (reves1 > 0 || reves2 > 0) {
			digito1 = reves1 % 10;
			digito2 = reves2 % 10;

			if (digito1 % 2 == 0)
				par = par * 10 + digito1;
			else
				impar = impar * 10 + digito1;
			reves1 /= 10;

			if (digito2 % 2 == 0)
				par = par * 10 + digito2;
			else
				impar = impar * 10 + digito2;
			reves2 /= 10;
		}
		System.out.println("El número formado por los dígitos pares es " + par);
		System.out.println("El número formado por los dígitos impares es " + impar);
    }
}
