/*
 * Create a class called BankAccount with the following attributes:

accountNumber (String)
accountHolderName (String)
balance (double)
Write getters, setters, and a parameterized constructor for the class.

Create a static method transferFunds in a separate class called BankUtils. The method should take four parameters:

fromAccount (BankAccount)
toAccount (BankAccount)
amount (double)
transactionCode (String)
The method should transfer the specified amount from the fromAccount to the toAccount,
and return a Transaction object containing the transactionCode, the amount 
transferred, and the timestamp of the transaction. If the fromAccount has insufficient
balance, the method should throw an InsufficientBalanceException with an appropriate error message.

Create a class called Transaction with the following attributes:

transactionCode (String)
amount (double)
timestamp (String)
Write getters and a parameterized constructor for the class.

Create an InsufficientBalanceException class that extends the Exception class. 
The exception should have a constructor that takes a message as a parameter.

In the main method, create two BankAccount objects, transfer some funds between 
them using the transferFunds method, and print the transaction details to the console. Handle any exceptions.

Sample Input:

Account 1:
Account Number: 12345
Account Holder Name: John
Balance: 5000.0

Account 2:
Account Number: 67890
Account Holder Name: Jane
Balance: 10000.0

Transfer Details:
Amount: 2000.0
Transaction Code: T0001

Sample Output:

Before Transfer:
Account 1: John - 12345 - 5000.0
Account 2: Jane - 67890 - 10000.0

After Transfer:
Account 1: John - 12345 - 3000.0
Account 2: Jane - 67890 - 12000.0

Transaction Details:
Transaction Code: T0001
Amount Transferred: 2000.0
Timestamp: 2023-04-01 10:30:00
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
