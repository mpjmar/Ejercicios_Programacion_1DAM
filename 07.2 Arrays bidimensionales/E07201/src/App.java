public class App {
    public static void main(String[] args) throws Exception {
        
        int[][] num = new int[3][6];
        num[0][0] = 0;
        num[0][1] = 30;
        num[0][2] = 2;
        num[0][5] = 5;
        num[1][0] = 75;
        num[1][4] = 0;
        num[2][2] = -2;
        num[2][3] = 9;
        num[2][5] = 11;
        muestraArray(num);
    }

    public static void muestraArray(int[][] array) {
        System.out.print("        ");
        for (int i = 0; i < array[0].length; i++) {
            System.out.printf("Columna %d ", i);
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Fila %d  ", i);
            for (int j = 0; j < array[i].length; j++)
                System.out.printf("%5d    ", array[i][j]);
            System.out.println();
        }
    }
}
