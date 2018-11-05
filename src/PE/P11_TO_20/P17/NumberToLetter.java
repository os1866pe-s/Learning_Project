package PE.P11_TO_20.P17;

public class NumberToLetter {

    private final String[] upTo19 = {"","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tenStepA = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety",};


    public NumberToLetter(){

    }

    public String getString(int i){

        if (i < 20){
            return upTo19[i];
        }else if (i < 100){
            return tenStepA[(i - (i % 10))/10] + upTo19[i%10];
        }else if (i < 1000 ){
            String temp = upTo19[(i - (i % 100))/100] + "Hundred";
              if ((i % 100) != 0){
                  temp += "And" + tenStepA[((i - (i % 10))/10) - ((i - (i % 100))/10)];
              }
              if ((i - (i/100)*100 - ( i % 10)) == 10){
                  temp += upTo19[i % 20];
              }else{
                  temp += upTo19[i % 10];
              }
              return temp;
        }else if( i == 1000){
            return "OneThousand";
        }

        return null;
    }


}
