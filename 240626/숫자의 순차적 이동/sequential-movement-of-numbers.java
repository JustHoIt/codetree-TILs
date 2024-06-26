import java.util.Scanner;

public class Main {
    static final int MAX_N = 20;
    static final int DIR_NUM = 8;

    static int n, m;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][] dots = new int[MAX_N * MAX_N + 1][2];

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                dots[grid[i][j]][0] = i;
                dots[grid[i][j]][1] = j;
            }
        }

        while (m-- > 0) {
            simulate();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean InRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static int[] FindMaxNum(int x, int y) {
        int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

        int max_num = 0;
        int next_x = x, next_y = y;
        for (int i = 0; i < DIR_NUM; i++) {
            int nx = x + dx[i], ny = y + dy[i];

            if (!InRange(nx, ny)) continue;

            if (max_num < grid[nx][ny]) {
                max_num = grid[nx][ny];
                next_x = nx;
                next_y = ny;
            }
        }

        return new int[]{next_x, next_y};
    }

    static void simulate() {
        for (int num = 1; num <= n * n; num++) {
            int x = dots[num][0], y = dots[num][1];
            int[] maxPos = FindMaxNum(x, y);
            int mx = maxPos[0], my = maxPos[1];
            int max_num = grid[mx][my];

            dots[num][0] = mx;
            dots[num][1] = my;
            dots[max_num][0] = x;
            dots[max_num][1] = y;

            grid[mx][my] = num;
            grid[x][y] = max_num;
        }
    }
}