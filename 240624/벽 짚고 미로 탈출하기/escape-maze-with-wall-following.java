import java.util.Scanner;

public class Main {
    static final int MAX_N = 100;
    static final int DIR_NUM = 4;

    static int n, x, y;
    static char[][] grid = new char[MAX_N][MAX_N];
    static boolean[][][] visited = new boolean[MAX_N][MAX_N][DIR_NUM];

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static int simulate(int x, int y) {
        int elapsedTime = 0;
        int cx = x, cy = y, dir = 0;
        visited[cx][cy][dir] = true;
        
        while (true) {
            int nx = cx + dx[dir], ny = cy + dy[dir];

            if (inRange(nx, ny) && visited[nx][ny][dir]) return -1;

            if (inRange(nx, ny) && grid[nx][ny] == '#') {
                dir = (dir + 1) % 4;
            } else if (!inRange(nx, ny)) {
                elapsedTime++;
                return elapsedTime;
            } else {
                int rx = nx + dx[(dir + 3) % 4], ry = ny + dy[(dir + 3) % 4];
                if (inRange(rx, ry) && grid[rx][ry] == '#') {
                    elapsedTime++;
                    cx = nx;
                    cy = ny;
                    visited[cx][cy][dir] = true;
                } else {
                    elapsedTime += 2;
                    visited[nx][ny][dir] = true;
                    cx = rx;
                    cy = ry;
                    dir = (dir + 3) % 4;
                    visited[cx][cy][dir] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        System.out.println(simulate(x - 1, y - 1));
        sc.close();
    }
}