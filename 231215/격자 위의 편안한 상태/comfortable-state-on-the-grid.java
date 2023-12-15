import java.util.Scanner;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static int N = 0;

    public static boolean inRange(int nx, int ny) {
        return (nx >= 0 && nx < N && ny >= 0 && ny < N);
    }

    public static int solution(int r, int c) {
        arr[r][c] = 1;
        int count = 0;
        for (int dir = 0; dir < 4; dir++) {
            int nx = r + dx[dir];
            int ny = c + dy[dir];
            if (inRange(nx, ny) && arr[nx][ny] == 1) {
                count++;
            }
        }
        if (count == 3) {
            count = 0;
            return 1;
        }
        count = 0;

        return 0;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            System.out.println(T.solution(r - 1, c - 1));
        }

    }
}