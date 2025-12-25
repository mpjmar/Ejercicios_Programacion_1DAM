public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.println("Este programa le dirá cuál es su horóscopo a partir de su fecha de nacimiento.");
			
			System.out.print("Introduzca el número del mes en que nació (1-12): ");
			int mes = Integer.parseInt(System.console().readLine());
	
			System.out.print("Ahora introduzca el día: ");
			int dia = Integer.parseInt(System.console().readLine());
	
			String horoscopo = "";
	
			if ((mes == 1 && dia >= 21) && (mes == 2 && dia <= 19))
				horoscopo = "Acuario";
			else if ((mes == 2 && dia >= 20) && (mes == 3 && dia <= 20))
				horoscopo = "Piscis";
			else if ((mes == 3 && dia >= 21) && (mes == 4 && dia <= 20))
				horoscopo = "Aries";
			else if ((mes == 4 && dia >= 21) && (mes == 5 && dia <= 20))
				horoscopo = "Tauro";
			else if ((mes == 5 && dia >= 21) && (mes == 6 && dia <= 21))
				horoscopo = "Géminis";
			else if ((mes == 5 && dia >= 22) && (mes == 7 && dia <= 22))
				horoscopo = "Cancer";
			else if ((mes == 7 && dia >= 23) && (mes == 8 && dia <= 23))
				horoscopo = "Leo";
			else if ((mes == 8 && dia >= 24) && (mes == 9 && dia <= 23))
				horoscopo = "Virgo";
			else if ((mes == 9 && dia >= 24) && (mes == 10 && dia <= 23))
				horoscopo = "Libra";
			else if ((mes == 10 && dia >= 24) && (mes == 11 && dia >= 22))
				horoscopo = "Escorpio";
			else if ((mes == 11 && dia >= 23) && (mes == 12 && dia <= 21))
				horoscopo = "Sagitario";
			else if ((mes == 12 && dia >= 22) && (mes == 01 && dia <= 20))
				horoscopo = "Capricornio";
	
			/* switch (mes) {
				case 1:
					horoscopo = (dia >= 21) ? "Acuario" : "Capricornio";
					break;
				case 2:
					horoscopo = (dia >= 20) ? "Piscis" : "Acuario";
					break;
				case 3:
					horoscopo = (dia >= 21) ? "Aries" : "Piscis";
					break;
				case 4:
					horoscopo = (dia >= 21) ? "Tauro" : "Aries";
					break;
				case 5:
					horoscopo = (dia >= 21) ? "Géminis" : "Tauro";
					break;
				case 6:
					horoscopo = (dia >= 22) ? "Cáncer" : "Géminis";
					break;
				case 7:
					horoscopo = (dia >= 23) ? "Leo" : "Cáncer";
					break;
				case 8:
					horoscopo = (dia >= 24) ? "Virgo" : "Leo";
					break;
				case 9:
					horoscopo = (dia >= 24) ? "Libra" : "Virgo";
					break;
				case 10:
					horoscopo = (dia >= 24) ? "Escorpio" : "Libra";
					break;
				case 11:
					horoscopo = (dia >= 23) ? "Sagitario" : "Escorpio";
					break;
				case 12:
					horoscopo = (dia >= 22) ? "Capricornio" : "Sagitario";
					break;
				default:
					horoscopo = "Mes inválido";
			} */
	
			System.out.println("Su horóscopo es " + horoscopo);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
