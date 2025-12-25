public class App {
    public static void main(String[] args) throws Exception {
        final int MINA = 1;
        final int TESORO = 2;
        int intentos = 3;

        int[][] mapa = Mapa.generaMapa(4, 5, MINA, TESORO);
        String[][] tablero = Tablero.generaTablero(4, 5);
        Mapa.asignaCoord(mapa, MINA, TESORO);
        Mapa.muestraMapa(mapa);
        Tablero.juega(tablero, intentos);
    }

    

    


    


    

    
}
