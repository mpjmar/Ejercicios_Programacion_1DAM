public class App {
    public static void main(String[] args) throws Exception {

		Fraccion f1 = new Fraccion(3, 5);
		Fraccion f2 = new Fraccion(5, 0);
		Fraccion f3 = new Fraccion(90, 8);
		Fraccion f4 = new Fraccion(-4, 6);

		muestraFraccion(f1);
		muestraFraccion(f2);
		muestraFraccion(f3);
		muestraFraccion(f4);

		muestraFraccion(f1.suma(3));
		muestraFraccion(f1.resta(f3));
		Fraccion f5 = f1.multiplica(f4);
		muestraFraccion(f5);
		muestraFraccion(f5.simplifica());
		Fraccion f6 = f3.divide(f1);
		muestraFraccion(f6);
		muestraFraccion(f6.simplifica());
		muestraFraccion(f1.suma(f2));
	}

	public static void muestraFraccion(Fraccion f) {
		if (f.getDenominador() == 0) {
			System.out.println("Una fracción no puede tener el denominador 0!");
			return;
		}
		System.out.printf("Fracción %s: %s%d / %d", f, f.getSigno() > 0 ? "" : "-", f.getNumerador(), f.getDenominador());
		System.out.println();
	}
}
