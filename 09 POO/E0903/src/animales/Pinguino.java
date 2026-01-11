package animales;

public class Pinguino extends Ave {
	
	public Pinguino() {
		super();
	}

	public Pinguino(Sexo sexo) {
		super(sexo);
	}

	public void vuela() {
		System.out.println("Lo siento, no puedo volar!");
	}

	public void programa() {
		System.out.println("Soy un pinguino programador y estoy programando en Java!");
	}

	public void nada() {
		System.out.println("Me encanta nadar!");
	}
}
