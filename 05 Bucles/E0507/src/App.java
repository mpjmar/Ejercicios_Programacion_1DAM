public class App {
    public static void main(String[] args) throws Exception {
        
		boolean correcta = false;
		int intentos = 0;
		int combinacion = 1234;
		int clave = 0;
		do {
			try {
				clave = Integer.parseInt(System.console().readLine("Introduzca la clave de la caja fuerte: "));
				correcta = clave == combinacion;
				if (!correcta)
					System.out.println("Clave incorrecta");
				intentos++;
			}
			catch (NumberFormatException e) {
				System.out.println("Debe introducir un número entero");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado");
			}
		} while (!correcta && intentos < 4);

		if (correcta)
			System.out.println("Ha abierto la caja fuerte");
		else
			System.out.println("Lo siento, ha agotado las 4 oportunidades");
    }
}
