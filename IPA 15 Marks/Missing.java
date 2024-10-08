import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Missing {
  public static void main(String[] args) {
    Set<Integer> set=new HashSet<>(Arrays.asList(1,2,4,8,9,11,12,14));
    for(int i=1;i<=14;i++){
        if(!set.contains(i)){
            System.out.print(i+" ");
        }
    }
  }
}
