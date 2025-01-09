import java.util.Scanner;
import java.util.ArrayList;

class Pair {
    int y, d;

    public Pair(int y, int d) {
        this.y = y;
        this.d = d;
    }
}

public class Main {
    public static final int MAX_H = 17;
    public static final int MAX_N = 100000;
    public static int n, q;
    public static ArrayList<Pair>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] depth = new int[MAX_N + 1];
    public static int[] distFromRoot = new int[MAX_N + 1];public static int[][] parent = new int[MAX_H + 1][MAX_N + 1]; 
    public static void dfs(int x) {
        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i).y;
            int d = edges[x].get(i).d;
    
            if(!visited[y]) {
                visited[y] = true;
                depth[y] = depth[x] + 1;
                distFromRoot[y] = distFromRoot[x] + d;
                parent[0][y] = x;
    
                dfs(y);
            }
        }
    }

    public static int getDist(int a, int b) {
        if(depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int a_save = a;
        int b_save = b;
        
        for(int h = MAX_H; h >= 0; h--) {
            if(depth[a] - depth[b] >= (1 << h)) {
                a = parent[h][a];
            }
        }

        if(a == b) {
            int lca = a;
            return distFromRoot[a_save] + distFromRoot[b_save] - 2 * distFromRoot[lca];
        }
    
        for(int h = MAX_H; h >= 0; h--) {
            if(parent[h][a] != parent[h][b]) {
                a = parent[h][a];
                b = parent[h][b];
            }
        }
    
        int lca = parent[0][a];

        return distFromRoot[a_save] + distFromRoot[b_save] - 2 * distFromRoot[lca];
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();

            edges[x].add(new Pair(y, d));
            edges[y].add(new Pair(x, d));
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
            
            System.out.println(getDist(a, b));
        }
    }
}