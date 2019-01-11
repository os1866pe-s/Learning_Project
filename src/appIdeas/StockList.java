package appIdeas;

import java.util.ArrayList;
import java.util.Optional;

public class StockList {

	ArrayList<Stock> stocks;


	//This whole thing may not be so good because the stocks will be lost once the app is closes
	// or maybe you could save them in a database.
	public StockList(){
		stocks = new ArrayList<>();
	}

	public Optional<Stock> getStock(String name){
		Stock found = null;
		for (Stock s: stocks){
			if (s.getName().equals(name));
			found = s;
		}
		return Optional.ofNullable(found);

	}


	public void addStock(String name){
		stocks.add(new Stock(name));
	}

}
