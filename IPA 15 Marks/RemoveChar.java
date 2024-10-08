public class RemoveChar {
    static String removeChar(String s,char ch){
        String ans="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c!=ch) ans+=c;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(removeChar("hello", 'l'));
    }
}
