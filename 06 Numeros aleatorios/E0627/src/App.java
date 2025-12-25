public class App {
    public static void main(String[] args) throws Exception {

		String jugada = "";
		boolean correcto = false;

		do {
			try {
				System.out.print("Turno del jugador (introduzca piedra, papel o tijera): ");
				jugada = System.console().readLine().toLowerCase();
				correcto = jugada.equals("piedra") || jugada.equals("papel") || jugada.equals("tijera");
				if (!correcto) System.out.println("Opción incorrecta.");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		int opcion = (int)(Math.random() * 3) + 1;
		String jugAleat = switch (opcion) {
			case 1 -> "piedra";
			case 2 -> "papel";
			case 3 -> "tijera";
			default -> "error";
		};
		System.out.println("Turno del ordenador: " + jugAleat);

		if (jugada.equals(jugAleat)) 
			System.out.println("Empate");
		else {
			int ganador = 1;
			switch (jugada) {
				case "piedra":
					if (jugAleat.equals("papel")) ganador = 2;
					break;
				case "papel":
					if (jugAleat.equals("tijera")) ganador = 2;
					break;
				case "tijera":
					if (jugAleat.equals("piedra")) ganador = 2;
					break;
				default:
					break;
				}
			System.out.printf("Gana el %s %n", ganador == 1 ? "jugador" : "ordenador");
		}
	}
}
