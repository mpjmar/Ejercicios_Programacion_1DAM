package coins;

public class Coin {

	private int value;
	private String side;

	public Coin() {
		this.value = Utils.assignValue();
		this.side = Utils.assignSide();
	}

	public Coin(Coin m) {
		int inherit = Utils.generateRandom(1, 2);
		if (inherit == 1) {
			this.value = m.getValue();
			this.side = Utils.assignSide();
		}
		else {
			this.value = Utils.assignValue();
			this.side = m.getSide();
		}
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getSide() {
		return this.side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return String.format("%d %s - %s%n", 
			this.value < 100 ? this.value : this.value / 100,
			this.value == 1 ? "céntimo" : this.value < 100 ? "céntimos" : this.value == 100 ? "euro" : "euros",
			this.side);
	}
}
