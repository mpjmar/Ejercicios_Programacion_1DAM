public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.print("Elija un sabor (manzana, fresa o chocolate): ");
			String sabor = System.console().readLine().toLowerCase();
			double precio = 0;
			double P_NATA = 2.50;
			double P_NOMBRE = 2.75;
			String tipo = "";
			switch (sabor) {
				case "manzana":
					precio = 18.00;
					break;
				case "fresa":
					precio = 16.00;
					break;
				case "chocolate":
					System.out.print("¿Qué tipo de chocolate quiere (negro o blanco): ");
					tipo = System.console().readLine().toLowerCase();
					switch (tipo) {
						case "negro":
							precio = 14.00;
							break;
						case "blanco":
							precio = 15.00;
							break;
						default:
							System.out.println("La opción introducida no es correcta.");
							return ;
					}
					break;
				default:
					System.out.println("La opción introducida no es correcta.");
					return ;
			}
			System.out.print("¿Quiere nata? (si o no): ");
			String nata = System.console().readLine().toLowerCase();
			
			System.out.print("¿Quiere ponerle un nombre? (si o no): ");
			String nombre = System.console().readLine().toLowerCase();

			System.out.printf("Tarta de %s ", sabor);
			if (sabor.equals("chocolate"))
				System.out.printf("%s", tipo);
			System.out.printf(": %.2f $%n", precio);
		
			double total = precio;
			if (nata.equals("si")) {
				System.out.printf("Con nata: %.2f $%n", P_NATA);
				total += P_NATA;
			}

			if (nombre.equals("si")) {
				System.out.printf("Con nombre: %.2f $%n", P_NOMBRE);
				total += P_NOMBRE;
			}

			System.out.printf("Total: %.2f $%n", total);
			
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
