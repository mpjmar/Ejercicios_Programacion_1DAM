public class App {
    public static void main(String[] args) throws Exception {
		
		int cant = 0;
		int sum = 0;
		try {
			System.out.println("Por favor, vaya introduciendo números. El programa terminará cuando la suma de los números sea mayor que 1000.");
			do  {
				sum += Integer.parseInt(System.console().readLine());
				cant++;
			} while (sum <= 10000);
		}
		catch (NumberFormatException e) {
			System.out.println("Los números deben ser enteros.");
		}
		catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}
		System.out.printf("""
				Ha introducido un total de %d números.
				La suma total es de %d.
				La media es %f
				""", cant, sum, (double) sum / cant);
    }
}
