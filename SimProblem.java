/*
 * 
 * Create a class Sim with below attributes:



simId - int

customerName - String

balance - double

ratePerSecond - double

circle - String



Write getters, setters and parameterized constructor as required. 



Public class Solution is already created with main method.


Code inside main method should not be altered else your solution might be 


scored as zero.You may copy the code from main method in eclipse to 

verify your implementation. 





Implement static method - transferCustomerCircle in Solution class.

This method will take first parameter as array of Sim class objects, 

second parameter as circle to be transferred (which is String parameter 

circle1) and third parameter as new circle (which is String parameter 

circle2).



Method will transfer the customer to new circle (circle2), where the

 circle attribute would match second parameter (circle1). 


Method will return array of Sim objects for which circle is transferred.


 Return array should be sorted in descending order of ratePerSecond

 (assuming ratePerSecond is not same for any of the Sim objects).





This method should be called from main method and display the simId,

customerName,circle and ratePerSecond of returned objects 

(as per sample output).



Main method mentioned above already has Scanner code to read values, 

create objects and test above methods. Hence do not modify it.






************************************************************************



Consider below sample input and output:



Input:

1
raj
100
1.5
KOL
2
chetan
200
1.6
AHD
3
asha
150
1.7
MUM
4
kiran
50
2.2
AHD
5
vijay
130
1.8
AHD
AHD
KOL



Output:

4 kiran KOL 2.2

5 vijay KOL 1.8

2 chetan KOL 1.6
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class Sim{

    private int id;
    private String name;
    private double bal;
    private double rate;
    private String circle;

    Sim(int id,String name,double bal,double rate,String circle){
        this.id=id;
        this.name=name;
        this.bal=bal;
        this.rate=rate;
        this.circle=circle;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
     
    public double getBalance(){
        return bal;
    }
    public void setBalance(double bal){
        this.bal=bal;
    }

    public double getRate(){
        return rate;
    }

    public void setRate(double rate){
        this.rate=rate;
    }

    public String getCircle(){
        return circle;
    }
    public void setCircle(String circle){
        this.circle=circle;
    }


}
public class SimProblem {

    public static Sim []transferCustomerCircle(Sim[]sims, String circle1, String circle2){
        List<Sim> list=new ArrayList<>();
        for(Sim sim:sims){
            if(sim.getCircle().equalsIgnoreCase(circle1)){
                // String temp=circle1;
               sim.setCircle(circle2);
                list.add(sim);
            }
        }
        if(list.isEmpty()) return null;
        list.sort((r1,r2)->Double.compare(r2.getRate(), r1.getRate()));
        return list.toArray(new Sim[0]);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Sim[] sim=new Sim[5];
        for(int i=0;i<5;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String name=sc.nextLine();
            double bal=sc.nextDouble();
            sc.nextLine();
            double rate=sc.nextDouble();
            sc.nextLine();
            String circle=sc.nextLine();
            sim[i]=new Sim(id, name, bal, rate, circle);
        }

        String c1=sc.nextLine();
        String c2=sc.nextLine();

        Sim[] r1=transferCustomerCircle(sim, c1, c2);
        if(r1!=null){
            for(Sim s:r1){
                System.out.println(s.getId()+" "+ s.getName()+" "+s.getCircle()+" "+s.getRate());
        
            }
        }
    }


}

