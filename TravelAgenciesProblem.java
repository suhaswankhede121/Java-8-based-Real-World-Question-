

/*
 * Create a class TravelAgencies with below attributes:

regNo – int
agencyName – String
pakageType – String
price – int
flightFacility – boolean

Write getters, setters for the above attributes . Create constructor which takes parameter in the above sequence.

Create class Solution with main method. Implement two static methods – findAgencyWithHighestPackagePrice and 
agencyDetailsforGivenIdAndType in Solution class.

findAgencyWithHighestPackagePrice method:

This method will take array of TravelAgencies objects as an input parameter and return the highest package 
price from the given array of objects.

agencyDetailsForGivenldAndType method:

This method will take three input parameters -array of TravelAgencies objects, int parameter regNo and String
parameter packageType. The method will return the TravelAgencies object based on below conditions.

FlightFacility should be available.
The input parameters(regNo and packageType) should matched with the regNo and packageType of TravelAgencies object.
If any of the above conditions are not met, then the method should return null. Note : Same Travel agency can 
have more than one package type. Travel agency and package type combination is unique. All the searches should 
be case insensitive.

The above mentioned static methods should be called from the main method.


For findAgencyWithHighestPackagePrice method – The main method should print the highestPackagePrice as it is. 
For agencyDetailsForGivenldAndType method -The main method should print the AgencyName and price of the returned 
object.The AgencyName and price should be concatinated with : while printing.
---------
Input
---------
123
A2Z Agency
Platinum
50000
true
345
SSS Agency
Gold
30000
false
987
Cox and Kings
Diamond
40000
true
888
Global Tours
Silver
20000
false
987
Diamond
-------------------------------
Output
-------------------------------
50000
Cox and Kings:40000
 */

class TravelAgencies{
    private int no;
    private String name;
    private String type;
    private int price;
    private boolean fac;
    

    TravelAgencies(int no,String name,String type,int price,boolean fac){
        this.no=no;
        this.name=name;
        this.type=type;
        this.price=price;
        this.fac=fac;

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

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type=type;
    }

    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }

    public boolean getFacility(){
        return fac;
    }
    public void setFacility(boolean fac){
        this.fac=fac;
    }
    
}


public class TravelAgenciesProblem {

    public static int findAgencyWithHighestPackagePrice(TravelAgencies[] agencies){
        int max=Integer.MIN_VALUE;
        for(TravelAgencies tv:agencies){
            if(tv.getPrice()>max){
                max=tv.getPrice();
            }
        }
        return max;
    }

    public static TravelAgencies agencyDetailsForGivenIdAndType(TravelAgencies [] agencies,int no,String type){
        for(TravelAgencies tv:agencies){
            if(tv.getFacility()==true && tv.getType().equalsIgnoreCase(type) && tv.getNo()==no){
                return tv;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        
    }
}
