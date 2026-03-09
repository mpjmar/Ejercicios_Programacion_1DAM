public class App {
    public static void main(String[] args) throws Exception {

		TiendaLibros tienda = new TiendaLibros();
		tienda.agregarLibro((new Libro("El Quijote", "Cervantes", 30.99)));
		tienda.agregarLibro((new Libro("otro libro", "otro autor", 10.50)));

		tienda.guardarEnFichero();
		tienda.leerLibros();
		tienda.borrarFichero();
	}
}