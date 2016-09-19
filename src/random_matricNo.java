import java.util.Random;
public class random_matricNo {
	private static final char[] chars,nums;

	  static {
	    StringBuilder tmp1 = new StringBuilder();
	    StringBuilder tmp2 = new StringBuilder();
	    for (char ch = '0'; ch <= '9'; ++ch)
	      tmp1.append(ch);
	    for (char ch = 'A'; ch <= 'Z'; ++ch)
	      tmp2.append(ch);
	    chars = tmp2.toString().toCharArray();
	    nums = tmp1.toString().toCharArray();
	  }   

	  public final Random random = new Random();

	  private final char[] buf;

	  public random_matricNo(int length) {
	    if (length < 1)
	      throw new IllegalArgumentException("length < 1: " + length);
	    buf = new char[length];
	  }

	  public String nextMatricNo() {
	    for (int idx = 0; idx < buf.length; ++idx){
	    	if(idx == 0 || (idx == buf.length - 1)){
	    		buf[idx] = chars[random.nextInt(chars.length)];
	    	}
	    	else{
	    		buf[idx] = nums[random.nextInt(nums.length)];
	    	}
	    }
	    return new String(buf);
	  }
	  
}
