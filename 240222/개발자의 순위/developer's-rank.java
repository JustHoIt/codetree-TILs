import java.util.Scanner;

public class Main {
    static int OFFSET = 21;
    static int[][] a = new int[OFFSET][OFFSET];
    static int[] tmp = new int[OFFSET];
    static int K, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        N = sc.nextInt();

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                tmp[j] = sc.nextInt();
            }
            for (int j = 0; j < N; j++) {
                for (int l = j + 1; l < N; l++) {
                    a[tmp[j]][tmp[l]]++;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < N; j++) {
                if (a[i][j] == K) {
                    cnt++;
                }
            }

        }
        System.out.println(cnt);
    }
}