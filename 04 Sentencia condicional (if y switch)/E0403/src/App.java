public class App {
    public static void main(String[] args) throws Exception {

		try {
			System.out.print("Por favor, introduzca un número del 1 al 7: ");
			int num = Integer.parseInt(System.console().readLine());
	
			String dia;
			switch (num) {
				case 1 -> dia = "lunes";
				case 2 -> dia = "martes";
				case 3 -> dia = "miércoles";
				case 4 -> dia = "jueves";
				case 5 -> dia = "viernes";
				case 6 -> dia = "sábado";
				case 7 -> dia = "domingo";
				default -> dia = "el número introducido es incorrecto";
			}
			System.out.println(dia);
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid input");
		}
		catch (Exception e) {
			System.out.println("Unexpected errror");
		}
    }
}
