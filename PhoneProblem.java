import java.util.Scanner;

class Phone{
    private int id;
    private String os;
    private String brand;
    private int price;

    Phone(int id,String os,String brand,int price){
        this.id=id;
        this.os=os;
        this.brand=brand;
        this.price=price;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getOs(){
        return os;
    }
    public void setOs(String os){
        this.os=os;
    }

    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }

    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }
}


public class PhoneProblem {

    public static int findPriceForGivenBrand(Phone[]phones,String brand){
        int sum=0;
        for(Phone p:phones){
            if(p.getBrand().equalsIgnoreCase(brand)){
                sum+=p.getPrice();
            }
        }
        return sum;
    }

    public static Phone getPhoneIdBasedOnOs(Phone[] phones,String os){
        for(Phone p:phones){
            if(p.getOs().equalsIgnoreCase(os) && p.getPrice()>=50000){
                return p;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Phone[]phones=new Phone[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String os=sc.nextLine();
            String brand=sc.nextLine();
            int price=sc.nextInt();
            sc.nextLine();
            phones[i]=new Phone(id, os, brand, price);
        }
        String brand=sc.nextLine();
        String os=sc.nextLine();
        int r1=findPriceForGivenBrand(phones, brand);
        if(r1>0){
            System.out.println(r1);
        }else{
            System.out.println("The given Brand is not available");
        }
        Phone r2=getPhoneIdBasedOnOs(phones, os);
        if(r2!=null){
            System.out.println(r2.getId());
        }else{
            System.out.println("No phones are available with specified os and price range");
        }
    }
}
