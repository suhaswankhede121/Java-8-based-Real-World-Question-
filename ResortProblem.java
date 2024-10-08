/*
 * from your xplore common community-> IPA Practice
 */


import java.util.Scanner;

class Resort{
    private int rId;
    private String rName;
    private String cat;
    private double p;
    private double r;

    public Resort(int rId,String rName,String cat,double p,double r){
        this.rId=rId;
        this.rName=rName;
        this.cat=cat;
        this.p=p;
        this.r=r;
    }

    public int getResortId(){
        return rId;
    }
    public void setResortId(int rId){
        this.rId=rId;
    }

    public String getResortName(){
        return rName;
    }
    public void setResortName(String rName){
        this.rName=rName;
    }

    public String getResortCategory(){
        return cat;
    }
    public void setResortCategory(String cat){
        this.cat=cat;
    }
    
    public double getResortPrice(){
        return p;
    }
    public void setResortPrice(double p){
        this.p=p;
    }

    public double getResortRating(){
        return r;
    }
    public void setResortRating(double r){
        this.r=r;
    }

}

public class ResortProblem {
    public static int findAvgPriceByCategory(Resort [] resorts,String category){
        double avg=0.0;
        double sum=0.0;
        int count=0;
        for(Resort resort:resorts){
            if(resort.getResortCategory().equalsIgnoreCase(category) && resort.getResortRating()>4){
                sum+=resort.getResortPrice();
                count++;
            }
        }
        avg=sum/count;
        if(avg>0){
            return (int) avg;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Resort [] resorts=new  Resort[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String name=sc.nextLine();
            String cat=sc.nextLine();
            double p=sc.nextDouble();
            sc.nextLine();
            double r=sc.nextDouble();
            resorts[i]=new Resort(id, name, cat, p, r);
        }
        sc.nextLine();
        String cat=sc.nextLine();
        int result=findAvgPriceByCategory(resorts, cat);
        if(result>0){
            System.out.println("Average price of the "+cat+" Resort:"+result);
        }else{
            System.out.println("There are no such available resort");
        }
    }

}
