package JAVA;

public class DataTypes {

	public static void main(String[] args) {
		byte d = 23; //1 byte -128:127
		short e = 24;  //-32,768:32767   2 bytes
		int a = 21;  //-2147483648:2147483647   4 bytes
		long c = 232139473;  //-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807  8 bytes
		float f = 234f;  //6-7 decimal digits   4 bytes
		double b = 21.4; //15 decimal digits 8 bytes
		boolean g = true;  //T/F   1 bit
		char h = 'B'; //2 bytes		
		System.out.println(a +"\n"+ b +"\n"+ c +"\n"+ d+"\n"+ e +"\n"+ f+"\n"+g+"\n"+h);

	}

}
