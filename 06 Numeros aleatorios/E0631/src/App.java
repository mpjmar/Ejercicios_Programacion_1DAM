public class App {
    public static void main(String[] args) throws Exception {
		
		int dado1, dado2, suma1, suma2 = 0;

		System.out.print("""
				┏━━━━━━━━━━━━━━━━━━━━━━━┓
				┃ ⚀ C ⚁ R ⚂ A ⚃ P ⚄ S ⚄ ┃
				┗━━━━━━━━━━━━━━━━━━━━━━━┛
				¿Cuánto dinero quiere apostar?\s """);
			
		int cantidad = Integer.parseInt(System.console().readLine());

		dado1 = (int)(Math.random() * 6) + 1;
		dado2 = (int)(Math.random() * 6) + 1;
		suma1 = dado1 + dado2;

		System.out.printf("""
				Dado 1: %d
				Dado 2: %d
				Suma: %d
				""", dado1, dado2, suma1);

		if (suma1 == 7 || suma1 == 11)
			System.out.printf("Enhorabuena, ha ganado otros %d euros.%n", cantidad);
		else if (suma1 == 2 || suma1 == 3 || suma1 == 12)
			System.out.println("Lo siento, ha perdido todo su dinero.");
		else {
			System.out.printf("""
					Tiene que seguir tirando, debe conseguir el %d para ganar.
					Si obtiene un 7, perderá la partida.
					Pulse INTRO para tirar los dados.
					
					""", suma1);
			System.console().readLine();
			do {
				dado1 = (int)(Math.random() * 6 + 1);
				dado2 = (int)(Math.random() * 6 + 1);
				suma2 = dado1 + dado2;

				System.out.printf("""
						Dado 1: %d
						Dado 2: %d
						Suma: %d
						""", dado1, dado2, suma2);
				
				if (suma2 != suma1 && suma2 != 7) {
					System.out.println("""
							Continúe jugando.
							Pulse INTRO para tirar los dados.
							""");
					System.console().readLine();
				}
			} while (suma2 != suma1 && suma2 != 7);
		}
		System.out.printf(suma1 == suma2 ? "¡Enhorabuena! ¡Ha ganado otros %d euros!%n¡Ahora tiene %d euros!%n" 
										: suma2 == 7 ? "Lo siento, ha perdido todo su dinero%n" : "", cantidad, cantidad * 2);
	}
}
