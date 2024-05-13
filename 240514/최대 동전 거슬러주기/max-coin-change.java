import java.util.Scanner;
public class Main {
    static int INT_MIN = Integer.MIN_VALUE;
    static int n, m;
    static int [] dp;
    static int [] coins;

    public static void initialize(){
        for(int i = 0; i<= m; i++){
            dp[i] = INT_MIN;
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

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i >= coins[j]){
                    if(dp[i - coins[j]] != INT_MIN){    
                        dp[i] = Math.max(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
        }

        if(dp[m] == INT_MIN){
            System.out.println(-1);
        }else{
            System.out.println(dp[m]);
        }
    }
}