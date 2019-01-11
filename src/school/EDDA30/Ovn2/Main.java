package school.EDDA30.Ovn2;

public class Main {



	public static void main(String[] args) {
		Person person;
		Student student;
		FacultyMember facultyMember;

		person = new Person("Lisa Svensson");
		person = new Student("Lisa Svenson", "D");
		//You can't go backwards in the hierarchy
		//student = new Person("Kalle Karlsson");
		student = new Student("Kalle Karlsson", "C");
		//You can't go backwards and then down again
		//student = new FacultyMember("Per Holm", "Computer Science");

		person = student;
		//Does not work because person might not be a student.
		//student = person;
		//Does not work because facultyMember might not be a student
		//facultyMember = student;
	}
}
