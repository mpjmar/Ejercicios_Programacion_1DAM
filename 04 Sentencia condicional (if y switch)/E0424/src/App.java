public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.println("");
			System.out.printf("""
					1 - Programador junior
					2 - Prog. senior
					3 - Jefe proyecto
					Introduzca el cargo del empleado (1 - 3): 		  
					""");
			int cargo = Integer.parseInt(System.console().readLine());
			double base = switch (cargo) {
				case 1 -> 950.00;
				case 2 -> 1200.00;
				case 3 -> 1600.00;
				default -> throw new NumberFormatException();
			}
			
			System.out.print("¿Cuántos días ha estado de viaje visitando clientes?: ");
			int dias = Integer.parseInt(System.console().readLine());
			double dietas = dias * 30;
			double bruto = base + dietas;

			System.out.print("Introduzca su estado civil (1 - Soltero, 2 - Casado): ");
			int estado = Integer.parseInt(System.console().readLine());
			int irpf = switch (estado) {
				case 1 -> 25;
				case 2 -> 20;
				default -> 20;
			}
			double totIrpf = bruto * irpf / 100;
			double neto = bruto - totIrpf;

			System.out.println("-----------------------------------");
			System.out.printf("%-25s%8.2f%s%n", "| Sueldo base", base, " |");
			System.out.printf("%-8s%2d%-1s%13.2f%s%n", "| Dietas (", dias, " viajes)", dietas, " |");
			System.out.println("----------------------------------");
			System.out.printf("%-25s%8.2f%s%n", "| Sueldo bruto", bruto, " |");
			System.out.printf("%-8s%2d%-7s%5.2f%s%n", "| Retención IRPF (", irpf, " %)", totIrpf, " |");
			System.out.println("----------------------------------");
			System.out.printf("%-25s%8.2f%s%n", "| Sueldo neto", neto, " |");
			System.out.println("-----------------------------------");

		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
			return ;
		} catch (Exception e) {
			System.out.println("Unexpected error");
			return ;
		}
    }
}
