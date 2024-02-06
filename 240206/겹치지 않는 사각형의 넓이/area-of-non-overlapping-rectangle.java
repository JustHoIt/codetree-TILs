import java.util.Scanner;
public class Main {
    static int OFFSET = 1000;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int[] x1 = new int[3];
        int[] y1 = new int[3];
        int[] x2 = new int[3];
        int[] y2 = new int[3];

        int[][] checked = new int[2001][2001];

        // Get input
        for (int i = 0; i < 3; i++) {
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            y2[i] = sc.nextInt();
            
            x1[i] += OFFSET;
            y1[i] += OFFSET;
            x2[i] += OFFSET;
            y2[i] += OFFSET;

            for (int x = x1[i]; x < x2[i]; x++) {
                for (int y = y1[i]; y < y2[i]; y++) {
                    checked[x][y] = i + 1;
                }
            }
        }

        int cnt = 0;
        for (int x = 0; x <= 2000; x++) {
            for (int y = 0; y <= 2000; y++) {
                if (checked[x][y] == 1 || checked[x][y] == 2) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}