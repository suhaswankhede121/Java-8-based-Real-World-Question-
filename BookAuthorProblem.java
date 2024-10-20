
//Hackthons problem 1


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Author{
    private int aid;
    private String aname;

    Author(int aid,String aname){
        this.aid=aid;
        this.aname=aname;
    }

    public int getAId(){
        return aid;
    }
    public void setAId(int aid){
        this.aid=aid;
    }

    public String getAName(){
        return aname;
    }
    public void setAName(String aname){
        this.aname=aname;
    }

}

class Books{
    private int id;
    private String title;
    private String genre;
    private double price;
    Author author;

    Books(int id,String title,String genre,double price,Author author){
        this.id=id;
        this.title=title;
        this.genre=genre;
        this.price=price;
        this.author=author;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre=genre;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }

    public String getAuthorName(){
        return author.getAName();
    }
    public void setAuthorName(String aname){
        this.author.setAName(aname);
    }

}

public class BookAuthorProblem {
    
    public static List<Books> getBooksBelongingToGenre(Books[] books,String genre){
        List<Books> list=new ArrayList<>();
        for(Books b:books){
            if(b.getGenre().equalsIgnoreCase(genre)){
                list.add(b);
            }
        }
        if(list.isEmpty()) return null;
        return list;
    }

    public static List<Books> calculateDiscountPrice(Books[] books,String genre,double discount){
        List<Books> list=new ArrayList<>();
        for(Books b:books){
            double dprice=b.getPrice()-(b.getPrice()*discount)/100;
            if(b.getGenre().equalsIgnoreCase(genre)){
                b.setPrice(dprice);
                list.add(b);
            }
        }
        if(list.isEmpty()) return null;
        return list;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        Author []author=new Author[n];
        Books[] book=new Books[n];
        for(int i=0;i<n;i++){
            int aid=sc.nextInt();
            sc.nextLine();
            String aname=sc.nextLine();
            int id=sc.nextInt();
            sc.nextLine();
            String title=sc.nextLine();
            String genre=sc.nextLine();
            double price=sc.nextDouble();
            sc.nextLine();
            author[i]=new Author(aid, aname);
            book[i]=new Books(id, title, genre, price,author[i]);
        }

        String genre=sc.nextLine();
        double dprice=sc.nextDouble();
        sc.nextLine();
        List<Books> r1=getBooksBelongingToGenre(book, genre);
        List<Books> r2=calculateDiscountPrice(book, genre, dprice);

        if(r1!=null){
            for(Books b:r1){
                System.out.println("AuthorName: "+b.getAuthorName()+","+" Title: "+b.getTitle());
            }
        }else{
            System.out.println("Genre is not available in the list");
        }

        if(r2!=null){
            for(Books b:r2){
                System.out.println("Discounted "+b.getGenre()+" Books"+" Upadated Price: "+b.getPrice());
            }
        }else{
            System.out.println("Discounted books are unavailable in the given genre");
        }

    }
}
