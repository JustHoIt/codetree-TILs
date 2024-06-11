import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] points = new int[n];

        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }

        Arrays.sort(points);

        int left = 0;
        int right = points[n - 1] - points[0];
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (solution(points, n, m, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static boolean solution(int[] points, int n, int m, int distance) {
        int count = 1;
        int lastPosition = points[0];

        for (int i = 1; i < n; i++) {
            if (points[i] - lastPosition >= distance) {
                count++;
                lastPosition = points[i];
                if (count >= m) {
                    return true;
                }
            }
        }

        return false;
    }
}