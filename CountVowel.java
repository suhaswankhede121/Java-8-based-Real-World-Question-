import java.util.Scanner;

public class CountVowel {
    public static void main(String[] args) {
        //Scanner sc=new Scanner(System.in);
        String str="Everyone should practice and learn to become professional";
        System.out.println(countVowelString(str));
    }

    private static int countVowelString(String str) {
        String arr[]=str.split(" ");
        int count=0;
        for(int i=0;i<arr.length;i++){
            //char ch[]=arr[i].toCharArray();
              char value =arr[i].charAt(0);
                if((value=='a' || value=='e' || value=='i' || value=='o' || value=='u') || (value=='A' || value=='E' || value=='I' || value=='O' || value=='U')){
                    count++;
                }
        }
        if(count>0){
            return count;
        }else{
            return -1;
        }
    }
}
