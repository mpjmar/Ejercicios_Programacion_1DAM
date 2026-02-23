public class Piece {
	
	private String name;
	private int value;
	private int numPieces;


	public Piece(String name, int value, int numPieces) {
		this.name = name;
		this.value = value;
		this.numPieces = numPieces;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getNumPieces() {
		return numPieces;
	}

	public void setNumPieces(int numPieces) {
		this.numPieces = numPieces;
	}
}