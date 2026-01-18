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

	public FichaDomino() {
		this.valor1 = creaValor(0, 6);
		this.valor2 = creaValor(0, 6);
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
	
	public static FichaDomino creaFichaQueEncaja(FichaDomino f) {
		FichaDomino nueva = new FichaDomino();
		while(nueva.valor1 != f.valor2)
			nueva.valor1 = creaValor(0, 6);
		return nueva;
	}

	public static int creaValor(int min, int max) {
		return (int)(Math.random() * (max - min + 1)) + min;
	}

	@Override
	public String toString() {
		return "[" + (valor1 == 0 ? " " : valor1) +
				 "|" + (valor2 == 0 ? " " : valor2) + "]";
	}
}
