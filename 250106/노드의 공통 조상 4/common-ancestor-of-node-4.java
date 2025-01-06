import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int MAX_N = 100000;
    public static int n, q;
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] parent = new int[MAX_N + 1];
    public static int[] depth = new int[MAX_N + 1];
    public static void dfs(int x) {
        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);
    
            if(visited[y]) {
                continue;
            }
    
            visited[y] = true;
            depth[y] = depth[x] + 1;
            parent[y] = x;
            dfs(y);
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 입력해주세요.
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
        depth[1] = 1;
        dfs(1);
        q = sc.nextInt();
        while(q-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            while(depth[a] != depth[b]) {
                if(depth[a] > depth[b]) {
                    a = parent[a];
                } else {
                    b = parent[b];
                }
            }

            while(a != b) {
                a = parent[a];
                b = parent[b];
            }

            System.out.println(a);
        }
    }
}