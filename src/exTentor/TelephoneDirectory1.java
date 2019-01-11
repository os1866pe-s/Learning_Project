package exTentor;

import java.util.ArrayList;

public class TelephoneDirectory1 {

	private ArrayList<Person1> persons;
	private int length;

	public TelephoneDirectory1(){
		persons = new ArrayList<Person1>();
		length = 0;
	}
	public void insert(Person1 p){
		persons.add(p);
		length++;
	}
	public void delete(String name){
		int place = 0;
		for (Person1 p : persons){
			if (p.getName().equals(name)){
				persons.remove(place);
			}
			place++;
		}
	}
	public Person1 findPerson(String name){
		for (Person1 p : persons){
			if (p.getName().equals(name)){
				return p;
			}
		}
		return null;
	}
}
