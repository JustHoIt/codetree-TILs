import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int INT_MAX = Integer.MAX_VALUE;
    static int n, m;
    static int [] dp;
    static int [] coins;
    public static void initialize(){
        Arrays.fill(dp, INT_MAX);
        dp[0] = 0;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        coins = new int[n];
        dp = new int[m + 1];

        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
        }
        initialize();

        for(int i = 1; i <= m; i++){
            for(int j = 0; j < n; j++){
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        if(dp[m] == INT_MAX){
            System.out.println(-1);
        }else{
            System.out.println(dp[m]);
        }

    }
}