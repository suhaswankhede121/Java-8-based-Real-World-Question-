import java.util.Scanner;

public class FactEach {


    static int fact(int no){
        if(no<=1) return 1;
        return no*fact(no-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       int arr[]=new int[5];
       for(int i=0;i<5;i++){
        arr[i]=sc.nextInt();
       }

       for(int i=0;i<5;i++){
        System.out.println(fact(arr[i]));
       }
       
    }
}
