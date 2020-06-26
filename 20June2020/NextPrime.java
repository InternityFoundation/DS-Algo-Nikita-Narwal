package Mathematics;
import java.util.*;
import java.math.*;

public class NextPrime {
	static long nextPrime(long n) {
		BigInteger b = new BigInteger(String.valueOf(n));
		return Long.parseLong(b.nextProbablePrime().toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//int q = sc.nextInt();
		int q = 100;
		for(int i = 0; i < q; i++) {
		int t = sc.nextInt();
		System.out.println(nextPrime(t));
		sc.close();
		}

	}

}
