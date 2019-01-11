package school.EDDA30.Ovn1;

import java.util.ArrayList;
import java.util.List;

public class Machine {

	private int nbr;
	private List<Job> jobs;

	/**
	 * Creates a machine with a nbr.
	 * @param nbr the number of the machine.
	 */
	public Machine(int nbr){
		this.nbr = nbr;
		jobs = new ArrayList<>();
	}

	/** Returns the nbr of the machine.*/
	public int getNbr(){
		return nbr;
	}

	/**
	 * Adds a job to the machine.
	 * @param j the job which is assigned to the machine
	 */
	public void assignJob(Job j){
		jobs.add(j);
	}

	/**
	 * Removes all the jobs from the machine.
	 */
	public void clearJobs(){
		jobs.clear();
	}

	/**
	 * Returns the next job in the list.
	 * If the list is empty it returns null.
	 *
	 * @return Returns the next job if there is any, otherwise null.
	 */
	public Job getNextJob(){
		if (jobs.size() > 0) {
			Job nextJob = jobs.get(jobs.size() - 1);
			jobs.remove(jobs.size() - 1);
			return nextJob;
		}
		return null;
	}

	/**
	 * Returns the total time of all the jobs currently
	 * assigned to the machine.
	 *
	 * @return total time of all jobs
	 */
	public int getTotalTime(){
		int totalTime = 0;
		for (Job j : jobs){
			totalTime += j.getTime();
		}
		return totalTime;
	}

	/**
	 * Returns the machine as a string with this configuration.
	 * "nbr_of_this_machine [job1, job2...]"
	 *
	 * @return string formatted like the configuration as above
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');

		jobs.forEach(job ->
				sb.append(job.toString())
				.append(", "));

		sb.replace(sb.length() - 2, sb.length() - 1,  "]");

		return sb.toString();
	}
}
