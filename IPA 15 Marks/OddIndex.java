public class OddIndex {
    public static String oddIndexChar(String s){
        String ans="";
        char ch[]=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(i%2!=0){
                ans+=ch[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(oddIndexChar("HelloWorld"));
    }
}
