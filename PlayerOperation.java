/*
 * This question is prevously asked in IPA exam of wings 1 most question totally based on the java 8 real world 
 * problem statement, so before solving such a question you must having a basic to intermediate understanding of java 8
 * and "Array of Objects in Java 7". - Note: This is prerequisites of the IPA internal examinination of Tcsl.
 * 
 * 
 * Lets begins with the questions
 * Create class Player :
 * with a attribute id,name,runs,type,match
 * above attribute should be followed polymorphism guidlines 
 * create solution class with main method and another method such as
 * 1.findPlayerWithLowestRun - parameter array object of player and player type 
 * return the least run if not return 0.
 * 
 * 2.findPlayerWithMatchtupe- paramter array of objects and match type
 * return the player who match match type and otherwise return null: note mathctype shoud case insensetive and descending order of their id's
 * Notes of Auther: Suhas W.
 */

 /**
  * PlayerOperation
  */

  import java.util.*;
  
  class Player{
    private int id;
    private String playerName;
    private int runs;
    private String playerType;
    private String matchType;

    public Player(int id,String playerName, int runs,String playerType,String matchType){
        this.id=id;
        this.playerName=playerName;
        this.runs=runs;
        this.playerType=playerType;
        this.matchType=matchType;
    }

    //implements getter and setter
    public int getPlayerId(){
        return id;
    }
    public void setPlayerId(int id){
        this.id=id;
    }

    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String playerName){
        this.playerName=playerName;
    }

    public int getRuns(){
        return runs;

    }
    public void setRuns(int runs){
        this.runs=runs;
    }

    public String getPlayerType(){
        return playerType;
    }
    public void setPlayerType(String playerType){
        this.playerType=playerType;
    }
    public String getMatchType(){
        return matchType;
    }
    public void setMatchType(String matchType){
        this.matchType=matchType;
    }
  }
 public class PlayerOperation {
 
    //1. this method return the lowest runs which matches their player Type
    public static int findPlayerWithLowestRun(Player[]players,String playerType) {
        int minRuns=Integer.MAX_VALUE;
        boolean flag=false;
        //Iterating over the array of objects
        for(Player player:players){
            if(player.getPlayerType().equalsIgnoreCase(playerType)){
                flag=true;
                if(player.getRuns()<minRuns){
                    minRuns=player.getRuns();
                }
            }
        }
        return flag ? minRuns:0;
    }   

    //2.find the player according to their match type if not return null
    public static Player[] findPlayerWithMatchType(Player[]players,String matchType){
        //To return the list of match player so required list
        List<Player> matchPlayers=new ArrayList<>();
        for(Player player:players){
            if(player.getMatchType().equalsIgnoreCase(matchType)){
                matchPlayers.add(player);
            }
        }
        if(matchPlayers.isEmpty()){
            return null;
        }
        //according to question if not null the return playerId in descending order
        matchPlayers.sort((p1,p2)->Integer.compare(p2.getPlayerId(), p1.getPlayerId()));
        return matchPlayers.toArray(new Player[0]); // return type is type array so need to convert list into array this is java 8 feature

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Player[]player=new Player[4];
        for(int i=0;i<4;i++){
            int id=Integer.parseInt(sc.nextLine()); //note: if this way is not support we can use parsing ->Integer.parseInt(sc.nextLine())
            String name=sc.nextLine();
            int runs=Integer.parseInt(sc.nextLine());
            String playerType=sc.nextLine();
            String matchType=sc.nextLine();
            player[i]=new Player(id, name, runs, playerType, matchType);
        }

        String playerType=sc.nextLine();
        String matchType=sc.nextLine();

        System.out.println();
        //now calling the methods 
        int minRuns=findPlayerWithLowestRun(player, playerType);
        if(minRuns>0){
            System.out.println(minRuns);
        }else{
            System.out.println("No such runs");
        }

        System.out.println();
        Player[] matchesPlayers=findPlayerWithMatchType(player, matchType);
        if(matchesPlayers !=null){
            for(Player p:matchesPlayers){
                System.out.println(p.getPlayerId());
            }
        }else{
            System.out.println("No such player exists");
        }
    }
 }