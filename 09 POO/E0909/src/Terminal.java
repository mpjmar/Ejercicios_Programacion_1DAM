public class Terminal {
	
	private String numero;
	private int seg;

	public Terminal(String numero) {
		this.numero = numero;
		this.seg = 0;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getSegundos() {
		return seg;
	}

	public void setSegundos(int min) {
		this.seg += min;
	}

	@Override
	public String toString() {
		return String.format("Nº %s - %ds de conversación", numero, seg);
	}

	public void llama(Terminal t, int seg) {
		this.seg = seg;
		t.setSegundos(t.seg + seg);
	}
}
