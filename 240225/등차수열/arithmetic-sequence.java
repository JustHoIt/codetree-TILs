import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arithmetic = new int[n];


        for (int i = 0; i < n; i++) {
            arithmetic[i] = sc.nextInt();
        }
        Arrays.sort(arithmetic);

        int maxCnt = Integer.MIN_VALUE;
        for (int k = 1; k <= arithmetic[arithmetic.length - 1]; k++) {
            int cnt = 0;
            for (int i = 0; i < n; i++) { // a의 값
                for (int j = i + 1; j < n; j++) { // b의 값

                    if (arithmetic[i] < k && k < arithmetic[j]) {
                        int a = k - arithmetic[i];
                        int b = arithmetic[j] - k;

                        if (a == b) {
                            cnt++;
                        }
                    }
                }
                maxCnt = Math.max(cnt, maxCnt);
            }
        }
        System.out.println(maxCnt);
    }
}