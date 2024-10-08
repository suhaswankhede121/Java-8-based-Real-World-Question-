public class LastLetter {
    static String lastLetter(String s){
        String arr[]=s.split(" ");
        String ans="";
        for(int i=0;i<arr.length;i++){
            char ch=arr[i].charAt(arr[i].length()-1);
            ans+=ch;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(lastLetter("Hello How Are You"));
    }
}
