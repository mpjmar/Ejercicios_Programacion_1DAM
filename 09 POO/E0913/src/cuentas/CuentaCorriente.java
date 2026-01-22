package cuentas;

public class CuentaCorriente implements Operaciones {
	
	private String numCuenta;
	private double saldo;

	public CuentaCorriente() {
		this.numCuenta = asignaNumero();
		this.saldo = 0;
	}

	public CuentaCorriente(double saldo) {
		this.numCuenta = asignaNumero();
		this.saldo = saldo;
	}

	public static String asignaNumero() {
		String numCuenta = "";
		numCuenta += aleatorios(4);
		numCuenta += " ";
		numCuenta += aleatorios(4);
		numCuenta += " ";
		numCuenta += aleatorios(2);
		numCuenta += " ";
		numCuenta += aleatorios(10);
		return numCuenta;
	}

	private static int aleatorios(int longitud) {
		int res = 0;
		for (int i = 0; i < longitud; i++) 
			res = res * 10 + (int)(Math.random() * 10);
		return res;
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
