import java.util.*;
//import java.io.*;
import java.lang.*;
public class Hash_close extends Hash{
	//private String matricNo;
	@SuppressWarnings("unchecked")
	private LinkedList<String>[] hash_table = new LinkedList[table_size];
	/*
	public int hash_func(String matricNo){
		long hash = 3;
		for (int i = 0; i < matricNo.length(); i++) {
		    hash = hash*11 + matricNo.charAt(i);
		}
		int hash_value = (int)(hash % 1000);
		return hash_value;
	}
	*/
	public Hash_close(){
		reset();
	}
	public boolean hash_insert(String matricNo){
		int hash_value = hash_func(matricNo);
		hash_table[hash_value].add(matricNo);
		return true;
	}
	public int[] hash_search(String matricNo){
		int hash_value = hash_func(matricNo);
		int counter = 0;
		int[] rtn = {1001,0};
		ListIterator<String> list_iterator = hash_table[hash_value].listIterator();
		while(list_iterator.hasNext()){
			counter++;
			if (list_iterator.next() == matricNo){
				rtn[0] = hash_value;
				rtn[1] = counter;
				return rtn;
			}
			
		}
		rtn[1] = counter;
		return rtn;
	}
	public void print_table(){
		for(int i = 0; i < table_size; i++){
			System.out.print(i+"::");
			ListIterator<String> list_iterator = hash_table[i].listIterator();
			while(list_iterator.hasNext()){
				System.out.print(list_iterator.next()+ "::");
			}
			System.out.print("\n");
		}
	}
	public List<String> data_set(){
		List<String> data = new ArrayList<>();
		String temp;
		for(int i = 0; i < table_size; i++){
			ListIterator<String> list_iterator = hash_table[i].listIterator();
			while(list_iterator.hasNext()){
				temp = list_iterator.next();
				if (temp != "empty")
					data.add(temp);
			}
		}
		return data;
	}
	public void reset(){
		for (int i = 0; i < table_size; i++)
			hash_table[i] = new LinkedList<String>();
	}
}
		