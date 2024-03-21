import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static int n, m;
    public static int[] coins;
    public static int[] dp;

    public static void initialize() {
        for (int i = 1; i <= m; i++) {
            dp[i] = INT_MAX;
        }
        dp[0] = 0;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //동전 종류
        m = sc.nextInt(); //금액
        coins = new int[n + 1];
        dp = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            coins[i] = sc.nextInt();
        }
        initialize();

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= coins[j]) {
                    if (dp[i - coins[j]] == INT_MAX) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        int ans = dp[m];

        if (ans == INT_MAX) {
            ans = -1;
        }

        System.out.println(ans);
    }
}