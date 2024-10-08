/*
 * This Question is from your Common Community->IPA Practice 
 */



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Laptop{
    private int id;
    private String brand;
    private String osType;
    private double p;
    private int rating;

    Laptop(int id,String brand,String osType,double p,int rating){
        this.id=id;
        this.brand=brand;
        this.osType=osType;
        this.p=p;
        this.rating=rating;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }

    public String getOsType(){
        return osType;
    }
    public void setOsType(String osType){
        this.osType=osType;
    }

    public double getPrice(){
        return p;
    }
    public void setPrice(double p){
        this.p=p;
    }

    public int getRating(){
        return rating;
    }
    public void setRating(int rating){
        this.rating=rating;
    }

}

public class LaptopProblem {
    public static int countOfLaptopsByBrandName(Laptop []laptops,String brand){
        int count=0;
        for(Laptop l:laptops){
            if(l.getBrand().equalsIgnoreCase(brand) && l.getRating()>3){
                count++;
            }
        }
        return count;
    }

    public static Laptop[] searchLaptopByOsType(Laptop[] laptops,String osType){
        List<Laptop> list=new ArrayList<>();
        for(Laptop l:laptops){
            if(l.getOsType().equalsIgnoreCase(osType)){
                list.add(l);
            }
        }
        if(list.isEmpty()) return null;
        list.sort((l1,l2)->Integer.compare(l2.getId(), l1.getId()));
        return list.toArray(new Laptop[1]);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Laptop[]laptop=new Laptop[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String os=sc.nextLine();
            double p=sc.nextDouble();
            sc.nextLine();
            int r=sc.nextInt();
            sc.nextLine();
            laptop[i]=new Laptop(id, b, os, p, r);
        }
        String brand=sc.nextLine();
        String osType=sc.nextLine();
        int r1=countOfLaptopsByBrandName(laptop, brand);
        if(r1>0){
            System.out.println(r1);
        }else{
            System.out.println("The given brand is not available");
        }

        Laptop[] r2=searchLaptopByOsType(laptop, osType);
        if(r2!=null){
            for(Laptop l:r2){
                System.out.println(l.getId());
                System.out.println(l.getRating());
            }
        }else{
            System.out.println("The given os is not available");
        }
    }
}
