public class App {
    public static void main(String[] args) throws Exception {
        
		int n = 0;
		try {
			n = Integer.parseInt(System.console().readLine("Introduzca un número y le mostraré su tabla de multiplicar: "));

			for (int i = 0; i <= 10; i++)
				System.out.println(n + " x " + i + " = " + n * i);
		}
		catch (NumberFormatException e) {
			System.out.println("Debe introducir un número entero");
		}
		catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado");
		}
    }
}
