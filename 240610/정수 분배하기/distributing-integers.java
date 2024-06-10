import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] arr = new int[n];

        long start = 1;
        long end = 0;

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            end = Math.max(arr[i], end);
        }

        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            if (canDivide(arr, n, m, mid)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static boolean canDivide(int[] arr, int n, int m, long k) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            count += arr[i] / k;
        }
        return count >= m;
    }
}