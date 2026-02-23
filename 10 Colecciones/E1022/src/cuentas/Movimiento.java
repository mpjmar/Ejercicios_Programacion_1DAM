package cuentas;

public class Movimiento {
	
	private String tipo;
	private double cantidad;
	private double saldo;
	private String cuentaOrigen;
	private String cuentaDestino;

	public Movimiento(String tipo, double cantidad, double saldo) {
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.saldo = saldo;
		this.cuentaOrigen = "";
		this.cuentaDestino = "";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(String cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public String getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(String cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

	@Override
	public String toString() {
		return String.format(tipo + " de " + cantidad + "€  Saldo: " + saldo + "€");
	}
}
