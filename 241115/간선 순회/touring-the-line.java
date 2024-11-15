import java.util.Scanner;
import java.util.ArrayList;

class Pair {
    int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public boolean isGreaterThan(Pair p) {
        if(this.first != p.first) {
            return this.first > p.first;
        }
        return this.second >= p.second;
    }
}

public class Main {
    public static final int MAX_N = 50000;
    public static int n, d;
    public static ArrayList<Pair>[] edge = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] distNode = new int[MAX_N + 1];
    public static int[] dist = new int[MAX_N + 1];
    public static Pair maxDist = new Pair(0, 0);
    public static int lastNode;

    public static void dfs(int x) {
        for(int i = 0; i < edge[x].size(); i++) {
            int y = edge[x].get(i).first;
            int d = edge[x].get(i).second;
    
            if(visited[y]) continue;
    
            visited[y] = true;
            distNode[y] = distNode[x] + 1;
            dist[y] = dist[x] + d;
    
            Pair curDist = new Pair(distNode[y], -dist[y]);

            if(curDist.isGreaterThan(maxDist)) {
                maxDist = curDist;
                lastNode = y;
            }
    
            dfs(y);
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = sc.nextInt();

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
        dfs(1);

        for(int i = 1; i <= n; i++) {
            visited[i] = false;
            distNode[i] = 0;
            dist[i] = 0;
        }

        visited[lastNode] = true;
        dfs(lastNode);

        System.out.print(1 + (-maxDist.second - 1) / d);
    }
}