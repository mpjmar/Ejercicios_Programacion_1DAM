import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        
		HashMap<String, Double> products = new HashMap<String, Double>();
		products.put("avena", 2.21);
		products.put("garbanzos", 2.39);
		products.put("tomate", 1.59);
		products.put("jengibre", 3.13);
		products.put("quinoa",4.50);
		products.put("guisantes",1.60);

		ArrayList<Product> shoppingList = new ArrayList<Product>();
		boolean finished = false;
		String name = "";
		int amount = 0;

		do {
			System.out.print("Producto: ");
			name = System.console().readLine();
			finished = name.equals("fin");
			boolean added = false;
			if (!finished) {
				amount = Integer.parseInt(System.console().readLine("Cantidad: "));
				for (Product p : shoppingList) {
					if (p.getName().equals(name)) {
						p.setAmount(p.getAmount() + amount);
						added = true;
						break;
					}
				}
				if (!added)
					shoppingList.add(new Product(name, products.get(name), amount));
			}
		} while (!finished);

		System.out.print("Introduzca código de descuento (INTRO si no tiene ninguno): ");
		String code = System.console().readLine();
		boolean hasDiscount = code.equals("ECODTO");
		if (!code.equals("ECODTO") || !code.equals(""))
			System.out.println("El código introducido no es correcto.");

		System.out.print("""
			
			Producto Precio Cantidad Subtotal
			---------------------------------
			""");

		double total = 0.00;
		for (Product p : shoppingList) {
			System.out.print(p);
			total += p.getPrice() * p.getAmount();
		}
		if (hasDiscount) {
			System.out.printf("""
				---------------------------------
				Descuento: %.2f
				""", total * 0.1);
		}
		System.out.printf("""
			---------------------------------
			TOTAL: %.2f
			""", total);
    }
}
