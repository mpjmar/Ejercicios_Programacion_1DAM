package vehiculos;

public class Bicicleta extends Vehiculo {

	private int pinones;

	public Bicicleta() {
		super();
		this.pinones = 0;
	}

	public Bicicleta(int pinones) {
		super();
		this.pinones = pinones;
	}

	public int getPinones() {
		return pinones;
	}

	public void setPinones(int pinones) {
		this.pinones = pinones;
	}

	@Override
	public void recorre(int kms) {
		super.recorre(kms);
		kilometrosRecorridos += kms;
		System.out.printf("Andando %d kilómetros.%n", kms);
	}
	
	public void hazCaballito() {
		System.out.println("Haciendo el caballito con la bicicleta!");
	}
}
