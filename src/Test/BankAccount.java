package Test;

public class BankAccount {

    private int accNbr; //kontonummber - en attribute
    private int balance; //saldot - en annan attribute
    private String holder; //owner - en attribute

    /**Creates a bankaccount with the bankaccount accountNbr
     * with the balance zero.*/
    //This is the Constructor.
    public BankAccount(String holder, int AccountNbr){
        this.holder = holder;
        accNbr = AccountNbr;
        balance = 0;
    }

    /**Creates a bankaccount with the bankaccount accountNbr, holder and a balance.*/
    public BankAccount(String holder,int AccountNbr, int balance){
        this.holder = holder;
        accNbr = AccountNbr;
        this.balance = balance;
    }

    /**Returns the number of the account*/
    //This is a method.
    public int getAccountNbr(){
        return accNbr;
    }

    /**Returns the balance of the account.*/
    public int getBalance(){
       return balance;
    }

    /**Inserts the amount of money to the account.*/
    public void deposit(int amount){
        balance += amount;
    }

    /**Withdras the amount of money from the account*/
    public void withDraw(int amount){

        if (amount <= balance){
            balance -=amount;
        }else{
            System.out.println("Not enough money!");
        }

    }

    /**Returns the owner of the bankaccount*/
    public String getHolder(){
        return holder;
    }

}
