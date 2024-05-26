import java.util.Scanner;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n + 1];

        for(int i = 1; i <= n; i++){
            arr[i] = i;
        }

        Map<Integer, HashSet<Integer>> result = new TreeMap<>();
        for(int i = 1; i <= n; i++){
            HashSet<Integer> set = new HashSet<>();
            set.add(i);
            result.put(i, set);
        }

        int[][] commands = new int[k][2];
        for(int i = 0; i < k; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            commands[i][0] = a;
            commands[i][1] = b;
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < k; j++){
                int seatA = commands[j][0];
                int seatB = commands[j][1];

                int pA = arr[seatA];
                int pB = arr[seatB];

                result.get(pA).add(seatB);
                result.get(pB).add(seatA);

                arr[seatA] = pB;
                arr[seatB] = pA;
            }
        }

        for (Map.Entry<Integer, HashSet<Integer>> entry : result.entrySet()) {
            System.out.println(entry.getValue().size());
        }
    }
}