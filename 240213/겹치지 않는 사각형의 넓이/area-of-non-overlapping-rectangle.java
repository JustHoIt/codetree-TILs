import java.util.Scanner;

public class Main {

    static int OFFSET = 1000;
    static int MAX = 2000;
    static int[][] checked = new int[MAX + 1][MAX + 1];

    public static void main(String[] args) {
        int cnt = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int x1 = sc.nextInt() + OFFSET;
            int y1 = sc.nextInt() + OFFSET;
            int x2 = sc.nextInt() + OFFSET;
            int y2 = sc.nextInt() + OFFSET;

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    if (i < 2) {
                        checked[j][k]++;
                    }else{
                        checked[j][k] = 2;
                    }

                }
            }
        }
        for (int i = 0; i <= MAX; i++) {
            for (int j = 0; j <= MAX; j++) {
                if (checked[i][j] == 1) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}