package vehiculos;
public abstract class Vehiculo implements Movimiento {
	
	private static int vehiculosCreados = 0;
	private static int kilometrosTotales = 0;
	protected int kilometrosRecorridos = 0;

	public Vehiculo() {
		vehiculosCreados++;
	}

	public static int getVehiculosCreados() {
		return vehiculosCreados;
	}

	public static int getKilometrosTotales() {
		return kilometrosTotales;
	}

	public int getKilometrosRecorridos() {
		return kilometrosRecorridos;
	}

	private static void acumulaKms(int kms) {
		kilometrosTotales += kms;
	}

	@Override
	public void recorre(int kms) {
		acumulaKms(kms);
	}

}
