/*
 * create class Marvel with following attribute
 * id, name,budget,boxOffice(income),rating,
 * It should be implement polymorphism 
 * create class which having methods such as
 * findAverageRating-array of object as Movie and budget 
 * return the average of ratings based on budget of the movie if not return 0
 * 
 * 2.searchMovieByBoxOffice- array of objcet and boxOffice
 * return Movie which has boxOffice less than given specified : note MovieId should be descending in nature nd type should be case Insensitive
 * 
 * Note: similar pattern ask in every IPA exam and wings 1 hands on from ninja to digital (Java 8 for digital to Prime)
 */

import java.util.*;

 class Marvel{

    private int movieId;
    private String movieName;
    private double budget;
    private double boxOffice;
    private int rating;
    
    public Marvel(int movieId,String movieName,double budget,double boxOffice,int rating){
        this.movieId=movieId;
        this.movieName=movieName;
        this.budget=budget;
        this.boxOffice=boxOffice;
        this.rating=rating;
    }

    //implementing getter nd setter
    public int getMovieId(){
        return movieId;
    }
    public void setMovieId(int movieId){
        this.movieId=movieId;
    }

    public String getMovieName(){
        return movieName;
    }
    public void setMovieName(String movieName){
        this.movieName=movieName;
    }

    public double getBudget(){
        return budget;
    }
    public void setBudget(double budget){
        this.budget=budget;
    }

    public double getBoxOffice(){
        return boxOffice;
    }
    public void setBoxOffice(double boxOffice){
        this.boxOffice=boxOffice;
    }

    public int getRating(){
        return rating;
    }
    public void setRating(int rating){
        this.rating=rating;
    }
 }

public class MovieOperation {
    
    //1. find average of rating based on their budget
    public static double findAverageRating(Marvel[]marvels,double budget){
      
        int sum=0,count=0;
        for(Marvel marvel:marvels){
            if(marvel.getBudget()>budget){
                sum+=marvel.getRating();
                count++;
            }
        }
        if(count>0){
            return sum/count;
        }
        return 0.0;
    }

    public static Marvel[] searchMovieByBoxOffice(Marvel[]marvels,double boxOffice){
        List<Marvel> searchedMovie=new ArrayList<>();
        for(Marvel marvel:marvels){
            if (boxOffice<marvel.getBoxOffice()) {
                searchedMovie.add(marvel);
            }
        }
        if(searchedMovie.isEmpty()){
            return null;
        }
        searchedMovie.sort((m1,m2)->Integer.compare(m2.getMovieId(),m1.getMovieId()));
        return searchedMovie.toArray(new Marvel[0]);
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        Marvel[] marvel=new Marvel[4];
        for(int i=0;i<4;i++){
            int id=Integer.parseInt(sc.nextLine());
            String name=sc.nextLine();
            double budget=Double.parseDouble(sc.nextLine());
            double boxOffice=Double.parseDouble(sc.nextLine());
            int rating=Integer.parseInt(sc.nextLine());
            marvel[i]=new Marvel(id, name, budget, boxOffice, rating);
        }


        double budget=Double.parseDouble(sc.nextLine());
        double boxOffice=Double.parseDouble(sc.nextLine());

        double avg=findAverageRating(marvel, budget);
        if(avg>0.0){
            System.out.println(avg);
        }else{
            System.out.println("No such movie");
        }

        Marvel[]searchMovie=searchMovieByBoxOffice(marvel, boxOffice);
        if(searchMovie !=null){
            for(Marvel marvels:searchMovie){
                System.out.println(marvels.getMovieId());
            }
        }else{
            System.out.println("no movie found");
        }
    }
}