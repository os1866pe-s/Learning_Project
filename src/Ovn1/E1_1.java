package Ovn1;

import java.util.Scanner;

public class E1_1 {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        int sum = 0;                        //"sum" is set to 0
                                            //
        int factor = 2;                     //"factor" is set to 2
                                            //
        for (int k = 1;k<=9;k++){           //for loop that:
            int digit = userInput.nextInt();//the input number is stored in "digit" /9
            int prod = factor* digit;       //"prod" = double every other time the "digit" /9*(2 , 1)=18 /5*(2, 1)=10
            if (prod > 9){                  //if "prod" is larger than 9
                prod = prod -9;             //"prod" is subtracted by 9             /(18, 9 )-9=9
            }                               //
            sum += prod;                    //every time a new number is entered "prod" is added to "sum"
            if (sum > 10){                  //this if statement just keeps the number "sum" at one digit which is sum%10
                sum = sum -10;              //
            }                               //
            factor = 3- factor;             //
            System.out.println(sum);        //this is making "factor" 2,1,2,1,2,1,2,1,2
        }                                   //
        int cDigit = 10 -sum;               //inverts the number from 10 5=5, 6=4

        System.out.println(cDigit);
    }
}
