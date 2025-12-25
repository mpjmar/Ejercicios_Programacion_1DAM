public class App {
    public static void main(String[] args) throws Exception {

		int carta = (int)(Math.random() * 10) + 1;
		System.out.print(carta > 1 && carta < 8 ? carta : 
							switch (carta) {
								case 1 -> "As";
								case 8 -> "Sota";
								case 9 -> "Caballo";
								case 10 -> "Rey";
								default -> "Error";
							});
		System.out.print(" de ");
		int palo = (int)(Math.random() * 4) + 1;
		System.out.println(switch (palo) {
								case 1-> "Copas";
								case 2 -> "Bastos";
								case 3 -> "Espadas";
								case 4 -> "Oros";
								default -> "Error";
		});
	}
}
