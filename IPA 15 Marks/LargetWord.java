import java.util.HashMap;
import java.util.Map;

public class LargetWord {
    static String largestWord(String s){
        HashMap<String,Integer> hm=new HashMap<>();
        String arr[]=s.split(" ");
        for(String str:arr){
            hm.put(str,str.length());
        }
        int max=Integer.MIN_VALUE;
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<String,Integer> entry:hm.entrySet()){
            if(entry.getValue()>max){
                max=entry.getValue();
            }
        }
        for(Map.Entry<String,Integer> entry:hm.entrySet()){
            if(entry.getValue()==max){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(largestWord("hey hello you are having any trouble"));
    }
}
