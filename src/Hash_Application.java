import java.util.*;
public class Hash_Application {
	private static Hash Hash;
	private static random_matricNo random_ID = new random_matricNo(9);
	public static void main(String[] args){
		//use close addressing
		Hash = new Hash_close();
		test_profiling(true);
		test_profiling(false);
		//use simple open addressing(linear probing)
		Hash = new Hash_open();
		test_profiling(true);
		test_profiling(false);
		//use double open addressing
		Hash = new Hash_open_double();
		test_profiling(true);
		test_profiling(false);
		//in case you want to see the hash table explicitly
		
		Hash = new Hash_open_double();
		small_test();
		
	}
	public static boolean insert(int size){
		for (int i = 0; i < size; i++){
			Hash.hash_insert(random_ID.nextMatricNo());
		}
		return true;
	}
	@SuppressWarnings("unchecked")
	public static double[] test_search(int testcase, int datasize, boolean successful){
		int[] result = new int[2];
		double search_ops = 0;
		double sum_time = 0;
		double [] rtn = new double[2];
		String random_str;
		List <String> existing_data = Hash.data_set();
		@SuppressWarnings("rawtypes")
		LinkedHashSet exist_data = new LinkedHashSet();
		exist_data.addAll(existing_data);
		for (int i = 0; i < testcase; i++){
			if(successful){
				random_str = existing_data.get(random_ID.random.nextInt(existing_data.size()));
			}
			else{
				random_str = random_ID.nextMatricNo();
				while (exist_data.contains(random_str))
				random_str = random_ID.nextMatricNo();
			}
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
	public static void small_test(){
		insert(900);
		Hash.print_table();
		String random_str = Hash.data_set().get(random_ID.random.nextInt(Hash.data_set().size()));
		int[] results = Hash.hash_search(random_str);
		System.out.format("position: %d with search operations %d times\n"
				+ "the searching matricNo. %s", results[0],results[1], random_str);
	}
	public static void test_profiling(boolean successful){
		double sum_time;
		double search_ops;
		double[] rtn = new double[2];
		for (int datasize = 100; datasize < 1000; datasize += 200){
			int testcase = 30000;
			sum_time = 0;
			search_ops = 0;
			Hash.reset();
			insert(datasize);
			//test 10 times for different data set to get the average
			for(int k = 0; k < 10; k ++){
				rtn = test_search(testcase, datasize, successful);
				sum_time += rtn[0];
				search_ops += rtn[1];
			}
			sum_time /= 10;
			search_ops /= 10;
			//print results
			System.out.format("datasize: %d\n"
					+ "  CPU time: %d ns\n"
					+ "  comparisons: %.1f\n", datasize, (int)sum_time, search_ops);
		}
	}
}
