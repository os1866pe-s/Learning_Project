package PE.P11_TO_20.P19;

public class P19 {
    //Calculates the amount of months that start with a sunday from beginning of 1901 - to end of 2000
    public static void main(String[] args){

        int r = 0;
        Calendar Cal = new Calendar();

        int days = 0;
        int startday = 3;

        int sundays = 0;
        //1 jan 1901 = Wednesday(3)

        for (int y = 0; y < 100; y++){
            for (int m = 1; m <= 12; m++){
                if (Cal.leapYear(y) && m == 2){
                    days += Cal.daysEveryMonth[m-1] + 1;
                }else {
                    days += Cal.daysEveryMonth[m-1];
                }

                if (((days + 1 + startday) % 7) == 0){
                    sundays++;
                }
            }
        }
        System.out.println(sundays);

    }
}
