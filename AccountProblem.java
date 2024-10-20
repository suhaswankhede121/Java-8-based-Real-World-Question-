/*
 * Java Hands-on 1
 */




class Account{
    private int id;
    private double bal;
    private double rate;

    Account(int id,double bal,double rate){
        this.id=id;
        this.bal=bal;
        this.rate=rate;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public double getBal(){
        return bal;
    }
    public void setBal(double bal){
        this.bal=bal;
    }

    public double getRate(){
        return rate;
    }
    public void setRate(double rate){
        this.rate=rate;
    }
}



public class AccountProblem {

    public static double calculateInterest(Account account,int noofyear){
        double perValue=(account.getRate()*noofyear)/100;
        return account.getBal()*(account.getRate()+perValue)/100;
    }
    public static void main(String[] args) {
        Account account=new Account(1, 1000, 10);
        int yr=5;
        double result=calculateInterest(account, yr);
        System.out.format("%.3f",result);
    }
}
