package school.EDDA10.Ovn3;

import java.util.Scanner;

public class P3_3 {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int i = 0;

        System.out.print("Enter a number: ");
        while (userInput.nextInt() != 0) {
            System.out.print("Enter a number: ");
            i++;
        }
        System.out.println("You entered " + i + " numbers which wasn't 0.");
    }
}
