import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int zero = 0;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int num1 = arr[n - 1] * arr[n - 2] * arr[n - 3];
        int num2 = arr[0] * arr[1] * arr[2]; //
        int num3 = arr[0] * arr[1] * arr[n - 1];  //음수 2개 양수 1개일경우

        answer = Math.max(num1, Math.max(num2, num3));

        System.out.println(answer);
    }
}