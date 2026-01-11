package animales;

public abstract class Ave extends Animal {
	
	public Ave() {
		super(Sexo.HEMBRA);
	}

	public Ave(Sexo sexo) {
		super(sexo);
	}

	public void ponHuevo() {
		if (this.getSexo() == Sexo.MACHO)
			System.out.println("Soy macho, no puedo poner huevos.");
		else
			System.out.println("Ahí va eso..., un huevo!");
	}

	public void limpiate() {
		System.out.println("Me estoy limpiando las plumitas.");
	}

	public void vuela() {
		System.out.println("Estoy volando.");
	}
}
