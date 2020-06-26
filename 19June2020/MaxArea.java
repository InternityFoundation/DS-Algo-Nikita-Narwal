//Given n Positive integers A1,A2,A3 .... An, where each integer represents
//a point at coordinate (i, Ai). n vertical lines are drawn such that the
//two endpoints of line i is at (i, Ai) and (i, 0). Find two lines, which
//together with x-axis forms a container, such that the container contains
//the most water.
package MaximumArea;
import java.util.*;

public class MaxArea {
	      public static int maxArea(int[] height) {
	      int length=height.length;
	      int end=length-1; 
	      int start=0; 
	      int max=0; 
	      while(start<end)
	      {
	        int result=(end-start)* Math.min(height[start], height[end]);
	        if(result>max)
	        {
	          max=result; 
	        }
	        if(height[start]< height[end])
	        {
	          start++; 
	        }else
	        {
	          end--; 
	        }
	      }
	      return max;
	    }
	    public static void main(String[] args){
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int[] arr = new int[n];
	        for(int i = 0; i < n; i++){
	            arr[i] = sc.nextInt();
	        }
	        System.out.print(maxArea(arr));
	        sc.close();
	    }
}
