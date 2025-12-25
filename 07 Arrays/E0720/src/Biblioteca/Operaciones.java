package Biblioteca;

public class Operaciones {
    
    public static String[] solicitarDatos() {
        String reyes[] = {};
        int cantidad = 0;

        try {
            System.out.print("Introduzca el número total de nombres de reyes: ");
            cantidad = Integer.parseInt(System.console().readLine());
            reyes = new String[cantidad];
        }
        catch (NumberFormatException e) {
            System.out.println("El número debe ser un entero.");
        }
        catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado.");
        }

        System.out.println("Vaya introduciendo los nombres de los reyes y pulsando INTRO: ");
        for (int i = 0; i < cantidad; i++)
            reyes[i] = System.console().readLine().toLowerCase();

        return reyes;
    }

    public static String mostrarReyConOrdinal(String array[], int ordinales[], String nombre) {
        return String.format("%s %dº", inicialMayuscula(nombre), asignarOrdinal(array, ordinales, nombre));
    }

    public static String inicialMayuscula(String nombre) {
        String inicialMay = "";
        for (int i = 0; i < nombre.length(); i++)
            inicialMay += i == 0 || nombre.charAt(i - 1) == ' ' ? Character.toUpperCase(nombre.charAt(i)) : nombre.charAt(i);
        return inicialMay;
    }

    public static int asignarOrdinal(String reyes[], int ordinales[], String nombre) {
        int i = 0;
        while (i < reyes.length) {
            if (reyes[i].equals(nombre)) {
                ordinales[i]++;
                break;
            }
            i++;
        }
        return ordinales[i];
    }
}
