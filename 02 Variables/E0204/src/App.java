public class App {
    public static void main(String[] args) throws Exception {

        double euros = 6;
        double ptas = 166.386;
        
        System.out.println(euros + " euros son " + (int) (euros * ptas) + " pesetas.");
        System.out.printf("%.1f euros son %d pesetas", euros, (int)(euros * ptas));
    }
}
