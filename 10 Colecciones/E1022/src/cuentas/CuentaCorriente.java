package cuentas;

import java.util.ArrayList;

public class CuentaCorriente implements Operaciones {
	
	private String numCuenta;
	private double saldo;
	private Movimiento nuevoMovimiento;
	private ArrayList<Movimiento> movimientos;

	public CuentaCorriente() {
		this.numCuenta = asignaNumero();
		this.saldo = 0;
		this.movimientos = new ArrayList<>();
	}

	public CuentaCorriente(double cantidad) {
		this.numCuenta = asignaNumero();
		this.saldo = cantidad;
		nuevoMovimiento = new Movimiento("Ingreso", cantidad, saldo);
		this.movimientos = new ArrayList<Movimiento>();
		movimientos.add(nuevoMovimiento);
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public double getSaldo() {
		return saldo;
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

	private static String aleatorios(int longitud) {
		String res = "";
		for (int i = 0; i < longitud; i++) 
			res += (int)(Math.random() * 10);
		return res;
	}

	public void movimientos() {
		System.out.printf("""
			Movimientos de la cuenta %s
			------------------------------------------------
			""", numCuenta);
		
		for (Movimiento m : movimientos) {
			if (m.getTipo().equals("Ingreso") || m.getTipo().equals("Cargo"))
				System.out.println(m);
			else {
				if (m.getTipo().equals("Transf. recibida"))
					System.out.println(m.getTipo() + " de " + m.getCantidad() + "€ de la cuenta " + m.getCuentaOrigen() + " | Saldo " + m.getSaldo());
				else
					System.out.println(m.getTipo() + " de " + m.getCantidad() + "€ a la cuenta " + m.getCuentaDestino() + " | Saldo " + m.getSaldo());
			}
		}
	}

	@Override
	public void ingreso(double cantidad) {
		this.saldo += cantidad;
		movimientos.add(new Movimiento("Ingreso", cantidad, saldo));
	}

	@Override
	public void cargo(double cantidad) {
		this.saldo -= cantidad;
		movimientos.add(new Movimiento("Cargo", cantidad, saldo));
	}

	@Override
	public void transferencia(CuentaCorriente c, double cantidad) {
		this.saldo -= cantidad;
		Movimiento movOrig = new Movimiento("Transf. emitida", cantidad, saldo);
		movOrig.setCuentaDestino(c.getNumCuenta());
		movimientos.add(movOrig);

		c.saldo += cantidad;
		Movimiento movDest = new Movimiento("Transf. recibida", cantidad, c.saldo);
		movDest.setCuentaOrigen(numCuenta);
		c.movimientos.add(movDest);
	}

	@Override
	public String toString() {
		return String.format("Número de cta: %s Saldo: %.2f€", numCuenta, saldo);
	}

	/* @Override
	public String toString() {
		String ret = "";
		for (Movimiento m : movimientos) {
			if (m.getTipo().equals("Ingreso") || m.getTipo().equals("Cargo"))
				ret += String.format(m.getTipo() + " de " + m.getCantidad() + "€  Saldo: " + m.getSaldo() + "€%n");
			else
				ret += String.format(m.getTipo() + " de " + m.getCantidad() + "€ de la cuenta " + 
						this.numCuenta.substring(numCuenta.length() - 11, numCuenta.length() - 1)) + "%n";
		}
		return ret;
	} */
}
