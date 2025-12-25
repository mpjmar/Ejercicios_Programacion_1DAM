import Biblioteca.Operaciones;

public class App {
    public static void main(String[] args) throws Exception {

        String[] reyes = Operaciones.solicitarDatos();
        int ordinales[] = new int[reyes.length];

        System.out.println();
        for (int i = 0; i < reyes.length; i++)
            System.out.println(Operaciones.mostrarReyConOrdinal(reyes, ordinales, reyes[i]));
    }
}
