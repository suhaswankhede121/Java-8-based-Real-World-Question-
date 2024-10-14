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
    
    public static Moviee getMovieByGenre(Moviee[] moviees,String gen){
        for(Moviee m:moviees){
            if(m.getGen().equalsIgnoreCase(gen)){
                if(m.getBudget()>80000000){
                    m.setMessage("High Budget Movie");
                }else{
                    m.setMessage("Low Budget Movie");
                }
                return m;
            }
        }
        return null;
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
        Moviee r1=getMovieByGenre(moviee, gen);
        if(r1!=null){
            System.out.println(r1.getMessage());
        }else{
            System.out.println("No such movies");
        }
    }
}
