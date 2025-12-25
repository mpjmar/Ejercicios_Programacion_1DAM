public class App {
    public static void main(String[] args) throws Exception {

		int estacion = 0, tMin = 0, tMax = 0;
		String cielo = "";
		boolean correcto = false;

		do {
			System.out.print("""
					1. Primavera
					2. Verano
					3. Otoño
					4. Invierno
					Seleccione la estación del año (1-4): """);
			try {
				estacion = Integer.parseInt(System.console().readLine());
				correcto = estacion > 0 && estacion < 5;
				if (!correcto) System.out.println("La opción introducida no es correcta.");
			} catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		switch (estacion) {
			case 1:
				tMax = (int)(Math.random() * (30 - 15 + 1)) + 15;
				tMin = (int)(Math.random() * tMax - 15 + 1) + 15;
				cielo = Math.random() >= 0.6 ? "Soleado" : "Nublado";
			break;
			case 2:
				tMax = (int)(Math.random() * (45 - 25 + 1)) + 25;
				tMin = (int)(Math.random() * tMax - 25 + 1) + 25;
				cielo = Math.random() >= 0.8 ? "Soleado" : "Nublado";
			break;
			case 3:
				tMax = (int)(Math.random() * (30 - 20 + 1)) + 20;
				tMin = (int)(Math.random() * tMax - 20 + 1) + 20;
				cielo = Math.random() >= 0.4 ? "Soleado" : "Nublado";
			break;
			case 4:
				tMax = (int)(Math.random() * 25);
				tMin = (int)(Math.random() * tMax - 25 + 1) + 25;
				cielo = Math.random() >= 0.2 ? "Soleado" : "Nublado";
			break;
		}
		
		System.out.printf("""

				Previsión del tiempo para mañana
				--------------------------------
				Temperatura mínima: %dºC
				Temperatura máxima: %dºC
				%s
				""", tMin, tMax, cielo);
	}
}
