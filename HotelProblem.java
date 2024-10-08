import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Hotels{
    private int id;
    private String name;
    private String dob;
    private int rbook;
    private String wf;
    private double bill;
   
   Hotels(int id,String name,String dob,int rbook,String wf,double bill){
    this.id=id;
    this.name=name;
    this.dob=dob;
    this.rbook=rbook;
    this.wf=wf;
    this.bill=bill;
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
   
   public String getDateOfBooked(){
    return dob;
   }
   public void setDateOfBooked(String dob){
     this.dob=dob;
   }

   public int getRoomBooked(){
    return rbook;
   }
   public void setRoomBooked(int rbook){
     this.rbook=rbook;
   }

   public String getWifi(){
    return wf;
   }
   public void setWifi(String wf){
     this.wf=wf;
   }

   public double getBill(){
    return bill;
   }
   public void setBill(double bill){
     this.bill=bill;
   }


}

public class HotelProblem {
    public static int noOfRoomsBookedInGivenMonth(Hotels[] hotels,String month){
        int total=0;
        for(Hotels h:hotels){
            String arr[]=h.getDateOfBooked().split("-");
            String value=arr[1];
            if(value.equals(month)){
                total+=h.getRoomBooked();
            }
        }
        return total;
    }

    public static Hotels searchHotelByWifiOption(Hotels[]hotels,String wf){
        List<Hotels> list=new ArrayList<>();
        for(Hotels h:hotels){
            if(h.getWifi().equalsIgnoreCase(wf)){
                list.add(h);
            }
        }
        if(list.isEmpty()) return null;
        list.sort((b1,b2)->Double.compare(b2.getBill(), b1.getBill()));
        return list.get(1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Hotels [] hotel=new Hotels[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String name=sc.nextLine();
            String dob=sc.nextLine();
            int room=sc.nextInt();
            sc.nextLine();
            String wi=sc.nextLine();
            double bill=sc.nextDouble();
            sc.nextLine();
            hotel[i]=new Hotels(id, name, dob, room, wi, bill);
        }
        String month=sc.nextLine();
        String w=sc.nextLine();

        int r1=noOfRoomsBookedInGivenMonth(hotel, month);
        if(r1>0){
            System.out.println(r1);
        }else{
            System.out.println("No rooms booked in the given month");
        }
        Hotels r2=searchHotelByWifiOption(hotel, w);
        if(r2!=null){
            System.out.println(r2.getId());
        }else{
            System.out.println("No such option available");
        }
    }
}
