import java.util.Scanner;

public class Main {
    static int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};


    public void solution(int n, int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < dx.length; k++) {
                    int idx = 1;
                    int x = i;
                    int y = j;
                    while (true) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (!inRange(nx, ny)) {
                            break;
                        }
                        if (arr[nx][ny] != arr[i][j]) {
                            break;
                        }
                        idx++;
                        x = nx;
                        y = ny;
                    }
                    if(idx == 5){
                        System.out.println(arr[i][j]);
                        System.out.println((i + 2 * dx[k] + 1) + " " + ( j+ 2 * dy[k]+1));
                        return;
                    }
                }

            }
        }
    }

    public static boolean inRange(int nx, int ny) {
        return (nx >= 0 && nx < 19 & ny >= 0 && ny < 19);
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = 19;
        int[][] arr = new int[19][19];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] > 0 && arr[i][j] <= 2){
                    System.out.println(0);
                    return;
                }
            }
        }
        T.solution(n, arr);
    }
}