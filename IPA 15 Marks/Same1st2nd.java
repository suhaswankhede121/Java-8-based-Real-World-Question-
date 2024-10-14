

public class Same1st2nd {

    static int getSameFirstSecond(String s){
        int count=0;
        String arr[]=s.split(" ");
        for(int i=0;i<arr.length;i++){
            char ch1=arr[i].charAt(0);
            char ch2=arr[i].charAt(arr[i].length()-1);
            if(Character.toLowerCase(ch1)==Character.toLowerCase(ch2)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(getSameFirstSecond("Anna asked about the Ginseng recipe"));
    }
}
