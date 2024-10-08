/*
 * Create a class HeadSets with below attributes:

headsetName - String
brand-String 
price - int
available- boolean

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods - findTotalPriceForGivenBrand and findAvailableHeadsetWithSecondMinPrice in Solution class.

findTotalPriceForGivenBrand method:
--------------------------------------
The method will return the total price of Headsets from array of Headset objects for the given brand(String parameter passed).
If no Headsets with the given brand is present in the array of Headsets objects, then the method should return 0.

findAvailableHeadsetWithSecondMinPrice method:
-----------------------------------------------
This method will take array of Headset objects as an input parameter and returns the available Headset object with the 
second lowest/minimum price from the given array of objects. 

If no Headsets with the above condition is present in the array of Headsets objects, then the method should return null.

Note : 
No two Headsets will have the same price.
All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For findTotalPriceForGivenBrand method - The main method should print the returned total price as it is if the returned 
value is greater than 0 or it should print "No Headsets available with the given brand".
Eg: 4500
where 4500 is the total Headsets price

For findAvailableHeadsetWithSecondMinPrice method - The main method should print the headsetsName and price from the 
returned Headsets object if the returned value is not null.
If the returned value is null then it should print "No Headsets available".

Eg:Logitech Wired
1500
where Logitech Wired is the headsetName and 1500 is the price

Before calling these static methods in main, use Scanner object to read the values of four Headset objects referring 
attributes in the above mentioned attribute sequence.
Next, read the value of String parameter for capturing brand.

Consider below sample input and output:

Input1:
----------------
boAt BassHeads
boAt
1220
true
Over Ear Wired
boAt
549
true
In Ear with Mic
JBL
450
true
Buds 2 Neo
RealMe
500
true
boAt

Output:
---------------
1769
Buds 2 Neo
500


Input2:
--------------------
boAt BassHeads
boAt
1220
false
Over Ear Wired
boAt
1549
false
In Ear with Mic
JBL
450
false
Buds 2 Neo
RealMe
500
false
boAt
Output:
--------------
2769
No Headsets available
--------------------------------------------------
 
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class HeadSets{
    private String hName;
    private String br;
    private int p;
    private boolean avail;

    public HeadSets(String hName,String br,int p,boolean avail){
        this.hName=hName;
        this.br=br;
        this.p=p;
        this.avail=avail;
    }

    public String getHeadSetsName(){
        return hName;
    }
    public void setHeadSetsName(String hName){
        this.hName=hName;
    }

    public String getHeadSetsBrand(){
        return br;
    }
    public void setHeadSetsBrand(String br){
        this.br=br;
    }

    public int getHeadSetsPrice(){
        return p;
    }
    public void setHeadSetsPrice(int p){
        this.p=p;
    }

    public boolean getHeadSetsAvailable(){
        return avail;
    }
    public void setHeadSetsAvailable(boolean avail){
        this.avail=avail;
    }
}


public class HeadsetProblem {
    
    public static int findTotalPriceForGivenBrand(HeadSets [] headSets,String brand){
        int total=0;
        for(HeadSets headSet:headSets){
            if(headSet.getHeadSetsBrand().equalsIgnoreCase(brand)){
                total+=headSet.getHeadSetsPrice();
            }
        }
        if(total>0){
            return total;
        }
        return 0;
    }

    public static HeadSets findAvailableHeadsetWithSecondMinPrice(HeadSets [] headSets){
        HashMap<String,Integer> hm=new HashMap<>();
        List<HeadSets> list=new ArrayList<>();
        for(HeadSets headSet:headSets){
            //hm.put(headSet.getHeadSetsName(),headSet.getHeadSetsPrice());
            if(headSet.getHeadSetsAvailable()){
                list.add(headSet);
            }
        }
    //     List<Map.Entry<String,Integer>> list=new ArrayList<>(hm.entrySet());
    //     list.sort(Map.Entry.comparingByValue());
        if(list.size()<2){
            return null;
        }
        list.sort((p1,p2)->Integer.compare(p2.getHeadSetsPrice(),p1.getHeadSetsPrice()));
        //return list.toArray(new HeadSets[1]);
        return list.get(list.size()-2);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HeadSets[] headSets=new HeadSets[4];
        for(int i=0;i<4;i++){
            String name=sc.nextLine();
            String b=sc.nextLine();
            int p=sc.nextInt();
            sc.nextLine();
            boolean a=sc.nextBoolean();
            sc.nextLine();
            headSets[i]=new HeadSets(name, b, p, a);
        }

        String brand=sc.nextLine();
        int r1=findTotalPriceForGivenBrand(headSets, brand);
        if(r1>0){
            System.out.println(r1);
        }
        HeadSets r2=findAvailableHeadsetWithSecondMinPrice(headSets);
        if(r2!=null){
            System.out.println(r2.getHeadSetsName());
            System.out.println(r2.getHeadSetsPrice());
        }else{
            System.out.println("No Headset Found");
        }
            
    }
}
