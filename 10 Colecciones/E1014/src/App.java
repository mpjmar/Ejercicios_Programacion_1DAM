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
			if (!finished) {
				amount = Integer.parseInt(System.console().readLine("Cantidad: "));
				shoppingList.add(new Product(name, products.get(name), amount));
			}
		} while (!finished);

		System.out.print("""
			
			Producto Precio Cantidad Subtotal
			---------------------------------
			""");

		double total = 0.00;
		for (Product p : shoppingList) {
			System.out.print(p);
			total += p.getPrice() * p.getAmount();
		}
		System.out.printf("""
			---------------------------------
			TOTAL: %.2f
			""", total);
    }
}
