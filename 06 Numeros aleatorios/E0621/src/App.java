public class App {
    public static void main(String[] args) throws Exception {

		int moneda = 0, cantMon = 8, lado = 0;
		for (int i = 0; i < 5; i++) {
			moneda = (int)(Math.random() * cantMon) + 1;
			System.out.print(switch(moneda) {
				case 1 -> "1 céntimo - ";
				case 2 -> "2 céntimos - ";
				case 3 -> "5 céntimos - ";
				case 4 -> "10 céntimos - ";
				case 5 -> "20 céntimos - ";
				case 6 -> "50 céntimos - ";
				case 7 -> "1 euro - ";
				case 8 -> "2 euros - ";
				default -> "error";
			});
			lado = (int)(Math.random() * 2) + 1;
			System.out.println(switch(lado) {
				case 1 -> "cara";
				case 2 -> "cruz";
				default -> "error";
			});
		}
	}
}
