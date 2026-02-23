import java.util.ArrayList;

public class Carrito {

	ArrayList<Elemento> cart;
	
	public Carrito() {
		cart = new ArrayList<Elemento>();
	}

	public void agrega(Elemento e) {
		cart.add(e);
	}

	public int numeroDeElementos() {
		return cart.size();
	}

	public double importeTotal() {
		double total = 0;

		for (Elemento e : cart)
			total += e.getPrice() * e.getAmount();
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
