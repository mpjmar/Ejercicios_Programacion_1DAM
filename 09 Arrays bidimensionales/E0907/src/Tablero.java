public class Tablero {

    public static void juega(String[][] tablero, int intentos) {
        boolean encontrado = false;
        System.out.println("¡BUSCA EL TESORO!");
        do {
            muestraTablero(tablero);
            encontrado = pideCoordenadas(tablero);
            intentos--;
        } while (intentos > 0 || !encontrado);
    }

    public static boolean pideCoordenadas(String[][] tablero) {
        boolean encontrado = false;
        System.out.print("Coordenada x: ");
        int x = Basicas.leeEntero(tablero.length, tablero[0].length);
        System.out.print("Coordenada y: ");
        int y = Basicas.leeEntero(tablero.length, tablero[0].length);
        switch (tablero[x][y]) {
            case "* ":
                System.out.println("¡Lo siento, has encontrado una mina!");
                encontrado = true;
                break;
            case "$ ":
                System.out.println("¡Enhorabuena! ¡Has encontrado el tesoro!");
                encontrado = true;
                break;
            case "X ":
                System.out.println("Ya lo has intentado en estas coordenadas.");
            default:
                tablero[y][x] = "X ";
                break;
        }
        return encontrado;
    }

    public static void muestraTablero(String[][] tablero) {
        System.out.println();
        for (int i = 0; i < tablero.length; i++) {
            System.out.printf("%d|", tablero.length - i - 1);
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
        System.out.print("  ");
        for (int i = 0; i <= tablero.length; i++) 
            System.out.printf("--", i);
        System.out.println();
        System.out.print(" ");
        for (int i = 0; i <= tablero.length; i++) 
            System.out.printf("% d", i);
        System.out.printf("%n%n");
    }
    
    public static String[][] generaTablero(int filas, int columnas) {
        String[][] tablero = new String[filas][columnas];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++)
                tablero[i][j] = " ";
        }
        return tablero;
    }
}
