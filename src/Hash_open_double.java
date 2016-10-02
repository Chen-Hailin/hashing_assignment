
public class Hash_open_double extends Hash_open{
	public Hash_open_double(){
		super();
	}
	private int double_hashing(String matricNo){
		long hash = 7;
		for (int i = 0; i < matricNo.length(); i++) {
		    hash = hash*17 + matricNo.charAt(i);
		}
		int inc_hash = (int)(hash % 991) + 3;
		return inc_hash;
	}
	public boolean hash_insert(String matricNo){
		int hash_value = hash_func(matricNo);
		int initial = hash_value;
		int inc_hash = double_hashing(matricNo);
		while (hash_table[hash_value] != "empty"){
			hash_value = (hash_value + inc_hash) % 997;
			if (initial == hash_value)
				return false;
		}
		hash_table[hash_value] = matricNo;
		
		return true;
	}
	public int[] hash_search(String matricNo){
		int hash_value = hash_func(matricNo);
		boolean found = false;
		int counter = 1;
		int[] rtn = {1001,0};
		int re_hash_value = double_hashing(matricNo);
		while(hash_table[hash_value] != "empty"){
			counter++;
			hash_value = (hash_value + re_hash_value) % 997;
			if (hash_table[hash_value] == matricNo){
				found = true;
				break;
			}
				
		}
		rtn[1] = counter;
		rtn[0] = (found)? hash_value : 1001;
		return rtn;
	}
}
