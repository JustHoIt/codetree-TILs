import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] arr = new int[n];
        int [] dp = new int[n];


        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(j + arr[j] >= i && dp[j] != Integer.MIN_VALUE){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(dp[n - 1]);
    }
}