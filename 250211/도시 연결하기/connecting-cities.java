import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int DIR_NUM = 4;
    public static final int MAX_G = 2500;
    public static final int MAX_N = 50;
    public static int n, m;
    public static int[][] grid = new int[MAX_N + 1][MAX_N + 1];
    public static int[][] renum = new int[MAX_N + 1][MAX_N + 1];
    public static int N; 
    public static int[][] graph = new int[MAX_G + 1][MAX_G + 1];
    public static boolean[] visited = new boolean[MAX_G + 1];
    public static int[] dist = new int[MAX_G + 1];
    
    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= m;
    }
    
    public static void makeGraph() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(grid[i][j] == 1) {
                    renum[i][j] = ++N;
                }
            }
        }
    
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                graph[i][j] = (int)1e9;
            }
        }
    
        int[] dx = new int[]{-1, 1,  0, 0};
        int[] dy = new int[]{ 0, 0, -1, 1};
    
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(grid[i][j] == 1) {
                    for(int k = 0; k < DIR_NUM; k++) {
                        int dist = 1;
                        while(true) {
                            int nx = i + dx[k] * dist, ny = j + dy[k] * dist;
                            if(!inRange(nx, ny)) {
                                break;
                            }
                            
                            if(grid[nx][ny] == 1) {
                                graph[renum[i][j]][renum[nx][ny]] = dist - 1; 
                                break;
                            }
                            dist++;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        makeGraph();

        for(int i = 1; i <= N; i++) {
            dist[i] = (int)1e9;
        }

        dist[1] = 0;

        int ans = 0;
        for(int i = 1; i <= N; i++) {
            int minIndex = -1;
            for(int j = 1; j <= N; j++) {
                if(visited[j]) {
                    continue;
                }
                
                if(minIndex == -1 || dist[minIndex] > dist[j]) {
                    minIndex = j;
                }
            }

            if(dist[minIndex] == (int)1e9) {
                ans = -1;
                break;
            }

            visited[minIndex] = true;

            ans += dist[minIndex];

            for(int j = 1; j <= N; j++) {
                dist[j] = Math.min(dist[j], graph[minIndex][j]);
            }
        }

        System.out.print(ans);
    }
}