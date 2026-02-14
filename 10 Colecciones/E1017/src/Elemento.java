public class Elemento {

	private String name;
	private double price;
	private int amount;

	public Elemento(String name, double price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	} 

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}
	
	@Override
	public String toString() {
		return String.format("%s PVP: %.2f Unidades: %d Subtotal: %.2f",
			name, price, amount, price * amount);
	}
}
