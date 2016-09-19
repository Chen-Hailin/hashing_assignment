import java.util.List;

public abstract class Hash {
	public final int table_size = 1000;
	public int hash_func(String matricNo){
		long hash = 3;
		for (int i = 0; i < matricNo.length(); i++) {
		    hash = hash*11 + matricNo.charAt(i);
		}
		int hash_value = (int)(hash % 997);
		return hash_value;
	}
	public abstract void reset();
	public abstract List<String> data_set();
	public abstract void print_table();
	public abstract boolean hash_insert(String matricNo);
	public abstract int[] hash_search(String matricNo);
}
