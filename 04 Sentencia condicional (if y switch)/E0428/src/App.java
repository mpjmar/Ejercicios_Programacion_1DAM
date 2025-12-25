public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			int opt1 = 0;
			int opt2 = 0;
			System.out.print("Turno del jugador 1 (introduzca piedra, papel o tijera): ");
			String player1 = System.console().readLine().toLowerCase();
			switch (player1) {
				case "piedra":
					opt1 = 1;
					break;
				case "papel":
					opt1 = 3;
					break;
				case "tijera":
					opt1 = 5;
					break;
				default:
					System.out.println("La opción introducida no es correcta.");
					return ;
			}

			System.out.print("Turno del jugador 2 (introduzca piedra, papel o tijera): ");
			String player2 = System.console().readLine().toLowerCase();
			switch (player2) {
				case "piedra":
					opt2 = 1;
					break;
				case "papel":
					opt2 = 3;
					break;
				case "tijera":
					opt2 = 5;
					break;
				default:
					System.out.println("La opción introducida no es correcta.");
					return ;
			}
			int res = opt1 + opt2;
			if (opt1 == opt2)
				System.out.println("Empate");
			else if ((opt1 == 1 && res == 6) || (opt1 == 3 && (res == 4)) || (opt1 == 5 && (res == 8)))
				System.out.println("Gana el jugador 1");
			else
				System.out.println("Gana el jugador 2");

		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
