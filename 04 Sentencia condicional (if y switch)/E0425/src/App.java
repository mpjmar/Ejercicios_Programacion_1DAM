public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.println("");

			final double M2 = 0.01;
			final double GTOS = 3.25;

			System.out.print("Introduzca la altura de la bandera en cm: ");
			int alto = Integer.parseInt(System.console().readLine());

			System.out.print("Ahora introduzca la anchura: ");
			int ancho = Integer.parseInt(System.console().readLine());

			System.out.print("¿Quiere escudo bordado? (s/n): ");
			String escudo = System.console().readLine();
			double esc = 0;

			int tam = alto * ancho;
			double precBand = tam * M2;
			
			System.out.printf("""
					%s
					%-10s%6d%5s%6.2f%2s
					""", "Gracias. Aquí tiene el desglose de su compra.",
								"Bandera de", tam, "cm2:", precBand, "$");

			if (escudo.toLowerCase().equals("n")) {
				esc = 0;
				System.out.printf("%-21s%6.2f%2s%n", "Sin escudo:", esc, "$");
			}
			else if (escudo.toLowerCase().equals("s")) {
				esc = 2.5;
				System.out.printf("%-21s%6.2f%2s%n", "Con escudo:", esc, "$");
			} else {
				System.out.println("Invalid input");
				return ;
			}

			double total = precBand + esc + GTOS;
			System.out.printf("""		
					%-21s%6.2f%2s
					%-21s%6.2f%2s
					""", "Gastos de envío:", GTOS, "$",
								"Total:", total, "$");

		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
