public class Mapa {

    public static void muestraMapa(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++)
                System.out.printf("%d ", matriz[i][j]);
            System.out.println();
        }
        System.out.println();
    }

    public static void asignaCoord(int[][] mapa, int mina, int tesoro) {
        int xMina = 0, yMina = 0, xTesoro = 0, yTesoro = 0;
        int ancho = mapa.length - 1;
        int alto = mapa[0].length - 1;
        do {
            rellenaConCeros(mapa);
            xMina = Basicas.generaAleat(0, ancho);
            yMina = Basicas.generaAleat(0, alto);
            xTesoro = Basicas.generaAleat(0, ancho);
            yTesoro = Basicas.generaAleat(0, alto);
        } while (xMina == xTesoro && yMina == yTesoro);
        mapa[xMina][yMina] = mina;
        mapa[xTesoro][yTesoro] = tesoro;
    }

    public static void rellenaConCeros(int[][] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++)
                mapa[i][j] = 0;
        }
    }

    
    public static int[][] generaMapa(int filas, int columnas, int mina, int tesoro) {
        int[][] mapa = new int[filas][columnas];
        asignaCoord(mapa, mina, tesoro);
        return mapa;
    }
}
