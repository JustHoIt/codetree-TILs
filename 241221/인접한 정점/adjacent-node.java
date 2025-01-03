import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int MAX_N = 10000;
    public static int n;
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] a = new int[MAX_N + 1];
    public static int[][] dp = new int[MAX_N + 1][2];
    public static void dfs(int x) {
        dp[x][1] = a[x];
        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);
    
            if(visited[y]) {
                continue;
            }
    
            visited[y] = true;
            dfs(y);
    
            dp[x][1] += dp[y][0];
            dp[x][0] += Math.max(dp[y][0], dp[y][1]);
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

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

        System.out.print(Math.max(dp[1][0], dp[1][1]));
    }
}