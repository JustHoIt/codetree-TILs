import java.util.*;

public class Main {
    static int N, S;

    public static void solution(int[] arr) {
        int answer = Integer.MAX_VALUE;
        int sum = Arrays.stream(arr).sum();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int a = arr[i] + arr[j];
                answer = Math.min(answer, Math.abs(S - ( sum - a)));
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        T.solution(arr);
    }
}