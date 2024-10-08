public class PalindromInString {

    static boolean isPalindrom(String s){
        StringBuilder sb=new StringBuilder(s);
        String temp=sb.reverse().toString();
        return temp.equals(s);
    }
    static int countPalindrom(String s){
        String arr[]=s.split(" ");
        int count=0;
        for(String str:arr){
            if(isPalindrom(str)){
                System.out.println(str);
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countPalindrom("My name is nitin and I can speak malayalam"));
    }
}
