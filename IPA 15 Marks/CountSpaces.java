public class CountSpaces {
    static int countSpace(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==' ') count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countSpace(" welcome to my word  "));
    }
}
