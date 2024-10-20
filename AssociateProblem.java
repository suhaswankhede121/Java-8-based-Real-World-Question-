
/*
 * Create class Associate with below attributes:
id - int
name - String
technology - String
experienceInYears - int

Create class Solution and implement static method "associatesForGivenTechnology" in the Solution class.
This method will take array of Associate objects and a searchTechnology String as parameters.
And will return another array of Associate objects where the searchTechnology String matches with the original array of 
Associate object's technology attribute (case insensitive search) and experienceInYears attribute should be multiples of 5.

Write necessary getters and setters.

Before calling "associatesForGivenTechnology" method in the main method, read values for five associate objects referring 
the attributes in above sequence along with a String searchTechnology.
Then call the "associatesForGivenTechnology" method and write the logic to print the id's in the main method.

Input
-----------------
101
Alex
Java
15
102
Albert
Unix
20
103
Alferd
Testing
13
104
Alfa
Java
15
105
Almas
Java
29
Java

Output
------------------
101
104
 */




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Associate{
    private String id;
    private String name;
    private String tech;
    private int yrexp;
  

    Associate(String name,String id, String tech,int yrexp){
        this.name=name;
        this.id=id;
        this.tech=tech;
        this.yrexp=yrexp;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getTech(){
        return tech;
    }
    public void setTech(String tech){
        this.tech=tech;
    }

    public int getYrExp(){
        return yrexp;
    }
    public void setYrExp(int yrexp){
        this.yrexp=yrexp;
    }
}

public class AssociateProblem {
    
    public static Associate[] associateForgiventechnology(String tech,Associate[]associates){
        List<Associate> list=new ArrayList<>();
        for(Associate a:associates){
            if(a.getTech().equalsIgnoreCase(tech) && a.getYrExp()%5==0){
                list.add(a);
            }
        }
          list.sort((i1,i2)->Integer.compare(Integer.parseInt(i1.getId()),Integer.parseInt(i2.getId())));
        return list.toArray(new Associate[0]);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Associate [] associates=new Associate[5];
        for(int i=0;i<5;i++){
            String id=sc.nextLine();
            String name=sc.nextLine();
            String tech=sc.nextLine();
            int yr=sc.nextInt();sc.nextLine();
            associates[i]=new Associate(id, name, tech, yr);
        }
        String tech=sc.nextLine();
        Associate r2[]=associateForgiventechnology(tech,associates);
        if(r2!=null){
            for(Associate a:r2){
                System.out.println(a.getId());
            }
        }
    }
}
