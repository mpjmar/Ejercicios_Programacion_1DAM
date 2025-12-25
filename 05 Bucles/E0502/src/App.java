public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			int i = 0; 
			
			while (i <= 100)
			{
				System.out.print(i + " ");
				i += 5;
			}
		}
		catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado");
		}
    }
}
