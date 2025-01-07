import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int MAX_H = 16;
    public static final int MAX_N = 50000;
    public static int n, q;
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] depth = new int[MAX_N + 1];
    public static int[][] parent = new int[MAX_H + 1][MAX_N + 1]; 
    public static void dfs(int x) {
        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);
    
            if(!visited[y]) {
                visited[y] = true;
                depth[y] = depth[x] + 1;
                parent[0][y] = x;
    
                dfs(y);
            }
        }
    }
    public static int lca(int a, int b) {
        if(depth[a] < depth[b]) {
            return lca(b, a);
        }
    
        for(int h = MAX_H; h >= 0; h--) {
            if(depth[a] - depth[b] >= (1 << h)) {
                a = parent[h][a];
            }
        }
    
        if(a == b) {
            return a;
        }
    
        for(int h = MAX_H; h >= 0; h--) {
            if(parent[h][a] != parent[h][b]) {
                a = parent[h][a];
                b = parent[h][b];
            }
        }
    
        return parent[0][a];
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
        
        depth[1] = 1;
        visited[1] = true;
        dfs(1);

        for(int h = 1; h <= MAX_H; h++) {
            for(int i = 1; i <= n; i++) {
                parent[h][i] = parent[h - 1][parent[h - 1][i]];
            }
        }

        q = sc.nextInt();

        while(q-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            System.out.println(lca(lca(a, b), c));
        }
    }
}