package appIdeas;

public class Stock {

	private String name;
	private float latest, todaysHighest, todaysLowest, todaysGrowth;


	public Stock(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}


	public float getLatest(){
		return latest;
	}

	public void setLatest(float latest) {
		this.latest = latest;
	}

	public float getTodaysHighest() {
		return todaysHighest;
	}

	public void setTodaysHighest(float todaysHighest) {
		this.todaysHighest = todaysHighest;
	}

	public float getTodayLowest() {
		return todaysLowest;
	}

	public void setTodaysLowest(float todaysLowest) {
		this.todaysLowest = todaysLowest;
	}

	public float getTodaysGrowth() {
		return todaysGrowth;
	}

	public void setTodaysGrowth(float todaysGrowth) {
		this.todaysGrowth = todaysGrowth;
	}
}
