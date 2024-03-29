import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = arr[i];
            int loc = arr[i];
            int cnt = 1;
            for (int j = loc; cnt < m; cnt++) {
                sum += arr[j - 1];
                j = arr[j - 1];
            }
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}