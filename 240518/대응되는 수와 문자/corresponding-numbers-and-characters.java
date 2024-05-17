import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String temp = sc.next();
            map1.put(temp, i);
            map2.put(i, temp);
        }

        for (int i = 0; i < m; i++) {
            String temp = sc.next();
            if (map1.containsKey(temp)) {
                System.out.println(map1.get(temp));
            } else {
                try {
                    int num = Integer.parseInt(temp);
                    System.out.println(map2.get(num));
                } catch (NumberFormatException e) {
                    System.out.println(map2.get(Integer.parseInt(temp)));
                }
            }
        }
    }
}