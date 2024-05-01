import java.util.Scanner;

public class Main {
    static int[] dp = new int[1001];

    public static void main(String[] args){        
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        preprocess();
        
        System.out.println(dp[n]);
    }

    public static void preprocess() {
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 1;
        
        for (int i = 5; i < 1001; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
            dp[i] %= 10007;
        }
    }
}