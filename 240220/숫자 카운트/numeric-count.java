import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> nums = new ArrayList<>();
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            nums.add(new int[]{a / 100, (a % 100) / 10, a % 10, c1, c2});
        }

        int cnt = 0;

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if (i == j || j == k || i == k) {
                        continue;  //같은 수는 들어 올 수 없음
                    }
                    boolean possible = true;

                    for (int[] n : nums) {
                        int cnt1 = 0, cnt2 = 0;
                        int[] m = {i, j, k};
                        for (int l = 0; l < 3; l++) {
                            for (int q = 0; q < 3; q++) {
                                if (n[l] == m[q]) {
                                    if (l == q) {
                                        cnt1++;
                                    } else {
                                        cnt2++;
                                    }
                                }
                            }
                        }

                        if (cnt1 != n[3] || cnt2 != n[4]) {
                            possible = false;
                        }
                    }
                    if (possible) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}