public class CountNoDigit {
    public static void main(String[] args) {
        int no=1459;
        int count=0;
        //way 1:
        while(no>0){
            int re=no%10;
            no/=10;
            if(re % 2==0) count++;

        }
        if(count>2) {
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }
    }
}
