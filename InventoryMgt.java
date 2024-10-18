/*
 * Create class Inventory with below attributes:

inventoryId - String
maximumQuantity - int
currentQuantity - int
threshold - int

Create class Solution and implement static method "Replenish" in the Solution class.
This method will take array of Inventory objects and a limit int as parameters.
And will return another array of Inventory objects where the limit int is greater than or equal to the original array of 
Inventory object's threshold attribute.

Write necessary getters and setters.

Before calling "Replenish" method in the main method, read values for four Inventory objects referring the attributes in above 
sequence along with a int limit.Then call the "Replenish" method and write logic in main method to print "Critical Filling",
if the threshold attribute is greater than 75. Else if the threshold attribute is between 50 and 75 then print 
"Moderate Filling". Else print "Non-Critical Filling"

Input
---------------------------
1
100
50
50
2
200
60
40
3
150
35
45
4
80
45
40
45

Output
----------------------------
2 Non-Critical Filling
3 Non-Critical Filling
4 Non-Critical Filling
 */




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Inventory{
   private String id;
   private int maxQ;
   private int curQ;
   private int thr;
   private String msg;

    Inventory(String id,int maxQ,int curQ,int thr){
        this.id=id;
        this.maxQ=maxQ;
        this.curQ=curQ;
        this.thr=thr;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }

    public int getMaxQuantity(){
        return maxQ;
    }
    public void setMaxQuantity(int maxQ){
        this.maxQ=maxQ;
    }

    public int getCurQuantity(){
        return curQ;
    }
    public void setCurQuantity(int curQ){
        this.curQ=curQ;
    }

    public int getThreshold(){
        return thr;
    }
    public void setThreshold(int thr){
        this.thr=thr;
    }

    public String getMsg(){
        return msg;
    }
    public void setMsg(String msg){
        this.msg=msg;
    }

}

public class InventoryMgt {

   public static Inventory[] replanish(Inventory[]inventories,int limit){
    List<Inventory> list=new ArrayList<>();
     for(Inventory i:inventories){
        if(i.getThreshold()<=limit){
            if(i.getThreshold()>75){
                i.setMsg("Critical Filling");
            }else if(i.getThreshold()>50 && i.getThreshold()<75){
                i.setMsg("Moderate Filling");
            }else{
                i.setMsg("Non-Critical Filling");
            }
            list.add(i);
        }
     }
     return list.toArray(new Inventory[0]);
   }

   public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    Inventory[] inventory=new Inventory[4];
    for(int i=0;i<4;i++){
        String id=sc.nextLine();
        int max=sc.nextInt();
        sc.nextLine();
        int cur=sc.nextInt();
        sc.nextLine();
        int t=sc.nextInt();
        sc.nextLine();
        inventory[i]=new Inventory(id, max, cur, t);
    }
    int limit=sc.nextInt();
    sc.nextLine();
    Inventory [] r1=replanish(inventory, limit);
    if(r1!=null){
        for(Inventory i:r1){
            System.out.println(i.getId()+" "+i.getMsg());
        }
    }else{
        System.out.println("Not found operations");
    }
   }
    
}
