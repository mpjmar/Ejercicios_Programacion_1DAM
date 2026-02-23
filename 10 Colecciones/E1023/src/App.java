import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(new Piece("Dama", 9, 1));
		pieces.add(new Piece("Torre", 5, 1));
		pieces.add(new Piece("Alfil", 3, 2));
		pieces.add(new Piece("Caballo", 2, 2));
		pieces.add(new Piece("Peon", 1, 8));
		
		int numCaptures = (int)(Math.random() * 16);

		ArrayList<Piece> captures = new ArrayList<>(numCaptures);
		int i = 0;
		do {
			int pos = (int)(Math.random() * pieces.size());
			int availPeaces = pieces.get(pos).getNumPieces();
			if (availPeaces > 0) {
				captures.add(pieces.get(pos));
				pieces.get(pos).setNumPieces(pieces.get(pos).getNumPieces() - 1);
				i++;
			}
		} while (i < numCaptures);

		int sum = 0;
		System.out.println("Fichas capturadas por el jugador: ");
		for (Piece p : captures) {
			System.out.printf("%s (%d peones)%n", p.getName(), p.getValue());
			sum += p.getValue();
		}
		System.out.printf("Puntos totales: %d peones.%n", sum);
	}
}
