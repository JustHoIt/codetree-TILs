import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - m; j++) {
                boolean allEqual = true;
                for (int k = 1; k < m; k++) {
                    if (board[i][j] != board[i][j + k]) {
                        allEqual = false;
                        break;
                    }
                }
                if (allEqual) {
                    cnt++;
                    break;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= n - m; i++) {
                boolean allEqual = true;
                for (int k = 1; k < m; k++) {
                    if (board[i][j] != board[i + k][j]) {
                        allEqual = false;
                        break;
                    }
                }
                if (allEqual) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}