import java.util.Scanner;
public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static int n, m;
    public static int [] coins;
    public static int [] dp;
    public static void initialize() {
        for (int i = 1; i <= m; i++) {
            dp[i] = INT_MAX;
        }
        dp[0] = 0;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        coins = new int[n + 1];
        dp = new int[m + 1];
        for(int i = 1; i <= n; i++){
            coins[i] = sc.nextInt();
        }

        initialize();

        for(int i = 0 ; i < dp.length; i++){
            System.out.print(dp[i] + " ");
        }
        System.out.println();

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (j >= coins[i]) {
                    if (dp[j - coins[i]] == INT_MAX) {
                        continue;
                    }
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        for(int i = 0 ; i < dp.length; i++){
            System.out.print(dp[i] + " ");
        }
        System.out.println();


        int ans = dp[m];

        if(ans == INT_MAX){
            ans = -1;
        }
        System.out.println(ans);
    }
}