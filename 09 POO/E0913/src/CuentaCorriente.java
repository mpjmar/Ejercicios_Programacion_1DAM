public class CuentaCorriente {
	
	private long numCuenta;
	private double saldo;

	public CuentaCorriente() {
		this.numCuenta = asignaNumero();
		this.saldo = 0;
	}

	public CuentaCorriente(double saldo) {
		this.numCuenta = asignaNumero();
		this.saldo = saldo;
	}

	private long asignaNumero() {
		return (long)(Math.random() * (9999999999L - 1000000000 + 1)) + 1000000000;
	}

	public void ingreso(double cantidad) {
		this.saldo += cantidad;
	}

	public void cargo(double cantidad) {
		this.saldo -= cantidad;
	}

	public void transferencia(CuentaCorriente c, double cantidad) {
		this.saldo -= cantidad;
		c.saldo += cantidad;
	}

	@Override
	public String toString() {
		return String.format("Número de cta: %d Saldo: %.2f€", numCuenta, saldo);
	}
}
