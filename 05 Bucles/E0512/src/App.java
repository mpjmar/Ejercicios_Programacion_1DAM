public class App {
    public static void main(String[] args) throws Exception {
        
		System.out.println("Este programa muestra los n primeros números de la serie de Fibonacci.");
		try {
			int n = Integer.parseInt(System.console().readLine("Por favor, introduzca n: "));

			int n1 = 0;
			int n2 = 1;
			int n3 = n1 + n2;
			for (int i = 0; i < n; i++) {
				if (i == 0)
					System.out.print(n1 + " ");
				else if (i == 1)
					System.out.print(n2 + " ");
				else
				{
					System.out.print((n3) + " ");
					n1 = n2;
					n2 = n3;
					n3 = n1 + n2;
				}
			}
		} 
		catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero");
		}
		catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado");
		}
    }
}
