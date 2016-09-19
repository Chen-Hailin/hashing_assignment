import java.util.*;
public class Hash_Application {
	//private static Hash_close HashClose = new Hash_close();
	//private static Hash_open HashOpen = new Hash_open();
	private static Hash Hash;
	private static random_matricNo random_ID = new random_matricNo(9);
	public static void main(String[] args){
		Hash = new Hash_close();
		test_profiling(Hash);
		//small_test(Hash);
		Hash = new Hash_open();
		test_profiling(Hash);
		Hash = new Hash_open_double();
		test_profiling(Hash);
		
	}
	public static boolean insert(int size){
		for (int i = 0; i < size; i++){
			Hash.hash_insert(random_ID.nextMatricNo());
		}
		return true;
	}
	public static double[] test_search(int testcase, int datasize){
		int[] result = new int[2];
		double search_ops = 0;
		double sum_time = 0;
		double [] rtn = new double[2];
		List <String> existing_data = Hash.data_set();
		LinkedHashSet exist_data = new LinkedHashSet();
		exist_data.addAll(existing_data);
		for (int i = 0; i < testcase; i++){
			String random_str = existing_data.get(random_ID.random.nextInt(existing_data.size()));
			//String random_str = random_ID.nextMatricNo();
			//while (exist_data.contains(random_str))
			//random_str = random_ID.nextMatricNo();
			long startTime = System.nanoTime();
			result = Hash.hash_search(random_str);
			search_ops += result[1];
			//System.out.println(result[1]);
			long estimatedTime = System.nanoTime() - startTime;
			sum_time = sum_time + estimatedTime;
		}
		sum_time = sum_time/testcase;
		search_ops /= testcase;
		rtn[0] = sum_time;
		rtn[1] = search_ops;
		return rtn;
	}
	public static void small_test(Hash Hash){
		insert(900);
		Hash.print_table();
		int[] results = Hash.hash_search("J0501352C");
		System.out.println(results[0]+"-"+results[1]);
	}
	public static void test_profiling(Hash Hash){
		int datasize;
		double sum_time;
		double search_ops;
		double[] rtn = new double[2];
		ArrayList<Double> search_ops_list;
		datasize = -100;
		for (int i = 0; i < 5; i++){
			datasize += 200;
			System.out.println("datasize: " + datasize);
			search_ops_list = new ArrayList<Double>();
			int testcase = 30000;
				sum_time = 0;
				search_ops = 0;
				Hash.reset();
				insert(datasize);
				for(int k = 0; k < 10; k ++){
					rtn = test_search(testcase, datasize);
					sum_time += rtn[0];
					search_ops += rtn[1];
				}
				sum_time /= 10;
				search_ops /= 10;
				search_ops_list.add(search_ops);
				System.out.print("  CPU time: " + (int)sum_time + "ns");
		
			System.out.println();
			for (int j = 0; j < search_ops_list.size(); j++){
				System.out.format("  comparisons: %.1f",search_ops_list.get(j));
			} 
			System.out.println();
		}
	}
}
