public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.println("");
			System.out.print("Introduzca la base imponible: ");
			double base = Double.parseDouble(System.console().readLine());

			System.out.print("Introduzca el tipo de IVA (general, reducido o superreducido): ");
			String tipoIva = System.console().readLine();
			int porc = switch (tipoIva.toLowerCase()) {
				case "general" -> 21;
				case "reducido" -> 10;
				case "superreducido" -> 4;
				default -> -1;
			}

			if (porc == -1) {
				System.out.println("El tipo introducido no es correcto.");
				return ;
			}

			System.out.print("Introduzca el código promocional (nopro, mitad, meno5 o 5porc): ");
			String cod = System.console().readLine();
			double iva = base * porc / 100;
			double total = base + iva;
			double promo = switch (cod.toLowerCase()) {
				case "mitad" -> total / 2;
				case "meno5" -> total - 5;
				case "5porc" -> total - 0.5 * total;
				default -> 0;
			}

			System.out.printf("%-20s%5.2f%n", "Base imponible", base);
			System.out.printf("%-5s%-2d%-13s%5.2f%n", "IVA (", porc, "%)", iva);
			System.out.printf("%-20s%5.2f%n", "Precio con IVA", base + iva);
			System.out.printf("%-7s%s%-8s%5.2f%n", "Promo (", cod, ") - ", promo);
			System.out.printf("%-20s%5.2f%n", "TOTAL", total - promo);

		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
