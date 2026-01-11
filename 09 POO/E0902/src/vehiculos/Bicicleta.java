package vehiculos;

public class Bicicleta extends Vehiculo {

	private int pinones;

	public Bicicleta(int pinones) {
		super();
		this.pinones = pinones;
	}
	
	public void hazCaballito() {
		System.out.println("Haciendo el caballito con la bicicleta!");
	}
}
