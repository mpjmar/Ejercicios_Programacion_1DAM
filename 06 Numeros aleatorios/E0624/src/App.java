public class App {

	public static int cuentaDigitos(int num) {
		int digitos = 0;

		while (num > 0) {
			num /= 10;
			digitos++;
		}
		return (digitos);
	}
    public static void main(String[] args) throws Exception {

		int num = 0;
		int aux1 = 0, aux2 = 0;

		try {
			System.out.print("Por favor, introduzca un número entero positivo: ");
			num = Integer.parseInt(System.console().readLine());
		} catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero.");
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}
		int digitos = cuentaDigitos(num);
		int len = (int)(Math.random() * digitos) + 1;
		System.out.println(len);
		
		// version 1
		aux1 = num;
		for (int i = 0; i < len; i++)
			aux1 /= 10;
		System.out.println(aux1 % 10);

		// version 2
		aux2 = num;
		aux2 /= (int)(Math.pow(10, len));
		System.out.println(aux2 % 10);
	}
}
