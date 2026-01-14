import vehiculos.Vehiculo;
import vehiculos.Bicicleta;
import vehiculos.Coche;

public class App {
    public static void main(String[] args) throws Exception {

		int opcion = 0;
		int kms;
		boolean valida = false;

		Bicicleta bici = new Bicicleta(9);
		Coche coche = new Coche(1900);

		do {
			System.out.printf("""
					VEHICULOS
					=========
					1. Anda con la bicicleta
					2. Haz el caballito con la bicicleta
					3. Anda con el coche
					4. Quema rueda con el coche
					5. Ver kilometraje de la bicicleta
					6. Ver kilometraje del coche
					7. Ver kilometraje total
					8. Salir
					Elige una opción (1-8): """);
			try {
				do {
					opcion = Integer.parseInt(System.console().readLine());
					valida = opcion > 0 && opcion < 9;
					if (!valida) System.out.println("La opción introducida no es válida.");
				} while (!valida);
			} catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
			
			switch (opcion) {
				case 1, 3:
					System.out.print("¿Cuántos kms?: ");
					kms = Integer.parseInt(System.console().readLine());
					if (opcion == 1)
						bici.recorre(kms);
					else
						coche.recorre(kms);
					break;
				case 2:
					bici.hazCaballito();
					break;
				case 4:
					coche.quemaRuedas();
					break;
				case 5, 6:
					System.out.printf("El kilometraje de%s es: ", opcion == 5 ? " la bicicleta" : "l coche");
					System.out.println((opcion == 5 ? bici.getKilometrosRecorridos() : coche.getKilometrosRecorridos()) + " Kms.");
					break;
				case 7:
					System.out.println("El kilometraje total es " + Vehiculo.getKilometrosTotales() + " Kms.");
			}
			System.out.println();
		} while (opcion != 8);
	}
}
