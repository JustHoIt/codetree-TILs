import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        System.out.println(minTime(X));
    }

    static int minTime(int X) {
        int[] dp = new int[X+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= X; i++) {
            for (int j = 1; j*j <= i; j++) {
                if (i - j*j >= j) {
                    dp[i] = Math.min(dp[i], dp[i-j*j] + j*2);
                } else {
                    dp[i] = Math.min(dp[i], dp[i-j*j] + j*2 -1);
                }
            }
        }
        return dp[X];
    }
}