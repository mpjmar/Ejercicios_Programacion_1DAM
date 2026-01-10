public class App {
    public static void main(String[] args) throws Exception {

		Caballo pegaso = new Caballo("Pegaso", "Pura Sangre", "Blanco", 15, 23);
		Caballo bucefalo = new Caballo("Bucéfalo", "Unicornio", "Celeste", 258, 0);

		System.out.println("El primer caballo se llama " + pegaso.getNombre());
		pegaso.relincha();
		pegaso.rumia();
		pegaso.trota();
		System.out.println();
		
		System.out.println("El segundo caballo se llama " + bucefalo.getNombre());
		bucefalo.trota();
		bucefalo.rumia();
		bucefalo.relincha();
	}
}
