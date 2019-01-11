package school.EDDA30.Ovn1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Scheduler {

	private List<Machine> machines;

	/**
	 * Creates a scheduler for a list of machines.
	 *
	 * @param machines the machines which will be assigned jobs.
	 */
	public Scheduler(List<Machine> machines) {
		this.machines = machines;
	}

	/**
	 * Takes a list of jobs and assigns them to the current available
	 * machines according to the LPT-algorithm.
	 *
	 * @param jobs the tasks the machines is assigned to.
	 */
	public void makeSchedule(List<Job> jobs) {
		jobs.sort((o1, o2) -> {
			if (o1.getTime() > o2.getTime()) return -1;
			else if (o1.getTime() < o2.getTime()) return 1;
			return 0;
		});

		for (Job j : jobs) {
			machines.stream().min((m1, m2) -> {
						if (m1.getTotalTime() > m2.getTotalTime()) return 1;
						else if (m1.getTotalTime() < m2.getTotalTime()) return -1;
						return 0;
					}).ifPresent(m -> m.assignJob(j));

		}
	}

	/**
	 * Prints out information for every machine like this,
	 * "nbr_of_machine [job1, job2...] totalTime"
	 */
	public void printSchedule() {

		machines.forEach(m -> System.out.println(
						String.format("%s %s%d",
								m.getNbr(),
								m.toString(),
								m.getTotalTime())));
	}
}
