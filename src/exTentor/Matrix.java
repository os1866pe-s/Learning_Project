package exTentor;

public class Matrix {

	private int n;
	private double[][] a;


	public Matrix(int n){
		this.n = n;
		a = new double[n][n];
	}

	public double get(int i , int j){
		return a[i][j];
	}

	public void add(Matrix m){
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				a[i][j] += m.get(i, j);
			}
		}
	}

	public double trace(){
		int sum = 0;
		for (int i = 0; i < n; i++){
			sum += a[i][i];
		}
		return sum;
	}

	public void addValue(int i, int j, int num){
		a[i][j] = num;
	}
}
