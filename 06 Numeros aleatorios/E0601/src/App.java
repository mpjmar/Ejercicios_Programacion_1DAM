public class App {
    public static void main(String[] args) throws Exception {

		int suma = 0; 

		System.out.print("Tirada de tres dados: ");
		
		for (int i = 0; i < 3; i++) {
			int res = (int)(Math.random() * 6) + 1;
			System.out.print(res + " ");
			suma += res;
		}
		System.out.printf("%nSuma: %d%n", suma);
	}
}
