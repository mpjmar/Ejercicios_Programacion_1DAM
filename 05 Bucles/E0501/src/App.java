public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			for (int i = 0; i <= 100; i += 5)
				System.out.print(i + " ");
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado");
		}
    }
}
