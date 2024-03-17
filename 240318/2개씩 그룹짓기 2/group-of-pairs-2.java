import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int a = Math.abs(arr[i] - arr[i + n]);
            min = Math.min(a, min);
        }
        System.out.println(min);
    }
}