import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = 15;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int a = arr[0];
        int b = arr[1];
        int c = 0;
        if (arr[2] < a + b) {
            c = arr[2];
        } else {
            c = arr[3];
        }
        int d = arr[14] - (a + b + c);

        System.out.println(a + " " + b + " " + c + " " + d);

    }
}