public class RepeatedSum {

    static int repeatedSum(int no){
        int sum=0;
        while(true){
            while(no>0){
                int r=no%10;
                 no/=10;
                sum+=r;
            }
            if(sum>9){
                no=sum;
                sum=0;
            }else{
                return sum;
            }
        }

    }
    public static void main(String[] args) {
        System.out.println(repeatedSum(159));
    }
}
