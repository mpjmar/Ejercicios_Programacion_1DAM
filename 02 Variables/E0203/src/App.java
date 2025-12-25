public class App {
    public static void main(String[] args) throws Exception {
        
        String nombre = "M. Paz Jiménez Martín";
        String direccion = "Calle del Ficus, 1 - 29001 - Málaga";
        String telefono = "666 666 666";
        
        System.out.printf("""
                %s
                %s
                %s
                """, nombre, direccion, telefono);
    }
}
