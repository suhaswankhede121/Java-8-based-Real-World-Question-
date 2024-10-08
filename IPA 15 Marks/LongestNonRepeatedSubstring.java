import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestNonRepeatedSubstring {

    static String nonRepeatedSubString(String str){
        Set<Character> set=new HashSet<>();
        String ans="";
        char ch[]=str.toCharArray();
        for(char c:ch){
            if(!set.contains(c)){
                set.add(c);
                ans+=c;
            }
            else{
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(nonRepeatedSubString("suhas"));
    }
}
