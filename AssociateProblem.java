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
