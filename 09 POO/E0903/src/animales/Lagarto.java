package animales;

public class Lagarto extends Animal {
	
	public Lagarto() {}

	public Lagarto(Sexo sexo) {
		super(sexo);
	}

	public void tomaElSol() {
		System.out.println("Estoy tomando el sol!");
	}

	public void baniate() {
		System.out.println("Me estoy dando un chapuzón!");
	}

	public void escondete() {
		System.out.println("Estoy escondido y no me puedes ver!");
	}
}
