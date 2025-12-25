public class App {
    public static void main(String[] args) throws Exception {

		boolean acertado = false;
		int intento = 0, oportunidades = 5;

		System.out.println("Estoy pensando un número del 0 al 100, intenta adivinarlo.");
		System.out.println("Tienes 5 oportunidades.");
		int num = (int)(Math.random() * 101);

		do {
			try {
				System.out.print("Introduce un número: ");
				intento = Integer.parseInt(System.console().readLine());
				acertado = intento == num;
				if (!acertado) {
					System.out.printf("El número que estoy pensando es %s que %d.%n", (intento < num ? "mayor" : "menor"), intento);
					oportunidades--;
					if (oportunidades > 0)
						System.out.printf("Te quedan %d %s.%n", oportunidades, (oportunidades > 1 ? "oportunidades" : "oportunidad"));
				}
				else
					System.out.println("¡Enhorabuena! ¡has acertado!");
				
			} catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!acertado && oportunidades > 0);
		
		if (!acertado)
		System.out.printf("Lo siento, no has acertado, estaba pensando en el %d.%n", num);
	}
}
