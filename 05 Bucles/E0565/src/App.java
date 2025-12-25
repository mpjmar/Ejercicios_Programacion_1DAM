public class App {

	public static void dibujaA(int altura, int palito) {
		for (int i = 1; i <= altura; i++) {
			for (int j = 1; j <= altura - i; j++)
				System.out.print(" ");
			for (int j = 1; j <= i * 2 - 1; j++)
				System.out.print(j == 1 || j == i * 2 - 1 || i == palito ? "*" : " ");
			System.out.println();
		}
	}
    public static void main(String[] args) throws Exception {

		int altura = 0, palito = 0;

		try {
			System.out.print("Introduzca la altura de la A (un número mayor o igual a 3): ");
			altura = Integer.parseInt(System.console().readLine());
			if (altura < 3) 
				System.out.println("La altura introducida no es correcta.");
			else {
				System.out.print("Introduzca la fila del palito horizontal (entre 2 y 6): ");
				palito = Integer.parseInt(System.console().readLine());
				if (palito < 1 || palito >= altura) 
					System.out.println("La fila introducida no es correcta.");
				else {
					dibujaA(altura, palito);
				}
			}
		}
		catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero.");
		}
		catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		} 
    }
}
