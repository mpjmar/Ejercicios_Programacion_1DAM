public class App {
    public static void main(String[] args) throws Exception {
        
		int cantidad = 0;
		int cantImpar = 0;
		int sumaImpar = 0;
		int parMax = 0;

		System.out.printf("""
				Por favor, vaya introduciendo números enteros.
				puede terminar mediante la introducción de un número negativo.
				""");
		try {
			int num = Integer.parseInt(System.console().readLine());
			while (num >= 0) {
				if (num % 2 != 0)
				{
					sumaImpar += num;
					cantImpar++;
				}
				if ((num % 2 == 0) && num > parMax)
					parMax =
				cantidad++;
				num = Integer.parseInt(System.console().readLine());
			}
		}
		catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero.");
		}
		catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}
		
		System.out.printf("""
				Ha introducido %d números positivos.
				La media de los impares es %d.
				El máximo de los pares es %d.
				""", cantidad,
				(int)(sumaImpar / cantImpar),
				parMax);
    }
}
