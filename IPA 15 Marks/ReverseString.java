public class ReverseString {

    static void reverse(char ch[],int i,int j){
        while(i<j){
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            i++;
            j--;
        }
    }
    static String reverseString(String s){
        String arr[]=s.split(" ");
        String ans="";
        for(int i=arr.length-1;i>=0;i--){
            char ch[]=arr[i].toCharArray();
            reverse(ch,0,ch.length-1);
            for(char c:ch){
                ans+=c;
            }
            ans+=" ";
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(reverseString("Hello How Are You"));
    }
}
