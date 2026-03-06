import java.io.IOException;

import biblioteca.EscribaReal;

public class App {
    public static void main(String[] args) throws Exception {

		EscribaReal escriba = new EscribaReal("codice.txt");

		String relato1 = "El dragón dormía bajo la luna plateada, soñando con mares lejanos.";
		String relato2 = "La bruja tejía hechizos mientras la tormenta rugía afuera.";
		String relato3 = "Un viajero encontró un mapa antiguo que lo llevó a un tesoro olvidado.";

		escriba.agregarRelato(relato1);
		escriba.agregarRelato(relato2);
		escriba.agregarRelato(relato3);

		String relato4 = "Este es el relato 4";
		String relato5 = "Este es el relato 5";

		escriba.agregarRelato(relato4);
		escriba.agregarRelato(relato5);

		try {
			escriba.guardarRelatosEnCodice();
			System.out.printf("Oh, viajero, este códice contiene %d relatos de antaño:%n", escriba.getCodice().getRelatosExistentes());
			System.out.println(escriba.getCodice().leerCodice());
			escriba.getCodice().borrarCodice();
		} catch (IOException ioe) {
			System.out.println("Error al gestionar el códice: " + ioe.getMessage());
		}
	}
}
