package exTentor;



public class Contest{
	private int n;
	private Person[] part;
	private int[] stats;

	public Contest(int nMax){
		part = new Person[nMax];
		stats = new int[6];

	}
	public void addPerson(String name){
		part[n] = new Person(name);
		n++;
	}

	public void computeStatistics(){
		for(int i = 0; i < n; i++){
			if (part[i].getPoints() < 10) {
				stats[0] += 1;
			}else if (part[i].getPoints() < 20) {
				stats[1] += 1;
			}else if (part[i].getPoints() < 30) {
				stats[2] += 1;
			}else if (part[i].getPoints() < 40) {
				stats[3] += 1;
			}else if (part[i].getPoints() < 50) {
				stats[4] += 1;
			}else {
				stats[5] += 1;
			}
		}
	}

	public void printStatistics(){
		StringBuilder sb = new StringBuilder();
		sb.append("Antalet deltagare i tävlingen är ");
		sb.append(n);
		sb.append(". Poängfördeling:");
		sb.append("\n\nPoäng\tAntal");

		for (int i = 0; i < 5; i++){
			sb.append("\n" + i*10 + "-" + (i*10 + 9) + "\t" + stats[i]);
		}

		sb.append("\n>=50\t" + stats[5]);
		System.out.println(sb);
	}


	public static void main(String[] args){
		Contest c = new Contest(5);
		c.addPerson("name1");
		c.addPerson("name2");
		c.computeStatistics();
		c.printStatistics();
	}
}
