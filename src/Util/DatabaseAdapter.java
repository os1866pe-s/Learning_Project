package Util;

public class DatabaseAdapter {

    private static final String DATABASE_NAME = "mydatabase.db";

    public static void getItem(){
        System.out.println("Returned a item");
    }

    public static void getAllItems(){
        System.out.println("Returned all items");
    }

    public static void removeItem(){
        System.out.println("Removed a item");
    }
}
