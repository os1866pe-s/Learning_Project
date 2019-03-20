package Test;

import Util.DatabaseAdapter;

public class MainActivityTest {

    public static void main(String[] args) {
        new MainActivityTest().onCreate();
    }

    public void onCreate(){
        System.out.println("Created");

        DatabaseAdapter.getItem();
        DatabaseAdapter.getAllItems();
        DatabaseAdapter.removeItem();
    }


}
