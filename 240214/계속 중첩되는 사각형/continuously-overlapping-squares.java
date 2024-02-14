import java.util.Scanner;

public class Main {
    static int n;
    static int OFFSET = 100;
    static int[][] checked = new int[OFFSET * 2 + 1][OFFSET * 2 + 1];

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int cnt = 0;

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt() + OFFSET;
            int y1 = sc.nextInt() + OFFSET;
            int x2 = sc.nextInt() + OFFSET;
            int y2 = sc.nextInt() + OFFSET;

            if (i % 2 == 0) {
                for (int j = x1; j < x2; j++) {
                    for (int k = y1; k < y2; k++) {
                        checked[j][k] = 1;
                    }
                }
            } else {
                for (int j = x1; j < x2; j++) {
                    for (int k = y1; k < y2; k++) {
                        checked[j][k] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < OFFSET * 2 + 1; i++) {
            for (int j = 0; j < OFFSET * 2 + 1; j++) {
                if (checked[i][j] == 2) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}