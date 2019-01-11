package exTentor;

public class TestMain {

	public static void main(String[] args) {
		TelephoneDirectory1 td = new TelephoneDirectory1();

		td.insert(new Person1("tord", "99999999"));
		td.insert(new Person1("risk", "46467677"));
		td.insert(new Person1("falk", "23232323"));
		td.insert(new Person1("sten", "11111111"));

		System.out.println(
				td.findPerson("risk").getTelNbr()
		);


		Matrix m = new Matrix(2);
		m.addValue(0,0, 1);
		m.addValue(0,1, 2);
		m.addValue(1,0, 3);
		m.addValue(1,1, 4);

		m.add(m);
		System.out.println(m.trace());



	}
}
