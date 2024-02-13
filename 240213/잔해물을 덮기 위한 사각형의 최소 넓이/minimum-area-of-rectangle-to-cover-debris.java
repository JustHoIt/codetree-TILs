import java.util.Scanner;

public class Main {

    static int OFFSET = 1000;
    static int[][] checked = new int[OFFSET * 2 + 1][OFFSET * 2 + 1];
    static int minX = OFFSET * 2 + 1, minY = OFFSET * 2 + 1;
    static int maxX = 0, maxY = 0, result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            int x1 = sc.nextInt() + OFFSET;
            int y1 = sc.nextInt() + OFFSET;
            int x2 = sc.nextInt() + OFFSET;
            int y2 = sc.nextInt() + OFFSET;

            if (i == 0) {
                for (int j = x1; j < x2; j++) {
                    for (int k = y1; k < y2; k++) {
                        checked[j][k]++;
                    }
                }
            } else {
                for (int j = x1; j < x2; j++) {
                    for (int k = y1; k < y2; k++) {
                        checked[j][k]--;
                    }
                }
            }
        }

        for (int i = 0; i <= OFFSET * 2; i++) {
            for (int j = 0; j <= OFFSET * 2; j++) {
                if (checked[i][j] == 1) {
                    result = 1;
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        if (result != 1) {
            System.out.println(0);
        } else {
            System.out.println((maxX - minX + 1) * (maxY - minY + 1));
        }
    }
}