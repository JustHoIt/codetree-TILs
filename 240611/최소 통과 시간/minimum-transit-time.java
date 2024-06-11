import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] times = new int[m];

        for (int i = 0; i < m; i++) {
            times[i] = sc.nextInt();
        }

        long left = 1;
        long right = 1_000_000_000L * n;
        long result = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (solution(n, times, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean solution(int n, int[] times, long timeLimit) {
        long result = 0;

        for (int time : times) {
            result += timeLimit / time;
            if (result >= n) {
                return true;
            }
        }

        return result >= n;
    }
}