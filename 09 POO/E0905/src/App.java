public class App {
    public static void main(String[] args) throws Exception {
        Pizza p1 = new Pizza("margarita", "mediana");
		Pizza p2 = new Pizza("funghi", "familiar");
		Pizza p3 = new Pizza("cuatro quesos", "mediana");
		p2.sirve();
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		if (!p2.sirve())
			System.out.println("esa pizza ya se ha servido");
		System.out.println("pedidas: " + Pizza.getTotalPedidas());
		System.out.println("servidas: " + Pizza.getTotalServidas());
    }
}
