public class App {
    public static void main(String[] args) throws Exception {

		int figura = 0, tirada = 3;
		int fig1 = 0, fig2 = 0, fig3 = 0;

		for (int i = 1; i <= tirada; i++) {
			figura = (int)(Math.random() * 5) + 1;
			System.out.print(switch (figura) {
				case 1 -> "corazón";
				case 2 -> "diamante";
				case 3 -> "herradura";
				case 4 -> "campana";
				case 5 -> "limón";
				default -> "error";
			});
			if (i == 1) fig1 = figura;
			else if (i == 2) fig2 = figura;
			else fig3 = figura;
			System.out.print(" ");
		}
		System.out.println();
		int coincidencias = 0;
		if (fig1 == fig2) coincidencias++;
		if (fig2 == fig3) coincidencias++;

		System.out.println(switch (coincidencias) {
			case 0 -> "Lo siento, ha perdido.";
			case 1 -> "Bien, ha recuperado su moneda.";
			case 2 -> "Enhorabuena, ha ganado 10 monedas.";
			default -> "Error";
		});
	}
}
