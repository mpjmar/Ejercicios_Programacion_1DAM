package animales;

public class Perro extends Mamifero {
	
	public Perro() {
		super(Sexo.HEMBRA);
	}

	public Perro(Sexo sexo) {
		super(sexo);
	}

	public void ladra() {
		System.out.println("Guau guau guau!");
	}

	public void dameLaPata() {
		System.out.println("Toma mi patita!");
	}

	public void caza() {
		System.out.println("Estoy cazando perdices!");
	}
}
