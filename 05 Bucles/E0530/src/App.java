public class App {
    public static void main(String[] args) throws Exception {
        
		String dia = "", dia1 = "", dia2 = "";
		int numDia1 = 0, numDia2 = 0;
		int hora1 = 0, hora2 = 0;
		
		for (int i = 1; i <= 2; i++) {
			boolean correcto = false, diaCorrecto = false;
			int numDia = 0;
			int hora = 0;
			System.out.println("Por favor, introduzca la " + (i == 1 ? "primera" : "segunda") + " hora.");
			do {
				try {
					do {
						diaCorrecto = true;
						dia = System.console().readLine("Día: ");
						numDia = switch(dia.toLowerCase()) {
							case "1", "lunes" -> 1;
							case "2", "martes" -> 2;
							case "3", "miercoles", "miércoles" -> 3;
							case "4", "jueves" -> 4;
							case "5", "viernes" -> 5;
							case "6", "sabado", "sábado" -> 6;
							case "7", "domingo" -> 7;
							default -> 0;
						};
						if (numDia == 0) {
							diaCorrecto = false;
							System.out.printf("""
								No se ha introducido correctamente el dia de la semana.
								Los días válidos son: lunes, martes, miércoles, jueves, viernes, sábado y domingo.
								""");
						}
					} while (!diaCorrecto);

					if (i == 2 && numDia < numDia1) { 
						System.out.println("El segundo día debe ser posterior al primero.");
						continue;
					}

					hora = Integer.parseInt(System.console().readLine("Hora: "));
					while (hora < 0 || hora > 23)  {
						System.out.printf("""
								No se ha introducido correctamente la hora del día.
								Las horas válidas están entre 0 y 23.
								""");
						hora = Integer.parseInt(System.console().readLine("Hora: "));
					}

					if (i == 1) {
						dia1 = dia;
						numDia1 = numDia;
						hora1 = hora;
					} else {
						dia2 = dia;
						numDia2 = numDia;
						hora2 = hora;
					}
					correcto = true;
				}
				catch (NumberFormatException e) {
					System.out.println("El número debe ser un entero.");
				}
				catch (Exception e) {
					System.out.println("Ha ocurrido un error inesperado.");
				}
			} while (!correcto);
			
		}
		int diff_dia = (numDia2 - numDia1 - 1) * 24;
		int diff_hora = (24 - hora1) + hora2;
		int diff = diff_dia + diff_hora;
		
		System.out.printf("Entre las %d:00h del %s y las %d:00h del %s hay %d %s.", 
							hora1, dia1, hora2, dia2, diff,
							(diff == 1 ? "hora" : "horas"));
		System.out.println();
    }
}
