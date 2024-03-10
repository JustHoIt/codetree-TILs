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
        String s = "";
        int cnt = 0;
        while (true) {
            int diff1 = arr.get(1) - arr.get(0);
            int diff2 = arr.get(2) - arr.get(1);
            if (diff1 == 1 && diff2 == 1) {
                break;
            }

            if (diff1 == 2 || diff2 == 2) {
                cnt++;
                break;
            }

            if (diff1 > diff2) {
                int tmp = arr.get(1);
                arr.set(1, arr.get(1) + 2);
                arr.set(0, tmp);
                cnt++;
            } else {
                int tmp = arr.get(1);
                arr.set(1, tmp - 1);
                arr.set(2, tmp);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}