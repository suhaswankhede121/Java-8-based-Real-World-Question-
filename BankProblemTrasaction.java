/*
 * Create a class BankAccount with the following attributes:

accountNumber - int
accountHolderName - String
balance - double

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create a class Solution with the main method.

Implement two static methods - withdraw and deposit in Solution class.

withdraw method:
------------------------------------------
This method will take two input parameters - array of BankAccount objects and the account number (int) from which withdrawal 
should be done.
The method will check if the account number is present in the array of BankAccount objects.
If present, the method will then check if the balance is sufficient to withdraw the requested amount (double). If yes, it will 
deduct the amount from the account balance and return the updated balance.
If the account number is not present or the balance is not sufficient, the method should return -1.

deposit method:
--------------------------------------------
This method will take two input parameters - array of BankAccount objects and the account number (int) in which deposit should 
be done.
The method will check if the account number is present in the array of BankAccount objects.
If present, it will add the deposit amount (double) to the account balance and return the updated balance.
If the account number is not present, the method should return -1.

These above mentioned static methods should be called from the main method.

For withdraw method - The main method should print the updated balance if the returned value is greater than or equal to 0, or 
it should print "Sorry - Insufficient balance" if the returned value is -1, or it should print "Sorry - Account not found" if 
the returned value is -2.

For deposit method - The main method should print the updated balance if the returned value is greater than or equal to 0, or 
it should print "Sorry - Account not found" if the returned value is -1.

Before calling these static methods in main, a parameterized constructor in the above mentioned attribute sequence as required.

Input
------------------------
1001
Alice
5000.0
1002
Bob
10000.0
1003
Charlie
15000.0
1002
5000.0
1001
10000.0

Output
---------------------------
5000.0
15000.0
 */




import java.text.SimpleDateFormat;
import java.util.Date;


class BankAccount{
    private String ano;
    private String ahn;
    private double bal;

    BankAccount(String ano,String ahn,double bal){
        this.ano=ano;
        this.ahn=ahn;
        this.bal=bal;
    }

    public String getAcNo(){
        return ano;
    }
    public void setAcNo(String ano){
        this.ano=ano;
    }
    public String getAcHolderName(){
        return ahn;
    }
    public void setAcHolderName(String ahn){
        this.ahn=ahn;
    }

    public double getBal(){
        return bal;
    }
    public void setBal(double bal){
        this.bal=bal;
    }
}

class BankUtilss{

    public static Transactions transferFunds(BankAccount fromAccount,BankAccount toAccount,double Amount,String traCode) throws Exception{

        if(fromAccount.getBal()<Amount){
            throw new InsufficientBalanceException("Your Account Balance is Unsufficient"+Amount);
        }
        double getBal=fromAccount.getBal()-Amount;
        double setBal=toAccount.getBal()+Amount;

        fromAccount.setBal(getBal);
        toAccount.setBal(setBal);
        String time=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        return new Transactions(traCode,Amount,time);
    }
}

class Transactions{

    private String tranCode;
    private double Ammount;
    private String time;

    Transactions(String tranCode,double Ammount,String time){
        this.tranCode=tranCode;
        this.Ammount=Ammount;
        this.time=time;
    }

    public String getTransactionCode(){
        return tranCode;
    }

    public double getAmmount(){
        return Ammount;
    }

    public String getTime(){
        return time;
    }
}

class InsufficientBalanceException extends Exception{
    String msg;
    InsufficientBalanceException(String msg){
        this.msg=msg;
    }
}

public class BankProblemTrasaction {
    public static void main(String[] args) throws Exception{
        BankAccount b1=new BankAccount("12345", "John", 5000.0);
        BankAccount b2=new BankAccount("67890", "Jane", 10000.0);
        double Amount=2000.0;
        String tranCode="T0001";
        System.out.println("Before Transfer:");
        System.out.println("Account 1: "+b1.getAcHolderName()+" - "+b1.getAcNo()+" - "+b1.getBal());
        System.out.println("Account 1: "+b2.getAcHolderName()+" - "+b2.getAcNo()+" - "+b2.getBal());

        try{

            Transactions obj=BankUtilss.transferFunds(b1, b2, Amount, tranCode);
            System.out.println("After Transfer:");
            System.out.println("Account 1: "+b1.getAcHolderName()+" - "+b1.getAcNo()+" - "+b1.getBal());
            System.out.println("Account 1: "+b2.getAcHolderName()+" - "+b2.getAcNo()+" - "+b2.getBal());

            System.out.println("Transaction Details:");
           System.out.println("Transaction Code: "+obj.getTransactionCode());
           System.out.println("Amount Transfer: "+obj.getAmmount());
           System.out.println("Timestamp: "+obj.getTime());
    
    

        }catch(InsufficientBalanceException e){
            System.out.println(e);
        }

    }
}
