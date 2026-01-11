package animales;

public abstract class Mamifero extends Animal {
	
	public Mamifero() {
		super();
	}

	public Mamifero(Sexo sexo) {
		super(sexo);
	}

	public void amamanta() {
		if (this.getSexo() == Sexo.MACHO)
			System.out.println("Soy macho, no puedo amamantar!");
		else
			System.out.println("Toma pecho, hazte grande!");
	}

	public void cuidaCrias() {
		System.out.println("Estoy cuidando a mis crías.");
	}

	public void anda() {
		System.out.println("Estoy andando.");
	}
}
