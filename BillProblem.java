/*
 * 
 * Create a class Bill with below attributes:

billNo- int
name - String
typeOfConnection - String
billAmount - double
status – boolean

where billNo is the bill number, name is the name of the customer, typeOfConnection is the type of the connection 
(prepaid, postpaid), billAmount is the bill amount and status is whether the bill is paid or not (if paid then value is TRUE 
else value is FALSE). 

The above attributes should be private, write getters, setters and parameterized constructor as required. 

Create class Solution with main method.
Implement two static methods - findBillWithMaxBillAmountBasedOnStatus and getCountWithTypeOfConnection in Solution class.

findBillWithMaxBillAmountBasedOnStatus method:
-----------------------------------------------------
This method will take an array of Bill objects and a boolean parameter as parameters. 
The method will return bill object array in ascending order of their bill number from the array of Bill objects whose bill 
amount is maximum in the array with the status attribute that matches with the input parameter.

If no Bill with the given status is present in the array of Bill objects, then the method should return null.

getCountWithTypeOfConnection method:
-----------------------------------------------------
This method will take two input parameters - array of Bill objects and string parameter ( for type of connection).
The method will return the count of bills from array of bill objects for the given type of connection.
If no bill with the given type of connection is present in the array of bill objects, then the method should return 0.


Note :

Two bill object can have the same bill amount.
All the searches should be case insensitive. 

The above mentioned static methods should be called from the main method.

For findBillWithMaxBillAmountBasedOnStatus method - The main method should print the billNo followed by # and name from the 
returned Bill object array if the returned value is not null.

If the returned value is null then it should print "There are no bill with the given status".

For getCountWithTypeOfConnection method - The main method should print the count of bills as it is, if the returned value is 
greater than 0,  otherwise it should print "There are no bills with given type of connection".

Before calling these static methods in main, use Scanner to read the number of object and objects to read the values of Bill 
objects referring attributes in the above mentioned attribute sequence. 

Next, read the value for status and typeOfConnection.


Consider below sample input and output:
Input:

4
111
Aman Mittal
Prepaid
914.25
true
222
Rekha Kumar
Prepaid
1425.75
false
333
Samyra Gupta
Prepaid
1305.00
true
444
Mohit Saxena
Postpaid
1300.50
false
false
Prepaid

Output:

222#Rekha Kumar
3
*************************************************************************************

 */




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Bill{
    private int no;
    private String name;
    private String con;
    private double amt;
    private boolean status;

    Bill(int no,String name,String con,double amt,boolean status){
        this.no=no;
        this.name=name;
        this.con=con;
        this.amt=amt;
        this.status=status;

    }

     public int getNo(){
        return no;
     }
     public void setNo(int no){
        this.no=no;
     }

     public String getName(){
        return name;
     }
     public void setName(String name){
        this.name=name;
     }

     public String getConnection(){
        return con;
     }
     public void setConnection(String con){
        this.con=con;
     }

     public double getBill(){
        return amt;
     }
     public void setBill(double amt){
        this.amt=amt;
     }

     public boolean getStatus(){
        return status;
     }
     public void setName(boolean status){
        this.status=status;
     }
}

public class BillProblem {
    public static Bill[] findBillWithMaxBillAmountBasedOnStatus(Bill[]bills,boolean status){
        List<Bill> list=new ArrayList<>();
        double max=Double.MIN_VALUE;
        for(Bill bill:bills){
            if(bill.getStatus()==status){
                if (bill.getBill()>max) {
                    max=bill.getBill();
                    list.add(bill);
                }
            }
        }
        if(list.isEmpty()) return null;
        list.sort((n1,n2)->Integer.compare(n1.getNo(), n2.getNo()));
        return list.toArray(new Bill[0]);
    }

    public static int getCountWithTypeOfConnection(Bill [] bills,String con){
        int count=0;
        for(Bill b:bills){
            if(b.getConnection().equalsIgnoreCase(con)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Bill [] bill=new Bill[4];

        for(int i=0;i<4;i++){
            int no=sc.nextInt();
            sc.nextLine();
            String name=sc.nextLine();
            String con=sc.nextLine();
            double amt=sc.nextDouble();
            sc.nextLine();
            boolean st=sc.nextBoolean();
            sc.nextLine();
            bill[i]=new  Bill(no, name, con, amt, st);
        }

        boolean status=sc.nextBoolean();
        sc.nextLine();
        String con=sc.nextLine();
        Bill[] r1=findBillWithMaxBillAmountBasedOnStatus(bill, status);
        if(r1!=null){
            for(Bill b:r1){
                System.out.println(b.getNo()+"#"+b.getName());
            }
        }else{
            System.out.println("There are no bill with the given status");
        }

        int r2=getCountWithTypeOfConnection(bill, con);
        if(r2>0){
            System.out.println(r2);
        }else{

            System.out.println("There are no bills with given type of connection");
        }
    }

}