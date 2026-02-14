public class Card {
	private final String[] SUIT = {"oros", "bastos", "espadas", "copas"};
	private final String[] FIGURE = {"as", "dos", "tres", "cuatro", "cinco", "seis", "siete", "sota", "caballo", "rey"};

	private String suit;
	private String figure;

	public Card() {
		this.suit = SUIT[random(0, SUIT.length)];
		this.figure = FIGURE[random(0, FIGURE.length)];
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getFigure() {
		return figure;
	}

	public void setFigure(String figure) {
		this.figure = figure;
	}

	@Override
	public String toString() {
		return figure + " de " + suit;
	}

	private int random(int min, int max) {
		return (int)(Math.random() * (max - min) + min);
	}
}
