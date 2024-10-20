

//java hands on 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Document{
    private int id;
    private String title;
    private String fname;
    private int pages;

    Document(int id,String title,String fname,int pages){
        this.id=id;
        this.title=title;
        this.fname=fname;
        this.pages=pages;
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

    public String getFolderName(){
        return fname;
    }
    public void setFolderName(String fname){
        this.fname=fname;
    }

    public int getPages(){
        return pages;
    }
    public void setPages(int pages){
        this.pages=pages;
    }
}

public class DocumentProblem {

    public static Document [] documentsWithOddPages(Document []documents){
        List<Document> list=new ArrayList<>();
        for(Document d:documents){
            if(d.getPages()%2!=0){
                list.add(d);
            }
        }
        if(list.isEmpty()) return null;
        list.sort((i1,i2)->Integer.compare(i1.getId(), i2.getId()));
        return list.toArray(new Document[0]);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Document [] document=new Document[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String title=sc.nextLine();
            String fname=sc.nextLine();
            int pages=sc.nextInt();
            sc.nextLine();
            document[i]=new Document(id, title, fname, pages);
        }
        Document [] r1=documentsWithOddPages(document);
        if(r1!=null){
            for(Document d:r1){
                System.out.println(d.getId()+" "+d.getTitle()+" "+d.getFolderName()+" "+d.getPages());
            }
        }
    }
}
