import java.util.Scanner;

public class Main{
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int maxSafeZones = 0;
        int bestK = 1;
        for (int K = 1; K <= 100; K++) {
            visited = new boolean[N][M];
            int safeZones = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > K && !visited[i][j]) {
                        dfs(i, j, K);
                        safeZones++;
                    }
                }
            }
            if (safeZones > maxSafeZones) {
                maxSafeZones = safeZones;
                bestK = K;
            }
        }

        System.out.println(bestK + " " + maxSafeZones);
    }

    static void dfs(int x, int y, int K) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (map[nx][ny] > K && !visited[nx][ny]) {
                    dfs(nx, ny, K);
                }
            }
        }
    }
}