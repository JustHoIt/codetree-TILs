import java.util.Scanner;

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_N = 300;
    public static int n;
    public static int[][] arr = new int[MAX_N + 1][MAX_N + 1];
    public static int[][] prefixSum = new int[MAX_N + 1][MAX_N + 1];
    public static int[] dp = new int[MAX_N + 1];
    
    public static int getSum(int x1, int y1, int x2, int y2) {
        return prefixSum[x2][y2]     - prefixSum[x1 - 1][y2] -
               prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
    }

    public static int getMaxArea(int x1, int x2) {
        for(int y = 1; y <= n; y++) {
            int value = getSum(x1, y, x2, y);
            dp[y] = Math.max(value, dp[y - 1] + value);
        }

        int maxArea = INT_MIN;

        for(int y = 1; y <= n; y++){
            maxArea = Math.max(maxArea, dp[y]);
        }
        
        return maxArea;
    }

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        prefixSum[0][0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                prefixSum[i][j] = prefixSum[i - 1][j] + 
                                   prefixSum[i][j - 1] -
                                   prefixSum[i - 1][j - 1] +
                                   arr[i][j];
            }
        }
        
        int ans = INT_MIN;
        for(int i = 1; i <= n; i++){
            for(int j = i; j <= n; j++){
                ans = Math.max(ans, getMaxArea(i, j));
            }
        }
        
        System.out.print(ans);
    }
}