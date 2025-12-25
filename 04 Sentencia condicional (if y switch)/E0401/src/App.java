public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.print("Por favor, introduzca un día de la semana y le diré qué asignatura toca a primera hora ese día: ");
			String dia = System.console().readLine().toLowerCase();
			String asignatura;

			switch (dia) {
				case "lunes" -> asignatura = "Sistemas informáticos";
				case "martes" -> asignatura = "Programación";
				case "miercoles", "miércoles" -> asignatura = "Sistemas informáticos";
				case "jueves" -> asignatura = "IPE 1";
				case "viernes" -> asignatura = "Bases de datos";
				case "sabado", "sábado", "domingo" -> asignatura = "Este día no hay clase!";
				default -> asignatura = "El día introducido no es correcto.";
			}
			System.out.println(asignatura);
		}
		catch (NullPointerException e) {
			System.out.println("Error reading from the console");
		}
		catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
