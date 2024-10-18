/*
 * Create class Player2 with below attributes:

id - int
name - String
iccRank - int
matchesPlayed - int
runsScored - int

Create class Solution and implement static method "findAverageOfRuns" in the Solution class.
This method will take array of Player objects and a target int as parameters.
And will return another double array where the target int is lesser than or equal to the original array of Player object's 
matchesPlayed attribute and contains the average run scored by each player satisfying above condition.

Write necessary getters and setters.

Before calling "findAverageOfRuns" method in the main method, read values for four Player objects referring the attributes 
in above sequence along with a int target.
Then call the "findAverageOfRuns" method and write logic in main method to print "Grade A",if the calculated averageRun 
value is 80 to 100. Else if the averageRun value is between 50 and 79 then print "Grade B". Else print "Grade C".

Input
------------------
100
Sachin
5
150
13000
101
Sehwag
4
120
10000
103
Dhoni
7
110
7000
104
Kohli
15
57
4400
100

Output
--------------------
Grade A
Grade A
Grade B

 */



 //Most Important Cocept Building Question.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Player2{
    private int id;
    private String name;
    private int rank;
    private int matches;
    private int runs;
    private String msg;
    private double avg;

    public Player2(int id,String name,int rank,int matches,int runs){
        this.id=id;
        this.name=name;
        this.rank=rank;
        this.matches=matches;
        this.runs=runs;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getRank(){
        return rank;
    }
    public void setRank(int rank){
        this.rank=rank;
    }

    public int getMatches(){
        return matches;
    }
    public void setMatches(int matches){
        this.matches=matches;
    }

    public int getRuns(){
        return runs;
    }
    public void setRuns(int runs){
        this.runs=runs;
    }

    public String getMsg(){
        return msg;
    }
    public void setMsg(String msg){
        this.msg=msg;
    }

    public double getAvg(){
        return avg;
    }
    public void setAvg(double avg){
        this.avg=avg;
    }
}

public class Player2Problem {
    public static Double[] findAverageOfRuns(Player2[]player2s,int target){
        ArrayList<Double> list=new ArrayList<>();
        for(Player2 p:player2s){
            if(target<=p.getMatches()){
                double avg=p.getRuns()/p.getMatches();
                list.add(avg);
            }
        }
        return list.toArray(new Double[0]);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            Player2 [] player2=new Player2[4];
            for(int i=0;i<4;i++){

                int id=sc.nextInt();
                sc.nextLine();
                String name=sc.nextLine();
                int rank=sc.nextInt();
                sc.nextLine();
                int matches=sc.nextInt();
                sc.nextLine();
                int runs=sc.nextInt();
                sc.nextLine();
                player2[i]=new Player2(id, name, rank, matches, runs);
            }

            int target=sc.nextInt();
            sc.nextLine();
            Double r1[]=findAverageOfRuns(player2, target);
            if(r1!=null){
                for(Double p:r1){
                    if(p>=80 && p<=100){
                        System.out.println("Grade A");
                    }else if(p>=50 && p<80){
                        System.out.println("Grade B");
                    }else{
                        System.out.println("Grade C");
                    }
                }
            }
    }
}
