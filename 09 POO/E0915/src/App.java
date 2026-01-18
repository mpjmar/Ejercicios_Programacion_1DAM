public class App {
    public static void main(String[] args) throws Exception {

		imprimeSecuencia(generaSecuencia(8));
	}

	public static FichaDomino[] generaSecuencia(int fichas) {
		FichaDomino[] secuencia = new FichaDomino[fichas];
		secuencia[0] = new FichaDomino();
		for (int i = 1; i < fichas; i++) {
			secuencia[i] = FichaDomino.creaFichaQueEncaja(secuencia[i - 1]);
		}
		return secuencia;
	}

	public static void imprimeSecuencia(FichaDomino[] secuencia) {
		for (int i = 0; i < secuencia.length; i++)
			System.out.print(secuencia[i]);
	}
}
