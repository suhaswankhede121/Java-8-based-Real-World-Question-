/*
 *  Create a class NavalVessel with the below attributes:

vesselld – int
vesselName – String
noOfVoyagesPlanned – int
noOfVoyagesCompleted – int
purpose – String


Write getters, setters for the above attributes. Create constructor which takes parameter in the above 
sequence except classification.

Create class Solution with main method. Implement two static methods – findAvgVoyagesByPct and findVesselByGrade 
in Solution class.

findAvgVoyagesByPct method:

This method will take two input parameters -array of NavalVessel objects and int parameter percentage. The method will 
return the average of the noOfVoyagesCompleted attribute from NavalVessel objects which meets the percentage requirement 
as mentioned below.The percentage for each navalVessel is calculated as 
percentage .(noOfVoyagesCompleted * 100)/noOfVoyagesPlanned. If the above calculated percentage is greater than or equal 
to the percentage passed as the parameter, then those objects should participate in the average calculation. If there are 
no objects with the mentioned criteria, then the method should return 0.

findVesselByGrade method:

This method will take a String parameter purpose, along with the array of NavalVessel objects. The method will return the 
NavalVessel object, if the input String parameter matches with the purpose attribute of the NavalVessel object. Before 
returning the object, the classification should be derived as mentioned below. This classification value should be assigned 
to the object before returning. If any of the above conditions are not met, then the method should return null. The 
classification attribute should be calculated based on the percentage calculation mentioned above. 
If the percentage = 100 then classification should be ‘Star’, if percentage is between 99 and 80 then classification should 
be ‘Leader, if percentage is between 79 and 55 then classification should be ‘Inspirer' otherwise the classification should 
be ‘Striver’ If the returned value is null then it should print “No Naval Vessel is available with the specified purpose”.

Before calling these static methods in main, use Scanner object to read the values of four NavalVessel objects referring 
attributes in the above mentioned attribute sequence (except the classification attribute). Next, read the value for 
percentage and purpose.

Input
-------------------
111
Rojer
100
100
Passenger
222
Kalam
200
100
Goods
333
Yashwin
400
300
Army
444
Thanishwini
500
500
Welfare
75
Army

Output
------------------
300
Yashwin%Inspirer
 */




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NavalVessel{
    private int id;
    private String name;
    private int noofplan;
    private int noofcomp;
    private String pur;
    private String cls;

    NavalVessel(int id,String name,int noofplan,int noofcomp,String pur){
        this.id=id;
        this.name=name;
        this.noofplan=noofplan;
        this.noofcomp=noofcomp;
        this.pur=pur;
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

    public int getPlan(){
        return noofplan;
    }
    public void setPlan(int noofplan){
        this.noofplan=noofplan;
    }

    public int getComp(){
        return noofcomp;
    }
    public void setComp(int noofcomp){
        this.noofcomp=noofcomp;
    }

    public String getPur(){
        return pur;
    }
    public void setPur(String pur){
        this.pur=pur;
    }

    public String getCls(){
        return cls;
    }
    public void setCls(String cls){
        this.cls=cls;
    }


}


public class NavalVesselProblem {
    public static int findAvgVoyagesByPct(NavalVessel[] navalVessels,int per){
        int sum=0;
        int count=0;
       
        for(NavalVessel nv:navalVessels){
            int p=(nv.getComp()*100)/nv.getPlan();
            if(p>=per){
                sum+=nv.getComp();
                count++;
            }
        }
        if(count>0) {
            double avg=sum/count;
            return (int) avg;
        }
        return 0;



    }

    public static NavalVessel findVesselByGrade(NavalVessel[]navalVessels,String pur){
       // List<NavalVessel> list=new ArrayList<>();
        for(NavalVessel nv:navalVessels){
            //list.add(nv);
            if(nv.getPur().equalsIgnoreCase(pur)){
                int per=(nv.getComp()*100)/nv.getPlan();
                if(per==100){
                    nv.setCls("Star");
                }else if(per>=80 && per<99){
                    nv.setCls("Leader");
                }else if(per>=55 && per<79){
                    nv.setCls("Inspirer");
                }else{
                    nv.setCls("Striver");
                }
                return nv;
            }
        }
       return null;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        NavalVessel []nv=new NavalVessel[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String n=sc.nextLine();
            int nop=sc.nextInt();
            sc.nextLine();
            int noc=sc.nextInt();
            sc.nextLine();
            String pur=sc.nextLine();
            nv[i]=new NavalVessel(id, n, nop, noc, pur);
        }

        int per=sc.nextInt();
        sc.nextLine();
        String pur=sc.nextLine();
        double r1=findAvgVoyagesByPct(nv, per);
        if(r1>0){
            System.out.println(r1);
        }else{
            System.out.println(0);
        }
        NavalVessel r2=findVesselByGrade(nv, pur);
        if(r2!=null){
            System.out.println(r2.getName()+"%"+r2.getCls());
        }else{
            System.out.println("No Naval Vessel is available with the specified purpose");
        }
    }
}
