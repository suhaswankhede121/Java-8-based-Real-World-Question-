import java.util.LinkedHashSet;

public class RemoveDublicates {
    static String removeDublicateChar(String s){
        String ans="";
        StringBuilder sb=new StringBuilder();
        LinkedHashSet<Character> set=new LinkedHashSet<>();
        for(char c:s.toCharArray()){
            if(c==' ' ||set.add(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeDublicateChar("Hello Hey guys"));
    }
}
