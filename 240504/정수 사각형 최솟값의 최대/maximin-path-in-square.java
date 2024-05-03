import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr  = new int[n][n];
        int [][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = arr[0][0];

        for(int i = 1; i < n; i++){
            dp[0][i] = Math.min(dp[0][i - 1], arr[0][i]);
        }

        for(int i = 1; i < n; i++){
            dp[i][0] = Math.min(dp[i - 1][0], arr[i][0]);
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                int left = dp[i][j - 1];
                int up = dp[i - 1][j];
                dp[i][j] = Math.min(arr[i][j], Math.max(left, up));
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}