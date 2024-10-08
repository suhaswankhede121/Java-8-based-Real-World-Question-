/*
 * Create a class Book with below attributes

id - int

pages - int

title - String

author - String

price - double

The above attributes should be private, write getters and setters and parameterized constructor as required.

Create a class Solution with main method
--------------------------------------------
Implement two static methods - findBookWithMaximumPrice and searchBookByTitle in Solution class.

findBookWithMaximumPrice :
=============================
Create a static method findBookWithMaximumPrice in the Solution class. This method will take array of Book objects and 
returns the Book object having the maximum Price if found else return null if not found.

searchBookByTitle :
=============================
Create a static method searchBookByTitle in the Solution class. This method will take array of Book objects and Title as 
input and returns the Book object having the mentioned Title if found else return null if not found.

These methods should be called from the main method.

write code to perform the following tasks.

1. Take necessary input variable and call findBookWithMaximumPrice. For this method - The main method should print the Book
 object with the maximum of mentioned attribute as it is if the returned value is not null, or it should print 
 "No Book found with mentioned attribute."

2. Take necessary input variable and call searchBookByTitle. For this method - The main method should print the Book object 
details as it is, if the returned value is not null or it should print "No Book found with mentioned attribute."

The above mentioned static methods should be called from the main method. Also write the code for accepting the inputs and 
printing the outputs. Don't use any static test or formatting for printing the result. Just invoke the method and print the
result.

All String comparison needs to be in case sensitive.

Input:

1
845
Bengali
Arijit
525.50
2
456
English
Raju
412.30
3
1022
History
Kaka
525.50
4
125
geography
MN
524
English

Output:

1 Bengali
3 History
2
456
 */



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book{
    private int id;
    private int page;
    private String t;
    private String a;
    private double p;

    Book(int id,int page,String t,String a, double p){
        this.id=id;
        this.page=page;
        this.t=t;
        this.a=a;
        this.p=p;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public int getPage(){
        return page;
    }
    public void setPage(int page){
        this.page=page;
    }

    public String getTitle(){
        return t;
    }
    public void setTitle(String t){
        this.t=t;
    }

    public String getAuthor(){
        return a;
    }
    public void setAuthor(String a){
        this.a=a;
    }

    public double getPrice(){
        return p;
    }
    public void setPrice(double p){
        this.p=p;
    }
}


public class BookProblem {
    public static Book findBookWithMaximumPrice(Book []books){
        List<Book> list=new ArrayList<>();
        for(Book b:books){
            list.add(b);
        }
        if(list.isEmpty()) return null;
        
        list.sort((p1,p2)->Double.compare(p2.getPrice(), p1.getPrice()));
        return list.get(0);
    }

    public static Book searchBookByTitle(Book []books,String t){
        for(Book b:books){
            if(b.getTitle().equalsIgnoreCase(t)){
                return b;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Book[] book=new Book[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            int pages=sc.nextInt();
            sc.nextLine();
            String t=sc.nextLine();
            String a=sc.nextLine();
            double p=sc.nextDouble();
            sc.nextLine();
            book[i]=new Book(id, pages, t, a, p);
        }
        String t=sc.nextLine();
        
        Book r1=findBookWithMaximumPrice(book);
        if(r1!=null){
            System.out.println(r1.getId()+" "+r1.getTitle());
          
        }else{
            System.out.println("No Book found with mentioned attribute");
        }

        Book r2=searchBookByTitle(book, t);
        if(r2!=null){
            System.out.println(r2.getId());
            System.out.println(r2.getPage());
        }else{
            System.out.println("No Book found with mentioned attribute");
        }
    }
}
