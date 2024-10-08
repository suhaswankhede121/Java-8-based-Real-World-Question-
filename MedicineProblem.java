
/*
 * 
 * Create class Medicine with below attributes: 

MedicineName - String 
batch - String 
disease - String 
price - int

Create class Solution and implement static method "getPriceByDisease" in the Solution class. 
This method will take array of Medicine objects and a disease String as parameters. 
And will return another sorted array of Integer objects where the disease String matches with the 
original array of Medicine object's disease attribute (case insensitive search).

Write necessary getters and setters.

Before calling "getPriceByDisease" method in the main method, read values for four Medicine objects 
referring the attributes in above sequence along with a String disease. Then call the "getPriceByDisease" 
method and print the result.

Input
-------------

dolo650
FAC124W
fever
100
paracetamol
PAC545B
bodypain
150
almox
ALM747S
fever
200
aspirin
ASP849Q
flu
250
fever

Output
---------
100
200
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Medicine{
    private String name;
    private String batch;
    private String d;
    private int p;

    public Medicine(String name,String batch,String d,int p){
        this.name=name;
        this.batch=batch;
        this.d=d;
        this.p=p;
    }

    public String getMedicineName(){
        return name;
    }
    public void setMedicineName(String name){
        this.name=name;
    }

    public String getMedicineBatch(){
        return batch;
    }
    public void setMedicineBatch(String batch){
        this.batch=batch;
    }

    public String getMedicineDi(){
        return d;
    }
    public void setMedicineDi(String d){
        this.d=d;
    }

    public int getMedicinePrice(){
        return p;
    }
    public void setMedicinePrice(int p){
        this.p=p;
    }
}

public class MedicineProblem {
    public static Medicine[] getPriceByDisease(Medicine[]medicines,String d){
        List<Medicine> list=new ArrayList<>();
        for(Medicine m:medicines){
            if(m.getMedicineDi().equalsIgnoreCase(d)){
                list.add(m);
            }
        }
        list.sort((p1,p2)->Integer.compare(p1.getMedicinePrice(),p2.getMedicinePrice()));
        return list.toArray(new Medicine[0]);
    }

    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         Medicine [] medicine=new Medicine[4];
         for(int i=0;i<4;i++){
            String n=sc.nextLine();
            String b=sc.nextLine();
            String d=sc.nextLine();
            int p=sc.nextInt();
            sc.nextLine();
            medicine[i]=new Medicine(n, b, d, p);
         }
         String d=sc.nextLine();
         Medicine r1[]=getPriceByDisease(medicine, d);
         for(Medicine m:r1){
            System.out.println(m.getMedicinePrice());
         }
    }
}
