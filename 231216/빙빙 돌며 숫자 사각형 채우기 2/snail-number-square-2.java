import java.util.Scanner;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int n = 0, m = 0;
    static int[][] arr;

    static int x = 0, y = 0;
    static int dir = 0;

    public static void solution() {
        for (int i = 2; i <= n * m; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (!inRange(nx, ny) || arr[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
            arr[x][y] = i;
        }

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                System.out.print(arr[j][k] + " ");
            }
            System.out.println();
        }
    }

    public static boolean inRange(int nx, int ny) {
        return (nx >= 0 && nx < n && ny >= 0 && ny < m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        arr[x][y] = 1;
        solution();
    }
}