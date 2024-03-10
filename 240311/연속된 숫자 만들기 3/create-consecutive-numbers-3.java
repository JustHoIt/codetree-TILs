import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            arr.add(sc.nextInt());
        }
        int cnt = 0;
        int diff1 = arr.get(1) - arr.get(0);
        int diff2 = arr.get(2) - arr.get(1);
        int max = Math.max(diff1, diff2);
        cnt = max - arr.get(0);

        System.out.println(cnt);
    }
}