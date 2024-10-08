public class FindFirstLetter {
    public static String findFirstChar(String s){
        String ans="";
        String arr[]=s.split(" ");
        for(String a:arr){
            ans+=a.charAt(0);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(findFirstChar("Kalyani Govt. Eng. College"));
    }
}
