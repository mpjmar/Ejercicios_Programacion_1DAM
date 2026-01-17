public class TarjetaRegalo {
	
	private double saldo;
	private int numTarjeta;

	public TarjetaRegalo(double saldo) {
		this.saldo = saldo;
		this.numTarjeta = creaNumero(10000, 99999);
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double cantidad) {
		saldo = cantidad;
	}

	public int getNumero() {
		return numTarjeta;
	}

	private int creaNumero(int min, int max) {
		return (int)(Math.random() * max - min + 1) + min;
	}

	public void gasta(double cantidad) {
		if (saldo >= cantidad)
			saldo -= cantidad;
		else
			System.out.printf("No tiene suficiente saldo para gastar %.2f€%n", cantidad);
	}

	public TarjetaRegalo fusionaCon(TarjetaRegalo t) {
		TarjetaRegalo nueva = new TarjetaRegalo(this.saldo + t.saldo);
		this.setSaldo(0);
		t.setSaldo(0);
		return nueva;
	}

	@Override
	public String toString() {
		return String.format("Tarjeta nº %d - Saldo %.2f€", numTarjeta, saldo);
	}
}
