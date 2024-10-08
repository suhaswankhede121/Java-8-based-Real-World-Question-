public class AsciiValueChar {

    public static char HighestAsciiChar(String s){
        char max=s.charAt(0);
        for(char ch:s.toCharArray()){
            if(ch>max){
                max=ch;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(HighestAsciiChar("priyanka"));
    }
}
