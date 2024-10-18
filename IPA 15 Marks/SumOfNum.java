import java.util.ArrayList;

public class SumOfNum {

    //Input : 123Arijit1998Arijit10
    static int sumOfNums(String s){
        //String arr[]=s.split(" ");
        int sum=0;
       // boolean flag=false;
        String temp="";
       // ArrayList<String> list=new ArrayList<>();
       int i=0;
        while(i<s.length()){
          // int j=i;
           while (i<s.length() && Character.isDigit(s.charAt(i))) {
              temp+=s.charAt(i);
              //j++;
              i++;
           }
           if(!temp.equals("")){    

            sum+=Integer.parseInt(temp);
           temp="";   
          } 
           i++;
        }

        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sumOfNums("123Arijit1998Arijit10"));
    }
}

