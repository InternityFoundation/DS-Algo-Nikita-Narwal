package PatternPrinting;

import java.util.Scanner;

public class Pattern12b {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = n; i >= 1; i--) {
			for(int j = n; j > i; j--) {
				System.out.print(" ");
			}
			for(int k = 1; k < (i*2); k++) {
				if(k > 1 && k < (i*2)-2)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		sc.close();

	}


}
// *    *
// *   *
//  * *
//   *
