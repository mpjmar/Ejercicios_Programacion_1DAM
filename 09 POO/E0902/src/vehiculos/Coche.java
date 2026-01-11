package vehiculos;

public class Coche extends Vehiculo {
	
	private int cilindrada;

	public Coche(int cilindrada) {
		super();
		this.cilindrada = cilindrada;
	}
	public void quemaRuedas() {
		System.out.println("Ffffsssshhhhhhhhh!");
	}
}
