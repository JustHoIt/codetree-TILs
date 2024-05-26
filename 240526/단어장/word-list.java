import java.util.Scanner;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        TreeMap<String, Integer> map = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            String str = sc.next();
            if(map.containsKey(str)){
                map.put(str, map.getOrDefault(str, 0) + 1);
            }else{
                map.put(str, 1);
            }
            
        }

        Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Entry<String, Integer> entry = it.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}