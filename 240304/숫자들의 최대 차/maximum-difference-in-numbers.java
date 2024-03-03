import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int cnt = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] - arr[i] <= k) {
                    cnt++;
                }else{
                    break;
                }
            }
            max = Math.max(cnt, max);
        }
        System.out.println(max);
    }
}