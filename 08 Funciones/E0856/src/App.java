public class App {
    public static void main(String[] args) throws Exception {
        int[][] matrix = {
			{45, 92, 14, 20, 25, 78},
			{35, 72, 24, 45, 42, 60},
			{32, 42, 64, 23, 41, 39},
			{98, 45, 94, 11, 18, 48}
		};
		System.out.print("Corteza: ");
		muestraArray(corteza(matrix));
    }

	public static int[] corteza(int[][] n) {
		int alto = n.length;
		int ancho = n[0].length;
		int longitud = alto * 2 + (ancho - 2) * 2;
		int[] corteza = new int[longitud];
		int pos = 0;

		for (int i = 0; i < ancho; i++)
			corteza[pos++] = n[0][i];
		
		for (int i = 1; i < alto; i++)
			corteza[pos++] = n[i][ancho - 1];

		for (int i = ancho - 2; i >= 0; i--)
			corteza[pos++] = n[alto - 1][i];

		for (int i = alto - 2; i > 0; i--)
			corteza[pos++] = n[i][0];

		return corteza;
	}

	public static void muestraArray(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}
}
