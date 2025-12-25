public class App {

    public static void main(String[] args) throws Exception {

        int numero[] = new int[12];
        int cuadrado[] = new int[12];
        int cubo[] = new int[12];

        for (int i = 0; i < numero.length; i++)
            numero[i] = (int)(Math.random() * 101);

        for (int i = 0; i < cuadrado.length; i++)
            cuadrado[i] = (int)(Math.pow(numero[i], 2));

        for (int i = 0; i < cubo.length; i++)
            cubo[i] = (int)(Math.pow(numero[i], 3));

        int ancho = 23;

        System.out.printf("%4s  |", "n");
        System.out.printf("%5s  |", "n²");
        System.out.printf("%6s", "n³");
        System.out.println();

        for (int i = 0; i < ancho; i++)
            System.out.print("-");
        System.out.println();
        
        for (int i = 0; i < numero.length; i++) {
            System.out.printf("%4s  |", numero[i]);
            System.out.printf("%6s |", cuadrado[i]);
            System.out.printf("%8s", cubo[i]);
            System.out.println();
        }
        System.out.println();
    }
}
