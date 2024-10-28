/*
 * 
 * Question 3: Library Management System with Genre
Design a system to manage records of books and genres in a library. The system should involve two classes: Genre and Book. A genre can have multiple books. Your task is to implement a solution that will maintain a list of Book objects within the Genre class and perform specific operations.

Class Genre:
Attributes:

genreId (int)
genreName (String)
books (Map of book ID to Book objects)
Class Book:
Attributes:

bookId (int)
title (String)
authorName (String)
Methods in Genre Class:
getBooksByAuthor()

This method retrieves and returns a list of book titles written by a specific author within a genre, sorted alphabetically. It takes three arguments: a list of genre objects, genreId, and the authorName. If no genre is found, print "Genre Not Found". If no books are found by the author, print "No Books Found".
getGenresByBookId()

This method finds all genres that contain a specific book ID and returns a list of genre names. It takes two arguments: a list of genre objects and the bookId. If no genres are found containing the book, print "No Genres Found".
Sample Input 1:
2
101
Fiction
3
501
The Great Gatsby
F. Scott Fitzgerald
502
1984
George Orwell
503
To Kill a Mockingbird
Harper Lee
102
Non-Fiction
2
504
Sapiens
Yuval Noah Harari
505
Educated
Tara Westover
101
F. Scott Fitzgerald
502
Sample Output 1:
The Great Gatsby
Fiction

Sample Input 2:
1
103
Science Fiction
1
506
Dune
Frank Herbert
507
nill
00

Sample Output 2:
Genre Not Found
No Genres Found
*/


import java.util.*;

class Book1 {
    private int bid;
    private String title;
    private String authorName;

    public Book1(int bid, String title, String authorName) {
        this.bid = bid;
        this.title = title;
        this.authorName = authorName;
    }

    public int getBid() {
        return bid;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }
}

class Genre {
    private int genreId;
    private String genreName;
    private Map<Integer, Book1> books;

    public Genre(int genreId, String genreName) {
        this.genreId = genreId;
        this.genreName = genreName;
        this.books = new HashMap<>();
    }

    public void addBook(Book1 book1) {
        books.put(book1.getBid(), book1);
    }

    public int getGenreId() {
        return genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public static List<String> getBooksByAuthor(List<Genre> genres, int genreId, String authorName) {
        for (Genre genre : genres) {
            if (genre.getGenreId() == genreId) {
                List<String> titles = new ArrayList<>();
                for (Book1 book : genre.books.values()) {
                    if (book.getAuthorName().equalsIgnoreCase(authorName)) {
                        titles.add(book.getTitle());
                    }
                }
                if (titles.isEmpty()) {
                    System.out.println("No Books Found");
                    return null;
                }
                Collections.sort(titles);
                return titles;
            }
        }
        System.out.println("Genre Not Found");
        return null;
    }

    public static List<String> getGenresByBookId(List<Genre> genres, int bookId) {
        List<String> genreNames = new ArrayList<>();
        for (Genre genre : genres) {
            if (genre.books.containsKey(bookId)) {
                genreNames.add(genre.getGenreName());
            }
        }
        if (genreNames.isEmpty()) {
            System.out.println("No Genres Found");
            return null;
        }
        return genreNames;
    }
}

public class LibraryMgtProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Genre> gList = new ArrayList<>();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int gId = sc.nextInt();
            sc.nextLine();
            String gName = sc.nextLine();
            Genre genre = new Genre(gId, gName);
            int nBooks = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < nBooks; j++) {
                int bid = sc.nextInt();
                sc.nextLine();
                String title = sc.nextLine();
                String author = sc.nextLine();
                genre.addBook(new Book1(bid, title, author));
            }
            gList.add(genre);
        }

        int genreId = sc.nextInt();
        sc.nextLine();
        String authorName = sc.nextLine();
        int bId = sc.nextInt();

        List<String> booksByAuthor = Genre.getBooksByAuthor(gList, genreId, authorName);
        if (booksByAuthor != null) {
            for (String title : booksByAuthor) {
                System.out.println(title);
            }
        }

        List<String> genresByBookId = Genre.getGenresByBookId(gList, bId);
        if (genresByBookId != null) {
            for (String genreName : genresByBookId) {
                System.out.println(genreName);
            }
        }

        sc.close();
    }
}
