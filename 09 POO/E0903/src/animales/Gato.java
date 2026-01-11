package animales;

public class Gato extends Mamifero {
	
	private String raza;

	public Gato() {
		super(Sexo.HEMBRA);
		raza = "siamés";
	}

	public Gato(String raza) {
		super();
		this.raza = raza;
	}

	public Gato(Sexo sexo) {
		super(sexo);
	}

	public Gato(Sexo sexo, String raza) {
		super(sexo);
		this.raza = raza;
	}

	public void maulla() {
		System.out.println("Miaaauuuu");
	}

	public void ronronea() {
		System.out.println("Prrrrrrrrr");
	}

	public void come(String comida) {
		if (comida.toLowerCase().equals("pescado"))
			System.out.println("Mmmmmm, gracias!");
		else
			System.out.println("Lo siento, yo sólo como pescado.");
	}

	public void peleaCon(Gato contrincante) {
		if (this.getSexo() == Sexo.HEMBRA)
			System.out.println("No me gusta pelear");
		else {
			if (contrincante.getSexo() == Sexo.HEMBRA)
				System.out.println("No peleo con gatitas");
			else
				System.out.println("Te vas a enterar!");
		}
	}

	public void limpiate() {
		System.out.println("Me estoy lamiendo.");
	}

	public void caza() {
		System.out.println("Estoy cazando ratones!");
	}
}
