public class App {
    public static void main(String[] args) throws Exception {
        
		int puntos = 0;

		try {
			System.out.println("CUESTIONARIO DE 1º DAM");
			System.out.print("""
					1. ¿Cuál de los siguientes tipos de datos de Java tiene más precisión?
					a) int
					b) double
					c) float
					==> """);
			String answer = System.console().readLine();
			System.out.println(answer.equals("b") ? "Correcto" : "Incorrecto");
			if (answer.equals("b")) puntos++;
			System.out.println("");

			System.out.printf("""
					2. ¿Cuál es el lenguaje que se utiliza para hacer consultas en las bases de datos?
					a) XML
					b) SELECT
					c) SQL
					==> """);
			answer = System.console().readLine();
			System.out.println(answer.equals("c") ? "Correcto" : "Incorrecto");
			if (answer .equals("c")) puntos++;
			System.out.println("");

			System.out.printf("""
					3. Para insertar un hiperenlace en un página se utiliza la etiqueta...
					a) href
					b) a
					c) link
					==> """);
			answer = System.console().readLine();
			System.out.println(answer.equals("b") ? "Correcto" : "Incorrecto");
			if (answer .equals("b")) puntos++;
			System.out.println("");

			System.out.printf("""
					4. ¿En qué directorio se encuentran los archivos de configuración de Linux?
					a) /etc
					b) /config
					c) /cfg
					==> """);
			answer = System.console().readLine();
			System.out.println(answer.equals("a") ? "Correcto" : "Incorrecto");
			if (answer.equals("a")) puntos++;
			System.out.println("");

			System.out.printf("""
					5. ¿Cuál de las siguientes memorias es volátil?
					a) RAM
					b) EPROM
					c) ROM
					==> """);
			answer = System.console().readLine();
			System.out.println(answer.equals("a") ? "Correcto" : "Incorrecto");
			if (answer.equals("a")) puntos++;
			System.out.println("");

			System.out.printf("Ha obtenido %d puntos", puntos);
		}
		catch (NullPointerException e)
		{
			System.out.println("Error reading from the console");
		}
		catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
