import java.util.Scanner;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int dir = 0;
    static int n = 0;
    static int[][] arr;

    static int x = 0, y = 0;

    public static boolean inRange(int nx, int ny) {
        return (nx >= 0 && nx < n && ny >= 0 && ny < n);
    }

    public static void solution() {
        x = n - 1;
        y = n - 1;
        for (int i = n * n - 1; i > 0; i--) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (!inRange(nx, ny) || arr[nx][ny] != 0) {
                dir = (dir + 3) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];

            }
            x = nx;
            y = ny;
            arr[x][y] = i;
        }

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                System.out.print(arr[j][k] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];
        arr[n - 1][n - 1] = n * n;
        solution();
    }
}