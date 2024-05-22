import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        int k = sc.nextInt();

        int [] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> sorted = new ArrayList<>(map.keySet());
        sorted.sort((a, b) -> {
            int diff = map.get(b) - map.get(a);
            return diff != 0 ? diff : b - a;
        });
        
        for (int i = 0; i < k; i++) {
            System.out.print(sorted.get(i) + " ");
        }
    }
}