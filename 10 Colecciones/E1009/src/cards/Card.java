package cards;

public class Card implements Comparable<Card> {
	
	private final String[] SUIT = {"Bastos", "Copas", "Espadas", "Oros"};
	private final String[] NUMBER = {"as", "dos", "tres", "cuatro", "cinco", "seis", "siete", "sota", "caballo", "rey"};
	
	private String cardSuit;
	private Integer cardNumber;

	public Card() {
		this.cardSuit = SUIT[Utils.generateRandom(0, 3)];
		this.cardNumber = Utils.generateRandom(0, 9);
	}

	public String getSuit() {
		return this.cardSuit;
	}

	public void setSuit(String suit) {
		this.cardSuit = suit;
	}

	public Integer getNumber() {
		return this.cardNumber;
	}

	public void setNumber(Integer number) {
		this.cardNumber = number;
	}

	@Override
	public String toString() {
		return String.format("%s de %s", NUMBER[cardNumber], cardSuit);
	}

	@Override
	public int compareTo(Card c) {
		if (this.cardSuit.equals(c.getSuit()))
			return this.cardNumber.compareTo(c.getNumber());
		return this.cardSuit.compareTo(c.getSuit());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Card c = (Card) obj;
		return this.cardSuit.equals(c.getSuit()) && this.cardNumber.equals(c.getNumber());
	}
}
