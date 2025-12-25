public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			int n = Integer.parseInt(System.console().readLine("Introduzca un número: "));
			System.out.printf(
				"""
				   n   |    n\u00B2   |    n\u00B3
				----------------------------
					""");
			for (int i = 0; i < 5; i++) {
				System.out.printf(
					"""
					%6d | %7d | %8d
						""",
					n + i,
					(int)Math.pow(n + i, 2),
					(int)Math.pow(n + i, 3));
			}
		} catch (NumberFormatException e) {
			System.out.println("El número debe ser entero");
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado");
		}
    }
}
