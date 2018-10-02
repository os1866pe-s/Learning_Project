package Test;

public class BankTest {
    public static void main(String[] args){

        BankAccount ac1 = new BankAccount("Sten",11111);
        int accNbr = ac1.getAccountNbr();

        ac1.deposit(1000);
        ac1.withDraw(999);

        BankAccount ac2 = new BankAccount("Gren",12345,3000);
        System.out.println(ac2.getBalance());
        System.out.println(ac2.getHolder());



    }
}
