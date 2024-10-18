

public class SmallVovel {

    static char smallestVowel(String str){
        char ans='a';
        for(char ch:str.toCharArray()){
            char ch1=Character.toLowerCase(ch);
            if(ch1=='a' || ch1=='e' || ch1=='i' || ch1=='o' || ch1=='u' ){
                if(ch1<ans){
                    ans=ch1;
                }
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        System.out.println(smallestVowel("Matrix"));
    }
}
