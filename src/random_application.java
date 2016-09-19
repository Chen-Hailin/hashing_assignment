import java.lang.String;
import java.util.LinkedList;
public class random_application {
	private static LinkedList<String>[] hash_table;
	public static void main(String[] args){
		random_matricNo random_ID = new random_matricNo(9);
		String str;
		for (int i = 0; i < 1000; i++){
			str = random_ID.nextMatricNo();
			System.out.println(i + ":" + str);
			hash_table[i].add(str);
		}
		System.out.println("Finished");
	}
}
