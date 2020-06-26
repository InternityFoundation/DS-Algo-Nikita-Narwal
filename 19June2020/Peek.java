//A peak element is an element that is greater than its neighbors.
//Given an input array nums, where nums[i] ≠ nums[i+1],
//find a peak element and return its index.
//The array may contain multiple peaks,
//in that case return the minimum index of the peak.
package PeekElement;

import java.util.Scanner;

public class Peek {

	public static int findPeakElement(int[] nums) {
        if(nums.length == 1 || nums[0] > nums[1]) return 0;
        if(nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        for(int i = 1; i < nums.length - 1; i++){
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = sc.nextInt();
        }
        System.out.print(findPeakElement(num));
        sc.close();
    }

}
