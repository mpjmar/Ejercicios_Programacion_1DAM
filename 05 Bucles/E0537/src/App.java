public class App {

	public static int invertido (int n) {
		
		int invertido = 1;

		while (n > 0) {
			invertido = invertido * 10 + n % 10;
			n /= 10;
		}
		return (invertido);
	}
    public static void main(String[] args) throws Exception {
        
		int n = 0;
		boolean correcto = false;

		System.out.print("Por favor, intoduzca un número entero positivo: ");
		do {
			try {
				n = Integer.parseInt(System.console().readLine());
				correcto = n > 0;
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		System.out.printf("El número %d en decimal es el ", n);
		
		int invertido = invertido(n);
		while (invertido > 1)
		{
			int digito = invertido % 10;
			while (digito > 0) {
				System.out.print("| ");
				digito--;
			}
			invertido /= 10;
			System.out.printf(invertido > 0 ? "- " : "en el sistema de palotes.%n");
		}
    }
}
