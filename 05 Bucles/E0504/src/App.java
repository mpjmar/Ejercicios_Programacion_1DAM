public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			for (int i = 320; i >= 160; i -= 20)
				System.out.print(i + " ");
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado");
		}
    }
}
