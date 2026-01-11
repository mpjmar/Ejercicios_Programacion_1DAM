public class Fraccion {
	
	private int signo;
	private int numerador;
	private int denominador;

	public Fraccion(int numerador, int denominador) {
		if (denominador == 0)
			System.out.println("Una fracción no puede tener el denominador 0!");
		else {
			if (numerador * denominador < 0)
				this.signo = -1;
			else
				this.signo = 1;
			this.numerador = Math.abs(numerador);
			this.denominador = Math.abs(denominador);
		}
	}

	public int getNumerador() {
		return this.numerador;
	}

	public int getDenominador() {
		return this.denominador;
	}

	public String toString() {
		String res = this.numerador + "/" + this.denominador;		
		return signo == -1 ? "-" + res : res;
	}

	public Fraccion invierte() {
		return new Fraccion(this.signo * this.denominador, this.numerador);
	}

	public Fraccion multiplica(int n) {
		return new Fraccion(this.signo * n * this.numerador, this.denominador);
	}

	public Fraccion multiplica(Fraccion f) {
		return new Fraccion(this.signo * this.numerador * f.getNumerador(), this.denominador * f.getDenominador());
	}

	public Fraccion divide(int n) {
		return new Fraccion(this.signo * this.numerador, this.denominador * n);
	}

	public Fraccion divide(Fraccion f) {
		return new Fraccion(this.signo * this.numerador * f.getDenominador(), this.denominador * f.getNumerador());
	}

	public Fraccion simplifica() {
		int signo = this.signo;
		int num = this.numerador;
		int denom = this.denominador;

		for (int i = 2; i <= Math.min(num, denom); i++) {
			while (((num % i == 0) && (denom % i == 0))) {
				num /= i;
				denom /= i;
			}
		}
		return new Fraccion(signo * num, denom);
	}
}
