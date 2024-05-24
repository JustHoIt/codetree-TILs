import java.util.Scanner;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> m = new TreeMap<>();

        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            String str = sc.next();
            m.merge(str, 1, Integer::sum);
        }

        int cnt = m.values().stream().mapToInt(Integer::intValue).sum();

        for (Entry<String, Integer> entry : m.entrySet()) {
            double ratio = (double) entry.getValue() / cnt * 100;
            System.out.printf("%s %.4f%n", entry.getKey(), ratio);
        }
    }
}