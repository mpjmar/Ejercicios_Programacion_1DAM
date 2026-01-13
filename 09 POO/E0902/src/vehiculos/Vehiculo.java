package vehiculos;
public abstract class Vehiculo {
	protected static int vehiculosCreados = 0;
	protected static int kilometrosTotales = 0;
	private int kilometrosRecorridos;

	public Vehiculo() {
		this.kilometrosRecorridos = 0;
		vehiculosCreados++;
	}

	public int getKilometrosRecorridos() {
		return this.kilometrosRecorridos;
	}

	protected static int getKilometrosTotales() {
		return Vehiculo.kilometrosTotales;
	}

	public void anda(int kms) {
		System.out.printf("Andando %d kilómetros.%n", kms);
		this.kilometrosRecorridos += kms;
		Vehiculo.kilometrosTotales += kms;
	}
}
