import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 300;
    public static int n;
    public static int[][] graph = new int[MAX_N + 1][MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] dist = new int[MAX_N + 1];

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

         for(int i = 1; i <= n; i++) {
            graph[0][i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        
        for(int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
        }

        dist[0] = 0;

        int ans = 0;
        for(int i = 0; i <= n; i++) {
            int minIndex = -1;

            for(int j = 0; j <= n; j++) {
                if(visited[j]) {
                    continue;
                }
                
                if(minIndex == -1 || dist[minIndex] > dist[j]) {
                    minIndex = j;
                }
            }

            visited[minIndex] = true;
            ans += dist[minIndex];

            for(int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], graph[minIndex][j]);
            }
        }

        System.out.print(ans);
    }
}
