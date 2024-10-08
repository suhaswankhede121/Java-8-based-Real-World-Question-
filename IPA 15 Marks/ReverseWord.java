public class ReverseWord {
    public static String reverseWord(String s){
        String arr[]=s.split(" ");
        String ans="";
        for(int i=arr.length-1;i>=0;i--){
            ans+=arr[i]+" ";
        }
        return ans;
    }
    public static String eachWord(String s){
        String arr[]=s.split(" ");
        String ans="";
        for(int i=0;i<arr.length;i++){
            char ch=arr[i].charAt(0);
            //char ch[]=arr[i].toCharArray();
            //char value=ch[0];
            ans+=ch;

        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(reverseWord("welcome to my java programming"));
        System.out.println(eachWord("Hello how are you"));
    }
}
