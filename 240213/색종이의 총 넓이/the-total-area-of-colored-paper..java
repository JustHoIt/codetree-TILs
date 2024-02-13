import java.util.Scanner;

public class Main {

    static int OFFSET = 100;
    static int MAX = 200;
    static int[][] checked = new int[MAX + 1][MAX + 1];

    public static void main(String[] args) {
        int cnt = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt() + OFFSET;
            int y1 = sc.nextInt() + OFFSET;
            int x2 = x1 + 8;
            int y2 = y1 + 8;

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    checked[j][k]++;
                }
            }
        }

        for (int i = 0; i <= MAX; i++) {
            for (int j = 0; j <= MAX; j++) {
                if (checked[i][j] >= 1) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}