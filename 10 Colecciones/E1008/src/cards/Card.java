package cards;

public class Card {
	
	private final String[] SUIT = {"Bastos", "Copas", "Espadas", "Oros"};
	private final String[] NUMBER = {"As", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey"};
	
	private String cardSuit;
	private String cardNumber;

	public Card() {
		this.cardSuit = SUIT[Utils.generateRandom(0, 3)];
		this.cardNumber = NUMBER[Utils.generateRandom(0, 9)];
	}

	public String getSuit() {
		return this.cardSuit;
	}

	public void setSuit(String suit) {
		this.cardSuit = suit;
	}

	public String getNumber() {
		return this.cardNumber;
	}

	public void setNumber(String number) {
		this.cardNumber = number;
	}

	@Override
	public String toString() {
		return String.format("%s de %s", cardNumber, cardSuit);
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Card c = (Card) obj;
		return this.cardSuit.equals(c.getSuit()) && this.cardNumber.equals(c.getNumber());
	}
}
