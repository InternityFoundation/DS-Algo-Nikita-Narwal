package PatternPrinting;

import java.util.Scanner;
public class Pattern10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			for(int j =1; j <= i; j++) {
				if(i >= 2 && j <= i-1)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		sc.close();

	}

}
