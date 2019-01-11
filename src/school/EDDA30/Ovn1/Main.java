package school.EDDA30.Ovn1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Machine> m = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			m.add(new Machine(i + 1));
		}
		List<Job> jobList = new ArrayList<>();
		String [] names = {"j1", "j2", "j3", "j4", "j5", "j6", "j7"};
		int[] times = {16, 14, 6, 5, 4, 3, 2};
		for (int i = 0; i < names.length; i++) {
			jobList.add(new Job(names[i], times[i]));
		}
		Scheduler s = new Scheduler(m);
		s.makeSchedule(jobList);
		s.printSchedule();
	}
}
