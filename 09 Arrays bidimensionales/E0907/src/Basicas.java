public class Basicas {


    public static int leeEntero(int filas, int columnas) {
        int entero = 0;
        boolean correcto = false;
        do {
            try {
                entero = Integer.parseInt(System.console().readLine());
                correcto = entero <= filas && entero <= columnas;
            } catch (NumberFormatException e) {
                System.out.println("El número debe ser un entero.");
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado.");
            }
        } while (!correcto);
        return entero;
    }

    public static int generaAleat(int min, int max) {
        int coordenada = (int)(Math.random() * (max - min + 1)) + min;
        return coordenada;
    }
}
