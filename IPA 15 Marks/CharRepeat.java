import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class CharRepeat {
    static String charRepeat(String s){
        String ans="";
        HashMap<Character,Integer> hm=new HashMap<>();
        LinkedHashSet<Character> set=new LinkedHashSet<>();
        for(char ch:s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            set.add(ch);
        }
        int i=0;
        for(Map.Entry<Character,Integer> e:hm.entrySet()){
            if(set.contains(e.getKey())){
                ans+=e.getKey();
                ans+=e.getValue();
            }
        }
        return ans;
    }
     public static void main(String[] args) {
        System.out.println(charRepeat("abbccc "));
    }
}
