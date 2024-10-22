/*
 * Create class Movie with below attributes: 

movieName - String 
company - String 
genre - String 
budget - int

Create class Solution and implement static method "getMovieByGenre" in the Solution class. This method will 
take array of Movie objects and a searchGenre String as parameters. And will return another array of Movie 
objects where the searchGenre String matches with the original array of Movie object's genre attribute 
(case insensitive search).

Write necessary getters and setters.

Before calling "getMovieByGenre" method in the main method, read values for four Movie objects referring the 
attributes in above sequence along with a String searchGenre. Then call the "getMovieByGenre" method and write
logic in main method to print "High Budget Movie",if the movie budget attribute is greater than 80000000 else 
print "Low Budget Movie".

Input
---------
aaa
Marvel
Action
250000000
bbb
Marvel
Comedy
25000000
ccc
Marvel
Comedy
2000000
ddd
Marvel
Action
300000000
Action

Output
-------------------
High Budget Movie
High Budget Movie
 */




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Moviee{
    private String name;
    private String com;
    private String gen;
    private int bud;
    private String msg;

    Moviee(String name,String com,String gen,int bud){
        this.name=name;
        this.com=com;
        this.gen=gen;
        this.bud=bud;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getCompany(){
        return com;
    }
    public void setCompany(String com){
        this.com=com;
    }

    public String getGen(){
        return gen;
    }
    public void setGen(String gen){
        this.gen=gen;
    }

    public int getBudget(){
        return bud;
    }
    public void setBudget(int bud){
        this.bud=bud;
    }

    public String getMessage(){
        return msg;
    }
    public void setMessage(String msg){
        this.msg=msg;
    }
}

public class MovieIPA {
    
    public static Moviee[] getMovieByGenre(Moviee[] moviees,String gen){
        List<Moviee> list=new ArrayList<>();
        for(Moviee m:moviees){
            if(m.getGen().equalsIgnoreCase(gen)){
                if(m.getBudget()>80000000){
                    m.setMessage("High Budget Movie");
                }else{
                    m.setMessage("Low Budget Movie");
                }
                list.add(m);
            }
        }
       if (list.isEmpty()) {
        return null;
       }
       return list.toArray(new Moviee[0]);
    }

    public static Moviee[] getMovieByGenre1(Moviee[] moviees,String gen){
        Moviee [] arr=null;
        int count=0;
        for(int i=0;i<moviees.length;i++){
            if(moviees[i].getGen().equalsIgnoreCase(gen)){
                if(moviees[i].getBudget()>80000000){
                    moviees[i].setMessage("High Budget Movie");
                }else{
                    moviees[i].setMessage("Low Budget Movie");
                }
                count++;
            }
        }
       arr=new Moviee[count];
       int j=0;
       for(int i=0;i<moviees.length;i++){
        if (moviees[i].getGen().equalsIgnoreCase(gen)) {
            if(moviees[i].getBudget()>80000000){
                moviees[i].setMessage("High Budget Movie");
            }else{
                moviees[i].setMessage("Low Budget Movie");
            }
            arr[j++]=moviees[i];
        }
       }
       return arr;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Moviee [] moviee=new Moviee[4];
        for(int i=0;i<4;i++){
            String name=sc.nextLine();
            String com=sc.nextLine();
            String gen=sc.nextLine();
            int bud=sc.nextInt();
            sc.nextLine();
            moviee[i]=new Moviee(name, com, gen, bud);
        }
        String gen=sc.nextLine();
        Moviee []r1=getMovieByGenre1(moviee, gen);
       if(r1!=null){
            //System.out.println(r1.getMessage());
            for(Moviee m:r1){
                System.out.println(m.getMessage());
            }
        }else{
            System.out.println("No such movies");
        }
    }
}
