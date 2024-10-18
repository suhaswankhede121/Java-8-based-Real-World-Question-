import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class GroupEmployee {
    public static void main(String[] args) {
        LinkedHashMap<String,List<String>> map=new LinkedHashMap<>();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            String name=sc.nextLine();
            String city=sc.nextLine();
            List<String> list=new ArrayList<>();
            list.add(city);
            map.put(name, list);
        }
        for(Entry<String, List<String>> entry:map.entrySet()){
            System.out.println(entry.getValue()+":"+entry.getKey());
        }
    }
}
