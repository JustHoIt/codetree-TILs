import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][3];
        int[] pCups = new int[3];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            a[i][2] = sc.nextInt();
        }

        int maxCnt = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            Arrays.fill(pCups, 0);
            int cnt = 0;
            pCups[i] = 1;
            for (int j = 0; j < n; j++) {
                int tmp = 0;
                tmp = pCups[a[j][0] - 1];
                pCups[a[j][0] - 1] = pCups[a[j][1] - 1];
                pCups[a[j][1] - 1] = tmp;

                if (pCups[a[j][2] - 1] == 1) {
                    cnt++;
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
        System.out.println(maxCnt);
    }
}