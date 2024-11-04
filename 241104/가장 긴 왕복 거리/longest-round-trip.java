import java.util.Scanner;

class Edge {
    int a, b, c;

    public Edge(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_M = 10000;
    public static final int MAX_N = 1000;
    public static int n, m, x;
    public static Edge[] edges = new Edge[MAX_M + 1];
    public static int[][] graph1 = new int[MAX_N + 1][MAX_N + 1];
    public static int[][] graph2 = new int[MAX_N + 1][MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    
    public static int[] dist1 = new int[MAX_N + 1];
    public static int[] dist2 = new int[MAX_N + 1];
    public static int ans;
    
    public static void dijkstra(int[] dist, int[][] graph) {
        for(int i = 1; i <= n; i++){
            dist[i] = (int)1e9;
        }
    
        for(int i = 1; i <= n; i++){
            visited[i] = false;
        }

        dist[x] = 0;

        for(int i = 1; i <= n; i++) {
            int minIndex = -1;
            for(int j = 1; j <= n; j++) {
                if(visited[j]){
                    continue;
                }
                
                if(minIndex == -1 || dist[minIndex] > dist[j]){
                    minIndex = j;
                }
            }
    
            visited[minIndex] = true;

            for(int j = 1; j <= n; j++) {
                if(graph[minIndex][j] == 0){
                    continue;
                }
    
                dist[j] = Math.min(dist[j], dist[minIndex] + graph[minIndex][j]);
            }
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해 주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();

        for(int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges[i] = new Edge(a, b, c);
        }

        for(int i = 1; i <= m; i++) {
            int a = edges[i].a;
            int b = edges[i].b;
            int c = edges[i].c;

            graph1[a][b] = c;
        }

        dijkstra(dist1, graph1);

        for(int i = 1; i <= m; i++) {
            int a = edges[i].a;
            int b = edges[i].b;
            int c = edges[i].c;

            graph2[b][a] = c;
        }

        dijkstra(dist2, graph2);

        for(int i = 1; i <= n; i++){
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }

        System.out.print(ans);
    }
}