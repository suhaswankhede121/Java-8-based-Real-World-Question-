import java.util.HashSet;
import java.util.Set;

public class RemoveDublicate {

    static String removeDublicates(String s){
        Set<Character> set=new HashSet<>();
        String ans="";
        // for(char ch:s.toCharArray()){
        //     set.add(ch);
        // }
        for(char ch:s.toCharArray()){
            if(set.add(ch) || ch==' ') ans+=ch;
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(removeDublicates("Arijit Ghosh"));
    }
}
