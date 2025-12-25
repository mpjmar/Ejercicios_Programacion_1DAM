public class App {
    public static void main(String[] args) throws Exception {

		int respuesta = 0, aleatorio = 0, intentos = 5;
		System.out.println("Piensa un número del 0 al 100. Intentaré adivinarlo en 5 intentos.");
		System.out.print("Pulsa la tecla INTRO cuando estés preparado.");
		System.console().readLine();
		aleatorio = (int)(Math.random() * 101);
		do {
			try {
				System.out.printf("¿Es el %d?%n", aleatorio);
				System.out.print("El número que estás pensando es 1)mayor 2)menor 3)el mismo: ");
				respuesta = Integer.parseInt(System.console().readLine());
				if (respuesta == 1)
					aleatorio = (int)(Math.random() * (100 - aleatorio + 1)) + aleatorio;
				else if (respuesta == 2)
					aleatorio = (int)(Math.random() * aleatorio) + 1;
				intentos--;
			} catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (respuesta != 3 && intentos > 0);

		System.out.println(respuesta == 3 ? "¡Bien! ¡He acertado!" : "Vaya, no he conseguido acertar el número.");
	}
}
