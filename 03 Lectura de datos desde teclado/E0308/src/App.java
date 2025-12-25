public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Introduzca el número de horas trabajadas durante la semana: ");
		int horas = Integer.parseInt(System.console().readLine());
		System.out.println("Su salario semanal es de " + horas * 12 + " euros");
    }
}
