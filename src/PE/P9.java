package PE;

public class P9 {
    public static void main(String[] args){



        for (int one = 0; one<1000; one++){
            for (int two = 0; two<1000; two++){
                for (int three = 0; three < 1000; three++){
                    if (Math.pow(one,2) +Math.pow(two,2) == Math.pow(three,2) && one+two+three == 1000 && one<two && two<three){
                        System.out.println(one+" "+two+ " "+three);
                        System.out.println(one*two*three);
                    }
                }

            }
        }




    }
}
