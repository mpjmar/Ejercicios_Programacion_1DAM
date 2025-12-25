import biblioteca.Operaciones;

public class App {
    public static void main(String[] args) throws Exception {

        int longitud = 0, min = 0, max = 0;
        try {
            System.out.print("Introduzca el tamaño del array: ");
            longitud = Integer.parseInt(System.console().readLine());
            System.out.print("Introduzca el valor mínimo: ");
            min= Integer.parseInt(System.console().readLine());
            System.out.print("Introduzca el valor máximo: ");
            max = Integer.parseInt(System.console().readLine());
        }
        catch (NumberFormatException e) {
            System.out.println("El número debe ser un entero.");
        }
        catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado.");
        }
        int[] array = Operaciones.crearArray(longitud, min, max);
        System.out.println();

        System.out.println("Array original: ");
        Operaciones.muestraArray(array);
        System.out.println();

        int[] resultado = Operaciones.recolocaArray(array);
        System.out.println("Array resultado: ");
        Operaciones.muestraArray(resultado);
        System.out.println();
    }
}
