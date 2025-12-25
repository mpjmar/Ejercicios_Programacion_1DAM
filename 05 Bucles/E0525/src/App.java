public class App {
    public static void main(String[] args) throws Exception {
        
		int num = 0;
		boolean correcto = false;
		do {
			try {
				num = Integer.parseInt(System.console().readLine("Introduzca un número entero: "));
				correcto = true;
			}
			catch (NumberFormatException e) {
				System.out.println("En número debe ser un entero.");
			}
			catch (Exception e){
				System.out.println("Ha ocurrido un error inesperado.");
			}
		while (!correcto); 
		int reves = 0;
		int	n = num;
		while (num > 0) {
			reves = reves * 10 + num % 10;
			num /= 10;
		}
		System.out.printf("Si le damos las vuelta al %d tenemos el %d%n", n, reves);
    }
}
