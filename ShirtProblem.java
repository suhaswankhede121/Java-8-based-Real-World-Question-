import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Shirt{
    private int tag;
    private String brand;
    private double price;
    private char gen;

    Shirt(){};

    Shirt(int tag,String brand,double price,char gen){
        this.tag=tag;
        this.brand=brand;
        this.price=price;
        this.gen=gen;
    }

    public int getTag(){
        return tag;
    }
    public void setId(int tag){
        this.tag=tag;
    }


    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }


    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }

    public char getGender(){
        return gen;
    }
    public void setGender(char gen){
        this.gen=gen;
    }

}

public class ShirtProblem {

    public static double getDiscountPrice(Shirt s){
        double dis=0.0;
        if(s.getGender()=='m'){
            dis=(s.getPrice()*10)/100;
        }else if(s.getGender()=='f'){
            dis=(s.getPrice()*20)/100;
        }else if(s.getGender()=='u'){
            dis=(s.getPrice()*30)/100;
        }
        return s.getPrice()-dis;
    }

    public static Shirt[] getShirtWithMoreThanSpecificPrice(Shirt[] shirts,double price){
        List<Shirt> list=new ArrayList<>();
        for(Shirt s:shirts){
            if(s.getPrice()>price){
                list.add(s);
            }
        }
        if(list.isEmpty()) return null;
        list.sort((p1,p2)->Double.compare(p1.getPrice(), p2.getPrice()));
        return list.toArray(new Shirt[0]);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Shirt[] shirt=new Shirt[5];
        for(int i=0;i<5;i++){
            int tag=sc.nextInt();
            sc.nextLine();
            String brand=sc.nextLine();
            double price=sc.nextDouble();
            sc.nextLine();
            char gen=sc.next().charAt(0);
            //sc.nextLine();
            shirt[i]=new Shirt(tag, brand, price, gen);
        }

        double price=sc.nextDouble();
        sc.nextLine();
         for(Shirt s:shirt){
            System.out.println(getDiscountPrice(s));
         }

        Shirt [] r2=getShirtWithMoreThanSpecificPrice(shirt, price);
        if(r2!=null){
            for(Shirt sh:r2){
                System.out.println(sh.getTag()+" "+sh.getPrice()+" "+sh.getBrand());
            }
        }else{
            System.out.println("No such shirt");
        }
    }
}
