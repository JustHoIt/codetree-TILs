import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int MAX_K = 10;
    public static final int MAX_N = 100000;
    public static int n, k;
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] a = new int[MAX_N + 1];
    public static int[][][] dp = new int[MAX_N + 1][MAX_K + 1][2];
    public static int ans;
    public static void dfs(int x) {
        int leftNum = 0;
        int rightNum = 0;

        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);
    
            if(visited[y]) {
                continue;
            }
    
            visited[y] = true;
            dfs(y);
    
            if(leftNum == 0) {
                leftNum = y;
            } else {
                rightNum = y;
            }
        }
    
        dp[x][1][1] = a[x];
        dp[x][0][0] = 0;
        if(leftNum != 0 && rightNum != 0) {
            for(int i = 1; i <= k; i++) {
                for(int j = 0; j < i; j++) {
                    dp[x][i][1] = Math.max(dp[x][i][1], dp[leftNum][j][0] + dp[rightNum][i - j - 1][0] + a[x]);
                }
            }
    
            for(int i = 0; i <= k; i++) {
                for(int j = 0; j <= i; j++) {
                    dp[x][i][0] = Math.max(dp[x][i][0], 
                                      Math.max(dp[leftNum][j][0], dp[leftNum][j][1]) + 
                                      Math.max(dp[rightNum][i - j][0], dp[rightNum][i - j][1])
                                  );
                }
            }
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            edges[i] = new ArrayList<>();
        }
        for(int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            edges[x].add(y);
            edges[y].add(x);
        }

        for(int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        k = sc.nextInt();
        visited[1] = true;
        dfs(1);

        for(int i = 1; i <= k; i++) {
            ans = Math.max(ans, dp[1][i][0]);
            ans = Math.max(ans, dp[1][i][1]);
        }

        System.out.print(ans);
    }
}