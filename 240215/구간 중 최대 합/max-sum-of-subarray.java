import java.util.*;

public class Main {
    static int n, k;

    public static void solution(int[] arr) {
        int maxValue = 0;
        for(int i = 0; i < n - k + 1; i++){
            int num = 0;
            num += arr[i];
            for(int j = i + 1; j < i + k; j++){
                num += arr[j];
            }
            maxValue = Math.max(maxValue, num);
        }
        System.out.println(maxValue);
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        T.solution(arr);
    }
}