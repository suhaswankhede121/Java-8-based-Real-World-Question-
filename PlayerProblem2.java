import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Players{
    private int id;
    private String skill;
    private String level;
    private int point;

    public Players(int id,String skill,String level,int point){
        this.id=id;
        this.skill=skill;
        this.level=level;
        this.point=point;
    }

    public int getPlayerId(){
        return id;
    }
    public void setPlayerId(int id){
        this.id=id;
    }

    public String getPlayerSkill(){
        return skill;
    }
    public void setPlayerSkill(String skill){
        this.skill=skill;
    }

    public String getPlayerLevel(){
        return level;
    }
    public void setPlayerLevel(String level){
        this.level=level;
    }

    public int getPlayerPoint(){
        return point;
    }
    public void setPlayerPoint(int point){
        this.point=point;
    }

}


public class PlayerProblem2 {
    public static int findPointsForGivenSkill(Players[]players,String skill){
        int sum=0;
        for(Players p:players){
            if(p.getPlayerSkill().equalsIgnoreCase(skill)){
                sum+=p.getPlayerPoint();
            }
        }
        if(sum>0) return sum;
        return 0;
    }

    public static Players[] getPlayerBasedOnLevel(Players[]players,String skill,String level){
        List<Players> list=new ArrayList<>();
        for(Players p:players){
            if((p.getPlayerSkill().equalsIgnoreCase(skill) && p.getPlayerLevel().equalsIgnoreCase(level)) && p.getPlayerPoint()>=20){
                list.add(p);
            }
        }
        if(list.isEmpty()){
            return null;
        }
        return list.toArray(new Players[0]);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Players [] player=new Players[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String skill=sc.nextLine();
            String level=sc.nextLine();
            int point=sc.nextInt();
            sc.nextLine();
            player[i]=new Players(id, skill, level, point);
        }
        String skill=sc.nextLine();
        String level=sc.nextLine();
        int r1=findPointsForGivenSkill(player, skill);
        if(r1>0){
            System.out.println(r1);
        }else{
            System.out.println("The given Skill is not available");
        }
        Players [] r2=getPlayerBasedOnLevel(player, skill, level);
        if(r2!=null){
            for(Players p:r2){
                System.out.println(p.getPlayerId());
            }
        }else{
            System.out.println("No player is available with specified level, skill and eligibility points");
        }
    }
}
