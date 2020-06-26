package LongestSubsequence;
import java.util.*;
public class LongSeq {
	    static final int no_of_char = 256;   
	    static int longestUniqueSubsttr(String str) 
	    { 
	        int n = str.length();  
	        int res = 0; 
	        int [] lastIndex = new int[no_of_char]; 
	        Arrays.fill(lastIndex, -1); 
	        int i = 0; 
	        for (int j = 0; j < n; j++) { 
	            i = Math.max(i, lastIndex[str.charAt(j)] + 1); 
	            res = Math.max(res, j - i + 1); 
	            lastIndex[str.charAt(j)] = j; 
	        } 
	        return res; 
	    } 
	    public static void main(String[] args) 
	    { 
	        Scanner sc = new Scanner(System.in);
	        String str = sc.nextLine(); 
	        int len = longestUniqueSubsttr(str); 
	        System.out.println(len); 
	        sc.close();
	    }  
}
