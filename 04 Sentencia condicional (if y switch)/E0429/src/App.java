public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			double precioC = 0;
			double precioB = 0;
			String pitufo = "";

			System.out.print("¿Qué ha tomado de comer? (palmera, donut o pitufo): ");
			String comida = System.console().readLine().toLowerCase();
			if (comida.equals("pitufo")) {
				System.out.print("¿Con qué se ha tomado el pitufo? (aceite o tortilla): ");
				pitufo = System.console().readLine().toLowerCase();
				if (pitufo.equals("aceite"))
					precioC = 1.20;
				else if (pitufo.equals("tortilla"))
					precioC = 1.60;
				else
					System.out.println("La opción no es correcta.");
			} else {
				switch (comida) {
					case "palmera" -> precioC = 1.40;
					case "donut" -> precioC = 1.00;
					default -> System.out.println("La opción no es correcta.");
				}
			}
			System.out.print("¿Qué ha tomado de beber? (zumo o café): ");
			String bebida = System.console().readLine().toLowerCase();
			precioB = bebida.equals("zumo") ? 1.50 : 1.20;
			
			switch (comida) {
				case "palmera" -> System.out.printf("Palmera: %.2f $%n", precioC);
				case "donut" -> System.out.printf("Donut: %.2f $%n", precioC);
				case "pitufo" -> System.out.printf("Pitufo con %s: %.2f $%n", pitufo, precioC);
				default -> System.out.println("Error");
			};
			
			switch (bebida) {
				case "zumo" -> System.out.printf("Zumo: %.2f $%n", precioB);
				case "cafe", "café" -> System.out.printf("Café: %.2f $%n", precioB);
				default -> System.out.println("Error");
			}
			System.out.printf("Total desayuno: %.2f $%n", precioC + precioB);

		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
