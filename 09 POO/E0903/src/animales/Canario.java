package animales;

public class Canario extends Ave {
	
	public Canario() {
		super();
	}

	public Canario(Sexo sexo) {
		super(sexo);
	}

	public void canta() {
		System.out.println("Prrrrri pipipipi");
	}

	public void caza() {
		System.out.println("Los canarios no cazan!");
	}

	public void pia() {
		System.out.println("Pio pio");
	}
}
