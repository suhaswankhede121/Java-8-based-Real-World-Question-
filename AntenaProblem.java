/*
 * create a class Antenna with below attributes.
antennaid=int
antennaName=String
projectLead=String
antennaVSWR=double

the above attribute should be private ,write getter and setter and parametrized constructor as well.

create class MyClass with main method.
implement two static methods searchAntennaByName and sortAntennaByVSWR in MyClass class.


searchAntennaByName :
---------------------------------------
This method will take an array of Antenna objects and the string value as input parameter.The method will find out Antenna name(String parameterpassed).
It will return Antennaid if found.if there is no Antenna that matches then the method will return zero.
The main method should print the antennaid,if the returned value is not 0.if the returned value is 0 then print,"There is no antenna with the given parameter".


sortAntennaByVSWR:
--------------------------------------
This method will take an array of Antenna Objects and a double value as input.
This method will return an array of Antenna objects sorted in ascending orderof their antennaVSWR, which is less than VSWR(double value passed).       

The main method should print name of the project leads from the returned array if the returned value is not null.if the returned value is null then main method 
should print "No Antenna found";


input1:

111
Reconfigurable
Hema
0.4
222
Wearable
Kavya
0.9
333
Microstrip
Teju
0.3
444
Dielectric
Sai
0.65
Microstrip
0.5

output:
333
Teju
Hema


input 2:
111
Reconfigurable
Hema
0.3
222
Wearable
Kavya
0.9
333
Microstrip
Teju
0.4
444
Dielectric
Sai
0.65
Resonator
0.25

output:
There is no antenna with given parameter
No Antenna found
 */




import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Antena{
    private int id;
    private String name;
    private String pl;
    private double vswr;

    Antena(int id,String name,String pl,double vswr){
        this.id=id;
        this.name=name;
        this.pl=pl;
        this.vswr=vswr;
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

    public String getPL(){
        return pl;
    }
    public void setPL(String pl){
        this.pl=pl;
    }

    public double getVswr(){
        return vswr;
    }
    public void setVswr(double vswr){
        this.vswr=vswr;
    }

}

public class AntenaProblem {
    public static int searchAntennaByName(Antena[]antenas,String name){
        for(Antena a:antenas){
            if(a.getName().equalsIgnoreCase(name)){
                return a.getId();
            }
        }
        return 0;
    }

    public static Antena[] sortAntennaByVSWR(Antena[]antenas,double vswr){
        List<Antena> list=new ArrayList<>();
        for(Antena a:antenas){
            if(vswr>a.getVswr()){
                list.add(a);
            }
        }
        if(list.isEmpty()) return null;
        list.sort((d1,d2)->Double.compare(d1.getVswr(), d2.getVswr()));
        return list.toArray(new Antena[0]);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Antena [] antena=new Antena[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String name=sc.nextLine();
            String pl=sc.nextLine();
            double vswr=sc.nextDouble();
            sc.nextLine();
            antena[i]=new Antena(id, name, pl, vswr);
        }
        String name=sc.nextLine();
        double vswr=sc.nextDouble();
        sc.nextLine();
        int r1=searchAntennaByName(antena, name);
        if(r1>0){
            System.out.println(r1);
        }else{
            System.out.println("There is no antenna with the given parameter");
        }

        Antena []r2=sortAntennaByVSWR(antena, vswr);
        if(r2!=null){
            for(Antena a:r2){
                System.out.println(a.getPL());
            }
        }else{
            System.out.println("No Antenna found");
        }
    }
}
