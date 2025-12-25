import biblioteca.Operaciones;

public class App {
    public static void main(String[] args) throws Exception {

        int array[] = Operaciones.generaArray(15, 0, 500);
        System.out.println("Array original: ");
        Operaciones.muestraArray(array);
        System.out.printf("%n%n");
        int cincuerizado[] = Operaciones.cincuerizaArray(array);
        System.out.println("Array cincuerizado: ");
        Operaciones.muestraArray(cincuerizado);
        System.out.println();
    }
}
