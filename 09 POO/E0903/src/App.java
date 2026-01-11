import animales.*;

public class App {
    public static void main(String[] args) throws Exception {

		System.out.println();
		Pinguino tux = new Pinguino(Sexo.MACHO);
		tux.come("palomitas");
		tux.programa();
		System.out.println();

		Perro laika = new Perro(Sexo.HEMBRA);
		laika.duerme();
		laika.dameLaPata();
		laika.amamanta();
		laika.cuidaCrias();
		System.out.println();

		Lagarto godzilla = new Lagarto(Sexo.MACHO);
		godzilla.tomaElSol();
		godzilla.duerme();
		System.out.println();
	}
}
