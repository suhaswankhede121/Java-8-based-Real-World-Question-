import java.util.LinkedHashSet;

public class RemoveConsicutive {
    static String removeConsecutive(String s){
        LinkedHashSet<Character> set=new LinkedHashSet<>();
        for(char c:s.toCharArray()){
            set.add(c);
        }
        String ans="";  
        // for(char c:set){
        //     ans+=c;
        // }
        char ch[]=s.toCharArray();
        ans+=ch[0];
        for(int i=1;i<ch.length;i++){
            if(ch[i]!=ch[i-1]){
                ans+=ch[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(removeConsecutive("abbcddeff"));
    }
}
