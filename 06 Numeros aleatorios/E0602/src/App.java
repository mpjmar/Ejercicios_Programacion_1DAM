public class App {
    public static void main(String[] args) throws Exception {

		int carta = (int)(Math.random() * 13) + 1;
		System.out.print(carta > 1 && carta < 11 ? carta : 
		switch (carta) {
				case 1 -> "A";
				case 11 -> "J";
				case 12 -> "Q";
				case 13 -> "K";
				default -> "Error";
			});

		System.out.print(" de ");
		
		int palo = (int)(Math.random() * 4) + 1;
		System.out.println(switch (palo) {
								case 1 -> "picas";
								case 2 -> "corazones";
								case 3 -> "diamantes";
								case 4 -> "tréboles";
								default -> "Error";
							});
	}
}
