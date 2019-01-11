package school.EDDA30.Ovn1;

import java.util.Collections;

public class Job {

	private String name;
	private int time;

	/**
	 * Creates a job with a name and time.
	 * @param name the name of the job.
	 * @param time the time the job takes.
	 */
	public Job(String name, int time){
		this.name = name;
		this.time = time;
	}

	/**
	 * Returns the time the job takes.
	 */
	public int getTime() {
		return time;

	}

	/**
	 * Returns the job in a string with the configuration as below.
	 * @return name (time)
	 */
	@Override
	public String toString() {
		return String.format("%s (%d)", name, time);
	}
}
