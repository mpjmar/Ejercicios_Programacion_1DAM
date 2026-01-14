package vehiculos;

public class Coche extends Vehiculo {
	
	private int cilindrada;

	public Coche() {
		super();
		this.cilindrada = 0;
	}

	public Coche(int cilindrada) {
		super();
		this.cilindrada = cilindrada;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public void recorre(int kms) {
		super.recorre(kms);
		kilometrosRecorridos += kms;
		System.out.printf("Andando %d kilómetros.%n", kms);
	}

	public void quemaRuedas() {
		System.out.println("Ffffsssshhhhhhhhh!");
	}
}
