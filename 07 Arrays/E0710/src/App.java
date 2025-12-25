public class App {
    public static void main(String[] args) throws Exception {
        int aleatorios[] = generaArray(20);
        System.out.println("Array original: ");
        System.out.println(arrayToString(aleatorios));
        System.out.println("Array con los pares al principio: ");
        System.out.println(arrayToString(muevePares(aleatorios)));
    }

    public static String arrayToString(int array[]) {
        String strArray = "";
        for (int i = 0; i < array.length; i++) 
            strArray += String.format("%d ", array[i]);
        return strArray;
    }

    public static int[] muevePares(int array[]) {
        int arrayRes[] = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                arrayRes[j++] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0)
                arrayRes[j++] = array[i];
        }   
        return arrayRes;
    }

    public static int[] generaArray(int cantidad) {
        int array[] = new int[cantidad];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 101);
        }
        return array;
    }
}
