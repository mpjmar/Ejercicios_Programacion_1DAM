public class App {
    public static void main(String[] args) throws Exception {

		try {
			System.out.print("Introduzca el número de horas trabajadas durante la semana: ");
			int horas = Integer.parseInt(System.console().readLine());
			int salario = horas < 40 ? (horas * 12) : (40 * 12 + (horas - 40) * 16);
			System.out.println("El sueldo semanal que le corresponde es " + salario + " euros");
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
        
    }
}
