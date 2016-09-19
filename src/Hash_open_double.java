
public class Hash_open_double extends Hash_open{
	private String rehash(String matricNo){
		StringBuilder sb = new StringBuilder();
		char ch;
		for (int i = 0; i < matricNo.length(); i++) {
		    ch = (char)((matricNo.charAt(i)*2531)%997);
		    sb.append(ch);
		}
		return sb.toString();
	}
	public Hash_open_double(){
		super();
	}
	private int double_hashing(String matricNo){
		long hash = 7;
		for (int i = 0; i < matricNo.length(); i++) {
		    hash = hash*17 + matricNo.charAt(i);
		}
		int hash_value = (int)(hash % 991) + 3;
		return hash_value;
	}
	public boolean hash_insert(String matricNo){
		int hash_value = hash_func(matricNo);
		int initial = hash_value;
		int re_hash_value = double_hashing(matricNo);
		while (hash_table[hash_value] != "empty"){
			//matricNo = rehash(matricNo, hash_value);
			hash_value = (hash_value + re_hash_value) % 997;
			if (initial == hash_value)
				return false;
		}
		hash_table[hash_value] = matricNo;
		
		return true;
	}
	public int[] hash_search(String matricNo){
		int hash_value = hash_func(matricNo);
		int initial = hash_value;
		int counter = 1;
		int[] rtn = {1001,0};
		int re_hash_value = double_hashing(matricNo);
		//System.out.print(re_hash_value+"-");
		//System.out.print(hash_value+"-");
		while(hash_table[hash_value] != matricNo){
			counter++;
			//matricNo = rehash(matricNo, hash_value);
			hash_value = (hash_value + re_hash_value) % 997;
			//System.out.println(hash_value);
			//System.out.println(hash_value+"::"+matricNo);
			if (initial == hash_value)
				break;
		}
		rtn[1] = counter;
		return rtn;
	}
}
