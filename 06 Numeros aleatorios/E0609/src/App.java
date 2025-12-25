public class App {
    public static void main(String[] args) throws Exception {

		int aleatorio = 0, cont = 0;

		do {
			aleatorio = (int)(Math.random() * 101);
			if (aleatorio % 2 == 0) {
				System.out.printf("%d ",aleatorio);
				cont++;
			}
		} while (aleatorio != 24);
		System.out.printf("%nSe han generado %d números.%n", cont);
	}
}
