import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 1000;
    public static int n, m;
    public static int a, b;
    public static int[][] graph = new int[MAX_N + 1][MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    
    public static int[] dist = new int[MAX_N + 1];

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        while(m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
			if(graph[x][y] == 0) {
				graph[x][y] = z;
				graph[y][x] = z;
			} else {
				graph[x][y] = Math.min(graph[x][y], z);
				graph[y][x] = Math.min(graph[y][x], z);
			}
        }

        a = sc.nextInt();
        b = sc.nextInt();

        for(int i = 1; i <= n; i++){
            dist[i] = (int)1e9;
        }

        dist[a] = 0;

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

        System.out.print(dist[b]);
    }
}