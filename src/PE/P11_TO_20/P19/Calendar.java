package PE.P11_TO_20.P19;

public class Calendar {

    public static final int MONDAY = 1;
    public static final int THUESDAY = 2;
    public static final int WENDSDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FIRDAY = 5;
    public static final int SATURDAY = 6;
    public static final int SUNDAY = 7;


    public int[] daysEveryMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Calendar(){

    }


    public boolean leapYear(int year){
        if (year % 4 == 0){
            if (year % 400 == 0){
                return false;
            }else {
                return true;
            }
        }else {
            return false;
        }
    }
}
