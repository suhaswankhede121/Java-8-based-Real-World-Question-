public class PerfectNo {
    
    static boolean isPerfect(int no){
      int sum=0;
      for(int i=1;i<no;i++){
        if(no % i==0){
            sum+=i;
        }
      }
      return sum==no ? true:false;
    }
    public static void main(String[] args) {
        System.out.println(isPerfect(8));
    }
}
