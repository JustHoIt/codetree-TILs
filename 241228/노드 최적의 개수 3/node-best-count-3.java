import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int MAX_N = 100000;
    public static int n;
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] parent = new int[MAX_N + 1];
    public static long[][][] dp = new long[MAX_N + 1][2][2];
    
    public static void dfs(int x) {
        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);
            if(!visited[y]) {
                visited[y] = true;
                parent[y] = x;
                dfs(y);
            }
        }

        dp[x][0][0] = 0;
        dp[x][1][0] = 0;
        dp[x][1][1] = 1;
    
        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);
    
            if(parent[y] != x) {
                continue;
            }    
            dp[x][0][0] += dp[y][1][0];
            dp[x][1][0] += Math.min(dp[y][1][1], dp[y][1][0]);
            dp[x][1][1] += Math.min(Math.min(dp[y][0][0], dp[y][1][0]), dp[y][1][1]);
        }
    
        if(dp[x][1][0] == 0) {
            dp[x][1][0] = (int)1e9;
        } else {
            long best = (int)1e9;
            for(int i = 0; i < edges[x].size(); i++) {
                int y = edges[x].get(i);
    
                if(parent[y] != x) {
                    continue;
                }
    
                best = Math.min(best, dp[x][1][0] - Math.min(dp[y][1][1], dp[y][1][0]) + dp[y][1][1]);
            }
    
            dp[x][1][0] = best;
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            edges[x].add(y);
            edges[y].add(x);
        }

        visited[1] = true;
        dfs(1);

        System.out.print(Math.min(dp[1][1][0], dp[1][1][1]));
    }
}