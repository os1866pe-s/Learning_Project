package Test;

public class Item {
    private int x = 0;
    private int y = 0;
    private String name;

    public Item(String name){
        this.name = name;
    }

    public Item(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    //Sorts the array t in the n first items
    public static Item[] sortByNames(Item[] items, int length){

    	//Goes through all items in the array
        for (int i = 0; i < length - 1; i++){
            int place = i;
            Item first = items[i];

            //Goes through all of the items that is unsorted
            for (int k = i + 1; k < length; k++){
				int value = items[place].getName().compareTo(items[k].getName());
				//Checks if the string is lower alphabetic
				if (value > 0){
                    place = k;
                }
            }
            //Switch the items
            items[i] = items[place];
            items[place] = first;
        }
        return items;
    }
}
