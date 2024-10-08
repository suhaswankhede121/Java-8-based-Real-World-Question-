import java.util.Scanner;

public class LowerCaseCount {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isLowerCase(ch)){
                count++;
            }
        }
        if(count>0){
            System.out.println(count);
        }else{
            System.out.println("No lower case character");
        }
    }
}
