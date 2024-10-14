
class Inventory{
    private int id;
    private int l1;
    private int l2;
    private int l3;
    private String msg;

    Inventory(int id,int l1,int l2,int l3){
        this.id=id;
        this.l1=l1;
        this.l2=l2;
        this.l3=l3;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public int getL1(){
        return l1;
    }
    public void setL1(int l1){
        this.l1=l1;
    }

    public int getL2(){
        return l2;
    }
    public void setL2(int l2){
        this.l2=l2;
    }

    public int getL3(){
        return l3;
    }
    public void setL3(int l3){
        this.l3=l3;
    }

    public String getMsg(){
        return msg;
    }
    public void setMsg(String msg){
        this.msg=msg;
    }

}

public class InventoryMgt {

    public static void replenish(Inventory[]inventories,int limit){
        for(Inventory i:inventories){
            if(i.ge)
        }
    }
    
}
