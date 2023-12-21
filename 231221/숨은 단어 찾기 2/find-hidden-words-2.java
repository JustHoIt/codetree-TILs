import java.util.Scanner;

public class Main {
    static int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};

    static int n, m;


    public void solution(char[][] arr) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 'L') {
                    continue;
                }
                for (int k = 0; k < 8; k++) {
                    int x = i;
                    int y = j;
                    int cnt = 0;
                    while (true) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (!inRange(nx, ny) || arr[nx][ny] != 'E') {
                            break;
                        }
                        cnt++;
                        x = nx;
                        y = ny;
                    }
                    if (cnt >= 2) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean inRange(int nx, int ny) {
        return (nx >= 0 && nx < n && ny >= 0 && ny < m);
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        T.solution(arr);
    }
}