import java.util.HashSet;
import java.util.Set;

public class ConsecutiveToVowels {


    /*Count the number of words in a sentence that contain at least two consecutive vowels (a, e, i, o, u) in them.
Here's a sample input and output:

Input: I enjoy eating spaghetti and meatballs for dinner
Output: 2

Explanation: There are two words in the sentence that contain at least two consecutive vowels - "eating" and "meatballs".
 */
    static int concutiveVowel(String s){
        char vowel[]={'a','e','i','o','u'};
        String arr[]=s.split(" ");
        int value=0;
        Set<Character> set=new HashSet<>();
        for(char c:vowel){
            set.add(c);
        }
        for(int i=0;i<arr.length;i++){
            char ch[]=arr[i].toCharArray();
            boolean flag=false;
            if(ch.length>1){
            for(int j=1;j<ch.length;j++){
                if(set.contains(ch[j]) && set.contains(ch[j-1])){
                    flag=true;
                    break;
                }
            }
            if(flag){
                value+=1;
            }
        }
            
        }
        return value;
    }
    public static void main(String[] args) {
        System.out.println(concutiveVowel("I enjoy eating spaghetti and meatballs for dinner"));
    }
}
