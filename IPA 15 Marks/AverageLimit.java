public class AverageLimit {
    static int avgLimit(int n, int arr[],int l1,int l2){
        int avg=0;
        int sum=0;
        int count=0;
        for(int i=l1;i<l2-1;i++){
            sum+=arr[i];
            count++;
        }
        return sum/count;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        System.out.println(avgLimit(5, arr, 0, 3));
    }
}
