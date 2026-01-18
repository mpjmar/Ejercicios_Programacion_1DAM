public class FichaDomino {
	
	private int valor1;
	private int valor2;

	public FichaDomino(int valor1, int valor2) {
		if (valor1 < 7 && valor2 < 7) {
			this.valor1 = valor1;
			this.valor2 = valor2;
		}
		else
			System.out.println("Los valores deben ser menores que 7.");
	}

	public FichaDomino voltea() {
		int temp = valor1;
		this.valor1 = valor2;
		this.valor2 = temp;
		return this;
	}

	public boolean encaja(FichaDomino f) {
		if (this.valor1 == f.valor1 || this.valor1 == f.valor2 || 
			this.valor2 == f.valor1 || this.valor2 == f.valor2)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return String.format("[%s|%s]", pasaAString(valor1), pasaAString(valor2));
	}

	private String pasaAString(int valor) {
		String pasado = "";
		if (valor == 0)
			return " ";
		return pasado + valor;
	}
}
