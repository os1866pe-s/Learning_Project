package exTentor;

public class Person{
	private String name;
	private int points;

	public Person(String name){
		this.name = name;
		points = 0;
	}
	public String getName(){
		return name;
	}

	public int getPoints(){
		return points;
	}

	public void addPoints(int p){
		points += p;
	}
}
