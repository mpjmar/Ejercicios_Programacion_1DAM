public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Por favor, introduce la hora del día (0 - 23): ");
		int hora = Integer.parseInt(System.console().readLine());

		try {
			if (hora >= 6 && hora <= 12)
				System.out.println("Buenos días");
			else if (hora >= 13 && hora <= 20)
				System.out.println("Buenas tardes");
			else if ((hora >= 21 && hora <= 23) || (hora >= 0 && hora <= 5))
				System.out.println("Buenas noches");
			else
				System.out.println("La hora introducida no es correcta.");
		}
		catch(NullPointerException e) {
			System.out.println("Error reading from the console");
		}
		catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
