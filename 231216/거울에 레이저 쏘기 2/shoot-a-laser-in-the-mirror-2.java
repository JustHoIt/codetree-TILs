import java.util.Scanner;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N = 0, C = 0;

    static char[][] arr;
    static int dir = 0;
    static int x = 0, y = 0;

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }

    public static void initialize(int num) {
        if (num <= N) {
            x = 0;
            y = num - 1;
            dir = 0;
        } else if (num <= 2 * N) {
            x = num - N - 1;
            y = N - 1;
            dir = 1;
        } else if (num <= 3 * N) {
            x = N - 1;
            y = N - (num - 2 * N);
            dir = 2;
        } else {
            x = N - (num - 3 * N);
            y = 0;
            dir = 3;
        }
    }

    public static void move(int nextDir) {

        x += dx[nextDir];
        y += dy[nextDir];
        dir = nextDir;
    }

    public static void solution() {
        int answer = 0;
        while (inRange(x, y)) {
            if (arr[x][y] == '/') {
                move(dir ^ 1);
            } else {
                move(3 - dir);
            }
            answer += 1;
        }
        System.out.println(answer);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        C = sc.nextInt();
        initialize(C);
        solution();
    }
}