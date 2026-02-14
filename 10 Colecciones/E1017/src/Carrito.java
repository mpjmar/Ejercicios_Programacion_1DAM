import java.util.ArrayList;

public class Carrito {

	ArrayList<Elemento> cart;
	private double total;
	
	public Carrito() {
		cart = new ArrayList<Elemento>();
		total = 0;
	}

	public void agrega(Elemento e) {
		cart.add(e);
		total += e.getPrice() * e.getAmount();
	}

	public int numeroDeElementos() {
		return cart.size();
	}

	public double importeTotal() {
		return total;
	}

	@Override
	public String toString() {
		String elements = "";
		for (Elemento e : cart) 
			elements += e + "\n";
		return String.format("""
			Contenido del carrito
			=====================
			%s
			""", elements);
	}
}
