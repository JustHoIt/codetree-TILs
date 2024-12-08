import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int MAX_N = 100000;
    public static int n, m;
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];
    public static int[] dp = new int[MAX_N + 1];

    public static void dfs(int x) {
        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);
            dp[y] += dp[x];
    
            dfs(y);
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            int y = i;

            if(x == -1) {
                continue;
            }
            edges[x].add(y);
        }
        for(int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            dp[x] += y;
        }

        dfs(1);

        for(int i = 1; i <= n; i++) { 
            System.out.print(dp[i] + " ");
        }
    }
}