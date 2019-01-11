package exTentor;

public class TelephoneDirectory {

	private Person1[] persons;
	private int length;

	public TelephoneDirectory(){
		persons = new Person1[100];
		length = 0;
	}
	public void insert(Person1 p){
		persons[length] = p;
		length++;
	}
	public void delete(String name){
		for (int i = 0; i < length; i++){
			if (persons[i].getName().equals(name)){
				persons[i] = null;
			}
		}
	}
	public Person1 findPerson(String name){
		for (int i = 0; i < length; i++){
			if (persons[i].getName().equals(name)){
				return persons[i];
			}
		}
		return null;
	}

}
