package school.EDDA30.Ovn9;

public class AlgEfficiency {

	//TODO not done with this, have to learn what "tidskomplexitet" is.

	public static void main(String[] args) {

		int n = 6;
		for (int i = 1; i <= n ; i++) {
			for (int j = 1; j <= 2; j++) {
				System.out.println("SimpleStatement: 2n  " + 2 * n);
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n / 2; j++) {
				System.out.println("SimpleStatement: (n^2)/2  " +  n * n / 2);
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = n; j >= i ; j--) {
				System.out.println("SimpleStatement: n * (n - k + 1) " + n * (n + 1)/2);
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j){
					System.out.println("SimpleStatement: n " + n);
				}
			}
		}
	}
}
