import java.util.ArrayList;

public class Carrito {

	ArrayList<Elemento> cart;
	
	public Carrito() {
		cart = new ArrayList<Elemento>();
	}

	public void agrega(Elemento e) {
		boolean found = false;

		for (Elemento elem : cart) {
			if (elem.getName().equals(e.getName())) {
				elem.setAmount(elem.getAmount() + e.getAmount());
				found = true;
			}
		}
		if (!found)
			cart.add(e);
	}

	public int numeroDeElementos() {
		return cart.size();
	}

	public double importeTotal() {
		int total = 0;

		for(Elemento e : cart)
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
			%s """, elements);
	}
}
