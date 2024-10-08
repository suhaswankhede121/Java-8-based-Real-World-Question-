public class RepeatedNumbers {
    static String repeatedNo(String s){
        String ans="";
        char ch[]=s.toCharArray();
        for(int i=1;i<ch.length;i++){
            if(Character.isDigit(ch[i])){
                int value=ch[i]-'0';
                if(value>1){
                    while (value!=0) {
                        ans+=ch[i-1];
                        value--;
                    }
                }
            }else{
                ans+=ch[i];
                
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(repeatedNo("a2b3c1"));
    }
}
