public class App {
    public static void main(String[] args) throws Exception {
        
		try {

			final int HOUR = 60;
			final int DAY = HOUR * 24;

			System.out.print("Introduzca un día de la semana (de lunes a viernes): ");
			String dia = System.console().readLine();

			int dias = switch (dia.toLowerCase()) {
				case "lunes" -> 5;
				case "martes" -> 4;
				case "miercoles", "miércoles" -> 3;
				case "jueves" -> 2;
				case "viernes" -> 1;
				default -> 0;
			}

			if (dias == 0) {
				System.out.println("El día introducido no es correcto");
				return ;
			}
			System.out.println("A continuación introduzca la hora (hora y minutos)");
			System.out.print("Hora: ");
			int horas = Integer.parseInt(System.console().readLine());

			System.out.print("Minutos: ") ;
			int min = Integer.parseInt(System.console().readLine());

			int rest = (dias * DAY) - (horas * HOUR) - min - (9 * HOUR);

			System.out.printf("Faltan %d minutos para llegar al fin de semana.%n", rest);

		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
