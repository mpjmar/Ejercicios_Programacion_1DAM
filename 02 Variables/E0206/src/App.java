

public class App {
    public static void main(String[] args) throws Exception {

        double base = 22.75;
        double iva = 0.21 * base;

        System.out.printf("""
            %-20s %5.2f
            %-20s %5.2f
            %s
            %-20s %5.2f
            """, "Base imponible", base, "IVA", iva, "--------------------------", "Total", base + iva);
    }
}
