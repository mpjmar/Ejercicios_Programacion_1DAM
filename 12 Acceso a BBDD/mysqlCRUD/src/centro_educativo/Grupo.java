package centro_educativo;

public class Grupo implements MySerializer {
    long id;
    String nombre;
    String profesor;

    public Grupo(){
        this(0, "", "");
    }

    // COMPROBAR ID AUTOINCREMENTAL??
    public Grupo(long id, String nombre, String profesor){
        this.id = id;
        this.nombre = nombre;
        this.profesor = profesor;
    }

	public Grupo(String data) {
		deserialize(data);
	}

	public Grupo(Grupo gr) {
		this.id = gr.id;
		this.nombre = gr.nombre;
		this.profesor = gr.profesor;
	}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Nombre: %s, Tutor: %s", this.id, this.nombre, this.profesor);
    }
    
	@Override
    public String serialize() {
        return String.format("\"%d\";\"%s\";\"%s", this.id, this.nombre, this.profesor);
    }

    private String substractQuotes(String data){
        return data.substring(1, data.length()-1);
    }

    @Override
    public void deserialize(String data) {
        String[] datos = data.split(";");
        
        this.id = Integer.parseInt(datos[0].substring(1, datos[0].length()-1));
        this.nombre = this.substractQuotes(datos[1]);
        this.profesor = this.substractQuotes(datos[2]);
    }
}
