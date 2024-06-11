import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int left = 1; 
        int right = 1000000000; 

        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canPlacePoints(arr, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }

    private static boolean canPlacePoints(int[][] arr, int mid) {
        int lastPos = arr[0][0]; 

        for (int i = 1; i < arr.length; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            if (lastPos + mid <= end) {
                lastPos = Math.max(lastPos + mid, start);
            } else {
                return false;
            }
        }

        return true;
    }
}