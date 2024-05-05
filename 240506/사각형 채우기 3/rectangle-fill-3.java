import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        long [] dp =  new long[1001];
        long [] dph = new long[1001];

        dp[1] = 2;
        dp[2] = 7;
        dph[1] = 1;
        dph[2] = 3;

        for(int i = 3; i < n; i++){
            dp[i] = (dp[i - 1] * 2 + dp[i - 2] + dph[i - 1] * 2) % 1000000007;
            dph[i] = (dp[i - 1] + dph[i - 1]) % 1000000007;
        }

        System.out.println(dp[n]);
    }
}