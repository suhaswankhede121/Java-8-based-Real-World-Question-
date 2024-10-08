public class StartWithCapital {
    static int startCapital(String s){
        int count=0;
        String arr[]=s.split(" ");
        for(String a:arr){
            char ch=a.charAt(0);
            if(Character.isUpperCase(ch)){
                count++;
                System.out.println(a);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(startCapital("The quick Brown Fox jumps over the lazy dog"));
    }
}
