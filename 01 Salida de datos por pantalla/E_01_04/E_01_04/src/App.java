public class App {
    public static void main(String[] args) throws Exception {

		final String RESET = "\u001B[0m";
		final String HEAD = "\u001B[46m";
		final String SIST = "\u001B[32mSIS\u001B[0m";
		final String LENG = "\u001B[34mLENG\u001B[0m" ;
		final String BBDD = "\u001B[35mBBDD\u001B[0m";
		final String PROG = "\u001B[31mPROG\u001B[0m";
		final String SOST = "\u001B[37mSOST\u001B[0m";
		final String IPE = "\u001B[33mIPE\u001B[0m";
		final String DIG = "\u001B[30mDIG\u001B[0m";
		final String ENT = "\u001B[36mENT\u001B[0m";

        System.out.printf("%-10s %-10s %-10s %-10s %-10s %n", "LUNES", "MARTES", "MIÉRC", "JUEVES", "VIERNES" + RESET);
		System.out.printf("%-19s %-19s %-19s %-19s %-19s %n", SIST, PROG, SIST, IPE, BBDD);
		System.out.printf("%-19s %-19s %-19s %-19s %-19s %n", SIST, PROG, SIST, IPE, BBDD);
		System.out.printf("%-19s %-19s %-19s %-19s %-19s %n", LENG, PROG, IPE, PROG, SIST);
		System.out.printf("%-19s %-19s %-19s %-19s %-19s %n", LENG, BBDD, DIG, PROG, ENT);
		System.out.printf("%-19s %-19s %-19s %-19s %-19s %n", BBDD, BBDD, PROG, PROG, ENT);
		System.out.printf("%-19s %-19s %-19s %-19s %-19s %n", BBDD, SOST, PROG, LENG, ENT);
    }
}
