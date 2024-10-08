/*
 * craete a class hotel with the following attributes
 * id,name,dateofjoining(dd-mm-yy),noofroomsbooked,bill,wifiFacility
 * apply polymorphism for the same 
 * 
 * create a another class for solution which has the following methodss
 * 1.noOfRoomsBooked - Hotel array object and month
 * return the no of rooms book in the hostel given specified month or else retunr 0
 * 
 * 2.searchHotelByWifiOption - Hotel array object and wifiOption
 * return array of hotel which has the wifi avaialable in the hostel
 * 
 */

 import java.util.*;

 class Hotel{
    private int hotelId;
    private String hotelName;
    private String dateOfJoining; //dd-mm-yy
    private int noOfRoomsBooked;
    private double bill;
    private String wifiFacility;

    public Hotel(int hotelId,String hotelName,String dateOfJoining,int noOfRoomsBooked,double bill,String wifiFacility){
        this.hotelId=hotelId;
        this.hotelName=hotelName;
        this.dateOfJoining=dateOfJoining;
        this.noOfRoomsBooked=noOfRoomsBooked;
        this.bill=bill;
        this.wifiFacility=wifiFacility;
    }

    public int getHotelId(){
        return hotelId;
    }
    public void setHotelId(int hotelId){
        this.hotelId=hotelId;
    }

    public String getHotelName(){
        return hotelName;
    }
    public void setHotelName(String hotelName){
        this.hotelName=hotelName;
    }
    
    public String getDateOfJoining(){
        return dateOfJoining;
    }
    public void setDateOfJoining(String dateOfJoining){
        this.dateOfJoining=dateOfJoining;
    }

    public int getNoOfRoomsBooked(){
        return noOfRoomsBooked;
    }
    public void setNoOfRoomsBooked(int noOfRoomsBooked){
        this.noOfRoomsBooked=noOfRoomsBooked;
    }

    public double getBill(){
        return bill;
    }
    public void setBill(double bill){
        this.bill=bill;
    }

    public String getWifiFacility(){
        return wifiFacility;
    }
    public void setWifiFacility(String wifiFacility){
        this.wifiFacility=wifiFacility;
    }

 }

public class HotelOperation {
    
    public static int noOfRoomsBooked(Hotel[]hotels,String month){
        int totalBooking=0;
        for(Hotel hotel:hotels){
            String resultMonth=hotel.getDateOfJoining().split("-")[1].toLowerCase();
            if(resultMonth.equalsIgnoreCase(month)){
                totalBooking+=hotel.getNoOfRoomsBooked();
            }
        }
        if(totalBooking>0){
            return totalBooking;
        }
        return 0;
    }

    public static Hotel[] searchHotelByWifiOption(Hotel[]hotels,String wifiOption){
        List<Hotel> searchHotel=new ArrayList<>();
        for(Hotel hotel:hotels){
            if(hotel.getWifiFacility().equalsIgnoreCase(wifiOption)){
                searchHotel.add(hotel);
            }
        }
        if(searchHotel.size()<2){
            return null;
        }

        searchHotel.sort((h1,h2)->Double.compare(h2.getBill(), h1.getBill()));
       return searchHotel.toArray(new Hotel[1]);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Hotel [] hotel=new Hotel[4];
        for(int i=0;i<4;i++){
            int id=Integer.parseInt(sc.nextLine());
            String name=sc.nextLine();
            String joining=sc.nextLine();
            int rooms=Integer.parseInt(sc.nextLine());
            double bill=Double.parseDouble(sc.nextLine());
            String wifi=sc.nextLine();
            hotel[i]=new Hotel(id, name, joining, rooms, bill, wifi);

        }
        String month=sc.nextLine();
        String wifiOption=sc.nextLine();

        int roomsBooked=noOfRoomsBooked(hotel, month);
        if(roomsBooked>0){
            System.out.println(roomsBooked);
        }else{
            System.out.println("no rooms booked");
        }

        Hotel[] searchHotel=searchHotelByWifiOption(hotel,wifiOption);
        if(searchHotel!=null){
            for(Hotel h:searchHotel){
                System.out.println(h.getHotelId());
            }
        }else{
            System.out.println("no such hotel");
        }
    }
}

