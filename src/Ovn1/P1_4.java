package Ovn1;

import java.util.Scanner;

public class P1_4 {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter the departure of you train (Ex 00:00): ");
        String time = userInput.nextLine();

        String refined = time.replace(":", " ");
        int depHour = Integer.parseInt(refined.substring(0, 2));
        int depMin = Integer.parseInt(refined.substring(3,5));


        System.out.print("Enter the runtime(min): ");
        int runtime = userInput.nextInt();

        int arrivalTime_min = (depMin+runtime)%60;
        int arrivalTime_hour =(int)(depHour +Math.floor((runtime+depMin)/60));
        String arT_min = String.valueOf(arrivalTime_min);
        if ((String.valueOf(arrivalTime_min)).length() == 1){
            arT_min = "0" + arT_min;
        }
        if (arrivalTime_hour >23){
            arrivalTime_hour -= 24;
        }
        System.out.println("Arrival time: " + arrivalTime_hour + ":" + arT_min);
    }
}
