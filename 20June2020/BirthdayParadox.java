package Mathematics;
import java.util.*;
public class BirthdayParadox {
	static double find(double p) {
		return Math.ceil(Math.sqrt(2*365*Math.log(1/(1-p))));
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		double p = sc.nextDouble();
		System.out.println(find(p));
		sc.close();
	}

}
