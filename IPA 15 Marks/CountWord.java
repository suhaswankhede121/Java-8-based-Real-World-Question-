import java.util.HashMap;
import java.util.Map;

public class CountWord {
    static int findCountWord(String s,String in){
        int count=0;
        HashMap<String,Integer> hm=new HashMap<>();
        String arr[]=s.split(" ");
        for(String str:arr){
            hm.put(str,hm.getOrDefault(str,0)+1);
        }
        System.out.println(hm);
        for(Map.Entry<String,Integer> e:hm.entrySet()){
            if(in.equalsIgnoreCase(e.getKey())){
                count=e.getValue();
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(findCountWord("Home sweet Home", "home"));
    }
}
