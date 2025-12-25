public class App {
    public static void main(String[] args) throws Exception {
        
		System.out.print("Introduzca la base imponible (precio del artículo sin IVA): ");
		double base = Double.parseDouble(System.console().readLine());
		System.out.printf("""
				%n%-20s %5.2f %1s
				%-20s %5.2f %1s
				%s
				%-20s %5.2f %1s
				""", 
				"Base imponible", base, "$",
				"IVA (21%)", base * 0.21, "$",
				"----------------------------",
				"Total", base + base * 0.21, "$");
    }
}
