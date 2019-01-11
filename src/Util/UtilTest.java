package Util;


public class UtilTest {
	public static void main(String[] args) {
		double x = 5;

		x = Util.map(x, -10, 10, 0, 1000);

		System.out.println(x);

	}


}
