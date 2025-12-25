public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			int i = 320;

			while (i >= 160) {
				System.out.print(i + " ");
				i -= 20;
			}
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado");
		}
    }
}
