public class App {
    public static void main(String[] args) throws Exception {

        int numeros[] = new int[100];
        int numElegido = -1, valorSust = -1;

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random() * 21);
        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
        try {
            boolean valido = false;
            do {
                System.out.print("Intoduzca un número de los que se han mostrado: ");
                numElegido = Integer.parseInt(System.console().readLine());
                valido = numElegido >= 0 && numElegido <= 20;
            } while (!valido);
            System.out.print("Introduzca el valor por el que quiere sustituirlo: ");
            valorSust = Integer.parseInt(System.console().readLine());
        }
        catch (NumberFormatException e) {
            System.out.println("El número debe ser un entero.");
        }
        catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado.");
        }
        
        for (int i = 0; i < numeros.length; i++)
            numeros[i] = numeros[i] == numElegido ? valorSust : numeros[i];

        for (int i = 0; i < numeros.length; i++)
            System.out.print((numeros[i] == valorSust ? "\"" + valorSust + "\"" : numeros[i]) + " ");
    }
}
