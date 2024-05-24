import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        TreeMap<Integer, Integer> m= new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            int a = sc.nextInt();
            if(!m.containsKey(a)){
                m.put(a, i);
            }
        }

        for(Integer i : m.keySet()){ 
            System.out.println(i + " " + m.get(i));
        }
    }
}