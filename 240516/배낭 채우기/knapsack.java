import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] weights = new int[n + 1];
        int [] values = new int[n + 1];

        int [][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++){
            for(int w = 1; w<= m; w++){
                if(weights[i] <= w){
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i]] + values[i]);
                }else{
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}