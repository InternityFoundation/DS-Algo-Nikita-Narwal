//There are two banks; Bank A and Bank B. Their interest rates vary.
//You have received offers from both bank in terms of annual rate of interest,
//tenure and variations of rate of interest over the entire tenure.
package Codevita;

import java.util.Scanner;
import java.math.*;

public class BankCompare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		while(test_case --> 0) {
			int loan_amount = sc.nextInt();
			int years = sc.nextInt();
			double[] bank_sum = new double[2];
			bank_sum[0] = 0;
			bank_sum[1] = 0;
			for(int i = 0; i < 2; i++) {
				int slab = sc.nextInt();
				for(int j = 0; j < slab; j++) {
					int slab_years = sc.nextInt();
					double interest = sc.nextDouble();
					double numerator = loan_amount * interest;
					double denominator = 1- (1/Math.pow((1+interest),12*slab_years));
					double calculate = numerator/denominator;
				}
			}
			if(bank_sum[0] > bank_sum[1]) {
				System.out.println("Bank A");
			}
			else {
				System.out.println("Bank B");
			}
		}
		sc.close();
	}

}
