import java.util.*;
//import java.io.*;
import java.lang.*;
public class Hash_open extends Hash{
	public final int table_size = 1000;
	public String[] hash_table = new String[table_size];
	public Hash_open(){
		reset();
	}
	public boolean hash_insert(String matricNo){
		int hash_value = hash_func(matricNo);
		int initial = hash_value;
		while (hash_table[hash_value] != "empty"){
			hash_value = (hash_value + 1) % table_size;
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
		while(hash_table[hash_value] != "empty"){
			counter++;
			hash_value = (hash_value + 1) % table_size;
			if (hash_table[hash_value] == matricNo){
				found = true;
				break;
			}
		}
		if(found){
			rtn[0] = hash_value;
		}
		rtn[1] = counter;
		return rtn;
	}
	public void print_table(){
		for(int i = 0; i < table_size; i++){
			System.out.println(i+"::"+hash_table[i]);
		}
	}
	public List<String> data_set(){
		List<String> data = new ArrayList<>();
		for(int i = 0; i < table_size; i++){
			if (hash_table[i] != "empty")
				data.add(hash_table[i]);
			}
		return data;
	}
	public void reset(){
		for(int i = 0; i < table_size; i++){
			hash_table[i] = "empty";
		}
	}
}
		