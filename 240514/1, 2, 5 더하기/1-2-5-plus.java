import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int [] dp = new int[n + 1];
        dp[0] = 1;

        for(int i = 1; i <= n; i++){
            dp[i] = (dp[i] + ((i - 1 >= 0) ? dp[i - 1] : 0) + ((i - 2 >= 0) ? dp[i - 2] : 0) + ((i - 5 >= 0) ? dp[i - 5] : 0)) % 10007;
        }
        System.out.println(dp[n]);
    }
}