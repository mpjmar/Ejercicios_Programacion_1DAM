public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			final double P_BASE = 8;
			final double P_ESPECT = 5;
			final double P_PAREJ = 11;
			double descuento = 0;
			int entrParej = 0;

			System.out.println("");
			System.out.println("Venta de entradas CineTuring");
			System.out.print("Número de entradas: ");
			int entradas = Integer.parseInt(System.console().readLine());

			double total = 0;
			System.out.print("Día de la semana: ");
			String dia = System.console().readLine();

			System.out.print("¿Tiene tarjeta CineTuring? (s/n): ");
			String tarj = System.console().readLine();
			if (tarj.toLowerCase().equals("s"))
				descuento = 0.1;

			System.out.println("");
			System.out.println("Aquí tiene sus entradas. Gracias por su compra.");
			if (dia.toLowerCase().equals("jueves")) {
				if (entradas >= 2) {
					entrParej = entradas / 2;
					total = entrParej * P_PAREJ;
					System.out.printf("%-30s%3d%n", "Entradas parejas", entrParej);
					System.out.printf("%-30s%6.2f%2s%n", "Precio por entrada de pareja", P_PAREJ, "$");
				}
				if (entradas % 2 != 0) {
					total = entrParej * P_PAREJ + P_BASE;
					System.out.printf("%-30s%3s%n", "Entradas individuales", "1");
					System.out.printf("%-30s%6.2f%2s%n", "Precio por entrada individual", P_BASE, "$");
				}

			} else if (dia.toLowerCase().equals("miercoles") || dia.toLowerCase().equals("miércoles")){
				total = entradas * P_ESPECT;
				System.out.printf("%-30s%3d%n", "Entradas individuales", entradas);
				System.out.printf("%-30s%6.2f%2s%n", "Precio por entrada individual", P_ESPECT, "$");
			} else {
				total = entradas * P_BASE;
				System.out.printf("%-30s%3d%n", "Entradas individuales", entradas);
				System.out.printf("%-30s%6.2f%2s%n", "Precio por entrada individual", P_BASE, "$");
			}
			
			double totDesc = total * descuento;
			System.out.printf("""
					%-30s%6.2f%2s
					%-30s%6.2f%2s
					%-30s%6.2f%2s
					""", "Total", total, "$",
								"Descuento", totDesc, "$",
								"A pagar", (total - totDesc), "$");
			
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
