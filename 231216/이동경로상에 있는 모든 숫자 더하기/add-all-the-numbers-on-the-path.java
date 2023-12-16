import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int dir = 0;
    static int n = 0;
    static String s = "";
    static int[][] arr;
    static int x = 0, y = 0;

    public static boolean inRange(int nx, int ny) {
        return (nx >= 0 && nx < n && ny >= 0 && ny < n);
    }

    public static void solution(String s) {
        int answer = 0;
        answer += arr[x][y];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (c == 'F') {
                if (inRange(nx, ny)) {
                    x = nx;
                    y = ny;
                    answer += arr[x][y];
                }
            } else {
                if (c == 'L') {
                    dir--;
                    if (dir == -1) {
                        dir = 3;
                    }
                } else {
                    dir++;
                    if (dir == 3) {
                        dir = 0;
                    }
                }

            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];
        int c = sc.nextInt();
        s = sc.next();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        x = n / 2;
        y = n / 2;

        solution(s);
    }
}