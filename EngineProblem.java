import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Engine{
    private int id;
    private String name;
    private String type;
    private double price;

    Engine(int id,String name,String type,double price){
        this.id=id;
        this.name=name;
        this.type=type;
        this.price=price;
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

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type=type;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }

}


public class EngineProblem {
    public static double findAvgEnginePriceByType(Engine[]engines,String type){
        int count=0;
        int sum=0;
        for(Engine e:engines){
            if(e.getType().equalsIgnoreCase(type)){
                sum+=e.getPrice();
                count++;
            }
        }
       if(count>0) return sum/count;
       return 0;
    }

    public static Engine [] searchEngineByName(Engine[]engines,String name){
        List<Engine> list=new ArrayList<>();
        for(Engine e:engines){
            if(e.getName().equalsIgnoreCase(name)){
                list.add(e);
            }
        }
        if (list.isEmpty()) {
            return null;
        }
        list.sort((i1,i2)->Integer.compare(i1.getId(), i2.getId()));
        return list.toArray(new Engine[0]);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Engine[]engine=new Engine[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String name=sc.nextLine();
            String type=sc.nextLine();
            double price=sc.nextDouble();
            sc.nextLine();
            engine[i]=new Engine(id, name, type, price);
        }
        String type=sc.nextLine();
        String name=sc.nextLine();
        double r1=findAvgEnginePriceByType(engine, type);
        if(r1>0){
            System.out.println(r1);
        }else{
            System.out.println("There are no engine with given type");
        }

        Engine[] r2=searchEngineByName(engine, name);
        if(r2!=null){
            for(Engine e:r2){
                System.out.println(e.getId());
            }
        }else{
            System.out.println("There are no engine with the given name");
        }
    }
}
