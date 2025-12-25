public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			int puntos = 0;
			String respuesta = "";
			System.out.println("TEST DE FIDELIDAD");
			System.out.println("Este programa te dirá si hay probabilidad de que tu pareja está siendo infiel.");

			System.out.println("1. Tu pareja parece estar más inquieta de lo normal sin ningún motivo aparente.");
			System.out.print("(v)verdadero o (f)falso: ");
			respuesta = System.console().readLine();
			if (respuesta.equals("v")) puntos += 3;

			System.out.println("2. Ha aumentado sus gastos de vestuario.");
			System.out.print("(v)verdadero o (f)falso: ");
			respuesta = System.console().readLine();
			if (respuesta.equals("v")) puntos += 3;

			System.out.println("3. Ha perdido el interés que mostraba anteriormente en ti.");
			System.out.print("(v)verdadero o (f)falso: ");
			respuesta = System.console().readLine();
			if (respuesta.equals("v")) puntos += 3;

			System.out.print("4. Ahora se efeita y se asea con más frecuencia (si es hombre) o ahora se arregla el pelo ");
			System.out.println("y se asea con más frecuencia.");
			System.out.print("(v)verdadero o (f)falso: ");
			respuesta = System.console().readLine();
			if (respuesta.equals("v")) puntos += 3;

			System.out.println("5. No te deja que mires la agenda de su teléfono móvil.");
			System.out.print("(v)verdadero o (f)falso: ");
			respuesta = System.console().readLine();
			if (respuesta.equals("v")) puntos += 3;

			System.out.println("6. A veces tiene llamadas que dice no querer contestar cuando estás tú delante.");
			System.out.print("(v)verdadero o (f)falso: ");
			respuesta = System.console().readLine();
			if (respuesta.equals("v")) puntos += 3;

			System.out.println("7. Últimamente se preocupa más en cuidar la línea y/o estar bronceado/a.");
			System.out.print("(v)verdadero o (f)falso: ");
			respuesta = System.console().readLine();
			if (respuesta.equals("v")) puntos += 3;

			System.out.println("8. Muchos días viene tarde después de trabajar porque dice tener mucho más trabajo.");
			System.out.print("(v)verdadero o (f)falso: ");
			respuesta = System.console().readLine();
			if (respuesta.equals("v")) puntos += 3;
			
			System.out.println("9. Has notado que últimamente se perfuma más.");
			System.out.print("(v)verdadero o (f)falso: ");
			respuesta = System.console().readLine();
			if (respuesta.equals("v")) puntos += 3;

			System.out.println("10. Se confunde y te dice que ha estado en sitios donde no ha ido contigo.");
			System.out.print("(v)verdadero o (f)falso: ");
			respuesta = System.console().readLine();
			if (respuesta.equals("v")) puntos += 3;

			System.out.println("");
			if (puntos <= 10)
				System.out.println("¡Enhorabuena! tu pareja parece ser totamente fiel.");
			else if (puntos > 10 && puntos <= 22) {
				System.out.print("Quizás exista el peligro de otra persona en su vida o en su mente, aunque seguramente será algo ");
				System.out.println("sin importancia. No bajes la guardia.");
			}
			else {
				System.out.print("Tu pareja tiene todos los ingredientes para estar viviendo un romance con otra persona. ");
				System.out.println("Te aconsejamos que indagues un poco más y averigües que es lo que está pasando por su cabeza.");
			}
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
