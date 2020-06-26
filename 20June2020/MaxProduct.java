import java.util.*;

import java.util.Scanner; 
class MaxProduct { 
	static int minimum(int x, int y) {
		return x < y ? x : y; 
		} 
	static int maximum(int x, int y) {
		return x > y ? x : y; 
		} 
	static int SubarrayProduct(int arr[]) 
	{ 
		int n = arr.length; 
		int max_num = 1; 
		int min_num = 1; 
		int max_till = 1; 
		int flag = 0; 
		for (int i = 0; i < n; i++) { 
			if (arr[i] > 0) { 
				max_num = max_num * arr[i]; 
				min_num = minimum(min_num * arr[i], 1); 
				flag = 1; 
			} 
			else if (arr[i] == 0) { 
				max_num = 1; 
				min_num = 1; 
			} 
			else { 
				int temp = max_num; 
				max_num = maximum(min_num * arr[i], 1); 
				min_num = temp * arr[i]; 
			} 
			if (max_till < max_num) 
				max_till = max_num; 
		} 

		if (flag == 0 && max_till == 1) 
			return 0; 
		return max_till; 
	} 

	public static void main(String[] args) 
	{ 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		 
		System.out.println(SubarrayProduct(arr));
		sc.close();
	} 
} 
