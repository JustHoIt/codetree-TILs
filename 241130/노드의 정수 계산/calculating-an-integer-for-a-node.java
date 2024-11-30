import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int MAX_N = 100000;
    public static int n;
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];
    public static int[] arr = new int[MAX_N + 1];
    public static int[] dp = new int[MAX_N + 1];
    public static void dfs(int x) {
        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);
            dfs(y);
        }
    
        dp[x] = arr[x]; 
        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);
            if(dp[y] > 0) {
                dp[x] += dp[y];
            }
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for(int i = 2; i <= n; i++) {
            int t = sc.nextInt();
            int a = sc.nextInt();
            int p = sc.nextInt();
            edges[p].add(i);

            arr[i] = (t == 1) ? a : -a;
        }

        dfs(1);
        System.out.print(dp[1]);
    }
}