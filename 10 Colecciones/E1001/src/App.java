import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
		ArrayList<String> students = new ArrayList<String>();
		students.add("Sergio");
		students.add("Adrian");
		students.add("Samuel");
		students.add("Miguel");
		students.add("Eliel");

		for(String s : students)
			System.out.println(s);
	}
}
