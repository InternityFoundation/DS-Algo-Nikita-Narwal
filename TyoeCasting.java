package JAVA;

public class TyoeCasting {

	public static void main(String[] args) {
		int m = 2345;
		long n = m;        //Automatic typecasting
		System.out.println(n);
		byte b = 121;
		short c = (short)b;    //Manual typecasting
		System.out.println(c);
		int x = 123456;
		float f = 100.12f;
		System.out.println(f);
	}

}
