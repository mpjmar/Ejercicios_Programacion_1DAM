public class App {
    public static void main(String[] args) throws Exception {

		try {
			System.out.print("A continuación deberá introducir una hora del día, ");
			System.out.println("primero introducirá la hora y luego los minutos.");
			
			System.out.print("hora: ");
			int hora = Integer.parseInt(System.console().readLine());
	
			System.out.print("minuto: ");
			int min = Integer.parseInt(System.console().readLine());
	
			if (hora < 0 || hora > 23 || min < 0 || min > 59)
				return;
			
			int rest = (24 * 3600) - (hora * 3600 + min * 60);
	
			System.out.printf("Desde las %02d:%02d hasta la medianoche faltan %d segundos.%n", hora, min, rest);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
