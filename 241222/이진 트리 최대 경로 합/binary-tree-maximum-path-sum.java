import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int MAX_N = 30000;
    public static int n;
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] a = new int[MAX_N + 1];
    public static int[] dp = new int[MAX_N + 1];
    public static int[] maxLength = new int[MAX_N + 1];
    public static int ans;
    public static void dfs(int x) {
        ArrayList<Integer> children = new ArrayList<>();
    
        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);
    
            if(visited[y]) {
                continue;
            }
    
            visited[y] = true;
            dfs(y);
            children.add(y);
        }
        int left = children.size() > 0 ? children.get(0) : 0;
        int right = children.size() > 1 ? children.get(1) : 0;
        dp[x] = a[x] + Math.max(0, Math.max(dp[left], dp[right]));
        maxLength[x] = a[x] + Math.max(0, dp[left]) + Math.max(0, dp[right]);
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
.
        for(int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        visited[1] = true;
        dfs(1);

        for(int i = 1; i <= n; i++) {
            ans = Math.max(ans, maxLength[i]);
        }

        System.out.print(ans);
    }
}