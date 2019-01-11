package school.EDDA30.Ovn2;

public class Student extends Person {

	protected String program;
	protected int credits;

	public Student(String name, String program) {
		super(name);
		this.program = program;
		this.credits = 0;
	}

	@Override
	public String toString() {
		return String.format("%s, %s", name, program);
	}
}
