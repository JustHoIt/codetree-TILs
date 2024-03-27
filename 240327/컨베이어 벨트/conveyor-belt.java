import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
        }

        int temp = 0;
        for (int i = 0; i < t; i++) {
            temp = arr[2 * n - 1];
            for (int j = 2 * n - 1; j >= 1; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }

        for (int i = 0; i < 2 * n; i++) {
            System.out.print(arr[i] + " ");
            if (i == n - 1) {
                System.out.println();
            }
        }
    }
}