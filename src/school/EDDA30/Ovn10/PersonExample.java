package school.EDDA30.Ovn10;

import java.util.ArrayList;
import java.util.List;

public class PersonExample {

	public static void print(List<Person> persons, PersonCondition condition){
		for (Person p : persons){
			if (condition.test(p)){
				System.out.println(p.toString());
			}
		}
	}

	public static class AgeCondition implements PersonCondition {

		@Override
		public boolean test(Person p) {
			return p.getAge() >= 18;
		}
	}

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Nilsosn, Sten", 13));
		persons.add(new Person("Jonsson, Camilla", 23));
		persons.add(new Person("Hermansson, Lena", 38));
		persons.add(new Person("Fransson, Anneli", 15));
		persons.add(new Person("Lundström, David", 21));
		persons.add(new Person("Björk, Stefan", 20));
		persons.add(new Person("Andersson, Gun", 55));
		persons.add(new Person("Lundgren, Carina", 12));
		persons.add(new Person("Svensson, Ulf", 47));


		PersonCondition cond = new AgeCondition();
		print(persons, cond);


		print(persons, x -> x.getAge() >= 18);
	}
}
