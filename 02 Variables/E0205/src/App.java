public class App {
    public static void main(String[] args) throws Exception {
        
        int ptas = 10000;
        double euros = 0.00601;

        System.out.println(ptas + " pesetas son " + ptas * (float) euros);
        System.out.printf("%d pesetas son %.2f euros", ptas, ptas * euros);
    }
}
