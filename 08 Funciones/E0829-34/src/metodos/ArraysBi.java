package metodos;

public class ArraysBi {

    public static int[] diagonal(int[][] arrayBi) {
        
        int fila = validaInt("Fila: ", 0, arrayBi.length);
        int columna = validaInt("Columna: ", 0, arrayBi[0].length);
        String direccion = validaString("Dirección (nose/neso): ", "nose", "neso");
        System.out.printf("%nDiagonal: ");
        return rellenaDiagonal(arrayBi, fila, columna, "nose");        
    }

    private static int[] rellenaDiagonal(int[][] arrayBi, int fila, int columna, String direccion) {
        int[] diagonalAux = new int[arrayBi.length];
        int idx = 0;
        for (int i = 0; i < arrayBi.length; i++) {
            for (int j = 0; j < arrayBi[i].length; j++) {
                if ((columna - j == fila - i) && direccion.equals("neso"))
                    diagonalAux[idx++] = arrayBi[i][j];
                else if ((columna - j == i - fila) && direccion.equals("nose"))
                    diagonalAux[idx++] = arrayBi[i][j]; 
            }
        }
        return copiaArray(diagonalAux, idx);
    }

    private static int[] copiaArray(int[] array, int len) {
        int[] copia = new int[len];
        for (int i = 0; i < copia.length; i++)
            copia[i] = array[i];
        return copia;
    }

    private static int validaInt(String mensaje, int min, int max) {
        boolean correcto = false;
        int num = -1;
        do {
            try {
                System.out.print(mensaje);
                num = Integer.parseInt(System.console().readLine());
                correcto = num >= min && num < max;
                if (!correcto) 
                    System.out.printf("El numero debe ser mayor o igual a %d y menor que %d%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("El número debe ser un entero.");
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado.");
            }
        } while (!correcto);
        return num;
    } 

    private static String validaString(String mensaje, String str1, String str2) {
        boolean correcto = false;
        String str = "";
        do {
            try {
                System.out.print(mensaje);
                str = System.console().readLine().toLowerCase();
                correcto = str.equals(str1) || str.equals(str2);
                if (!correcto) 
                    System.out.printf("La opción introducida no es correcta.");
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado.");
            }
        } while (!correcto);
        return str;
    } 

    public static void muestraPuntosDeSilla(int[][] arrayBi) {
        for (int i = 0; i < arrayBi.length; i++)
            for (int j = 0; j < arrayBi[i].length; j++)
                if (esPuntoDeSilla(arrayBi, i, j))
                    System.out.printf("fila %d, columna %d -> %d%n", i, j, arrayBi[i][j]);
    } 

    public static boolean esPuntoDeSilla(int[][] arrayBi, int i, int j) {
        int min = 0, colMax = arrayBi[0].length - 1, filaMax = arrayBi.length - 1;
        if (i == min && j == min || i == min && j == colMax || i == filaMax && j == min || i == filaMax && j == colMax)
            return true;
        return false;       
    }

    public static int[] coordenadasEnArrayBiInt(int[][] arrayBi, int n) {
        int[] coordenadas = {-1, -1};
        for (int i = 0; i < arrayBi.length; i++) {
            for (int j = 0; j < arrayBi[i].length; j++) {
                if (arrayBi[i][j] == n) {
                    coordenadas[0] = i;
                    coordenadas[1] = j;
                    return coordenadas;
                }
            }
        }
        return coordenadas;
    }

    public static void muestraCoordenadas(int[] array) {
        System.out.print(array[0] + " ");
        System.out.println(array[1]);
    }

    public static int[] columnaDeArrayBiInt(int[][] arrayBi, int columna) {
        int[] array = new int[arrayBi.length];
        for (int i = 0; i < arrayBi.length; i++) 
            array[i] = arrayBi[i][columna];
        return array;
    }

    public static int[] filaDeArrayBiInt(int[][] arrayBi, int fila) {
        int[] array = new int[arrayBi[fila].length];
        for (int i = 0; i < arrayBi[fila].length; i++)
            array[i] = arrayBi[fila][i];
        return array;
    }

    
    public static void muestraArrayBi(int[][] arrayBi) {
        for (int i = 0; i < arrayBi.length; i++)
            muestraArray(arrayBi[i]);
        System.out.println();
    }

    public static void muestraArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.printf("%3d", array[i]);
        System.out.println();
    }

    public static int[][] generaArrayBi(int n, int m, int min, int max) {
        int[][] arrayBi = new int[n][m];
        for (int i = 0; i < arrayBi.length; i++)
            for (int j = 0; j < arrayBi[i].length; j++)
                arrayBi[i][j] = (int)(Math.random() * (max - min + 1)) + min;
        return arrayBi;
    }
}
