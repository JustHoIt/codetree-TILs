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
    public static final int MAX_N = 100000;
    public static int n;
    public static ArrayList<Pair>[] edge = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] dist = new int[MAX_N + 1];
    public static int maxDist;
    public static int lastNode;
    public static int a, b;
    public static int ans;
    
    public static void dfs(int x, int ignoreNum) {
        for(int i = 0; i < edge[x].size(); i++) {
            int y = edge[x].get(i).y;
            int d = edge[x].get(i).d;
    
            if(visited[y]) {
                continue;
            }
    
            visited[y] = true;
            dist[y] = dist[x] + d;
    
            if(dist[y] > maxDist && y != ignoreNum) {
                maxDist = dist[y];
                lastNode = y;
            }
    
            dfs(y, ignoreNum);
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            edge[i] = new ArrayList<>();
        }
        
        for(int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();

            edge[x].add(new Pair(y, d));
            edge[y].add(new Pair(x, d));
        }

        visited[1] = true;
        dfs(1, -1);
        a = lastNode;

        for(int i = 1; i <= n; i++) {
            visited[i] = false;
            dist[i] = 0;
        }
        maxDist = -1;
        visited[a] = true;
        dfs(a, -1);
        b = lastNode;

        for(int i = 1; i <= n; i++) {
            visited[i] = false;
            dist[i] = 0;
        }
        maxDist = -1;
        visited[a] = true;
        dfs(a, b);
        ans = Math.max(ans, maxDist);

        for(int i = 1; i <= n; i++) {
            visited[i] = false;
            dist[i] = 0;
        }
        maxDist = -1;
        visited[b] = true;
        dfs(b, a);
        ans = Math.max(ans, maxDist);

        System.out.print(ans);
    }
}