import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Footwear{
    private int id;
    private String name;
    private String type;
    private int price;

    Footwear(int id,String name,String type,int price){
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

    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }
}


public class FootwearProblem {

    public static int getCountByType(Footwear[]footwears,String type){
        int count=0;
        for(Footwear f:footwears){
            if(f.getType().equalsIgnoreCase(type)){
                count++;
            }
        }
        return count;
    }

    public static Footwear getSecondHighestPriceByBrand(Footwear[]footwears,String name){
        List<Footwear> list=new ArrayList<>();
        for(Footwear f:footwears){
            if(f.getName().equalsIgnoreCase(name)){
                list.add(f);
            }
        }
        if(list.isEmpty()) return null;
        list.sort((p1,p2)->Integer.compare(p2.getPrice(), p1.getPrice()));
        return list.get(1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Footwear[] footwear=new Footwear[5];
        for(int i=0;i<5;i++){
            int id=sc.nextInt();sc.nextLine();
            String n=sc.nextLine();
            String t=sc.nextLine();
            int p=sc.nextInt();sc.nextLine();
            footwear[i]=new Footwear(id, n, t, p);
        }
        String type=sc.nextLine();
        String name=sc.nextLine();
        int r1=getCountByType(footwear, type);
        if(r1>0){
            System.out.println(r1);
        }else{
            System.out.println("Footwear not available");
        }
        Footwear r2=getSecondHighestPriceByBrand(footwear, name);
        if(r2!=null){
            System.out.println(r2.getId());
            System.out.println(r2.getName());
            System.out.println(r2.getPrice());
        }else{
            System.out.println("Brand not available");
        }
    }
}
