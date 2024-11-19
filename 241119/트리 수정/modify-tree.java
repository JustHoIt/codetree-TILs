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
    public static final int MAX_N = 2000;
    public static int n;
    public static ArrayList<Pair>[] edge = new ArrayList[MAX_N];
    public static boolean[][] removed = new boolean[MAX_N][MAX_N];
    public static int[] edgeX = new int[MAX_N];
    public static int[] edgeY = new int[MAX_N];
    public static int[] edgeDist = new int[MAX_N];
    public static boolean[] visited = new boolean[MAX_N];
    public static int[] dist = new int[MAX_N];
    public static int maxDist, lastNode;
    public static int ans;

    public static void dfs(int x) {
        for(int i = 0; i < edge[x].size(); i++) {
            int y = edge[x].get(i).y;
            int d = edge[x].get(i).d;
            
            if(removed[x][y]) {
                continue;
            }

            if(visited[y]) {
                continue;
            }
    
            visited[y] = true;
            dist[y] = dist[x] + d;
    
            if(dist[y] > maxDist) {
                maxDist = dist[y];
                lastNode = y;
            }
    
            dfs(y);
        }
    }
    
    public static int getTreeDiameter(int x) {
        for(int i = 0; i < n; i++) visited[i] = false;
        for(int i = 0; i < n; i++) dist[i] = 0;
        maxDist = 0;
        lastNode = x;
        visited[x] = true;
        dfs(x);
    
        for(int i = 0; i < n; i++) visited[i] = false;
        for(int i = 0; i < n; i++) dist[i] = 0;
        maxDist = 0;

        visited[lastNode] = true;   
        dfs(lastNode);
    
        return maxDist;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            edge[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();

            edgeX[i] = x;
            edgeY[i] = y;
            edgeDist[i] = d;
            edge[x].add(new Pair(y, d));
            edge[y].add(new Pair(x, d));
        }

        for(int i = 0; i < n - 1; i++) {
            removed[edgeX[i]][edgeY[i]] = true;
            removed[edgeY[i]][edgeX[i]] = true;

            int maxDiameter = edgeDist[i] + getTreeDiameter(edgeX[i]) + getTreeDiameter(edgeY[i]);
            ans = Math.max(ans, maxDiameter);

            removed[edgeX[i]][edgeY[i]] = false;
            removed[edgeY[i]][edgeX[i]] = false;
        }

        System.out.print(ans);
    }
}