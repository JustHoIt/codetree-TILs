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

        int[][] segments = new int[m][2];
        for (int i = 0; i < m; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }

        Arrays.sort(points);

        for (int i = 0; i < m; i++) {
            int start = segments[i][0];
            int end = segments[i][1];
            int count = count(points, start, end);
            System.out.println(count);
        }
    }

    private static int count(int[] points, int start, int end) {
        int left = findLeft(points, start);
        int right = findRight(points, end);
        return right - left;
    }

    private static int findLeft(int[] points, int start) {
        int left = 0, right = points.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (points[mid] < start) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int findRight(int[] points, int end) {
        int left = 0, right = points.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (points[mid] <= end) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}