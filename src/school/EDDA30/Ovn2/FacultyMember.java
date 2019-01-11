package school.EDDA30.Ovn2;

public class FacultyMember extends Person {

	protected String department;

	public FacultyMember(String name, String department) {
		super(name);
		this.department = department;
	}

	@Override
	public String toString() {
		return String.format("%s, %s", name, department);
	}
}
