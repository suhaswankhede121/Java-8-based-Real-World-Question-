
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {

    static char firstNonRepeated(String s){
        LinkedHashMap<Character,Integer> hm=new LinkedHashMap<Character,Integer>();
        for(char ch:s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch, 0)+1);
        }
        for(Map.Entry<Character,Integer> e:hm.entrySet()){
            if(e.getValue()==1) return e.getKey();
        }
        return '0';
    }
    public static void main(String[] args) {
        System.out.println(firstNonRepeated("minimum"));
    }
}
