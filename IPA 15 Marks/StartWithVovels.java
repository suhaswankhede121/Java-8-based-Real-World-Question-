public class StartWithVovels {
    public static int countStart(String s){
        int count=0;
        String arr[]=s.split(" ");
        for(String value:arr){
            char ch=value.charAt(0);
            if((ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') || (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='i') ){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countStart("Arijit is student of MCA"));
    }
}
