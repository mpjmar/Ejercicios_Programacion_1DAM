public class App {
    public static void main(String[] args) throws Exception {
        int[][] matrix = {
			{187, 82, 55, 196, 159, 177},
			{28, 68, 183, 9, 91, 158},
			{141, 141, 173, 10, 115, 169},
			{24, 27, 130, 128, 189, 70}
		};
		System.out.println("Posición 3 -> " + nEsimo(matrix, 3));
		System.out.println("Posición 20 -> " + nEsimo(matrix, 20));
		System.out.println("Posición 24 -> " + nEsimo(matrix, 24));
		System.out.println("Posición 23 -> " + nEsimo(matrix, 23));
    }

	public static int nEsimo(int[][] n, int posicion) {
		int pos = 0;
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n[i].length; j++) {
				if (pos == posicion)
					return n[i][j];
				pos++;
			}
		}
		return -1;
	}
}
