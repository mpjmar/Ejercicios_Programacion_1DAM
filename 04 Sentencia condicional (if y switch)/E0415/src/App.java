public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.println("Este programa pinta una pirámide.");
			System.out.print("Introduzca un carácter de relleno: ");
			String c = System.console().readLine();
			System.out.printf("""
					Elija un tipo de pirámide
					1. Con el vértice hacia arriba
					2. Con el vértice hacia abajo
					3. Con el vértice hacia la izquierda
					4. Con el vértice hacia la derecha
					""");
			int vertice = Integer.parseInt(System.console().readLine());
			System.out.println(""); 

			switch (vertice) {
				case 1:
					System.out.println("  " + c);
					System.out.println(" " + c + c + c);
					System.out.println(c + c + c + c + c);
				break;

				case 2:
					System.out.println(c + c + c + c + c);
					System.out.println(" " + c + c + c);
					System.out.println("  " + c);
				break;

				case 3:
					System.out.println("  " + c);
					System.out.println(" " + c + c);
					System.out.println(c + c +c);
					System.out.println(" " + c +c);
					System.out.println("  " + c);
				break;

				case 4:
					System.out.println(c);
					System.out.println(c + c);
					System.out.println(c + c + c);
					System.out.println(c + c);
					System.out.println(c);
				break;

				default:
					System.out.println("La opción introducida no es correcta");
			}

/* 			switch (vertice) {
				case 1 :
					System.out.printf("""
							  %s
							 %s%s%s
							%s%s%s%s%s
							""", c, c, c, c, c, c, c, c, c);
				break;

				case 2 :
					System.out.printf("""
							%s%s%s%s%s
							 %s%s%s
							  %s
							""", c, c, c, c, c, c, c, c, c);
				break;

				case 3 :
					System.out.printf("""
							  %s
							 %s%s
							%s%s%s
							 %s%s
							  %s
							""", c, c, c, c, c, c, c, c, c);
				break;

				case 4 :
					System.out.printf("""
							%s
							%s%s
							%s%s%s
							%s%s
							%s
							""", c, c, c, c, c, c, c, c, c);
				break;
			} */
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
