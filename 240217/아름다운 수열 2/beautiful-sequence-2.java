import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] A = new int[MAX_N];
        int[] B_count = new int[MAX_N + 1];
        int[] tmp = new int[MAX_N + 1];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int n = scanner.nextInt();
            B_count[n]++;
        }

        int ans = 0;
        for (int i = 0; i <= N - M; i++) {
            System.arraycopy(B_count, 0, tmp, 0, MAX_N + 1);
            for (int j = i; j < i + M; j++) {
                tmp[A[j]]--;
            }
            boolean beauty = true;
            for (int j = 0; j <= MAX_N; j++) {
                if (tmp[j] != 0) {
                    beauty = false;
                    break;
                }
            }
            if (beauty) ans++;
        }
        System.out.println(ans);
    }
}