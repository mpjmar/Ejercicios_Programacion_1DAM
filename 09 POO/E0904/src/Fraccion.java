public class Fraccion {
	
	private int signo;
	private int numerador;
	private int denominador;

	public Fraccion(int numerador, int denominador) {
		if (denominador == 0)
			System.out.println("Una fracción no puede tener el denominador 0!");
		else {
			this.signo = numerador * denominador < 0 ? -1 : 1;
			this.denominador = Math.abs(denominador);
		}
	}

	public int getNumerador() {
		return this.numerador;
	}

	public int getDenominador() {
		return this.denominador;
	}

	public int getSigno() {
		return this.signo;
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
		return multiplica(new Fraccion(1, n));
	}

	public Fraccion divide(Fraccion f) {
		return multiplica(f.invierte());
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

	public Fraccion suma(int n) {
		Fraccion f = new Fraccion(n, 1);
		return suma(f);
	}

	public Fraccion suma(Fraccion f) {
		int num1 = this.signo * this.numerador * f.getDenominador();
		int num2 = f.getSigno() * f.getNumerador() * this.denominador;
		int denom = this.denominador * f.getDenominador();
		return new Fraccion(num1 + num2, denom);
	}

	public Fraccion resta(int n) {
		return suma(-n);
	}

	public Fraccion resta(Fraccion f) {
		return suma(f.negar());
	}

	public Fraccion negar() {
		return new Fraccion(-this.signo * this.numerador, this.denominador);
	}
}
