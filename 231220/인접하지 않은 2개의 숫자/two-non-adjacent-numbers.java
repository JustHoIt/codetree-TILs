import java.util.Scanner;

public class Main {

    public int solution(int N, int[] arr) {
        int answer = Integer.MIN_VALUE;


        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 2; j < N; j++) {
                int idx = arr[i] + arr[j];
                if (answer < idx) {
                    answer = idx;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(N, arr));

    }
}